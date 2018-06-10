package in.effcode.App.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.effcode.in.themes.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivitySecond extends AppCompatActivity {

    @BindView(R.id.btnSubmit)
    FloatingActionButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_second);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSubmit)
    public void onClickSubmit(){
        Intent intent = new Intent(this,LoginActivityUI.class);
        startActivity(intent);
    }
}
