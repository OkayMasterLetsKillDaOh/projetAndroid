package com.example.myapplication.TP.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

/**
 * Created by MOMO Adrien Nickson on 19/02/21.
 */
public class CustomImageDemoView extends View {

    private Drawable mCustomImage;
    private int canvasWidth;
    private int canvasHeight;

    public CustomImageDemoView(Context context) {
        super(context);
        mCustomImage = context.getResources().getDrawable(R.drawable.android_fun);
    }

    public CustomImageDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mCustomImage = context.getResources().getDrawable(R.drawable.android_fun);
    }

    public CustomImageDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomImageDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mCustomImage.setBounds(0, 0, canvasWidth, canvasWidth/2 );
        mCustomImage.draw(canvas);

        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
        textPaint.setColor(Color.WHITE);

        String text = "Quand android à  faim il croque à la pomme!!!";
        StaticLayout staticLayout = new StaticLayout(text, textPaint, (int) canvasWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0, false);
        staticLayout.draw(canvas);
    }
}
