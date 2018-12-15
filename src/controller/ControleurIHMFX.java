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
    Vue vueNbCoup;
    Vue vueUndoRedo;
    public Button reset;

    public ControleurIHMFX(Controleur controleur, Vue vueJeu, Vue vueMenu, Vue vueUndoRedo, IHMFX i) {
        this.controleur = controleur;
        this.vueJeu = vueJeu;
        this.vueMenu = vueMenu;
        this.vueUndoRedo = vueUndoRedo;

        for (Map.Entry<Button, String> entry : vueUndoRedo.getButtonMap().entrySet()) {
            entry.getKey().setOnAction(new MyAct(entry.getValue(), i));
        }

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

    class MyAct implements EventHandler<ActionEvent> {
        String indice;
        IHMFX i;

        MyAct(String indice, IHMFX i) {
            this.indice = indice;
            this.i = i;
        }

        @Override
        public void handle(ActionEvent event) {
            if (this.indice.equals("Undo")) {
                Controleur.getInstance().modele.undo();
                i.actualise();
            }
            if (this.indice.equals("Redo")){
                Controleur.getInstance().modele.redo();
                i.actualise();
            }
        }
    }
}