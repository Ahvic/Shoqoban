package model;

import javafx.scene.input.KeyCode;
import javafx.util.Pair;

import java.util.Stack;

public class FacadeModele {

    //🤰

    ModeleConcret mc;
    DecoNbCoup dNC;
    DecoUndoRedo dUR;

    public FacadeModele(String nom){
        mc = new ModeleConcret(nom);
        dNC = new DecoNbCoup(mc);
        dUR = new DecoUndoRedo(mc);
    }

    public char[][] getTab_Etat(){
        return mc.getTab_Etat();
    }

    public void move(KeyCode k){
        mc.move(k, 0);
    }

    public boolean aGagner(){
        return mc.aGagner();
    }

    public int getNbCoup(){
        return  dNC.getNbCoup();
    }

    public void undo(){
        dUR.undo();
    }

    public void redo(){
        dUR.redo();
    }

    public void reset(){
        dUR.reset();
    }

    //A SUPPRIMER SEULEMENT POUR TEST

    public Stack<Pair> getInputValide(){
        return mc.getInputValide();
    }

    public Stack<Pair> getInputUndo(){
        return mc.getInputUndo();
    }
}
