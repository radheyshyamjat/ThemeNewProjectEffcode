package in.effcode.App.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.effcode.in.themes.R;

import butterknife.ButterKnife;

/**
 * Created by Radhey on 31/5/18.
 * Author Radhey
 */

public class FragmentPhotos extends Fragment {
    private View view;
    private Activity activity;
    private static final String TAG = "FragmentPeople";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_photos,container,false);
        ButterKnife.bind(view);
        activity = getActivity();
        Log.d(TAG,"Come on on create method fragmetn photos");
        init();
        return view;
    }

    private void init() {
    }
}
