import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import controller.Controleur;
import javafx.util.Pair;
import model.CommandeConcret;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Controleur controleur = Controleur.getInstance();

        try{
            controleur.Init();
        }catch (FileNotFoundException exception)
        {
            System.out.println ("Le fichier n'a pas été trouvez");
        }

        while(true){
            char[][] tab = controleur.getEtat();

            for(int i = 0; i < tab.length; i++){
                for(int j = 0; j < tab[0].length; j++){
                    System.out.print(tab[i][j]);
                }
                System.out.println();
            }

            KeyCode input = KeyCode.valueOf(new Scanner(System.in).next());
            CommandeConcret cc = new CommandeConcret();

            if(input.getName() != "A")
                controleur.Jouer(input);
            else
                cc.undo();

            System.out.println("NbUndo: " + controleur.getNbUndo());
            ArrayList<Pair> p = controleur.getEnsInput();

            for (int i = 0; i < p.size(); i++) {
                System.out.print("(" + p.get(i).getKey() + "," + p.get(i).getValue() + ")");
            }

            System.out.println();
        }
    }
}