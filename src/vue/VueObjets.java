package vue;

/**
 * Created by Calgaryz.
 */

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Ta doc ici
 */
public enum VueObjets implements IObjet{
    CAISSE('$', "CAISSE.PNG"),
    JOUEUR('@', "JOUEUR.PNG"),
    MUR('#', "MUR.PNG"),
    SOL(' ',"SOL.PNG"),
    TROU('.',"TROU.PNG"),
    TROU_COMBL('*', "TROU_COMBL.PNG");


    private char etat;
    private Image sprite;

    VueObjets(char etat, String Ssprite) {
        this.etat = etat;
        try {
            this.sprite = new Image(new FileInputStream(Ssprite),80,80,false,false);
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
