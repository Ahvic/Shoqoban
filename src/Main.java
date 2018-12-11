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
    int a;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controleur controleur = Controleur.getInstance();
        controleur.Init();
        primaryStage.setScene(new Scene(controleur.getGridPane(), 800, 400));
        primaryStage.setTitle("Shoqoban");
        primaryStage.show();
        controleur.getGridPane().setOnKeyPressed(new EventHandler<KeyEvent>() {


            public void handle(KeyEvent event) {
                KeyCode input = event.getCode();
                a = controleur.Jouer(input);
            }
        });
        if( a == 0 ){
            controleur.getGridPane().requestFocus();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}