import controller.Controleur;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import vue.BuilderVue;
import vue.Observateur;
import vue.Vue;
import vue.VueNbCoup;

public class IHMFX extends Application implements Observateur {
    VueNbCoup vueNbCoup;
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
        ControleurIHMFX controleurIHMFX = new ControleurIHMFX(controleur,vue);
        vue.gridPane.setAlignment(Pos.CENTER);
        vueNbCoup= new VueNbCoupIHMFX(controleur);
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

        primaryStage.setTitle("Chameaux");
        primaryStage.show();
    }

    public void lance() {
        launch(new String[]{});
    }
}
