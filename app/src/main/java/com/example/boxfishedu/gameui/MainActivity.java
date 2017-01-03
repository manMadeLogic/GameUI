package com.example.boxfishedu.gameui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.boxfishedu.gameui.ui.ClipSurfaceView;

public class MainActivity extends AppCompatActivity {

    Animation animation;
    ImageView myImage;
    ClipSurfaceView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        view=new ClipSurfaceView(this);
//        setContentView(view);

        animation = AnimationUtils.loadAnimation(this, R.anim.myanim);
        myImage = (ImageView) this.findViewById(R.id.myImage);
        myImage.startAnimation(animation);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        myImage.startAnimation(animation);
        return super.onTouchEvent(event);
    }
}
