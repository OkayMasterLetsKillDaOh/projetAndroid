package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class TpEcoleView extends View {

    private int canvasWidth;
    private int canvasHeight;
    private Bitmap photo;

    public TpEcoleView(Context context) {
        super(context);
        photo = BitmapFactory.decodeResource(getResources(), R.drawable.res);
    }

    public TpEcoleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        photo = BitmapFactory.decodeResource(getResources(), R.drawable.res);
    }

    public TpEcoleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TpEcoleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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

        canvas.drawColor(Color.WHITE);
        Rect rectangle_bitmap = new Rect(0,Math.min(canvasHeight,canvasWidth)/2,Math.min(canvasHeight,canvasWidth),canvasHeight);
        canvas.drawBitmap(photo,null,rectangle_bitmap,mPaint);

        mPaint.setAntiAlias(true);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, canvasHeight/4, canvasWidth/4, 2*canvasHeight/4, mPaint);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0, canvasHeight/4, canvasWidth/4, 2*canvasHeight/4, mPaint);

        mPaint.setColor(Color.parseColor("#ff00ff"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5f);
        canvas.drawCircle(canvasWidth/2, canvasHeight/2, Math.min( (float)(canvasWidth*0.4), (float)(canvasHeight*0.4))/2, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setTextSize(50f);
        canvas.drawText("Ceci est un texte",(float)canvasWidth/10,(float)canvasHeight/10 ,mPaint);

        super.onDraw(canvas);
    }

}
