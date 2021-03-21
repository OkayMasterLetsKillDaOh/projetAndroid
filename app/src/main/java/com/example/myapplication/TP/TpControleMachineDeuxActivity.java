package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.GoogleView;

public class TpControleMachineDeuxActivity extends AppCompatActivity {

    GoogleView mGoogleView;
    RadioGroup mRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_controle_machine_deux);
        mRadioGroup = findViewById(R.id.radioGroup);
        mGoogleView = findViewById(R.id.googleView);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case (R.id.radioButtonCourt): {
                        mGoogleView.dessinerCourt();
                        break;
                    }
                    case (R.id.radioButtonCarre): {
                        mGoogleView.dessinerCarre();
                        break;
                    }
                    case (R.id.radioButtonArrondi): {
                        mGoogleView.dessinerArrondi();
                        break;
                    }
                }
            }
        });
    }
}