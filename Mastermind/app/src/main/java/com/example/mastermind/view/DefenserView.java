package com.example.mastermind.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.R;
import com.example.mastermind.controler.DefenserControler;
import com.example.mastermind.main.Main;

public class DefenserView extends AppCompatActivity {

    private ImageView[] combinaisonDef;
    private ImageView[] couleur;
    private Button btnValider;
    private Intent toplay;
    private PlayView pv;
    private MediaPlayer sonDefenser;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_defenseur);
        this.sonDefenser = MediaPlayer.create(DefenserView.this, R.raw.portail_magique);
        this.sonDefenser.setLooping(true);
        this.sonDefenser.start();
        this.combinaisonDef = new ImageView[4];
        this.combinaisonDef[0] = findViewById(R.id.rondCombDef0);
        this.combinaisonDef[1] = findViewById(R.id.rondCombDef1);
        this.combinaisonDef[2] = findViewById(R.id.rondCombDef2);
        this.combinaisonDef[3] = findViewById(R.id.rondCombDef3);

        this.couleur = new ImageView[6];
        this.couleur[0] = findViewById(R.id.rondRougeDef);
        this.couleur[1] = findViewById(R.id.rondVertDef);
        this.couleur[2] = findViewById(R.id.rondBleuDef);
        this.couleur[3] = findViewById(R.id.rondJauneDef);
        this.couleur[4] = findViewById(R.id.rondBlancDef);
        this.couleur[5] = findViewById(R.id.rondNoirDef);

        DefenserControler dc = new DefenserControler(this);

        for(int i = 0; i < this.couleur.length; i++){
            if(i < 4){
                this.combinaisonDef[i].setOnClickListener(dc);
            }
            this.couleur[i].setOnClickListener(dc);
        }
        this.btnValider = findViewById(R.id.btnValider);
        this.btnValider.setOnClickListener(dc);

        this.toplay = new Intent(this, PlayView.class);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (sonDefenser != null && sonDefenser.isPlaying()) {
            sonDefenser.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sonDefenser != null) {
            sonDefenser.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sonDefenser != null) {
            sonDefenser.release();
        }
    }

    public ImageView[] getCombinaisonDef() {
        return this.combinaisonDef;
    }

    public ImageView[] getCouleur() {
        return this.couleur;
    }

    public Button getBtnValider(){
        return this.btnValider;
    }

    public void StartPlay(){
        startActivity(toplay);
    }

    public Intent getIntent(){
       return toplay;
    }

    public MediaPlayer getSonDefenser(){
        return this.sonDefenser;
    }




}
