package com.example.mastermind.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mastermind.R;
import com.example.mastermind.controler.MainControler;
import com.example.mastermind.view.DefenserView;
import com.example.mastermind.view.PlayView;

public class Main extends AppCompatActivity{


    private Button btnModeTransp;
    private Button btnOrdi;
    private Button btnDef;
    private ImageView btnIcon;

    private ImageView rulesImage;
    private boolean isRulesVisible;

    private Intent toOrdi;
    private Intent toDef;

    private MediaPlayer sonMenu;

    private ImageView sonIcon;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        this.sonIcon = findViewById(R.id.volume_icon);


        sonMenu = MediaPlayer.create(Main.this, R.raw.ost_amakna);
        sonMenu.setLooping(true);
        sonMenu.start();

        this.isRulesVisible = false;


        this.btnModeTransp = findViewById(R.id.mode_transparent);
        this.btnOrdi = findViewById(R.id.ordinateur);
        this.btnDef = findViewById(R.id.defenseur);
        this.btnIcon = findViewById(R.id.info_icon);
        this.rulesImage = findViewById(R.id.rules_image);

        MainControler mc = new MainControler(this);

        this.btnModeTransp.setOnClickListener(mc);
        this.btnOrdi.setOnClickListener(mc);
        this.btnDef.setOnClickListener(mc);
        this.btnIcon.setOnClickListener(mc);
        this.rulesImage.setOnClickListener(mc);
        this.sonIcon.setOnClickListener(mc);

        this.toOrdi = new Intent(Main.this, PlayView.class);

        this.toDef = new Intent(Main.this, DefenserView.class);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sonMenu != null && sonMenu.isPlaying()) {
            sonMenu.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sonMenu != null) {
            sonMenu.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sonMenu != null) {
            sonMenu.release();
        }
    }




    public void startOrdi(){
        startActivity(toOrdi);
    }

    public void startDef(){
        startActivity(toDef);
    }

    public Button getBtnModeTransp(){
        return this.btnModeTransp;
    }

    public Button getBtnOrdi(){
        return this.btnOrdi;
    }

    public Button getBtnDef(){
        return this.btnDef;
    }

    public ImageView getBtnIcon(){
        return this.btnIcon;
    }

    public ImageView getRules_image(){
        return this.rulesImage;
    }

    public MediaPlayer getSonMenu(){
        return this.sonMenu;
    }

    public ImageView getSonIcon() { return this.sonIcon; }

}