package in.effcode.App.Config;
import android.app.Activity;
import android.app.Application;
import android.widget.Toast;
import in.effcode.App.Utils.StringUtils;

/**
 * Created by Radhey on 17/05/18.
 *
 * @author Radhey
 */
public class App extends Application {
	private static App instance;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static synchronized void showToast(Activity activity, String message) {
		if (null != message) {
			Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
		}
	}
	public static synchronized void showToast(Activity activity, int stringResId) {
		String message = activity.getString(stringResId);
		if (!StringUtils.isEmpty(message)) {
			Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
		}
	}

	public static App getAppContext() {
		return instance;
	}
}
