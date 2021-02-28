package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.FlecheView;

import java.util.ArrayList;
import java.util.List;

public class TpEvenementActivity extends AppCompatActivity{

    private EditText cels;
    private EditText far;
    private Spinner spinner;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tp_evenement);

        cels = findViewById(R.id.textCelsius);
        far = findViewById(R.id.textFar);

        cels.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                try {
                    float c = Float.parseFloat(v.getText().toString());
                    Toast.makeText(TpEvenementActivity.this, "Le nombre est OK!", Toast.LENGTH_SHORT).show();
                    c = ((9f*c)/5f) + 32f;
                    far.setText(""+c);
                } catch (Exception e) {
                    Toast.makeText(TpEvenementActivity.this, "Le nombre est incorrect", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        far.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                try {
                    float c = Float.parseFloat(v.getText().toString());
                    Toast.makeText(TpEvenementActivity.this, "Le nombre est OK!", Toast.LENGTH_SHORT).show();
                    c = (c-32f)*(5f/9f);
                    cels.setText(""+c);
                } catch (Exception e) {
                    Toast.makeText(TpEvenementActivity.this, "Le nombre est incorrect", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        List liste = new ArrayList();
        liste.add("Croix");
        liste.add("Carré");
        liste.add("Rond");
        liste.add("Triangle");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, liste);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
    }

