package com.example.myapplication.TP;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TpCycleDeVieDemoActivity extends AppCompatActivity {

    List<TextView> textViews = new ArrayList<TextView>();
    LinearLayout ll;
    public static final int AGE_REQUEST_ACTIVITY_CODE = 11;
    private Button mAgeButton;

    public String getNow(){
        return (new SimpleDateFormat("HH 'h,' mm 'minutes,' ss 'secondes.' - SS 'Millisecondes'")).format(new Date());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_cycle_de_vie_demo);
        ll = findViewById(R.id.ll);
        TextView texte = new TextView(this);
        texte.setText("onCreate: " + getNow());
        ll.addView(texte);
        mAgeButton = findViewById(R.id.age_button);
        mAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(TpCycleDeVieDemoActivity.this, TpAgeRequestActivity.class);
                startActivityForResult(gameActivityIntent, AGE_REQUEST_ACTIVITY_CODE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView texte = new TextView(this);
        texte.setText("onStart: " + getNow());
        ll.addView(texte);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Content de te revoir!", Toast.LENGTH_LONG);
        TextView texte = new TextView(this);
        texte.setText("onResume: " + getNow());
        ll.addView(texte);
    }

    @Override
    protected void onPause() {
        super.onPause();
        TextView texte = new TextView(this);
        texte.setText("onPause: " + getNow());
        ll.addView(texte);
    }

    @Override
    protected void onStop() {
        super.onStop();
        TextView texte = new TextView(this);
        texte.setText("onStop: " + getNow());
        ll.addView(texte);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        TextView texte = new TextView(this);
        texte.setText("onActivityResult: " + getNow());
        ll.addView(texte);

        if (requestCode == AGE_REQUEST_ACTIVITY_CODE && resultCode == RESULT_OK) {
            int age = data.getIntExtra(TpAgeRequestActivity.AGE_KEY, -1);
            texte = new TextView(this);
            texte.setText("Okay Master Let's Kill Da Oh a " + age + " ans!");
            texte.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
            ll.addView(texte);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}