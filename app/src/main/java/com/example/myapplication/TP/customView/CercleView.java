package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by MOMO Adrien Nickson on 19/02/21.
 */
public class CercleView extends View {

    private int canvasWidth;
    private int canvasHeight;

    public CercleView(Context context) {
        super(context);
    }

    public CercleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CercleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CercleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasWidth = w;
        canvasHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(canvasWidth/2, canvasHeight/2, Math.min( (float)(canvasWidth*0.8), (float)(canvasHeight*0.8))/2, mPaint);
        super.onDraw(canvas);
    }
}
