package vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by legret on 07/12/18.
 */
public class VueFin extends Vue{

    public VueFin(){
        Text txt = new Text("Vous avez gagné, vous êtes très fort, Bravo");
        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        gridPane.add(txt, 10, 4, 2, 2);
        Button btn = new Button("On relance le niveau pour le plaisir");
        gridPane.add(btn, 16, 2);
        Button btn2 = new Button("On passe au niveau suivant");
        gridPane.add(btn2, 0, 8,8,8);
        Button btn3 = new Button("Retour au menu");
        gridPane.add(btn3, 16, 20);
        gridPane.setStyle("-fx-background-color: #403704");

        dessine();
    }
    public void dessine(){
        System.out.println("dessine Fin");
    }

}
