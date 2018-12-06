package vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;
import java.util.ArrayList;

abstract class Vue {

    private GridPane principale;

    ArrayList<Region> bas = new ArrayList<Region>();
    Region centre;
    int largeurScene = 800;
    int hauteurScene = 400;

    public Vue setLargeur(int l){
        largeurScene=l;
        return this;
    }

    public Vue setHauteur(int l) {
        hauteurScene=l;
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

}
