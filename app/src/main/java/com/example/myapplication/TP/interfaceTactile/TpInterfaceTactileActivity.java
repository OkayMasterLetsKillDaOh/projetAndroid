package com.example.myapplication.TP.interfaceTactile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.TpInterfaceTactileUnView;

public class TpInterfaceTactileActivity extends AppCompatActivity {

    // Initial offset for rectangle.
    private static final int OFFSET = 120;
    // Multiplier for randomizing color.
    private static final int MULTIPLIER = 100;

    // The Canvas object stores information on WHAT to draw
    // onto its associated bitmap.
    // For example, lines, circles, text, and custom paths.
    private Canvas mCanvas;

    // The Paint object stores HOW to draw.
    // For example, what color, style, line thickness, or text size.
    // The Paint class offers a rich set of coloring and drawing options.
    private Paint mPaint = new Paint();

    // Create a Paint object for underlined text.
    // The Paint clas offers a full complement of typographical styling methods.
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);

    // The bitmap represents the pixels that will be displayed.
    private Bitmap mBitmap;

    // The view is the container for the bitmap.
    // Layout on the screen and all user interaction is through the view.
    private ImageView mImageView;

    private Rect mRect = new Rect();
    // Distance of rectangle from edge of canvas.
    private int mOffset = OFFSET;
    // Bounding box for text.
    private Rect mBounds = new Rect();

    private int mColorBackground;
    private int mColorRectangle;
    private int mColorAccent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_interface_tactile);

        mColorBackground = Color.parseColor("#FFFFD600");

        mColorRectangle = Color.parseColor("#455A64");

        mColorAccent = Color.parseColor("#FF4081");

        // Set properties of the Paint used to draw on the canvas.
        mPaint.setColor(mColorBackground);
        mPaintText.setColor(Color.parseColor("#303F9F"));
        mPaintText.setTextSize(70);

        // Get a reference to the ImageView.
        mImageView = (ImageView) findViewById(R.id.myimageview);

        // You cannot create the Canvas in onCreate(),
        // because the views have not been
        // laid out, so their final size is not available.
        // When you create a custom view in a later lesson,
        // you will learn other ways of initializing your drawing surface.
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            this.drawSomething(mImageView);
        if (event.getAction() == MotionEvent.ACTION_HOVER_MOVE)
            Toast.makeText(this, "Moving...", Toast.LENGTH_SHORT).show();
        return false;
    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        int halfWidth = vWidth / 2;
        int halfHeight = vHeight / 2;
        // Only do this first time view is clicked after it has been created.
        if (mOffset == OFFSET) { // Only true once, so don't need separate flag.
            // Each pixel takes 4 bytes, with alpha channel.
            // Use RGB_565 if you don't need alpha and a huge color palette.
            mBitmap = Bitmap.createBitmap(
                    vWidth, vHeight, Bitmap.Config.ARGB_8888);
            // Associate the bitmap to the ImageView.
            mImageView.setImageBitmap(mBitmap);
            // Create a Canvas with the bitmap.
            mCanvas = new Canvas(mBitmap);
            // Fill the entire canvas with this solid color.
            mCanvas.drawColor(mColorBackground);
            // Draw some text styled with mPaintText.
            mCanvas.drawText("Continnuer à taper...", 100, 100, mPaintText);
            // Increase the indent.
            mOffset += OFFSET;
        } else {
            // Draw in response to user action.
            // As this happens on the UI thread, there is a limit to complexity.
            if (mOffset < halfWidth && mOffset < halfHeight) {
                // Change the color by subtracting an integer.
                mPaint.setColor(mColorRectangle - MULTIPLIER*mOffset);
                mRect.set(
                        mOffset, mOffset, vWidth - mOffset, vHeight - mOffset);
                mCanvas.drawRect(mRect, mPaint);
                // Increase the indent.
                mOffset += OFFSET;
            } else {
                mPaint.setColor(mColorAccent);
                mCanvas.drawCircle(
                        halfWidth, halfHeight, halfWidth / 3, mPaint);
                String text = "Done!";
                // Get bounding box for text to calculate where to draw it.
                mPaintText.getTextBounds(text, 0, text.length(), mBounds);
                // Calculate x and y for text so it's centered.
                int x = halfWidth - mBounds.centerX();
                int y = halfHeight - mBounds.centerY();
                mCanvas.drawText(text, x, y, mPaintText);
                //mCanvas = new Canvas(mBitmap);
                //mOffset = OFFSET;
            }
        }
        // Invalidate the view, so that it gets redrawn.
        view.invalidate();
    }

}