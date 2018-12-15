package vue;

import controller.Controleur;
import javafx.scene.control.Button;


import java.util.HashMap;

public class VueUndoRedo extends Vue{

    public VueUndoRedo(){
        buttonMap = new HashMap<Button,String>();
        Button btn = new Button("Undo");
        buttonMap.put(btn,"Undo");
        gridPane.add(btn,0,0);
        btn = new Button("Redo");
        buttonMap.put(btn,"Redo");
        gridPane.add(btn,1,0);

    }

    public void dessine() {
        System.out.println("dessine UndoRedo");
    }
}
