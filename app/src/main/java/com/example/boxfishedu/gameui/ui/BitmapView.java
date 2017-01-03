package com.example.boxfishedu.gameui.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.boxfishedu.gameui.R;

// +----------------------------------------------------------------------
// | CreateTime: 17/1/3 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.xueyong.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public class BitmapView extends View {
    Bitmap myBitMap;
    Paint paint;

    public BitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initBitmap();
    }

    private void initBitmap() {
        paint = new Paint();
        myBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setTextSize(15);
        canvas.drawBitmap(myBitMap, 10, 10, paint);
        canvas.save();
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        Matrix m3 = new Matrix();
        m1.setTranslate(500, 10);
        m2.setRotate(15);
        m3.setConcat(m1, m2);
        m1.setScale(0.8f, 0.8f);
        m2.setConcat(m1, m3);
        canvas.drawBitmap(myBitMap, m2, paint);
        canvas.restore();
//        canvas.save();
    }
}
