package vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.Map;

public abstract class Vue {

    protected GridPane gridPane = new GridPane();
    protected Map<Button,String> buttonMap;


    public GridPane getGridPane(){
        return this.gridPane;
    }

    public void dessine(){
        System.out.println("nothing happend");
    }


    public Map<Button,String> getButtonMap(){
        return this.buttonMap;
    }
    public String getLink(Button b){
        return buttonMap.get(b);
    }

}
