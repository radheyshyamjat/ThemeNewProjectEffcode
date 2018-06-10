package in.effcode.App.Activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.effcode.in.themes.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.effcode.App.Views.Button;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLoginViaFacebook)
    Button login;

    private Context context;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        context = this;
        activity = this;
    }

    @OnClick(R.id.btnLoginViaFacebook)
    public void onClickLoginViaFacebook(){
        Intent navigateToNextActivity = new Intent();
        navigateToNextActivity.setClass(this,Profile.class);
        startActivity(navigateToNextActivity);
//        autoLaunchVivo(context);
    }

    @OnClick(R.id.btnSignUpViaMail)
    public void onClickLoginViaGmail(){
        Intent navigateToNextActivity = new Intent();
        navigateToNextActivity.setClass(this,LoginActivitySecond.class);
        startActivity(navigateToNextActivity);
//        autoLaunchVivo(context);
    }


    private static void autoLaunchVivo(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.iqoo.secure",
                    "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"));
            context.startActivity(intent);
        } catch (Exception e) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.vivo.permissionmanager",
                        "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                context.startActivity(intent);
            } catch (Exception ex) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName("com.iqoo.secure",
                            "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager");
                    context.startActivity(intent);
                } catch (Exception exx) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
