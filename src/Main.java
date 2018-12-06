import controller.Controleur;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Shoqoban");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Controleur.getInstance().Init();

        Controleur.getInstance().getGridPane().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode input = event.getCode();
                Controleur.getInstance().Jouer(input);
            }
        });
        Controleur.getInstance().getGridPane().requestFocus();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
