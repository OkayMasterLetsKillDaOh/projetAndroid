package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Printer;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by MOMO Adrien Nickson on 21/03/21.
 */
public class GoogleView extends View {
    private Canvas mExtraCanvas;
    private Bitmap mExtraBitmap;
    private int canvasWidth;
    private int canvasHeight;
    private Path path;
    private Paint paint;
    private Paint.Join paintStyle = Paint.Join.BEVEL;
    private boolean logoNoir = false;

    public GoogleView(Context context) {
        super(context);
    }

    public GoogleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GoogleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        canvasWidth = w;
        canvasHeight = h;
        super.onSizeChanged(w, h, oldw, oldh);
        mExtraBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mExtraCanvas = new Canvas(mExtraBitmap);
        path = new Path();

        float x = Math.min(canvasWidth, canvasHeight)/4;
        float dx = 7*x/12;

        //en haut
        path.moveTo(canvasWidth / 2, canvasHeight / 2 - x);

        // à gauche
        path.cubicTo(canvasWidth / 2 - dx, canvasHeight / 2 - x,
                canvasWidth / 2 - x, canvasHeight / 2 - dx,
                canvasWidth / 2 - x, canvasHeight / 2);

        // à en bas
        path.cubicTo(canvasWidth / 2 - x, canvasHeight / 2 + dx,
                canvasWidth / 2 - dx, canvasHeight / 2 + x,
                canvasWidth / 2, canvasHeight / 2 + x);

        //à droite
        path.cubicTo(canvasWidth / 2 + dx, canvasHeight / 2 + x,
                canvasWidth / 2 + x, canvasHeight / 2 + dx,
                canvasWidth / 2 + x, canvasHeight / 2);

        // vers le milieu
        path.lineTo(canvasWidth / 2, canvasHeight / 2);


        paint = new Paint();
        paint.setStrokeWidth(Math.min(canvasWidth, canvasHeight)/10);
        paint.setStyle(Paint.Style.STROKE);

        dessinerLogo();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mExtraBitmap, 0, 0, null);
    }

    public void dessinerLogo(){
        mExtraCanvas.drawColor(Color.parseColor("#0099cc"));
        if (logoNoir){
            paint.setColor(Color.BLACK);
        }else{
            paint.setColor(Color.WHITE);
        }
        paint.setStrokeJoin(paintStyle);
        mExtraCanvas.drawPath(path, paint);
        invalidate();
    };

    public void dessinerArrondi() {
        paintStyle = Paint.Join.ROUND;
        dessinerLogo();
    }

    public void dessinerCarre() {
        paintStyle = Paint.Join.MITER;
        dessinerLogo();
    }

    public void dessinerCourt() {
        paintStyle = Paint.Join.BEVEL;
        dessinerLogo();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //System.out.println();
        if (event.getPointerCount() > 0){
            logoNoir = true;
        }else {
            logoNoir = false;
        }
        return true;
    }

}
