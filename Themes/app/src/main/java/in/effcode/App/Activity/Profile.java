package in.effcode.App.Activity;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.effcode.in.themes.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.effcode.App.Adapter.ProfileAdapter;
import in.effcode.App.Views.RoundImageView;

public class Profile extends AppCompatActivity {

    private static final String TAG = "Profile";
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.ivProfile)
    RoundImageView ivProfile;

    private ProfileAdapter profileAdapter;
    Activity activity;
    private int tabCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        activity = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText("Profile");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburger);
        init();

        Glide.with(this).load(R.drawable.p13).into(ivProfile);

    }

    private void init() {
//        toolbar_title.setText(getResources().getStringArray(R.array.profile_tab_titles)[0]);
        profileAdapter = new ProfileAdapter(activity,getSupportFragmentManager());
        mViewPager.setAdapter(profileAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.removeAllTabs();
        tabCount = profileAdapter.getCount();
//        TabLayout.Tab tab = mTabLayout.newTab();
//        RelativeLayout tabItemLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.tab_item_dashboard, mTabLayout, false);

//        tab.setCustomView(tabItemLayout);


        for (int i=0;i<tabCount;i++){
            TabLayout.Tab tab = mTabLayout.newTab();
            RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.tabs_title,mTabLayout,false);
            TextView tvTab = ButterKnife.findById(relativeLayout, R.id.tvTitle);
            tvTab.setText(getResources().getStringArray(R.array.profile_tab_titles)[i]);
            tab.setCustomView(relativeLayout);
            if (i==0){
                mTabLayout.addTab(tab,i,true);
            }else {
                mTabLayout.addTab(tab,i,false);
            }
        }

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("MAIN","TAG is her and positon"+position);
//                toolbar_title.setText(getResources().getStringArray(R.array.profile_tab_titles)[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
