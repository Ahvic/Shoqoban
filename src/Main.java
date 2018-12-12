import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import controller.Controleur;
public class Main extends Application {

    // HELLO IM A TEST wesh alors

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controleur controleur = Controleur.getInstance();
        controleur.Init();
        primaryStage.setScene(new Scene(controleur.getGridPane(), 800, 400));
        primaryStage.setTitle("Shoqoban");
        primaryStage.show();
        Controleur.setPrimary(primaryStage);
        //controleur.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}