package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import vue.IHMFX;
import vue.Vue;

import java.util.Map;

public class ControleurIHMFX {
    Controleur controleur;
    Vue vueJeu;
    Vue vueMenu;
    Vue vueFin;
    Vue vueNbCoup;
    public Button reset;

    public ControleurIHMFX(Controleur controleur, Vue vueJeu, Vue vueMenu,IHMFX i) {
        this.controleur = controleur;
        this.vueJeu = vueJeu;
        this.vueMenu = vueMenu;

        for (Map.Entry<Button, String> entry : vueMenu.getButtonMap().entrySet()) {
            entry.getKey().setOnAction(new MyAction(entry.getValue(), i));
        }

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
        IHMFX i;

        MyAction(String indice, IHMFX i) {
            this.indice = indice;
            this.i = i;
        }

        @Override
        public void handle(ActionEvent event) {
            Controleur.getInstance().setModele("src/Niveaux/" + indice);
            i.play();
        }
    }
}