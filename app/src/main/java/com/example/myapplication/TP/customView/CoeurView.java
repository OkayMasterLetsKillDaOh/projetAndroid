package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;

import com.example.myapplication.R;

/**
 * Created by MOMO Adrien Nickson on 19/02/21.
 */

public class CoeurView extends View {
    private Paint paint;
    private Path path;
    private int canvasWidth;
    private int canvasHeight;

    public CoeurView(Context context) {
        super(context);
        path = new Path();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasWidth = w;
        canvasHeight = h;

        paint.setShader(null);
        //        float width = getContext().getResources().getDimension(R.dimen.heart_width);
        //        float height = getContext().getResources().getDimension(R.dimen.heart_height);
        float width = 200;
        float height = 200;

        //Starting point
        path.moveTo(width / 2, height / 5);

        //Upper left path
        path.cubicTo(5 * width / 14, 0,
                0, height / 15,
                width / 28, 2 * height / 5);

        //Lower left path
        path.cubicTo(width / 14, 2 * height / 3,
                3 * width / 7, 5 * height / 6,
                width / 2, height);

        //Lower right path
        path.cubicTo(4 * width / 7, 5 * height / 6,
                13 * width / 14, 2 * height / 3,
                27 * width / 28, 2 * height / 5);

        //Upper right path
        path.cubicTo(width, height / 15,
                9 * width / 14, 0,
                width / 2, height / 5);

        paint.setColor(Color.RED);
        paint.setStyle(Style.FILL);
        path.offset((canvasWidth - width)/2,(canvasHeight - height)/2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Fill the canvas with background color
        canvas.drawColor(Color.BLACK);
        canvas.drawPath(path, paint);
    }
}