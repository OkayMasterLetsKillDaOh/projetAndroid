package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myapplication.TP.TpEvenementActivity;
import com.example.myapplication.TP.TpMainActivity;

public class MainActivity extends AppCompatActivity {

    private Button tpButton;
    private LinearLayout lineDark;
    private ToggleButton toggleDark;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tpButton = (Button) (findViewById(R.id.tp_button));
        System.out.println(tpButton);
        tpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tpLayoutActivityIntent = new Intent(MainActivity.this, TpMainActivity.class);
                startActivity(tpLayoutActivityIntent);
            }
        });

        lineDark = findViewById(R.id.linearDark);
        toggleDark = findViewById(R.id.toggle1);
        text = findViewById(R.id.text1);

        toggleDark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "CHECK", Toast.LENGTH_SHORT).show();

                if (isChecked) {
                    lineDark.setBackgroundColor(Color.BLACK);
                    text.setTextColor(Color.parseColor("#ffffff"));
                    Toast.makeText(MainActivity.this, "DARK", Toast.LENGTH_SHORT).show();
                } else {
                    lineDark.setBackgroundColor(Color.parseColor("#ffffff"));
                    Toast.makeText(MainActivity.this, "WHITE", Toast.LENGTH_SHORT).show();
                    text.setTextColor(Color.parseColor("#000000"));

                }
            }
        });
    }
}