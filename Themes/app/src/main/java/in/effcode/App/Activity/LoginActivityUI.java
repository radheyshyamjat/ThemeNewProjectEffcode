package in.effcode.App.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.effcode.in.themes.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivityUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ui);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSubmit)
    public void onClickSubmit(){
        Intent intent = new Intent(this,OtpSendActivity.class);
        startActivity(intent);
    }
}
