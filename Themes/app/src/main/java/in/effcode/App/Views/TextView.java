package in.effcode.App.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.effcode.in.themes.R;

import in.effcode.App.Config.TypefaceLoader;
import in.effcode.App.Utils.CommonUtils;

/**
 * Created by Radhey on 17/5/18.
 * Author Radhey
 */

public class TextView extends AppCompatTextView {
    private Context context;
    private String font = "MavenPro-Medium.ttf";

    public TextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }

    public TextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init(context, attrs);
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface typeface = TypefaceLoader.get(context, "fonts/" + font);
            setTypeface(typeface);
        }
    }

    private void init(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.TypefacedTextView);
            int index = styledAttrs.getInt(R.styleable.TypefacedTextView_customTypeface, 1);
            styledAttrs.recycle();
            Typeface typeface = TypefaceLoader.get(context, "fonts/" + CommonUtils.getFontName(index));
            setTypeface(typeface);
        }

    }
}
