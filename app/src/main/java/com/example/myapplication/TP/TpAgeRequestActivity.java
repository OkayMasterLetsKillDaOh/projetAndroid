package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class TpAgeRequestActivity extends AppCompatActivity {

    public static final String AGE_KEY = "AGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_age_request);

        Button b = findViewById(R.id.age_submit);
        EditText e = findViewById(R.id.age_input);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.putExtra(AGE_KEY, Integer.parseInt(e.getText().toString()));
                    setResult(RESULT_OK, intent);
                    finish();
                }catch (Exception e){
                    Toast.makeText(TpAgeRequestActivity.this, "L'age n'est pas correct!", Toast.LENGTH_LONG);
                }
            }
        });

    }
}