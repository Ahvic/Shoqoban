package model;

/**
 * Created by Calgaryz.
 */

public enum ModelConcret implements Model{ //Tout les objets n'ayant pas d'animation
    SOL(' '),
    CAISSE('$'),
    TROU('.'),
    TROU_COMBL('*'),
    MUR('#'),
    JOUEUR('@');


    private char etat;

    ModelConcret(char etat) {
        this.etat = etat;
    }

    public char getEtat(){
        return this.etat;
    }

}
