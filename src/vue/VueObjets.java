package vue;

/**
 * Created by Calgaryz.
 */

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Ta doc ici, ok
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


    VueObjets(char etat, String Ssprite) {
        this.etat = etat;
        try {
            this.sprite = new Image(new FileInputStream(Ssprite),48,48,false,false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public char getEtat() {
        return this.etat;
    }

    public Image getSprite() {
        return this.sprite;
    }

}
