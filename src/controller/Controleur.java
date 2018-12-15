package controller;
import controller.Sujet;
import javafx.scene.input.KeyCode;
import model.FacadeModele;
import model.ModeleConcret;
import vue.Observateur;

import java.util.ArrayList;

public class Controleur implements Sujet {
    private static Controleur singleton;
    FacadeModele modele;
    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    public static Controleur getInstance() {
        if (singleton == null)
            singleton = new Controleur();
        return singleton;
    }



    private Controleur() {
        this.modele = new FacadeModele("src/Niveaux/sokoban01.xsb");
    }

    public void abonne(Observateur observateur) {
        observateurs.add(observateur);
    }


    public void notifie() {
        for (Observateur observateur:observateurs)
            observateur.actualise();
    }

    public void move(KeyCode x) {
        modele.move(x);
        notifie();
    }

    public void reset() {
        modele.reset();
        notifie();
    }

    public void setModele(String s) {
        this.modele = new FacadeModele(s);
    }
    public char[][] getEtat(){
        return modele.getTab_Etat();
    }
    public int getNbCoup() {
        return modele.getNbCoup();
    }


    public ArrayList<String> getNiveaux() {
        return null;
    }

}