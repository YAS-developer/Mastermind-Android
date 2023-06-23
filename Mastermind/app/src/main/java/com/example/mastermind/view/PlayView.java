package com.example.mastermind.view;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.method.KeyListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.R;
import com.example.mastermind.controler.PlayControler;
import com.example.mastermind.main.Main;
import com.example.mastermind.model.Combinaison;
import com.example.mastermind.model.Defenseur;

import java.util.LinkedList;

public class PlayView extends AppCompatActivity {
    private PlayControler pc;
    private MediaPlayer sonVictoire;
    private MediaPlayer sonDefaite;
    private AlertDialog.Builder popUp;
    private EditText textPopUp;


    private LinkedList<ImageView[]> allComb;
    private LinkedList<ImageView[]> allRep;


    private ImageView[] comb0;
    private ImageView[] comb1;
    private ImageView[] comb2;
    private ImageView[] comb3;
    private ImageView[] comb4;
    private ImageView[] comb5;
    private ImageView[] comb6;
    private ImageView[] comb7;
    private ImageView[] comb8;
    private ImageView[] comb9;

    private ImageView[] rep0;
    private ImageView[] rep1;
    private ImageView[] rep2;
    private ImageView[] rep3;
    private ImageView[] rep4;
    private ImageView[] rep5;
    private ImageView[] rep6;
    private ImageView[] rep7;
    private ImageView[] rep8;
    private ImageView[] rep9;

    private ImageView[] couleur;

    private Button btnValider;

    private LinearLayout main_jeu;

