package vue;

import controller.Controleur;
import controller.ControleurIHMFX;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class IHMFX extends Application implements Observateur {
    Vue vueNbCoup;
    Vue vueUndoRedo;
    Vue vue;
    Vue vueMenu;
    BuilderVue bld;
    Stage primaryStage;

    public void actualise(){
        Platform.runLater(new Runnable() {
            public void run() {
                vueNbCoup.dessine();
                vue.dessine();
            }
        });
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Controleur controleur = Controleur.getInstance();
        controleur.abonne(this);
        bld = new BuilderVue();
        vueMenu = bld.creerVue("Menu");
        vue = bld.creerVue("Jeu");
        ControleurIHMFX controleurIHMFX = new ControleurIHMFX(controleur,vue,vueMenu,this);
        vue.gridPane.setAlignment(Pos.CENTER);
        MonteurScene monteurScene = new MonteurScene();
        Scene scene = monteurScene.
                setCentre(vueMenu.gridPane).
                setLargeur(800).
                setHauteur(200).
                retourneScene();

        primaryStage.setScene(scene);

        primaryStage.setTitle("Shoqoban");
        primaryStage.show();


    }

    public void play(){
        Controleur controleur = Controleur.getInstance();
        controleur.abonne(this);
        vue = bld.creerVue("Jeu");
        ControleurIHMFX controleurIHMFX = new ControleurIHMFX(controleur,vue,vueMenu,this);
        vue.gridPane.setAlignment(Pos.CENTER);
        vueNbCoup= bld.creerVue("NbCoup");
        vueNbCoup.gridPane.setAlignment(Pos.CENTER);
        vueNbCoup.gridPane.setAlignment(Pos.CENTER);
        vueUndoRedo = bld.creerVue("UndoRedo");
        vueUndoRedo.gridPane.setAlignment(Pos.CENTER);

        /* montage de la scene */
        MonteurScene monteurScene = new MonteurScene();

        Scene scene = monteurScene.
                setCentre(vue.gridPane).
                ajoutBas(controleurIHMFX.reset).
                ajoutBas(vueNbCoup.gridPane).
                ajoutBas(vueUndoRedo.gridPane).
                setLargeur(800).
                setHauteur(400).
                retourneScene();

        primaryStage.setScene(scene);

        primaryStage.setTitle("Shoqoban");
        primaryStage.show();

        vue.getGridPane().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                KeyCode input = event.getCode();
                controleur.move(input);
            }
        });
        vue.getGridPane().requestFocus();
    }

    public void lance() {
        launch();
    }
}
