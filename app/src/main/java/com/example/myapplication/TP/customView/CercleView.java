package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

/**
 * Created by MOMO Adrien Nickson on 19/02/21.
 */
public class CercleView extends View {

    private Canvas mExtraCanvas;
    private Bitmap mExtraBitmap;
    private float reticuleX;
    private float reticuleY;
    float rayon;

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
        mExtraBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mExtraCanvas = new Canvas(mExtraBitmap);
        if (reticuleX == 0.0f)
            reticuleX = w/2;
        if (reticuleY == 0.0f)
            reticuleY = h/2;
        rayon = Math.min( (float)(w*0.8), (float)(h*0.8))/8;
        dessinerLeCercle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mExtraBitmap, 0, 0, null);
    }

    public void dessinerLeCercle(){
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mExtraCanvas.drawColor(Color.WHITE);
        mExtraCanvas.drawCircle(reticuleX, reticuleY, rayon, mPaint);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int index = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;

        if (event.getAction() != MotionEvent.ACTION_MOVE){
            System.out.println( "\n\n" + index + "  --  " + event.toString());
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int historySize = event.getHistorySize();
                System.out.println(historySize);
                if (historySize > 0){
                    float dx = event.getX() - event.getHistoricalX(historySize-1);
                    float dy = event.getY() - event.getHistoricalY(historySize-1);
                    System.out.println("dx: " + dx + "; dy: " + dy);
                    reticuleX+=dx;
                    reticuleY+=dy;
                    dessinerLeCercle();
                }
            default:
                // do nothing
        }

        return true;
    }

    public void positionerReticule(float x, float y){
        reticuleX = x;
        reticuleY = y;
    }

    public float getReticuleX(){
        return reticuleX;
    }

    public float getReticuleY(){
        return reticuleY;
    }

}