    private MediaPlayer sonArriere;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);



        sonArriere = MediaPlayer.create(PlayView.this, R.raw.ost_sang);
        sonArriere.setLooping(true);
        sonArriere.start();

        sonVictoire = MediaPlayer.create(PlayView.this, R.raw.gold_win_voix);
        sonVictoire.setLooping(false);
        sonDefaite = MediaPlayer.create(PlayView.this, R.raw.defaite_lol);
        sonDefaite.setLooping(false);


        this.popUp = new AlertDialog.Builder(this);
        this.popUp.setTitle("FIN DE PARTIE");

        textPopUp= new EditText(this);
        textPopUp.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);  // permet de définir le type de texte à multiligne
        textPopUp.setSingleLine(false);  // permet de désactiver la ligne unique
        textPopUp.setLines(5);  // permet de définir le nombre de lignes à afficher
        textPopUp.setMaxLines(10);  // permet de définir le nombre maximum de lignes
        textPopUp.setVerticalScrollBarEnabled(true);  // permet de définir si la barre de défilement verticale doit être activée ou désactivée
        textPopUp.setGravity(Gravity.TOP | Gravity.LEFT);
        textPopUp.setKeyListener(new KeyListener() {
            @Override
            public int getInputType() {
                return InputType.TYPE_NULL; // refuse toute saisie
            }

            @Override
            public boolean onKeyDown(View view, Editable text, int keyCode, KeyEvent event) {
                return false;
            }

            @Override
            public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {
                return false;
            }

            @Override
            public boolean onKeyOther(View view, Editable text, KeyEvent event) {
                return false;
            }

            @Override
            public void clearMetaKeyState(View view, Editable content, int states) {
            }
        });



        this.main_jeu = findViewById(R.id.main_jeu);
        this.allComb = new LinkedList<>();
        this.allRep = new LinkedList<>();

        this.comb0 = new ImageView[4];
        this.comb1 = new ImageView[4];
        this.comb2 = new ImageView[4];
        this.comb3 = new ImageView[4];
        this.comb4 = new ImageView[4];
        this.comb5 = new ImageView[4];
        this.comb6 = new ImageView[4];
        this.comb7 = new ImageView[4];
        this.comb8 = new ImageView[4];
        this.comb9 = new ImageView[4];

        this.rep0 = new ImageView[4];
        this.rep1 = new ImageView[4];
        this.rep2 = new ImageView[4];
        this.rep3 = new ImageView[4];
        this.rep4 = new ImageView[4];
        this.rep5 = new ImageView[4];
        this.rep6 = new ImageView[4];
        this.rep7 = new ImageView[4];
        this.rep8 = new ImageView[4];
        this.rep9 = new ImageView[4];

        this.couleur = new ImageView[6];


        this.comb0[0] = findViewById(R.id.rond_Jeu_0_0);
        this.comb0[1] = findViewById(R.id.rond_Jeu_0_1);
        this.comb0[2] = findViewById(R.id.rond_Jeu_0_2);
        this.comb0[3] = findViewById(R.id.rond_Jeu_0_3);

        this.comb1[0] = findViewById(R.id.rond_Jeu_1_0);
        this.comb1[1] = findViewById(R.id.rond_Jeu_1_1);
        this.comb1[2] = findViewById(R.id.rond_Jeu_1_2);
        this.comb1[3] = findViewById(R.id.rond_Jeu_1_3);

        this.comb2[0] = findViewById(R.id.rond_Jeu_2_0);
        this.comb2[1] = findViewById(R.id.rond_Jeu_2_1);
        this.comb2[2] = findViewById(R.id.rond_Jeu_2_2);
        this.comb2[3] = findViewById(R.id.rond_Jeu_2_3);

        this.comb3[0] = findViewById(R.id.rond_Jeu_3_0);
        this.comb3[1] = findViewById(R.id.rond_Jeu_3_1);
        this.comb3[2] = findViewById(R.id.rond_Jeu_3_2);
        this.comb3[3] = findViewById(R.id.rond_Jeu_3_3);

        this.comb4[0] = findViewById(R.id.rond_Jeu_4_0);
        this.comb4[1] = findViewById(R.id.rond_Jeu_4_1);
        this.comb4[2] = findViewById(R.id.rond_Jeu_4_2);
        this.comb4[3] = findViewById(R.id.rond_Jeu_4_3);

        this.comb5[0] = findViewById(R.id.rond_Jeu_5_0);
        this.comb5[1] = findViewById(R.id.rond_Jeu_5_1);
        this.comb5[2] = findViewById(R.id.rond_Jeu_5_2);
        this.comb5[3] = findViewById(R.id.rond_Jeu_5_3);

        this.comb6[0] = findViewById(R.id.rond_Jeu_6_0);
        this.comb6[1] = findViewById(R.id.rond_Jeu_6_1);
        this.comb6[2] = findViewById(R.id.rond_Jeu_6_2);
        this.comb6[3] = findViewById(R.id.rond_Jeu_6_3);

        this.comb7[0] = findViewById(R.id.rond_Jeu_7_0);
        this.comb7[1] = findViewById(R.id.rond_Jeu_7_1);
        this.comb7[2] = findViewById(R.id.rond_Jeu_7_2);
        this.comb7[3] = findViewById(R.id.rond_Jeu_7_3);

        this.comb8[0] = findViewById(R.id.rond_Jeu_8_0);
        this.comb8[1] = findViewById(R.id.rond_Jeu_8_1);
        this.comb8[2] = findViewById(R.id.rond_Jeu_8_2);
        this.comb8[3] = findViewById(R.id.rond_Jeu_8_3);

        this.comb9[0] = findViewById(R.id.rond_Jeu_9_0);
        this.comb9[1] = findViewById(R.id.rond_Jeu_9_1);
        this.comb9[2] = findViewById(R.id.rond_Jeu_9_2);
        this.comb9[3] = findViewById(R.id.rond_Jeu_9_3);


        this.rep0[0] = findViewById(R.id.rond_reponse_Jeu_0_0);
        this.rep0[1] = findViewById(R.id.rond_reponse_Jeu_0_1);
        this.rep0[2] = findViewById(R.id.rond_reponse_Jeu_0_2);
        this.rep0[3] = findViewById(R.id.rond_reponse_Jeu_0_3);

        this.rep1[0] = findViewById(R.id.rond_reponse_Jeu_1_0);
        this.rep1[1] = findViewById(R.id.rond_reponse_Jeu_1_1);
        this.rep1[2] = findViewById(R.id.rond_reponse_Jeu_1_2);
        this.rep1[3] = findViewById(R.id.rond_reponse_Jeu_1_3);

        this.rep2[0] = findViewById(R.id.rond_reponse_Jeu_2_0);
        this.rep2[1] = findViewById(R.id.rond_reponse_Jeu_2_1);
        this.rep2[2] = findViewById(R.id.rond_reponse_Jeu_2_2);
        this.rep2[3] = findViewById(R.id.rond_reponse_Jeu_2_3);

        this.rep3[0] = findViewById(R.id.rond_reponse_Jeu_3_0);
        this.rep3[1] = findViewById(R.id.rond_reponse_Jeu_3_1);
        this.rep3[2] = findViewById(R.id.rond_reponse_Jeu_3_2);
        this.rep3[3] = findViewById(R.id.rond_reponse_Jeu_3_3);

        this.rep4[0] = findViewById(R.id.rond_reponse_Jeu_4_0);
        this.rep4[1] = findViewById(R.id.rond_reponse_Jeu_4_1);
        this.rep4[2] = findViewById(R.id.rond_reponse_Jeu_4_2);
        this.rep4[3] = findViewById(R.id.rond_reponse_Jeu_4_3);

        this.rep5[0] = findViewById(R.id.rond_reponse_Jeu_5_0);
        this.rep5[1] = findViewById(R.id.rond_reponse_Jeu_5_1);
        this.rep5[2] = findViewById(R.id.rond_reponse_Jeu_5_2);
        this.rep5[3] = findViewById(R.id.rond_reponse_Jeu_5_3);

        this.rep6[0] = findViewById(R.id.rond_reponse_Jeu_6_0);
        this.rep6[1] = findViewById(R.id.rond_reponse_Jeu_6_1);
        this.rep6[2] = findViewById(R.id.rond_reponse_Jeu_6_2);
        this.rep6[3] = findViewById(R.id.rond_reponse_Jeu_6_3);

        this.rep7[0] = findViewById(R.id.rond_reponse_Jeu_7_0);
        this.rep7[1] = findViewById(R.id.rond_reponse_Jeu_7_1);
        this.rep7[2] = findViewById(R.id.rond_reponse_Jeu_7_2);
        this.rep7[3] = findViewById(R.id.rond_reponse_Jeu_7_3);

        this.rep8[0] = findViewById(R.id.rond_reponse_Jeu_8_0);
        this.rep8[1] = findViewById(R.id.rond_reponse_Jeu_8_1);
        this.rep8[2] = findViewById(R.id.rond_reponse_Jeu_8_2);
        this.rep8[3] = findViewById(R.id.rond_reponse_Jeu_8_3);

        this.rep9[0] = findViewById(R.id.rond_reponse_Jeu_9_0);
        this.rep9[1] = findViewById(R.id.rond_reponse_Jeu_9_1);
        this.rep9[2] = findViewById(R.id.rond_reponse_Jeu_9_2);
        this.rep9[3] = findViewById(R.id.rond_reponse_Jeu_9_3);


        this.couleur[0] = findViewById(R.id.rondRougeJeu);
        this.couleur[1] = findViewById(R.id.rondVertJeu);
        this.couleur[2] = findViewById(R.id.rondBleuJeu);
        this.couleur[3] = findViewById(R.id.rondJauneJeu);
        this.couleur[4] = findViewById(R.id.rondBlancJeu);
        this.couleur[5] = findViewById(R.id.rondNoirJeu);

        this.btnValider = findViewById(R.id.BtnValiderJeu);



        if (getIntent() != null && getIntent().hasExtra("DEFENSEUR")){
            Defenseur comb_def = (Defenseur) getIntent().getParcelableExtra("DEFENSEUR");
            this.pc = new PlayControler(this,comb_def);
        }
        else{
            this.pc = new PlayControler(this);
        }

        this.main_jeu.setOnClickListener(this.pc);

        for(int i = 0; i < 6; i++){

            if(i < 4){
                this.comb0[i].setOnClickListener(pc);
                this.comb1[i].setOnClickListener(pc);
                this.comb2[i].setOnClickListener(pc);
                this.comb3[i].setOnClickListener(pc);
                this.comb4[i].setOnClickListener(pc);
                this.comb5[i].setOnClickListener(pc);
                this.comb6[i].setOnClickListener(pc);
                this.comb7[i].setOnClickListener(pc);
                this.comb8[i].setOnClickListener(pc);
                this.comb9[i].setOnClickListener(pc);

                this.rep0[i].setOnClickListener(pc);
                this.rep1[i].setOnClickListener(pc);
                this.rep2[i].setOnClickListener(pc);
                this.rep3[i].setOnClickListener(pc);
                this.rep4[i].setOnClickListener(pc);
                this.rep5[i].setOnClickListener(pc);
                this.rep6[i].setOnClickListener(pc);
                this.rep7[i].setOnClickListener(pc);
                this.rep8[i].setOnClickListener(pc);
                this.rep9[i].setOnClickListener(pc);
            }
            this.couleur[i].setOnClickListener(pc);
        }

        this.btnValider.setOnClickListener(pc);

        this.allComb.add(this.comb0);
        this.allComb.add(this.comb1);
        this.allComb.add(this.comb2);
        this.allComb.add(this.comb3);
        this.allComb.add(this.comb4);
        this.allComb.add(this.comb5);
        this.allComb.add(this.comb6);
        this.allComb.add(this.comb7);
        this.allComb.add(this.comb8);
        this.allComb.add(this.comb9);

        this.allRep.add(this.rep0);
        this.allRep.add(this.rep1);
        this.allRep.add(this.rep2);
        this.allRep.add(this.rep3);
        this.allRep.add(this.rep4);
        this.allRep.add(this.rep5);
        this.allRep.add(this.rep6);
        this.allRep.add(this.rep7);
        this.allRep.add(this.rep8);
        this.allRep.add(this.rep9);


    }


    public ImageView[] getAllComb(int index){
        return this.allComb.get(index);
    }

    public  ImageView[] getAllRep(int index){
        return this.allRep.get(index);
    }

    public ImageView[] getCouleur(){
        return this.couleur;
    }

    public Button getBtnValider(){
        return this.btnValider;
    }

    public LinearLayout getMain_jeu() { return this.main_jeu; }


    @Override
    public void onBackPressed() {
        this.sonArriere.stop();
        Intent intent = new Intent(this, Main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sonArriere != null) {
            sonArriere.release();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sonArriere != null && sonArriere.isPlaying()) {
            sonArriere.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sonArriere != null) {
            sonArriere.start();
        }
    }

    public EditText getTextPopUp(){
        return this.textPopUp;
    }

    public AlertDialog.Builder getPopUp(){
        return this.popUp;
    }

    public MediaPlayer getSonArriere(){
        return this.sonArriere;
    }

    public MediaPlayer getSonVictoire(){
        return this.sonVictoire;
    }

    public MediaPlayer getSonDefaite(){
        return this.sonDefaite;
    }
}

