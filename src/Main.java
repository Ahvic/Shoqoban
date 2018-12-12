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

    private static final int maxWidth = 800;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controleur controleur = Controleur.getInstance();
        controleur.InitVue();
        primaryStage.setScene(new Scene(controleur.getGridPane(), maxWidth, 400));
        primaryStage.setTitle("Shoqoban");
        primaryStage.show();
        //controleur.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}