import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.VueJeu;
import controller.Controleur;
public class Main extends Application {

    // HELLO IM A TEST wesh alors

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controleur controleur = Controleur.getInstance();

        char entrepot[][] = {{'#', '#', '#', '#', '#', '#', '#'},
                {'#', '.', ' ', '$', ' ', '.', '#'},
                {'#', ' ', '$', '@', '$', ' ', '#'},
                {'#', '.', ' ', '$', ' ', '.', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}};

        VueJeu vue = new VueJeu(entrepot);
        vue.gridPane.setAlignment(Pos.CENTER);

        /* montage de la scene */

        vue = (VueJeu) vue.setCentre(vue.gridPane);
        Scene scene =   vue.retourneScene();

        primaryStage.setScene(scene);

        primaryStage.setTitle("shoqoban");
        primaryStage.show();
    }


    public static void main(String[] args) {


        Controleur.getInstance().Menu();
        launch(args);
    }
}
