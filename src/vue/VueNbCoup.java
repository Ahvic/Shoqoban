package vue;
import javafx.scene.control.Label;


public class VueNbCoup {
    Controleur controleur;
    Label label = new Label("0");

    public VueNbCoup(Controleur controleur) {
        this.controleur=controleur;
        Commande commande = controleur.commandeNbCoup();
    }

    public void dessine() {
        label.setText(commande.exec()+"");
    }



}
