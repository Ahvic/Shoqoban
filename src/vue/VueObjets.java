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
    CAISSE('$', "32j.gif"),
    JOUEUR('@', "48j.png"),
    MUR('#', "MUR.PNG"),
    SOL(' ',"SOL.PNG"),
    TROU('.',"TROU.PNG"),
    TROU_COMBL('*', "TROU_COMBL.PNG");


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
