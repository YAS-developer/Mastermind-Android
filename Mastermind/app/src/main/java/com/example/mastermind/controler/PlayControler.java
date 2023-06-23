package com.example.mastermind.controler;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;

import com.example.mastermind.R;
import com.example.mastermind.model.Combinaison;
import com.example.mastermind.model.Defenseur;
import com.example.mastermind.view.PlayView;

public class PlayControler implements View.OnClickListener{

    private PlayView pv;
    private int[] index;
    private int[] indexRep;
    private int ligne;
    private boolean finPartie;
    private Defenseur vrai;
    private Combinaison reponse_def;

    private Combinaison[] prop;
    private Combinaison[] rep;



    public PlayControler(PlayView pv){
        this.pv = pv;
        this.index = new int[10];
        this.indexRep = new int[10];
        this.ligne = 0;
        this.vrai = new Defenseur();
        this.finPartie = false;
        this.reponse_def = new Combinaison();
        this.prop = new Combinaison[10];
        this.rep = new Combinaison[10];

        System.out.println(this.vrai.toString());

        for(int i = 0; i < 10; i++){
            this.prop[i] = new Combinaison();
            this.rep[i] = new Combinaison();
        }
    }


    public PlayControler(PlayView pv, Defenseur def){
        this.pv = pv;
        this.index = new int[10];
        this.indexRep = new int[10];
        this.ligne = 0;
        this.vrai = def;
        this.reponse_def = new Combinaison();
        this.finPartie = false;
        System.out.println("BON CONSTRUCTEUR");
        this.prop = new Combinaison[10];
        this.rep = new Combinaison[10];
        for(int i = 0; i < 10; i++){
            this.prop[i] = new Combinaison();
            this.rep[i] = new Combinaison();
        }
    }



    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {



        if(!finPartie){
            if(v.equals(pv.getBtnValider())){
                this.reponse_def = new Combinaison();
                this.reponse_def = vrai.comparer(this.prop[ligne]);

                for(int i = 0; i < 4; i++){
                    if(this.reponse_def.getColor(i).equals(Color.valueOf(R.color.black))){
                        this.pv.getAllRep(ligne)[this.indexRep[ligne]].setImageResource(R.drawable.rond_noir_petit);
                    }
                    else if(this.reponse_def.getColor(i).equals(Color.valueOf(R.color.white))){
                        this.pv.getAllRep(ligne)[this.indexRep[ligne]].setImageResource(R.drawable.rond_blanc_petit);
                    }
//                else if(this.reponse_def.getColor(i).equals(Color.valueOf(R.color.transparent))){
//                    this.pv.getAllRep(ligne)[this.indexRep[ligne]].setImageResource(R.drawable.rond_transparent_petit);
//                }
                    this.indexRep[ligne]++;
                }

                if(this.reponse_def.getChoix()[0].equals(Color.valueOf(R.color.black)) && reponse_def.getChoix()[1].equals(Color.valueOf(R.color.black)) && reponse_def.getChoix()[2].equals(Color.valueOf(R.color.black)) && reponse_def.getChoix()[3].equals(Color.valueOf(R.color.black)) && ligne <= 9) {
                    this.reponse_def.gagner();
                    this.pv.getMain_jeu().setBackgroundResource(R.drawable.victoire);
                    this.pv.getSonArriere().stop();
                    this.pv.getSonVictoire().start();
                    int tentative = ligne+1;
                    this.pv.getTextPopUp().setText("L'attaquant a trouvé la combinaison gagnante en "+tentative+" tentative(s) ! Il remporte les Dofus ! "+ this.vrai.toString());
                    this.pv.getPopUp().setView(this.pv.getTextPopUp());
                    this.pv.getPopUp().show();
                    this.finPartie = true;
                } else if(ligne == 9){
                    this.pv.getMain_jeu().setBackgroundResource(R.drawable.defaite);
                    this.pv.getSonArriere().stop();
                    this.pv.getSonDefaite().start();
                    this.pv.getTextPopUp().setText("L'attaquant a échoué, qu'il repose les Dofus !\n"+ this.vrai.toString());
                    this.pv.getPopUp().setView(this.pv.getTextPopUp());
                    this.pv.getPopUp().show();
                    this.finPartie = true;
                }

                this.ligne++;


            }
            for (int i = 0; i < this.pv.getCouleur().length ; i++){
                if(v.equals(this.pv.getCouleur()[i])){
                    switch(i){
                        case 0 :{
                            for(int j = 0; j < 10; j++){
                                if(j == ligne){
                                    if(this.index[ligne] >= 4){
                                        System.out.println("Maximale de pion, Veuillez valider votre combinaison");
                                    }
                                    else{
                                        this.prop[ligne].add(Color.valueOf(R.color.red));
                                        this.pv.getAllComb(ligne)[this.index[ligne]].setImageResource(R.drawable.rond_rouge_moyen);
                                        this.index[ligne]++;
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                        case 1 : {
                            for(int j = 0; j < 10; j++){
                                if(j == ligne){
                                    if(this.index[ligne] >= 4){
                                        System.out.println("Maximale de pion, Veuillez valider votre combinaison");
                                    }
                                    else{
                                        this.prop[ligne].add(Color.valueOf(R.color.green));
                                        this.pv.getAllComb(ligne)[this.index[ligne]].setImageResource(R.drawable.rond_vert_moyen);
                                        this.index[ligne]++;
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                        case 2 : {
                            for(int j = 0; j < 10; j++){
                                if(j == ligne){
                                    if(this.index[ligne] >= 4){
                                        System.out.println("Maximale de pion, Veuillez valider votre combinaison");
                                    }
                                    else{
                                        this.prop[ligne].add(Color.valueOf(R.color.blue));
                                        this.pv.getAllComb(ligne)[this.index[ligne]].setImageResource(R.drawable.rond_bleu_moyen);
                                        this.index[ligne]++;
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                        case 3 : {
                            for(int j = 0; j < 10; j++){
                                if(j == ligne){
                                    if(this.index[ligne] >= 4){
                                        System.out.println("Maximale de pion, Veuillez valider votre combinaison");
                                    }
                                    else{
                                        this.prop[ligne].add(Color.valueOf(R.color.yellow));
                                        this.pv.getAllComb(ligne)[this.index[ligne]].setImageResource(R.drawable.rond_jaune_moyen);
                                        this.index[ligne]++;
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                        case 4 : {
                            for(int j = 0; j < 10; j++){
                                if(j == ligne){
                                    if(this.index[ligne] >= 4){
                                        System.out.println("Maximale de pion, Veuillez valider votre combinaison");
                                    }
                                    else{
                                        this.prop[ligne].add(Color.valueOf(R.color.white1));
                                        this.pv.getAllComb(ligne)[this.index[ligne]].setImageResource(R.drawable.rond_blanc_moyen);
                                        this.index[ligne]++;
                                    }
                                    break;
                                }
                            }
                            break;
                        }

                        case 5 : {
                            for(int j = 0; j < 10; j++){
                                if(j == ligne){
                                    if(this.index[ligne] >= 4){
                                        System.out.println("Maximale de pion, Veuillez valider votre combinaison");
                                    }
                                    else{
                                        this.prop[ligne].add(Color.valueOf(R.color.black1));
                                        this.pv.getAllComb(ligne)[this.index[ligne]].setImageResource(R.drawable.rond_noir_moyen);
                                        this.index[ligne]++;
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                        default: break;
                    }
                }
            }
        }
        else{
            this.pv.onBackPressed();
        }
    }

//    public void RempliRep(){
//    }
//
//    private  void proposer(Combinaison essaie){
//        this.reponse_def = vrai.comparer(this.prop[ligne]);
//        if(this.reponse_def.getChoix()[0].equals(CouleurJeu.black) && reponse_def.getChoix()[1].equals(CouleurJeu.black) && reponse_def.getChoix()[2].equals(CouleurJeu.black) && reponse_def.getChoix()[3].equals(CouleurJeu.black)) {
//            this.reponse_def.gagner();
//        }
//    }
}
