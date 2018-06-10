package in.effcode.App.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.effcode.App.Fragment.FragmentPeoples;
import in.effcode.App.Fragment.FragmentPhotos;
import in.effcode.App.Fragment.FragmentVideos;

/**
 * Created by Radhey on 31/5/18.
 * Author Radhey
 */

public class ProfileAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private int TAB_COUNT;
    private FragmentPeoples fragmentPeoples = new FragmentPeoples();
    private FragmentPhotos fragmentPhotos = new FragmentPhotos();
    private FragmentVideos fragmentVideos = new FragmentVideos();

    public ProfileAdapter(Context context,FragmentManager fm) {
        super(fm);
        TAB_COUNT = 3;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                if (null == fragmentPeoples){
                 return fragmentPeoples = new FragmentPeoples();
                }
                return fragmentPeoples;
            case 1:
                if (null == fragmentPhotos){
                    return fragmentPhotos = new FragmentPhotos();
                }
                return fragmentPhotos;
            case 2:
                if (null == fragmentVideos){
                    return fragmentVideos = new FragmentVideos();
                }
                return fragmentVideos;
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
