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

/**
 * Created by Radhey on 31/5/18.
 * Author Radhey
 */

public class FragmentVideos extends Fragment{
    private static final String TAG = "FragmentVideos";
    private View view;
    private Activity activity;
    @BindView(R.id.rvVideos)
    public RecyclerView rvVideos;
    private ArrayList<Object> videoList;
    private PeoplesAdapter peopleVideosAdapter;
    private Context mContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_videos,container,false);
        ButterKnife.bind(this,view);
        mContext = getContext();
        activity = getActivity();
        init();
        return view;
    }

    private void init() {
        Log.d(TAG,"Come on fragment videos");
        JazzyRecyclerViewScrollListener listener = new JazzyRecyclerViewScrollListener();
        listener.setTransitionEffect(new SlideInEffect());
//        rvVideos.setOnScrollListener(listener);
        rvVideos.setHasFixedSize(true);
        rvVideos.setLayoutManager(new LinearLayoutManager(activity));
        videoList = new ArrayList<>();
        getVideoList();
        peopleVideosAdapter = new PeoplesAdapter(mContext,videoList, new PeoplesAdapter.Callback() {
            @Override
            public void onNextPageRequest() {
                
            }

            @Override
            public void onItemClick(Object object) {

            }
        });
        rvVideos.setAdapter(peopleVideosAdapter);
    }

    private void getVideoList() {

        notifyAdapter();
    }

    private void notifyAdapter() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                peopleVideosAdapter.notifyDataSetChanged();
            }
        });
    }

    public class PeopleVideo{

    }
}
