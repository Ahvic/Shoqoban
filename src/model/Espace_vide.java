package model;


import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public final class Espace_vide extends ModelConcret{

    //sprite
    private Image sprite;

    //singleton instance
    private static Espace_vide instance;

    // constructeur
    private Espace_vide(Image sprite){

        this.sprite = sprite;

    }

    //cette méthode peut être appelée de n'importe où, retourne l'instance ou la crée
    private static Espace_vide getInstance() throws FileNotFoundException {
        if (Espace_vide.instance != null) {

            return Espace_vide.instance;

        }else {

            synchronized(Espace_vide.class) {

                if (Espace_vide.instance == null) {
                    Espace_vide.instance = new Espace_vide(new Image(new FileInputStream("Esp_v.PNG"),80,80,false,false));
                }
            }
        }

        return Espace_vide.instance;
    }


    @Override
    public Image getSprite() {
        return this.sprite;
    }
}
