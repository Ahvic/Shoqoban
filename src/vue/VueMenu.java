package vue;

import controller.Controleur;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hadji on 04/12/18.
 */
public class VueMenu extends Vue{
    public VueMenu() {
        Text txt = new Text("Menu");
        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        gridPane.add(txt, 0, 0, 2, 1);

        ArrayList<String> niveaux = Controleur.getInstance().getNiveaux();
        Iterator<String> it = niveaux.iterator();

        while (it.hasNext()) {

            Button btn = new Button(it.next());
            gridPane.add(btn, 1, 4);

        }

        gridPane.setStyle("-fx-background-color: #666;");
        dessine();
    }
    public void dessine() {
        System.out.println("dessine Menu");
    }
}
