package model;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Calgaryz.
 */

public enum ModelConcret implements Model{ //Tout les objets n'ayant pas d'animation
    CAISSE("caisse.PNG"),
    ESPACE_VIDE("espace_vide.PNG"),
    MUR("mur.PNG"),
    PLATEFORME("plateforme.PNG");

    /*à noter que le joueur ne fait pas partie de cette classe */

    private Image sprite;

    ModelConcret(String img) {
        try {
            this.sprite = new Image(new FileInputStream(img),80,80,false,false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Image getSprite(){
        return this.sprite;
    }

}
