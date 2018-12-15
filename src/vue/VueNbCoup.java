package vue;

import controller.Controleur;

import javafx.scene.control.Label;

public class VueNbCoup extends Vue{

    public Label label = new Label("0");

    public void dessine() {
        label.setText(Controleur.getInstance().getNbCoup()+"");
    }
}
