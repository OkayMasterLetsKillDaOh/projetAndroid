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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.TP.customView.FlecheView;

public class TpEvenementDemoActivity extends AppCompatActivity {

    /*Exercice 1*/
    private FrameLayout mFrameLayout;
    private FlecheView mFlecheView;
    private Button mDroite;
    private Button mGauche;
    private String mOrientation;

    /*Exercice 1*/
    private EditText mEditText;
    private TextView mTextView;

    private ScrollView mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Exercice 1*/
        mOrientation = "right";
        setContentView(R.layout.activity_tp_evenement_demo);

        // On récupère la largeur de l'écrant pour pouvoir créer un carré
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, width);
        mFrameLayout = findViewById(R.id.fleche_layout);
        mFrameLayout.setLayoutParams(lp);

        mFlecheView = new FlecheView(this);
        mFrameLayout.addView(mFlecheView);

        mDroite = findViewById(R.id.right);
        mGauche = findViewById(R.id.left);

        mDroite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mOrientation != "right"){
                    mFlecheView.setRotation(0);
                    mOrientation = "right";
                } else {
                    Toast.makeText(TpEvenementDemoActivity.this, "Déjà orienté vers la droite!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mGauche.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mOrientation != "left"){
                    mFlecheView.setRotation(180);
                    mOrientation = "left";
                } else {
                    Toast.makeText(TpEvenementDemoActivity.this, "Déjà orienté vers la gauche!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /* Exercice 2 */
        mScrollView = findViewById(R.id.main_layout);
        mEditText = findViewById(R.id.editTextTextPersonName);
        mTextView = findViewById(R.id.editTextResult);

        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(TpEvenementDemoActivity.this, v.getText().toString().length() + " caractères.", Toast.LENGTH_SHORT).show();
                // mScrollView.setBackgroundColor(Color.BLACK);
                return true;
            }
        });

        mEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(TpEvenementDemoActivity.this, " Debut.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(TpEvenementDemoActivity.this, " Fin.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0){
                    String texte = "Vous avez saisi: <<" + mEditText.getText() + ">>";
                    mTextView.setText(texte);
                }
                else
                    mTextView.setText("");
            }
        });
    }
}