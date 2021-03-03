package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.myapplication.R;
import com.example.myapplication.TP.utils.FlashlightCone;

public class TpInterfaceTactileUnView extends SurfaceView implements Runnable {

    private int mViewWidth;
    private int mViewHeight;
    private Paint mPaint;
    private Path mPathRectangle;
    private SurfaceHolder mSurfaceHolder;
    private float positionX;
    private float positionY;
    private Thread thread;

    public TpInterfaceTactileUnView(Context context) {
        super(context);
        mSurfaceHolder = getHolder();
    }

    public TpInterfaceTactileUnView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSurfaceHolder = getHolder();
    }

    public TpInterfaceTactileUnView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mSurfaceHolder = getHolder();
    }

    public void resume(){
        thread = new Thread(this);
        thread.start();
    }

    public void pause(){
        System.out.println("test!");
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Canvas canvas;
        while (true) {
            if (mSurfaceHolder.getSurface().isValid()) {
                System.out.println("On est dans le thread!");
                canvas = mSurfaceHolder.lockCanvas();
                canvas.save();
                canvas.drawColor(Color.WHITE);
                mPathRectangle.addRect(mViewWidth / 3, mViewHeight / 3, 2 * mViewWidth / 3, 2 * mViewHeight / 3, Path.Direction.CCW);

                if (positionX > mViewWidth / 3 && positionX < mViewWidth*2 / 3
                && positionY > mViewHeight/3 && positionY < mViewHeight*2/3) {
                    mPaint.setColor(Color.RED);
                } else {
                    mPaint.setColor(Color.BLUE);
                }
                canvas.drawPath(mPathRectangle, mPaint);

                mPathRectangle.rewind();
                canvas.restore();
                mSurfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE); // Win!
        mPathRectangle = new Path();
        positionX = w/2;
        positionY = h/2;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        positionX = event.getX();
        positionY = event.getY();
        return true;
    }
}
