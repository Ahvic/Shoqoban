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
    ArrayList<Region> bas = new ArrayList<Region>();
    Region centre;
    int largeurScene = 800;
    int hauteurScene = 400;



    public GridPane getGridPane(){
        return this.gridPane;
    }
    public Vue setLargeur(int l){
        largeurScene=l;
        return this;
    }

    public Vue setHauteur(int l) {
        hauteurScene=l;
        return this;
    }
    public Vue gridPaneCentre(){
        gridPane.setAlignment(Pos.CENTER);
        return this;
    }
    public Vue setCentre(Region node) {
        centre = node;
        return this;
    }

    public Vue ajoutBas(Region node) {
        bas.add(node);
        return this;
    }

    public void dessine(){
        System.out.println("nothing happend");
    }

    public javafx.scene.Scene retourneScene() {
        assert (centre !=null);
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(centre,0,0);
        gridPane.setMinSize(largeurScene, hauteurScene);
        centre.setMinSize(largeurScene, hauteurScene*7/8);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        if (bas.size()!=0) {
            GridPane gridPaneBas = new GridPane();
            gridPaneBas.setAlignment(Pos.CENTER);
            gridPaneBas.setMinSize(largeurScene, hauteurScene/8);
            gridPaneBas.setPadding(new Insets(10, 10, 10, 10));
            //Setting the padding
            gridPane.setPadding(new Insets(10, 10, 10, 10));
            int i=0;
            for (Region n:bas) {
                n.setMinSize(largeurScene/bas.size(),hauteurScene/8);
                gridPaneBas.add(n,i,0);
                i++;
            }
            gridPane.add(gridPaneBas,0,1);
        }

        return new javafx.scene.Scene(gridPane,largeurScene,hauteurScene);

    }
    public Map<Button,String> getButtonMap(){
        return this.buttonMap;
    }
    public String getLink(Button b){
        return buttonMap.get(b);
    }

}
