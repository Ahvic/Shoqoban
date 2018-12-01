package model;

/**
 * Created by hadji on 01/12/18.
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.*;
import java.util.ArrayList;
public class Concepteur {

    ArrayList<Region> bas = new ArrayList<Region>();
    Region centre;
    int largeurScene = 800;
    int hauteurScene = 400;

    private char[][] lectureFichier(String nomFichier){

        int largeur = 0;
        int hauteur = 0;

        try
        {
            File f = new File (nomFichier);
            FileReader fr = new FileReader (f);
            BufferedReader br = new BufferedReader (fr);

            try
            {
                String line = br.readLine();

                while (line != null)
                {
                    hauteur++;
                    if(line.length() > largeur){
                        largeur = line.length();
                    }
                    line = br.readLine();
                }
                br.close();

                char[][] carte = new char[hauteur][largeur];

                br = new BufferedReader(fr);
                line = br.readLine();
                int i = 0;
                while (line != null)
                {
                    for(int j = 0; j<line.length();j++) {
                        carte[i][j] = line.charAt(j);
                    }
                    i++;
                    line = br.readLine();
                }
                br.close();
                fr.close();
                return carte;
            }
            catch (IOException exception)
            {
                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("Le fichier n'a pas été trouvé");
        }
        return null;
    }
    public Concepteur setLargeur(int l){
        largeurScene=l;
        return this;
    }

    public Concepteur setHauteur(int l) {
        hauteurScene=l;
        return this;
    }

    public Concepteur setCentre(Region node) {
        centre = node;
        return this;
    }

    public Concepteur ajoutBas(Region node) {
        bas.add(node);
        return this;
    }

    public Scene retourneScene() {
        assert (centre !=null);
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(centre,0,0);
        gridPane.setMinSize(largeurScene, hauteurScene);
        centre.setMinSize(largeurScene, hauteurScene*7/8);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        if (bas.size()!=0) {
            GridPane gridPaneBas = new GridPane();
            gridPaneBas.setAlignment(Pos.CENTER);
            gridPaneBas.setMinSize(largeurScene, hauteurScene/8);
            gridPaneBas.setPadding(new Insets(10, 10, 10, 10));
            //Setting the padding
            gridPane.setPadding(new Insets(10, 10, 10, 10));
            int i=0;
            for (Region n:bas) {
                n.setMinSize(largeurScene/bas.size(),hauteurScene/8);
                gridPaneBas.add(n,i,0);
                i++;
            }
            gridPane.add(gridPaneBas,0,1);
        }

        return new Scene(gridPane,largeurScene,hauteurScene);

    }
}
