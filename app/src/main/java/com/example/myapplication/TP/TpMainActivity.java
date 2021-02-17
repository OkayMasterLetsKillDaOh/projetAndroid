package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class TpMainActivity extends AppCompatActivity {

    private Button relativeLayoutDemoButton;
    private Button relativeLayoutButton;

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

    }
}