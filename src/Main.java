import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.CommandeConcret;
import model.Concepteur;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Hello World!");
        StackPane root = new StackPane();

        Scene principale = new Scene(root, 300, 250);
        principale.setOnKeyPressed(e -> {

            KeyCode kC = e.getCode();

            //CommandeConcret c = new CommandeConcret();
            //int[] f = c.directionJoueur(kC);
        });

        primaryStage.setScene(principale);
        primaryStage.show();
    }
}