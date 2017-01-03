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
    Bitmap myBitmap;
    Paint paint;

    public BitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initBitmap();
    }

    private void initBitmap() {
        paint = new Paint();
        myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setTextSize(15);
        canvas.drawBitmap(myBitmap, 10, 10, paint);
        canvas.save();
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        Matrix m3 = new Matrix();
        m1.setTranslate(500, 10);
        m2.setRotate(15);
        m3.setConcat(m1, m2);
        m1.setScale(0.8f, 0.8f);
        m2.setConcat(m1, m3);
        canvas.drawBitmap(myBitmap, m2, paint);
        canvas.restore();
        canvas.save();
        paint.setAlpha(180);
        m1.setTranslate(200,100);
        m2.setScale(1.3f, 1.3f);
        m3.setConcat(m1, m2);
        canvas.drawBitmap(myBitmap, m3,  paint);
        paint.reset();
        canvas.restore();
        paint.setTextSize(40);
        paint.setColor(0xffFFFFFF);
        canvas.drawText("图片的宽度: "+myBitmap.getWidth(), 20, 380, paint);//绘制字符串，图片的宽度
        canvas.drawText("图片的高度: "+myBitmap.getHeight(), 20, 430, paint);//绘制字符串，图片的高度
        paint.reset();
    }
}
