package vue;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Created by Calgaryz on 04/12/18.
 */
public class VueJeu extends Vue{

    public Button[][] myButton;


    public void initilisation(char[][] etats){
        myButton = new Button[etats.length][etats[0].length];
        for (int i=0;i<etats.length;i++) {
            for(int j=0;j<etats[i].length;j++){
                myButton[i][j] = new Button();
                myButton[i][j].setMinSize(32,32);
                myButton[i][j].setMaxSize(48,48);
                gridPane.add(myButton[i][j],j,i);
            }

        }
        dessine(etats);
    }
    public VueJeu() {

    }



    public void dessine(char [][] etats){
        for (int i=0;i<etats.length;i++) {
            for(int j=0;j<etats[i].length;j++){
                for (VueObjets o : VueObjets.values()) {
                    if(etats[i][j]==o.getEtat()){
                        myButton[i][j].setGraphic(new ImageView(o.getSprite()));

                    }

                }
            }

        }
    }

    public GridPane getGridPane(){
        return this.gridPane;
    }
}
