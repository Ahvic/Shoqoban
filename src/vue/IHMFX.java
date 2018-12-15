package vue;

import controller.Controleur;
import controller.ControleurIHMFX;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IHMFX extends Application implements Observateur {
    VueNbCoup vueNbCoup;
    Vue vue;
    BuilderVue bld;

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
        Controleur controleur = Controleur.getInstance();
        controleur.abonne(this);
        bld = new BuilderVue();
        vue = bld.creerVue("Jeu");
        ControleurIHMFX controleurIHMFX = new ControleurIHMFX(controleur,vue);
        vue.gridPane.setAlignment(Pos.CENTER);
        vueNbCoup= new VueNbCoup();
        vueNbCoup.label.setAlignment(Pos.CENTER);

        /* montage de la scene */
        MonteurScene monteurScene = new MonteurScene();

        Scene scene = monteurScene.
                setCentre(vue.gridPane).
                ajoutBas(controleurIHMFX.reset).
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
