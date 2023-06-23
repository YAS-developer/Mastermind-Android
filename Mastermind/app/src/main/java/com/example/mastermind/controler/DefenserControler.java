package com.example.mastermind.controler;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.view.View;


import com.example.mastermind.R;
import com.example.mastermind.model.Combinaison;
import com.example.mastermind.model.Defenseur;
import com.example.mastermind.view.DefenserView;

import java.io.Serializable;

public class DefenserControler implements View.OnClickListener{

    private DefenserView def;
    private Combinaison combinaisondef;
    private int index;

    public DefenserControler(DefenserView def){
        this.def = def;
        this.combinaisondef = new Combinaison();
        this.index = 0;
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {

        if(v.equals(this.def.getBtnValider())){
            this.def.getSonDefenser().stop();
            Defenseur tmp = new Defenseur(this.combinaisondef);
            this.def.getIntent().putExtra("DEFENSEUR", tmp);
            this.def.StartPlay();
        }


        for(int i = 0; i < this.def.getCouleur().length ; i++){
            if(v.equals(this.def.getCouleur()[i])){
                if(this.index >= 4){
                    System.out.println("nombre de pions maximale atteint");
                }
                else{
                    switch (i){
                        case 0 : {
                            this.combinaisondef.add(Color.valueOf(R.color.red));
                            this.def.getCombinaisonDef()[index].setImageResource(R.drawable.rond_rouge);
                            index++;
                            break;
                        }
                        case 1 : {
                            this.combinaisondef.add(Color.valueOf(R.color.green));
                            this.def.getCombinaisonDef()[index].setImageResource(R.drawable.rond_vert);
                            index++;
                            break;
                        }
                        case 2 : {
                            this.combinaisondef.add(Color.valueOf(R.color.blue));
                            this.def.getCombinaisonDef()[index].setImageResource(R.drawable.rond_bleu);
                            index++;
                            break;
                        }
                        case 3 : {
                            this.combinaisondef.add(Color.valueOf(R.color.yellow));
                            this.def.getCombinaisonDef()[index].setImageResource(R.drawable.rond_jaune);
                            index++;
                            break;
                        }
                        case 4 : {
                            this.combinaisondef.add(Color.valueOf(R.color.white1));
                            this.def.getCombinaisonDef()[index].setImageResource(R.drawable.rond_blanc);
                            index++;
                            break;
                        }
                        case 5 : {
                            this.combinaisondef.add(Color.valueOf(R.color.black1));
                            this.def.getCombinaisonDef()[index].setImageResource(R.drawable.rond_noir);
                            index++;
                            break;
                        }
                        default: break;
                    }
                }
            }
        }
    }
}
