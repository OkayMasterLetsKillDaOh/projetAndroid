package com.example.myapplication.TP;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CycleDeVieDemoActivity extends AppCompatActivity {

    List<TextView> textViews = new ArrayList<TextView>();
    LinearLayout ll;

    public String getNow(){
        return (new SimpleDateFormat("HH 'h,' mm 'minutes,' ss 'secondes.' - SS 'Millisecondes'")).format(new Date());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_de_vie_demo);
        ll = findViewById(R.id.ll);

        TextView texte = new TextView(this);
        texte.setText("onCreate: " + getNow());
        ll.addView(texte);
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
}