package vue;

import controller.Controleur;

import javafx.scene.control.Label;

public class VueNbCoup extends Vue{
    private Label label;

    public VueNbCoup(){
        label = new Label("0");
        gridPane.add(label,0,0);
    }

    public void dessine() {
        label.setText(Controleur.getInstance().getNbCoup()+"");
    }
}
