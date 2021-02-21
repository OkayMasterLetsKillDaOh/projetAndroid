package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.FlecheView;

public class TpEvenementActivity extends AppCompatActivity{

    private LinearLayout lineDark;
    private ToggleButton toggleDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        lineDark = findViewById(R.id.linearDark);
        toggleDark = findViewById(R.id.toggle1);

        toggleDark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(TpEvenementActivity.this, "CHECK", Toast.LENGTH_SHORT).show();

                if (isChecked) {
                    lineDark.setBackgroundColor(Color.BLACK);
                    Toast.makeText(TpEvenementActivity.this, "DARK", Toast.LENGTH_SHORT).show();
                } else {
                    lineDark.setBackgroundColor(Color.parseColor("#ffffff"));
                    Toast.makeText(TpEvenementActivity.this, "WHITE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
