package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class TpMainActivity extends AppCompatActivity {

    private Button relativeLayoutDemoButton;
    private Button relativeLayoutButton;
    private Button dessinDemoButton;
    private Button dessinButton;
    private Button evenementsDemoButton;
    private Button evenementsButton;
    private Button interfaceTactileDemoButton;
    private Button interfaceTactileButton;
    private Button interfaceTactileAvanceDemoButton;
    private Button interfaceTactileAvanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_main);

        relativeLayoutDemoButton = (Button) (findViewById(R.id.tp_relative_layout_demo));
        relativeLayoutDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpLayoutActivityIntent = new Intent(TpMainActivity.this, TpRelativeLayoutDemoActivity.class);
                startActivity(tpLayoutActivityIntent);
            }
        });

        relativeLayoutButton = (Button) (findViewById(R.id.tp_relative_layout));
        relativeLayoutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(TpMainActivity.this, "Lets GO!", Toast.LENGTH_SHORT).show();
                Intent tpLayoutActivityIntent = new Intent(TpMainActivity.this, TpRelativeLayoutActivity.class);
                startActivity(tpLayoutActivityIntent);
            }
        });

        dessinDemoButton = (Button) (findViewById(R.id.tp_dessin_demo));
        dessinDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(TpMainActivity.this, "Lets GO!", Toast.LENGTH_SHORT).show();
                Intent tpLayoutActivityIntent = new Intent(TpMainActivity.this, TpDessinDemoActivity.class);
                startActivity(tpLayoutActivityIntent);
            }
        });

        dessinButton = (Button) (findViewById(R.id.tp_dessin));
        dessinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(TpMainActivity.this, "Lets GO!", Toast.LENGTH_SHORT).show();
                Intent tpDessinActivityIntent = new Intent(TpMainActivity.this, TpDessinActivity.class);
                startActivity(tpDessinActivityIntent);
            }
        });

        evenementsDemoButton = (Button) (findViewById(R.id.tp_evenements_demo));
        evenementsDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpEvenementsActivityIntent = new Intent(TpMainActivity.this, TpEvenementDemoActivity.class);
                startActivity(tpEvenementsActivityIntent);
            }
        });

        interfaceTactileDemoButton = (Button) (findViewById(R.id.tp_interface_tactile_demo));
        interfaceTactileDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpInterfaceTactileDemoActivityIntent = new Intent(TpMainActivity.this, TpInterfaceTactileDemoActivity.class);
                startActivity(tpInterfaceTactileDemoActivityIntent);
            }
        });

        interfaceTactileButton = (Button) (findViewById(R.id.tp_interface_tactile));
        interfaceTactileButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpInterfaceTactileActivityIntent = new Intent(TpMainActivity.this, TpInterfaceTactileActivity.class);
                startActivity(tpInterfaceTactileActivityIntent);
            }
        });
        interfaceTactileAvanceDemoButton = (Button) (findViewById(R.id.tp_interface_tactile_avance_demo));
        interfaceTactileAvanceDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpInterfaceTactileAvanceDemoActivityIntent = new Intent(TpMainActivity.this, TpInterfaceTactileAvanceDemoActivity.class);
                startActivity(tpInterfaceTactileAvanceDemoActivityIntent);
            }
        });

    }
}