package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.AsView;

public class TpDessinActivity extends AppCompatActivity {

    private LinearLayout llTp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_dessin);

        llTp = (LinearLayout) (findViewById(R.id.ll_viewtp));
        AsView asView = new AsView(this);
        asView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        llTp.addView(asView);
    }
}