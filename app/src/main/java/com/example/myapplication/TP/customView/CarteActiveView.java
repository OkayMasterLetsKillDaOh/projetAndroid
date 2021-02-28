package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Created by MOMO Adrien Nickson on 19/02/21.
 */

public class CarteActiveView extends View {
    private Paint mPaint;
    private Path mPath;
    private Path mPath2;
    private Path mPath3;
    private int canvasWidth;
    private int canvasHeight;
    Context context;
    Canvas canvas;

    public CarteActiveView(Context context) {
        super(context);
        this.context = context;
    }

    public CarteActiveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CarteActiveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public CarteActiveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
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
        mPath.lineTo(width / 10, 3*height / 5);
        mPath.lineTo(width / 2, height);
        mPath.lineTo(9*width/10, 3*height / 5);
        mPath.close();

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
        this.canvas = canvas;
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE); // default: FILL
        mPaint.setStrokeWidth(12); // default: Hairline-width (really thin)
        canvas.drawRect(30, 30, canvasWidth - 30, canvasHeight - 30, mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE); // default: FILL
        canvas.drawPath(mPath, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath2, mPaint);
        canvas.drawPath(mPath3, mPaint);
        canvas.drawCircle(50, 50, 50, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        String position = "X:" + x + "; Y:" + y;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                dessinerPoint(x,y);
                invalidate();
                break;
            default:
                // Do nothing.
        }
        return true;
    }

    public void dessinerPoint(float x, float y){
        System.out.println("---");
        canvas.drawCircle(x, y, 50, mPaint);
    }
}
