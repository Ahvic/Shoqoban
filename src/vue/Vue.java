package vue;

import controller.Controleur;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

abstract class Vue {
    Button[][] myButton;
    GridPane gridPane = new GridPane();

    Image [] jeu = new Image []{
            new Image(new FileInputStream("32j.gif"), 32, 32, false, false),
            new Image(new FileInputStream("48j.png"), 48, 48, false, false)
    };

    public void VueIHFX(char [][]etats) throws FileNotFoundException{
        myButton = new Button[etats.length][etats[0].length];
        for (int i=0;i<etats.length;i++) {
            for(int j=0;j<etats[i].length;j++){
                myButton[i][j] = new Button();
                myButton[i][j].setMinSize(32,32);
                myButton[i][j].setMaxSize(48,48);
                gridPane.add(myButton[i][j],i,j);
            }

        }
        dessine(etats);
    }



    public void dessine(char [][] etats){
        for (int i=0;i<etats.length;i++) {
            for(int j=0;j<etats[i].length;j++){
                for (VueObjets o : ) {
                    if(etats[i][j]==c.getEtat())

                }
            }
            myButton[i].setGraphic(new ImageView(jeu[commandeGetEtat.exec()[i]]));
        }
    }


}
