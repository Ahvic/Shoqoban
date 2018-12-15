package model;

import javafx.scene.input.KeyCode;

public interface Modele {

    /**
     * Determine si le joueur a gagner sa partie.
     * Se contente de regarde si il reste une caisse
     * qui n'est pas dans un trou.
     *
     * @return boolean gagner ou non
     */

    boolean aGagner();

    /**
     * Va modifier le tableau du controlleur pour
     * faire le mouvement dans la direction donnee en
     * parametre
     *
     * @param c la touche indiquant la direction
     */

    void move(KeyCode c);

    /**
     * Transforme la touche rentree en parametre en direction
     * au format [y,x]
     *
     * @param c la touche a convertir
     * @return in[2] contenant la direction du mouvement au format [y,x]
     */

    int[] directionJoueur(KeyCode c);
}
