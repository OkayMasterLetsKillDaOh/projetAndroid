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
 * Created by MOMO Adrien Nickson on 21/02/21.
 */
public class FlecheView extends View {

    private Paint paint;
    private Path path;
    private int canvasWidth;
    private int canvasHeight;

    public FlecheView(Context context) {
        super(context);
        path = new Path();
        paint = new Paint();
    }

    public FlecheView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        paint = new Paint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasWidth = w;
        canvasHeight = h;

        float mid = canvasWidth / 2;
        float min = Math.min(canvasWidth, canvasHeight);
        float half = min / 2;

        mid = mid - half;


        //top left
        path.moveTo(mid + half * 0.2f, half * 0.84f);
        //top right
        path.lineTo(mid + half * 1.2f, half * 0.84f);

        path.lineTo(mid + half * 1.2f, half * 0.55f);

        path.lineTo(mid + half * 1.8f, half );

        path.lineTo(mid + half * 1.2f, half * 1.45f);

        path.lineTo(mid + half * 1.2f, half * 1.16f);

        path.lineTo(mid + half * 0.2f, half * 1.16f);

        path.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, paint);
    }
}
