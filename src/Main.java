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
        GridPane gridPane = new GridPane();
        primaryStage.setScene(new Scene(controleur.getGridPane(), 800, 400));
        primaryStage.setTitle("Shoqoban");
        primaryStage.show();
        controleur.Init();
        /*gridpane.setOnKeyPressed(new EventHandler<KeyEvent>() {


            public void handle(KeyEvent event) {
                KeyCode input = event.getCode();
                controleur.Jouer(input);
            }
        });
        controleur.getGridPane().requestFocus();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
