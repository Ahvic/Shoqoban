package model;

import javafx.scene.input.KeyCode;

public class DecoNbCoup implements Modele {

    private  ModeleConcret cc;

    public DecoNbCoup (ModeleConcret cc){
        this.cc = cc;
    }

    public boolean aGagner() {
        return cc.aGagner();
    }

    public void move(KeyCode c) {
        cc.move(c);
    }

    public int[] directionJoueur(KeyCode c) {
        return cc.directionJoueur(c);
    }

    public int getNbCoup() {
        return cc.getInputValide().size();
    }
}
