package com.example.boxfishedu.gameui.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.boxfishedu.gameui.MainActivity;
import com.example.boxfishedu.gameui.R;

// +----------------------------------------------------------------------
// | CreateTime: 17/1/3 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.xueyong.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public class ClipSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private final MainActivity activity;
    private Path mPath;
    private Path mPath1;//创建多边形路径
    private Paint paint;
    private Bitmap bm;

    public ClipSurfaceView(Context context) {
        super(context);
        this.activity = (MainActivity)context;
        this.getHolder().addCallback(this);
        paint = new Paint();
        paint.setAntiAlias(true);
        mPath = new Path();
        mPath.moveTo(350, 20);
        mPath.lineTo(520, 20);
        mPath.lineTo(500, 170);
        mPath.lineTo(330, 170);
        mPath.lineTo(350, 20);

        //设置路径
        mPath1=new Path();
        mPath1.moveTo(170, 50);
        mPath1.lineTo(260, 50);
        mPath1.lineTo(240, 120);
        mPath1.lineTo(150, 120);
        mPath1.lineTo(170, 50);

        bm= BitmapFactory.decodeResource(activity.getResources(), R.drawable.tubiao);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//    public void draw(Canvas canvas) {
//        super.draw(canvas);
//        canvas.drawARGB(0, 0, 0, 0);
//        canvas.drawARGB(128, 128, 128, 128);
        canvas.drawARGB(255, 128, 255, 0);
        canvas.save();
        canvas.clipRect(30, 20,280, 250);//裁剪一个矩形
        canvas.drawColor(Color.WHITE);//画布设置为白色
        paint.setColor(Color.RED);
        canvas.drawCircle(85, 75, 50, paint);//绘制红色圆形
        paint.setColor(Color.BLUE);
        canvas.drawRect(170,150, 260, 240, paint);//绘制蓝色矩形
        canvas.restore();//恢复至前的保存状态

        canvas.save();//保存当前状态
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath1, paint);//绘制黑色平行四边形边框
        canvas.restore();//恢复至前的保存状态

        canvas.save();//保存当前状态
        canvas.clipPath(mPath);//根据路径裁剪出平行四边形
        canvas.drawBitmap(bm, 10, 20, paint);//贴图
        canvas.restore();

        canvas.save();
        canvas.clipRect(30, 300, 180, 450);
        canvas.clipRect(55, 325, 155, 425, Region.Op.DIFFERENCE);//裁剪出回字形
        canvas.drawBitmap(bm, 33, 130, paint);//贴图
        canvas.restore();

        canvas.save();
        mPath.reset();
        mPath.addCircle(470, 479, 240, Path.Direction.CCW);
        canvas.clipPath(mPath, Region.Op.REPLACE);//根据路径剪裁出圆形
        canvas.drawBitmap(bm, 130, 150, paint);
        canvas.restore();

        canvas.save();
        canvas.clipRect(80, 790, 600, 960);//绘制矩形
        canvas.clipRect(270, 790, 430, 1200, Region.Op.UNION);//连接两个矩形
        canvas.drawColor(Color.RED);//超出图片的部分绘制成红色
        canvas.drawBitmap(bm, 110, 450, paint);
        canvas.restore();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Canvas canvas = surfaceHolder.lockCanvas();
        try {
            synchronized (surfaceHolder) {
//                draw(canvas);
                onDraw(canvas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

//        Canvas canvas = surfaceHolder.lockCanvas();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
