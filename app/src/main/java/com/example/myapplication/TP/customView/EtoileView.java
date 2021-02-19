package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by MOMO Adrien Nickson on 19/02/21.
 */
public class EtoileView extends View {

    private Paint paint;
    private Path path;
    private int canvasWidth;
    private int canvasHeight;

    public EtoileView(Context context) {
        super(context);
    }

    public EtoileView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EtoileView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EtoileView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasWidth = w;
        canvasHeight = h;

//        path.offset((canvasWidth - width)/2,(canvasHeight - height)/2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);

        Path path = new Path();
        float mid = canvasWidth / 2;
        float min = Math.min(canvasWidth, canvasHeight);
        float half = min / 2;

        // pour le cercle
        float fat = min / 17;
        float rad = half - fat;

        mid = mid - half;

        paint.setStrokeWidth(fat);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(mid + half, half, rad, paint);

        path.reset();

        paint.setStyle(Paint.Style.FILL);


        //top left
        path.moveTo(mid + half * 0.5f, half * 0.84f);
        //top right
        path.lineTo(mid + half * 1.5f, half * 0.84f);
        //bottom left
        path.lineTo(mid + half * 0.68f, half * 1.45f);
        //top tip
        path.lineTo(mid + half * 1.0f, half * 0.5f);
        //bottom right
        path.lineTo(mid + half * 1.32f, half * 1.45f);
        //top left
        path.lineTo(mid + half * 0.5f, half * 0.84f);

        path.close();
        canvas.drawPath(path, paint);
    }
}
