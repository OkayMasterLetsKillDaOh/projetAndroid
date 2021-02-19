package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by MOMO Adrien Nickson on 19/02/21.
 */

public class CarteView extends View {
    private Paint mPaint;
    private Path mPath;
    private Path mPath2;
    private Path mPath3;
    private int canvasWidth;
    private int canvasHeight;

    public CarteView(Context context) {
        super(context);
    }

    public CarteView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CarteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CarteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasWidth = w;
        canvasHeight = h;

        mPath = new Path();
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        float width = canvasWidth/3;
        float height = canvasHeight/3;

        //Starting point
        mPath.moveTo(width / 2, height / 5);

        //Upper left path
        mPath.cubicTo(5 * width / 14, 0,
                0, height / 15,
                width / 28, 2 * height / 5);

        //Lower left path
        mPath.cubicTo(width / 14, 2 * height / 3,
                3 * width / 7, 5 * height / 6,
                width / 2, height);

        //Lower right path
        mPath.cubicTo(4 * width / 7, 5 * height / 6,
                13 * width / 14, 2 * height / 3,
                27 * width / 28, 2 * height / 5);

        //Upper right path
        mPath.cubicTo(width, height / 15,
                9 * width / 14, 0,
                width / 2, height / 5);



        mPath2 = new Path(mPath);
        Matrix scaleMatrix = new Matrix();
        RectF rectF = new RectF();

        mPath2.computeBounds(rectF, true);
        scaleMatrix.setScale(0.25f, 0.25f,rectF.centerX(),rectF.centerY());

        mPath2.transform(scaleMatrix);

        mPath3 = new Path(mPath2);

        mPath3.offset( canvasWidth - width,canvasHeight - height );

        mPath.offset(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#af703c"));
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE); // default: FILL
        //mPaint.setStrokeJoin(Paint.Join.ROUND); // default: MITER
        mPaint.setStrokeWidth(12); // default: Hairline-width (really thin)
        canvas.drawRect(30, 30, canvasWidth - 30, canvasHeight - 30, mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE); // default: FILL
        //canvas.drawCircle(canvasWidth/2,canvasHeight/2,canvasWidth/4, mPaint);

        canvas.drawPath(mPath, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath2, mPaint);
        canvas.drawPath(mPath3, mPaint);

    }

}
