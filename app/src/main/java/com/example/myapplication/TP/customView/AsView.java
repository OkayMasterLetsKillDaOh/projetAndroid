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

public class AsView extends View {
    private Paint mPaint;
    private Path mPath;
    private Path mPath2;
    private Path mPath3;
    private Path mTextPath;
    private Path mTextPath2;
    private int canvasWidth;
    private int canvasHeight;

    public AsView(Context context) {
        super(context);
    }

    public AsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasWidth = w;
        canvasHeight = h;

        mPath = new Path();
        mTextPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        float width = canvasWidth/3;
        float height = canvasHeight/3;

        //Starting point
        mPath.moveTo(width / 2, height / 5);
        mPath.lineTo(width / 10, 3*height / 5);
        mPath.lineTo(width / 2, height);
        mPath.lineTo(9*width/10, 3*height / 5);
        mPath.close();

        mTextPath.moveTo(width / 2, height / 20);
        mTextPath.lineTo(width / 10, 3*height / 5);
        mTextPath.moveTo(width / 2, height / 20);
        mTextPath.lineTo(9*width / 10, 3*height / 5);
        mTextPath.moveTo(width/2,(int)6.5*height/20);
        mTextPath.lineTo(7*width/10,1.5f*height/5);
        mTextPath.moveTo(width/2,(int)6.5*height/20);
        mTextPath.lineTo(3*width/10,1.5f*height/5);

        mPath2 = new Path(mPath);
        Matrix scaleMatrix = new Matrix();
        Matrix scaleMatrixPlus = new Matrix();
        Matrix scaleMatrixRotate = new Matrix();

        RectF rectF = new RectF();

        mPath2.computeBounds(rectF, true);
        scaleMatrix.setScale(0.4f, 0.4f,rectF.centerX(),rectF.centerY());
        scaleMatrixPlus.setScale(0.4f,0.4f,rectF.centerX(),rectF.centerY()/3);
        scaleMatrixRotate.setRotate(180f,rectF.centerX(),rectF.centerY()/2.3f);
        mTextPath.computeBounds(rectF, true);
        mTextPath.transform(scaleMatrixPlus);
        mPath2.transform(scaleMatrix);

        mTextPath2 = new Path(mTextPath);
        mPath3 = new Path(mPath2);
        mTextPath2.transform(scaleMatrixRotate);

        mPath3.offset( canvasWidth - width,canvasHeight - height*1.2f );
        mTextPath2.offset( canvasWidth - width,canvasHeight - height/2f );

        mPath.offset(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#ffffff"));
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE); // default: FILL
        //mPaint.setStrokeJoin(Paint.Join.ROUND); // default: MITER
        mPaint.setStrokeWidth(12); // default: Hairline-width (really thin)
        canvas.drawRect(30, 30, canvasWidth - 30, canvasHeight - 30, mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE); // default: FILL
        //canvas.drawCircle(canvasWidth/2,canvasHeight/2,canvasWidth/4, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(mPath, mPaint);
        canvas.drawPath(mPath2, mPaint);
        canvas.drawPath(mPath3, mPaint);
        canvas.drawPath(mTextPath,mPaint);
        canvas.drawPath(mTextPath2,mPaint);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath, mPaint);
        canvas.drawPath(mPath2, mPaint);
        canvas.drawPath(mPath3, mPaint);
        canvas.drawPath(mTextPath,mPaint);
        canvas.drawPath(mTextPath2,mPaint);

    }

}

