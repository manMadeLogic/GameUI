package com.example.boxfishedu.gameui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.boxfishedu.gameui.ui.ClipSurfaceView;

public class MainActivity extends AppCompatActivity {

    ClipSurfaceView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        view=new ClipSurfaceView(this);
        setContentView(view);
    }
}
