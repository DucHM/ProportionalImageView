package me.giacoppo.proportionalimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Peppe on 23/02/2017.
 */

public class ProportionalImageView extends ImageView {

    private double ratio = 1.0;
    private int widthUnits = 1;
    private int heightUnits = 1;

    public ProportionalImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ProportionalImageView, 0, 0);
        widthUnits = ta.getInt(R.styleable.ProportionalImageView_widthUnits, 1);
        heightUnits = ta.getInt(R.styleable.ProportionalImageView_heightUnits, 1);
    }

    public void setWidthUnits(int units) {
        if (units > 0) {
            widthUnits = units;
            update();
        } else throw new ProportionalImageViewException("Width units must be greater than 0");
    }

    public void setHeightUnits(int units) {
        if (units > 0) {
            heightUnits = units;
            update();
        } else throw new ProportionalImageViewException("Height units must be greater than 0");
    }

    public void setRatio(double _ratio) {
        if (_ratio > 0) {
            ratio = _ratio;
            requestLayout();
        } else throw new ProportionalImageViewException();
    }

    private void update() {
        ratio = heightUnits / widthUnits;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (ratio > 0) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int) (width * ratio);
            setMeasuredDimension(width, height);
        } else throw new ProportionalImageViewException();
    }

    private class ProportionalImageViewException extends RuntimeException {
        ProportionalImageViewException(){
            super("Ratio must be greater than 0");
        }
        ProportionalImageViewException(String message) {
            super(message);
        }
    }
}