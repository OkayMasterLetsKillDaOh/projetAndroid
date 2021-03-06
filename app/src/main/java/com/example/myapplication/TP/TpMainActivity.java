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
    private Button interfaceTactileButton;
    private Button cycleDeVieButton;
    private Button cycleDeVieDemoButton;
    private Button preferencesButton;
    private Button preferencesDemoButton;
    private Button controleMachineUnButton;
    private Button controleMachineDeuxButton;

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

        interfaceTactileButton = (Button) (findViewById(R.id.tp_interface_tactile));
        interfaceTactileButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpInterfaceTactileActivityIntent = new Intent(TpMainActivity.this, TpInterfaceTactileActivity.class);
                startActivity(tpInterfaceTactileActivityIntent);
            }
        });

        cycleDeVieDemoButton = (Button) (findViewById(R.id.tp_cycle_de_vie_demo));
        cycleDeVieDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpCycleDeVieDemoActivityIntent = new Intent(TpMainActivity.this, TpCycleDeVieDemoActivity.class);
                startActivity(tpCycleDeVieDemoActivityIntent);
            }
        });

        preferencesDemoButton = (Button) (findViewById(R.id.tp_preferences_demo));
        preferencesDemoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpPreferencesDemoActivityIntent = new Intent(TpMainActivity.this, TpPreferencesDemoActivity.class);
                startActivity(tpPreferencesDemoActivityIntent);
            }
        });

        controleMachineDeuxButton = (Button) (findViewById(R.id.tp_controle_machine_deux));
        controleMachineDeuxButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpControleMachineDeuxActivityIntent = new Intent(TpMainActivity.this, TpControleMachineDeuxActivity.class);
                startActivity(tpControleMachineDeuxActivityIntent);
            }
        });

    }
}