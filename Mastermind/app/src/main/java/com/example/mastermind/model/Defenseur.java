package com.example.mastermind.model;


import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.mastermind.model.Combinaison;

import java.io.Serializable;

public class Defenseur extends Combinaison implements Parcelable {

    public Defenseur(){
        super();

        // On ajoute une 4 couleur aleatoire a notre defenseur
        for(int i = 0; i < 4; i++){
            this.add(this.getRandom());
        }
    }

    public Defenseur(Combinaison c){
        super();
        for(int i = 0; i < 4; i++){
            this.add(c.getColor(i));
        }
    }


    public static final Creator<Defenseur> CREATOR = new Creator<Defenseur>() {
        @Override
        public Defenseur createFromParcel(Parcel in) {
            Defenseur defenseur = new Defenseur();

            int[] intArray = in.createIntArray();
            Color[] colorArray = new Color[intArray.length];
            for (int i = 0; i < intArray.length; i++) {
                colorArray[i] = Color.valueOf(intArray[i]);
            }
            defenseur.choix = colorArray;
            defenseur.index = in.readInt();

            return defenseur;
        }

        @Override
        public Defenseur[] newArray(int size) {
            return new Defenseur[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        int[] intArray = new int[this.choix.length];
        for (int i = 0; i < this.choix.length; i++) {
            intArray[i] = this.choix[i].toArgb();
        }
        dest.writeIntArray(intArray);
        dest.writeInt(this.index);

    }
}