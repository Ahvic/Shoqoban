package model;

/**
 * Created by hadji on 01/12/18.
 */

import java.io.*;
import java.util.ArrayList;


public class Concepteur {


    public char[][] lectureFichier(String nomFichier){

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
                fr = new FileReader(f);
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
    public ArrayList lectureNiveaux() throws IOException {
        ArrayList<String> niveaux = new ArrayList<String>();
        try{
            File repertoire = new File("Niveaux");
            if(!repertoire.isDirectory()) {
                throw new IOException("IOException Lecture Niveaux");
            }
            String [] listefichiers;
            int i;
            listefichiers=repertoire.list();
            for(i=0;i<listefichiers.length;i++){
                if(listefichiers[i].endsWith(".xsb")){
                    niveaux.add(listefichiers[i]);
                }
            }
        }catch(FileNotFoundException exception){
            System.out.print("Pas de dossier Niveaux");
        }catch (IOException exception){
            System.out.print(exception.toString());
        }

        return niveaux;
    }
}
