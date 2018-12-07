import controller.Controleur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.VueJeu;
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
        vue.gridPaneCentre();

        /* montage de la scene */

        vue = (VueJeu) vue.setCentre(vue.getGridPane());
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
