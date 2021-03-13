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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by MOMO Adrien Nickson on 09/03/21.
 */
public class TpInterfaceTactileExerciceUnView extends View {

    private Canvas mExtraCanvas;
    private Bitmap mExtraBitmap;
    private List<Pointeur> pointeurs;
    int[] couleurs = { Color.GREEN, Color.LTGRAY, Color.YELLOW, Color.BLUE, Color.GRAY, Color.CYAN, Color.DKGRAY, Color.parseColor("#15FE5A"), Color.GRAY, Color.WHITE};
    private Paint mPaint;

    public TpInterfaceTactileExerciceUnView(Context context) {
        super(context);
    }

    public TpInterfaceTactileExerciceUnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TpInterfaceTactileExerciceUnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Note: Called whenever the view changes size.
     * Since the view starts out with no size, this is also called after
     * the view has been inflated and has a valid size.
     */
    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        mExtraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mExtraCanvas = new Canvas(mExtraBitmap);
        pointeurs = new ArrayList<>();
        mPaint = new Paint();
        dessinerPoints();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mExtraBitmap, 0, 0, null);
    }

    private void dessinerPoints(){
        mExtraCanvas.drawColor(Color.parseColor("#000000"));
        Paint mPaint = new Paint();
        int rayon  = 75;
        for (int i = 0; i < pointeurs.size(); i++) {
            mPaint.setColor(pointeurs.get(i).getColor());
            mExtraCanvas.drawCircle(pointeurs.get(i).getX(), pointeurs.get(i).getY(), rayon, mPaint);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;

        if (event.getAction() != MotionEvent.ACTION_MOVE){
            System.out.println( "\n\n" + index + "  --  " + event.toString());
        }

        if (true){
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pointeurs.add(new Pointeur(event.getX(index), event.getY(index), index <  couleurs.length ? couleurs[index] : couleurs[new Random().nextInt(couleurs.length)]));
                    System.out.println( "ACTION_DOWN");
                    dessinerPoints();
                    break;
                case MotionEvent.ACTION_UP:
                    pointeurs.remove(index);
                    System.out.println("ACTION_UP");
                    dessinerPoints();
                    break;
                default:
                    // do nothing
            }
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_POINTER_DOWN:
                    pointeurs.add(new Pointeur(event.getX(index), event.getY(index), index <  couleurs.length ? couleurs[index] : couleurs[new Random().nextInt(couleurs.length)]));
                    dessinerPoints();
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    pointeurs.remove(index);
                    dessinerPoints();
                    break;
                default:
                    // do nothing
            }
        }

        return true;
    }

    private class Pointeur{
        float x;
        float y;
        int color;

        public Pointeur(float x, float y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public int getColor() {
            return color;
        }
    }
}
