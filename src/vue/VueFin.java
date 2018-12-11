package vue;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by legret on 07/12/18.
 */
public class VueFin extends Vue{

    public Button btn;


    public VueFin(){

        Text txt = new Text("Vous avez gagné, vous êtes très très fort, Bravo");
        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        gridPane.add(txt, 0, 0, 2, 1);
        Button btn = new Button("On relance le niveau pour le plaisir");
        gridPane.add(btn, 1, 4);
        Button btn2 = new Button("On passe au niveau suivant");
        btn.setMinSize(48,48);
        gridPane.add(btn2, 0, 4);
        Button btn3 = new Button("Retour au menu");
        gridPane.add(btn3, 1, 0);
        gridPane.setStyle("-fx-background-color: #666;");
        dessine();
    }
    public void dessine(){
        System.out.println("dessine Fin");
    }

}
