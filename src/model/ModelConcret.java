package model;

/**
 * Created by Calgaryz.
 */

public enum ModelConcret implements Model{
    CAISSE('$'),
    JOUEUR('@'),
    MUR('#'),
    SOL(' '),
    TROU('.'),
    TROU_COMBL('*');


    private char etat;

    ModelConcret(char etat) {
        this.etat = etat;
    }

    public char getEtat() {
        return this.etat;
    }

}
