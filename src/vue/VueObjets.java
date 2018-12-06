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
    MUR('#', "32j.gif"),
    SOL(' ',"32j.gif"),
    TROU('.',"32j.gif"),
    TROU_COMBL('*', "32j.gif");


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
