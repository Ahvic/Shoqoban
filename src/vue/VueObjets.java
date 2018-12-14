package vue;


import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Enumeration qui permet le lien entre un char et un sprite
 */
public enum VueObjets implements IObjet{
    CAISSE('$', "ball.png"),
    JOUEUR('@', "joueur.png"),
    MUR('#', "mur.png"),
    SOL(' ',"sol.png"),
    TROU('.',"trou.png"),
    TROU_COMBL('*', "combl.png"),
    JOUEUR_SUR_TROU('+', "joueur_tombe.png");


    private char etat;
    private Image sprite;

    /**
     * Constructeur
     * @param etat char du tableau d'état
     * @param Ssprite image de l'objet enuméré
     */

    VueObjets(char etat, String Ssprite) {
        this.etat = etat;
        try {
            this.sprite = new Image(new FileInputStream(Ssprite),48,48,false,false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * méthode getEtat() retourne le char de l'Objet
     * @return char
     */

    public char getEtat() {
        return this.etat;
    }

    /**
     * méthode getSprite() retourne l'Image de l'Objet
     * @return Image
     */

    public Image getSprite() {
        return this.sprite;
    }

}
