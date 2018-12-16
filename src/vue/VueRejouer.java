package vue;

import javafx.scene.control.Button;


import java.util.HashMap;

public class VueRejouer extends Vue{

    public VueRejouer(){
        buttonMap = new HashMap<Button,String>();
        Button btn = new Button("Rejouer");
        buttonMap.put(btn,"Rejouer");
        gridPane.add(btn,0,0);

    }

    public void dessine() {
        System.out.println("dessine Rejouer");
    }
}