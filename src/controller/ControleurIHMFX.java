package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import vue.Vue;

import java.util.Map;

public class ControleurIHMFX {
    Controleur controleur;
    Vue vueJeu;
    Vue vueMenu;
    Vue vueFin;
    Vue vueNbCoup;
    public Button reset;

    public ControleurIHMFX(Controleur controleur, Vue vueJeu) {
        this.controleur = controleur;
        this.vueJeu = vueJeu;
        this.vueMenu = vueMenu;
        this.vueFin = vueFin;
        this.vueNbCoup = vueNbCoup;

       // for (Map.Entry<Button, String> entry : vueMenu.getButtonMap().entrySet()) {
        //    entry.getKey().setOnAction(new MyAction(entry.getValue()));
        //}

        reset = new Button("Reset");
        reset.setOnAction(new ActionReset());
    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.reset();
        }

    }

    class MyAction implements EventHandler<ActionEvent> {
        String indice;

        MyAction(String indice) {
            this.indice = indice;
        }

        @Override
        public void handle(ActionEvent event) {
            Controleur.getInstance().setModele(indice);
        }
    }
}