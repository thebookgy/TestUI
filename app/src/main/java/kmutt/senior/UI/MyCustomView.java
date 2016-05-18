package kmutt.senior.UI;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

import kmutt.senior.pet.R;


public class MyCustomView extends View {


    private int circleColour;
    private int circleTextColor;
    private String circleText;
    private Paint paintColorStyle;


    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paintColorStyle = new Paint();
        TypedArray attributeValuesArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.MyCustomView, 0, 0);
        try {
            circleText = attributeValuesArray.
                    getString(R.styleable.MyCustomView_circleText);
            circleColour = attributeValuesArray.
                    getInteger(R.styleable.MyCustomView_circleColor, 0);
            circleTextColor = attributeValuesArray.
                    getInteger(R.styleable.MyCustomView_circleTextColor, 0);

        } finally {
            attributeValuesArray.recycle();
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        paintColorStyle.setStyle(Paint.Style.FILL);
        paintColorStyle.setAntiAlias(true);
        paintColorStyle.setColor(circleColour);
        Random rand = new Random();
        int n = rand.nextInt(this.getMeasuredHeight());
        int centerX =  n / 2;
        int centerY = n / 2;
        int radius = 150;
        canvas.drawCircle(centerX, centerY, radius, paintColorStyle);
        paintColorStyle.setColor(circleTextColor);
        paintColorStyle.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(circleText, centerX, centerY, paintColorStyle);
    }

    public int getCircleColour() {
        return circleColour;
    }

    public int getCircleTextColor() {
        return circleTextColor;
    }

    public String getCircleText() {
        return circleText;
    }



    public void setCircleColor(int newCircleColor) {
        circleColour = newCircleColor;
        invalidate();
        requestLayout();
    }

    public void setCircleTextColor(int newCircleTextColor) {
        circleTextColor = newCircleTextColor;
        invalidate();
        requestLayout();
    }

    public void setCircleText(String newCircleText) {
        circleText = newCircleText;
        invalidate();
        requestLayout();
    }


}
