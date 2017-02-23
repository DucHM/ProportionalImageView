package me.giacoppo.proportionalimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Peppe on 23/02/2017.
 */

public class ProportionalImageView extends ImageView {

    private double ratio=1.0;

    public ProportionalImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    private void init(Context context, AttributeSet attrs ) {
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ProportionalImageView, 0, 0);
        int widthUnits = ta.getInt(R.styleable.ProportionalImageView_widthUnits,1);
        int heightUnits = ta.getInt(R.styleable.ProportionalImageView_heightUnits,1);
        ratio = ((double)heightUnits)/widthUnits;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int)(width*ratio);
        setMeasuredDimension(width,height);
    }
}
