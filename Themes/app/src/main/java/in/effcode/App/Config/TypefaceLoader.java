package in.effcode.App.Config;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by Radhey on 17/5/18.
 * Author Radhey
 */

public class TypefaceLoader {
    private static final String TAG = "TypefaceLoader";

    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    public static Typeface get(Context context, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(context.getAssets(), assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    return get(context, assetPath);
                }
            }
            return cache.get(assetPath);
        }
    }
}
