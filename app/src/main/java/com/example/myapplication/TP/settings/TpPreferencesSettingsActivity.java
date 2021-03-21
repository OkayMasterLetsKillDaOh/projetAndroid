package com.example.myapplication.TP.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.myapplication.R;

public class TpPreferencesSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.tp_prefrences);
    }

}