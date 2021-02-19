package com.example.myapplication.TP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.CercleView;
import com.example.myapplication.TP.customView.CoeurView;
import com.example.myapplication.TP.customView.CarteView;
import com.example.myapplication.TP.customView.EtoileView;

public class TpDessinDemoActivity extends AppCompatActivity {

    private LinearLayout llCercle;
    private LinearLayout llEtoile;
    private LinearLayout llCoeur;
    private LinearLayout llCarte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_dessin_demo);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0,
                300, (float) 0.7);

        llCercle = (LinearLayout) (findViewById(R.id.ll_cercle));
        CercleView cercleView = new CercleView(this);
        cercleView.setLayoutParams(lp);
        llCercle.addView(cercleView);

        /*llEtoile = (LinearLayout) (findViewById(R.id.ll_etoile));
        EtoileView etoileView = new EtoileView(this);
        etoileView.setLayoutParams(lp);
        llEtoile.addView(etoileView);*/

        llCoeur = (LinearLayout) (findViewById(R.id.ll_coeur));
        CoeurView coeurView = new CoeurView(this);
        coeurView.setLayoutParams(lp);
        llCoeur.addView(coeurView);

        llCarte = (LinearLayout) (findViewById(R.id.ll_carte));
        CarteView carteView = new CarteView(this);
        carteView.setLayoutParams(new LinearLayout.LayoutParams(0,
                600, (float) 0.5));
        llCarte.addView(carteView);

    }
}