package com.example.mastermind.controler;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.mastermind.R;
import com.example.mastermind.main.Main;

public class MainControler implements View.OnClickListener{

    private Main main;
    private boolean colorSwitch;

    private boolean sonSwitch;
    public MainControler(Main main){
        this.main = main;
        this.colorSwitch = true;
        this.sonSwitch = true;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        if(v.equals(this.main.getBtnModeTransp())){
            if(colorSwitch){
                this.main.getBtnModeTransp().setText("Mode Transparent\nDesactive");
                colorSwitch = false;
            }
            else {
                this.main.getBtnModeTransp().setText("Mode Transparent\nActive");
                colorSwitch = true;
            }
        }
        else if(v.equals(this.main.getBtnOrdi())){
            this.main.getSonMenu().stop();
            this.main.startOrdi();
        }
        else if(v.equals(this.main.getBtnDef())){
            this.main.getSonMenu().stop();
            this.main.startDef();
        }
        else if(v.equals(this.main.getBtnIcon())){
            this.main.getRules_image().setVisibility(View.VISIBLE);
        }
        else if (v.equals(this.main.getRules_image())){
            this.main.getRules_image().setVisibility(View.INVISIBLE);
        }
        else if (v.equals(this.main.getSonIcon())) {
            if(this.sonSwitch)
            {
                if (this.main.getSonMenu() != null && this.main.getSonMenu().isPlaying())
                {
                   this.main.getSonMenu().pause();
                }
                this.main.getSonIcon().setImageResource(R.drawable.volume_desactive);
                sonSwitch = false;
            }
            else
            {
                if (this.main.getSonMenu() != null)
                {
                    this.main.getSonMenu().start();
                }
                this.main.getSonIcon().setImageResource(R.drawable.volume_active);
                sonSwitch = true;
            }

        }
    }
}
