import javafx.scene.input.KeyCode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Concepteur;
import model.CommandeConcret;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        StackPane root = new StackPane();
        Scene principale = new Scene(root, 300, 250);

        Concepteur c = new Concepteur();
        CommandeConcret CC = new CommandeConcret();
        CC.tab = c.lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\Shoqoban\\Test\\Level1.xsb");

        principale.setOnKeyPressed(e -> {

            KeyCode k = e.getCode();
            CC.tab = CC.move(k,CC.tab);

            for(int i = 0; i < CC.tab.length; i++){
                for(int j = 0; j < CC.tab[0].length; j++)
                    System.out.print(CC.tab[i][j]);
                System.out.println();
            }
        });

        primaryStage.setScene(principale);
        primaryStage.show();
    }
}