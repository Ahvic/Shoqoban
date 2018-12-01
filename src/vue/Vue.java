package vue;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

abstract class Vue {

    Commande commande;
    Button[] myButton;
    GridPane gridPane = new GridPane();

    Image [] jeu = new Image []{
            new Image(new FileInputStream("32j.gif"), 32, 32, false, false),
            new Image(new FileInputStream("48j.png"), 48, 48, false, false)
    };

    public VueIHFX(Controleur controleur) throws FileNotFoundException{
        commandeGetEtat = controleur.commandeGetEtat();
        myButton = new Button[commandeGetEtat.exec().length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            myButton[i] = new Button();
            myButton[i].setMinSize(32,32);
            myButton[i].setMaxSize(48,48);
            gridPane.add(myButton[i],i,0);
        }
        dessine();
    }









    public void dessine(){
        for (int i=0; i<commandeGetEtat.exec().length;i++){
            myButton[i].setGraphic(new ImageView(jeu[commandeGetEtat.exec()[i]]));
        }
    }


}
