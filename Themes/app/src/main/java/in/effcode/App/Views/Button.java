package in.effcode.App.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.effcode.in.themes.R;

import in.effcode.App.Config.TypefaceLoader;
import in.effcode.App.Utils.CommonUtils;

/**
 * Created by Radhey on 17/5/18.
 * Author Radhey
 */

public class Button extends AppCompatButton {
    private Context context;
    private String font = "Light.ttf";

    public Button(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }

    public Button(Context context, AttributeSet attrs, int defStyle) {
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
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.TypefacedButton);
            int index = styledAttrs.getInt(R.styleable.TypefacedButton_customTypeface, 1);
            styledAttrs.recycle();
            Typeface typeface = TypefaceLoader.get(context, "fonts/" + CommonUtils.getFontName(index));
            setTypeface(typeface);
        }
    }
}
