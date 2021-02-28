package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.TpInterfaceTactileUnView;

public class TpInterfaceTactileActivity extends AppCompatActivity {

    TpInterfaceTactileUnView tpInterfaceTactileUnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_interface_tactile);
        tpInterfaceTactileUnView = findViewById(R.id.tp_interface_tactile_un);
    }

    @Override
    protected void onPause() {
        super.onPause();
        tpInterfaceTactileUnView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tpInterfaceTactileUnView.resume();
    }

}