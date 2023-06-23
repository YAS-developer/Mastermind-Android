package com.example.mastermind.model;

import android.annotation.SuppressLint;
import android.graphics.Color;


import com.example.mastermind.R;

import java.util.Random;



public class Combinaison {
    //choix contient les pions de la combinaison
    protected Color[] choix;
    //index contient le nombre de pions ajoutés à la combinaison
    protected int index;

    @SuppressLint("ResourceAsColor")
    public Combinaison(){
        this.choix=new Color[4];
        for(int i=0;i<4;i++){
            if(this.choix[i]==null){this.choix[i]=Color.valueOf(R.color.transparent);}
        }
    }

    //add ajoute une couleur à la combinaison
    public void add (Color c){

        if(this.index==4){System.out.println("Vous avez le nombre maximal de pions");this.index=4;}
        else if(this.index==0){
            this.choix[0]=c;this.index++;
        }
        else{
            this.choix[index]=c;
            this.index++;
        }
    }



    // comparer compare la combinaison avec une autre donnée en argument.
    // Elle renvoie la réponse, càd une combinaison contenant des couleurs noires, blancs ou grisclair.

    @SuppressLint("ResourceAsColor")
    public Combinaison comparer(Combinaison c){
        Combinaison reponse_defenseur = new Combinaison();
        Combinaison def2 = new Combinaison();
        Combinaison choix1= new Combinaison();

        // fait un clone de c
        for(int i = 0; i < 4 ; i++){
            choix1.choix[i] = c.choix[i];
        }

        // fait un clone de defenseur
        for(int i = 0; i < 4 ; i++){
            def2.choix[i] = this.choix[i];
        }


        // met une case gris au clone de defenseur
        for(int i=0 ; i<4; i++){
            if(this.choix[i].equals(c.choix[i])){
                def2.choix[i]= Color.valueOf(R.color.transparent);
            }
        }

        // met une case noir a la reponse
        for(int i = 0; i < 4; i++){
            if(def2.choix[i].equals(Color.valueOf(R.color.transparent))){
                def2.choix[i]= Color.valueOf(R.color.black);
                reponse_defenseur.choix[i] = Color.valueOf(R.color.black);
            }
        }

        // met les cases blanches a la reponse
        for(int i=0 ; i<4; i++){
            if(!def2.choix[i].equals(Color.valueOf(R.color.black))){
                for(int j=0 ; j <4; j++){
                    if(i!=j && def2.choix[j].equals(choix1.choix[i]) && !def2.choix[j].equals(Color.valueOf(R.color.transparent)) && !choix1.choix[i].equals(Color.valueOf(R.color.transparent))){
                        // On ajoute une case grise aux doublons de defenseur et de la combinaison.
                        def2.choix[j]= Color.valueOf(R.color.transparent);
                        choix1.choix[i] = Color.valueOf(R.color.transparent);
                        // ajoute
                        reponse_defenseur.choix[i] = Color.valueOf(R.color.white);

                    }
                }
            }
        }

        reponse_defenseur.index=4;
        return reponse_defenseur;
    }

    public Color getColor(int index){
        if(index >= 0 || index <= 4){
            return this.choix[index];
        }
        else {
            throw new IllegalArgumentException("Votre index est doit etre entre 0 et 4 compris");
        }
    }

    public Color[] getChoix(){
        return this.choix;
    }

    public boolean gagner(){
        System.out.println("You win !");
        return true;
    }

    // permet de recuperer couleur aleatoire dans une case du tableau de couleur
    @SuppressLint("ResourceAsColor")
    public Color getRandom() {
        Color[] couleurjeux;
        couleurjeux = new Color[6];

        // On ajoute les couleurs du jeu
        couleurjeux[0] = Color.valueOf(R.color.red);
        couleurjeux[1] = Color.valueOf(R.color.green);
        couleurjeux[2] = Color.valueOf(R.color.blue);
        couleurjeux[3] = Color.valueOf(R.color.yellow);
        couleurjeux[4] = Color.valueOf(R.color.white1);
        couleurjeux[5] = Color.valueOf(R.color.black1);

        // On génère un int de 0 à la taille du tableau
        int rnd = new Random().nextInt(couleurjeux.length);
        // on return donc une case aleatoire du tableau de couleur
        return couleurjeux[rnd];
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public String toString(){
        String s="Combinaison : ";
        for(int i=0;i<4;i++){
            if(choix[i].equals(Color.valueOf(R.color.transparent))){s+="transparent, ";}
            else if(choix[i].equals(Color.valueOf(R.color.red))){s+="Rouge, ";}
            else if(choix[i].equals(Color.valueOf(R.color.blue))){s+="Bleu, ";}
            else if(choix[i].equals(Color.valueOf(R.color.yellow))){s+="Jaune, ";}
            else if(choix[i].equals(Color.valueOf(R.color.green))){s+="Vert, ";}
            else if(choix[i].equals(Color.valueOf(R.color.black1))){s+="noir, ";}
            else if(choix[i].equals(Color.valueOf(R.color.white1))){s+="blanc, ";}
            else if(choix[i].equals(Color.valueOf(R.color.black))){s+="Bien place, ";}
            else if(choix[i].equals(Color.valueOf(R.color.white))){s+="Mal place, ";}
        }
        return s;
    }
}
