package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.TP.settings.TpPreferencesSettingsActivity;

public class TpPreferencesDemoActivity extends AppCompatActivity {

    Button mButtonA;
    Button mButtonT;
    Button mButtonC;
    Button mButtonG;
    TextView mTextView;
    TableLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_preferences_demo);

        mButtonA = findViewById(R.id.button_a);
        mButtonT = findViewById(R.id.button_t);
        mButtonC = findViewById(R.id.button_c);
        mButtonG = findViewById(R.id.button_g);
        mTextView = findViewById(R.id.champ_de_texte);

        mButtonA.setOnClickListener(new ButtonPreferencesListener());
        mButtonT.setOnClickListener(new ButtonPreferencesListener());
        mButtonC.setOnClickListener(new ButtonPreferencesListener());
        mButtonG.setOnClickListener(new ButtonPreferencesListener());





        PreferenceManager.setDefaultValues(this, R.xml.tp_prefrences, false);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);


        tl = findViewById(R.id.table_layout);
        tl.setBackgroundColor(Color.parseColor(prefs.getString("couleur_de_fond", "#FFFFFF")));
        mButtonA.setEnabled(prefs.getBoolean("a", true));
        mButtonT.setEnabled(prefs.getBoolean("t", true));
        mButtonC.setEnabled(prefs.getBoolean("c", true));
        mButtonG.setEnabled(prefs.getBoolean("g", true));

        prefs.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                switch (key){
                    case ("couleur_de_fond"):{
                        tl.setBackgroundColor(Color.parseColor(sharedPreferences.getString(key, "#FFFFFF")));
                        return;
                    }
                    case ("a"):{
                        mButtonA.setEnabled(sharedPreferences.getBoolean(key, true));
                        return;
                    }
                    case("t"): {
                        mButtonT.setEnabled(sharedPreferences.getBoolean(key, true));
                        return;
                    }
                    case("c"): {
                        mButtonC.setEnabled(sharedPreferences.getBoolean(key, true));
                        return;
                    }
                    case("g"): {
                        mButtonG.setEnabled(sharedPreferences.getBoolean(key, true));
                        return;
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tp_preferences_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.preferences:
            {
                Intent intent = new Intent();
                intent.setClassName(this, "com.example.myapplication.TP.settings.TpPreferencesSettingsActivity");
                startActivity(intent);
                return true;
            }
            case R.id.test:
            {
                Toast.makeText(this, "Test Ok!", Toast.LENGTH_LONG).show();;
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    class ButtonPreferencesListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button b =(Button)v;
            mTextView.setText(mTextView.getText()+b.getText().toString());
        }
    }
}