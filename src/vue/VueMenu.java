package vue;

import controller.Controleur;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Concepteur;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



public class VueMenu extends Vue{
    public VueMenu() {
        buttonMap = new HashMap<Button,String>();
        Text txt = new Text("Menu");
        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        gridPane.add(txt, 0, 0, 2, 1);
        try{
            ArrayList<String> niveaux = Concepteur.lectureNiveaux();
            Iterator<String> it = niveaux.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                Button btn = new Button("Niveau " + i);

                buttonMap.put(btn,it.next());
                gridPane.add(btn, 1, 4+i);

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }



        gridPane.setStyle("-fx-background-color: #666;");
        dessine();
    }

    public void dessine() {
        System.out.println("dessine Menu");
    }
}
