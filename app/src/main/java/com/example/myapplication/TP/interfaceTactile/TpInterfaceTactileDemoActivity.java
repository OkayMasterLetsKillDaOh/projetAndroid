package com.example.myapplication.TP.interfaceTactile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.CercleView;

public class TpInterfaceTactileDemoActivity extends AppCompatActivity {

    CercleView c;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_interface_tactile_demo);
        c = findViewById(R.id.cercleView);

        prefs = PreferenceManager.getDefaultSharedPreferences(this); //getPreferences(MODE_PRIVATE)
        if (prefs.contains("reticule_x") && prefs.contains("reticule_y")){
            c.positionerReticule(prefs.getFloat("reticule_x", -1f), prefs.getFloat("reticule_y", -1f));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        prefs.edit().putFloat("reticule_x", c.getReticuleX()).apply();
        prefs.edit().putFloat("reticule_y", c.getReticuleY()).apply();
    }
}