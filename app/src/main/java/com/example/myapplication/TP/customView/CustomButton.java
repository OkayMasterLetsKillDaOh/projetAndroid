package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.Random;

/**
 * Created by MOMO Adrien Nickson on 19/02/21.
 */
public class CustomButton extends Button {

    private int canvasWidth;
    private int canvasHeight;
    private Color color;
    private AttributeSet attrs;
    public CustomButton(Context context) {
        super(context);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attrs = attrs;
        init();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attrs = attrs;
        init();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasWidth = w;
        canvasHeight = h;
    }

    private void init() {
        //setText("Changer de couleur");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        int[] colors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GRAY, Color.GREEN};

        p.setColor(colors[new Random().nextInt(colors.length)]);
        Rect rect = new Rect(0, 0, canvasWidth, canvasHeight);
        canvas.drawRect(rect, p);
        super.onDraw(canvas);
    }

}
