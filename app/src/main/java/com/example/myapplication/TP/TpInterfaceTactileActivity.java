package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.TP.interfaceTactile.TpInterfaceTactileArdoiseActivity;
import com.example.myapplication.TP.interfaceTactile.TpInterfaceTactileAvanceDemoActivity;
import com.example.myapplication.TP.interfaceTactile.TpInterfaceTactileDemoActivity;

public class TpInterfaceTactileActivity extends AppCompatActivity {

    private Button interfaceTactileDemoButton;
    private Button ardoiseButton;
    private Button interfaceTactileAvanceDemoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_interface_tactile_main);

        interfaceTactileDemoButton = (Button) (findViewById(R.id.tp_interface_tactile_demo));
        interfaceTactileDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpInterfaceTactileDemoActivityIntent = new Intent(TpInterfaceTactileActivity.this, TpInterfaceTactileDemoActivity.class);
                startActivity(tpInterfaceTactileDemoActivityIntent);
            }
        });

        interfaceTactileAvanceDemoButton = (Button) (findViewById(R.id.tp_interface_tactile_avance_demo));
        interfaceTactileAvanceDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpInterfaceTactileAvanceDemoActivityIntent = new Intent(TpInterfaceTactileActivity.this, TpInterfaceTactileAvanceDemoActivity.class);
                startActivity(tpInterfaceTactileAvanceDemoActivityIntent);
            }
        });

        ardoiseButton = (Button) (findViewById(R.id.ardoise));
        ardoiseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent anterfaceTactileArdoiseActivity = new Intent(TpInterfaceTactileActivity.this, TpInterfaceTactileArdoiseActivity.class);
                startActivity(anterfaceTactileArdoiseActivity);
            }
        });

    }
}