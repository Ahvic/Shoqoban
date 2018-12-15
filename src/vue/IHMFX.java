package vue;

import controller.Controleur;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import vue.*;

public class IHMFX extends Application implements Observateur {
    Vue vueNbCoup;
    Vue vue;
    BuilderVue bld;

    public void actualise(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vueNbCoup.dessine();
                vue.dessine();
            }
        });
    };

    public void start(Stage primaryStage) throws Exception{
        Controleur controleur = Controleur.getInstance();
        controleur.abonne(this);

        bld = new BuilderVue();
        vue = bld.creerVue("Menu");
        vue.getGridPane().setAlignment(Pos.CENTER);
        vueNbCoup= bld.creerVue("NbCoup");
        vueNbCoup.label.setAlignment(Pos.CENTER);

        /* montage de la scene */
        MonteurScene monteurScene = new MonteurScene();

        Scene scene = monteurScene.
                setCentre(vue.gridPane).
                ajoutBas(controleur.reset).
                ajoutBas(vueNbCoup.label).
                setLargeur(800).
                setHauteur(200).
                retourneScene();

        primaryStage.setScene(scene);

        primaryStage.setTitle("Shoqoban");
        primaryStage.show();
    }

    public void lance() {
        launch(new String[]{});
    }
}
