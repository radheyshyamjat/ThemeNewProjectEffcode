package in.effcode.App.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.effcode.in.themes.R;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.effcode.App.Adapter.PeoplesAdapter;
import in.effcode.App.Model.Peoples;

/**
 * Created by Radhey on 31/5/18.
 * Author Radhey
 */

public class FragmentPeoples extends Fragment {
    private static final String TAG = "FragmentPeople";
    private View view;
    private Activity activity;
    private Context context;

//    @BindView(R.id.rvPeoples)
    public RecyclerView rvPeoples;

    private ArrayList<Object> peoplesList;
    private PeoplesAdapter peoplesAdapter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_peoples, container, false);
        ButterKnife.bind(this,view);
        rvPeoples = view.findViewById(R.id.rvPeoples);
        activity = getActivity();
        mContext = getContext();
        init();
        return view;
    }

    private void init() {
        JazzyRecyclerViewScrollListener listener = new JazzyRecyclerViewScrollListener();
        listener.setTransitionEffect(new SlideInEffect());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPeoples.setLayoutManager(layoutManager);
        rvPeoples.setHasFixedSize(false);
        peoplesList = new ArrayList<>();
        getPeoplesList();
        peoplesAdapter = new PeoplesAdapter(mContext,peoplesList, new PeoplesAdapter.Callback() {
            @Override
            public void onNextPageRequest() {

            }

            @Override
            public void onItemClick(Object object) {

            }
        });
        rvPeoples.setAdapter(peoplesAdapter);
        notifyAdapter();
    }

    private void notifyAdapter(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                peoplesAdapter.notifyDataSetChanged();
            }
        });
    }
    private void getPeoplesList() {
        Log.d(TAG,"Come on getpeoples list");
        peoplesList.add( new Peoples(R.drawable.p1, "Emma Smith", false));
        peoplesList.add( new Peoples(R.drawable.p2, "Olivia Warner", true));
        peoplesList.add( new Peoples(R.drawable.p3, "Ava Albert", true));
        peoplesList.add( new Peoples(R.drawable.p4, "Isabella Ten", false));
        peoplesList.add( new Peoples(R.drawable.p5, "Sophia Watson", true));
        peoplesList.add( new Peoples(R.drawable.p6, "Mia Thomas", true));
        peoplesList.add( new Peoples(R.drawable.p7, "Charlotte Taylor", false));
        peoplesList.add( new Peoples(R.drawable.p8, "Amelia Jones", true));
        peoplesList.add( new Peoples(R.drawable.p9, "Aria Harris", true));
        peoplesList.add( new Peoples(R.drawable.p10, "Rileya White", false));
        peoplesList.add( new Peoples(R.drawable.p11, "Luna Jones", true));
        peoplesList.add( new Peoples(R.drawable.p12, "Lucy Anderson", false));
    }
}
