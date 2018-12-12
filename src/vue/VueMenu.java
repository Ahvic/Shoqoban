package vue;

import controller.Controleur;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by hadji on 04/12/18.
 */
public class VueMenu extends Vue{
    public Map<Button,String> buttonMap;
    public VueMenu() {
        buttonMap = new HashMap<Button,String>();
        Text txt = new Text("Menu");
        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        gridPane.add(txt, 0, 0, 2, 1);

        ArrayList<String> niveaux = Controleur.getInstance().getNiveaux();
        Iterator<String> it = niveaux.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            Button btn = new Button("Niveau " + i);
            buttonMap.put(btn,it.next());
            gridPane.add(btn, 1, 4+i);

        }

        gridPane.setStyle("-fx-background-color: #666;");
        dessine();
    }
    public Map<Button,String> getButtonMap(){
        return this.buttonMap;
    }
    public void dessine() {
        System.out.println("dessine Menu");
    }
}
