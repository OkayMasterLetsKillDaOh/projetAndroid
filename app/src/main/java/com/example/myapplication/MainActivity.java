package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.TP.TpMainActivity;

public class MainActivity extends AppCompatActivity {

    private Button tpButton;

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


    }
}