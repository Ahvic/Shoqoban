package model;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Joueur implements Model, Editable {  //SINGLETON

    private static Image sprite;

    private static Joueur instance = null;

    private Joueur(Image sprite) throws FileNotFoundException {
        Joueur.sprite = sprite;
    }

    @Override
    public void setSprite(String img) {
        try {
            Joueur.sprite = new Image(new FileInputStream(img),80,80,false,false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Image getSprite(){
        return Joueur.sprite;
    }

    public static Joueur getInstance() throws FileNotFoundException {
        if(Joueur.instance == null){

            //on crée l'instance du joueur avec un sprite par défaut

            Joueur.instance = new Joueur(new Image(new FileInputStream("joueur.PNG"),80,80,false,false));
        }
        return instance;
    }
}
