import javafx.scene.input.KeyCode;
import model.Concepteur;
import model.CommandeConcret;

public class Main {
    public static void main(String[] args) {

        Concepteur c = new Concepteur();
        char[][] tab = c.lectureFichier("C:\\Users\\Antoi\\IdeaProjects\\Shoqoban\\Test\\Level1.xsb");

        KeyCode k = KeyCode.valueOf("RIGHT");

        CommandeConcret CC = new CommandeConcret();
        tab = CC.move(k,tab);

        for(int i = 0; i < tab[0].length; i++){
            for(int j = 0; j < tab[1].length; j++)
                System.out.print(tab[i][j]);
            System.out.println();
        }
    }
}