package com.example.myapplication.TP.interfaceTactile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.GameView;

public class TpInterfaceTactileAvanceDemoActivity extends AppCompatActivity {

    private GameView mGameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_interface_tactile_avance_demo);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mGameView = new GameView(this);
        // Android 4.1 and higher simple way to request fullscreen.
        //mGameView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(mGameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGameView.resume();
    }

}