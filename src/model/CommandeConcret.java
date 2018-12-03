package model;

import javafx.scene.input.KeyCode;

public class CommandeConcret implements Commande{


    public CommandeConcret(){

    }

    /*
    * Que faire si il n'y a pas de @ ?
    *
    * Gere collision
    * Deplacement
    *
    * Direction sous forme de fleche du clavier 👍
    * Tableau rectangulaire                     👍
    * L'espace de jeue st entoure de mur
    * Gestion des caisses vérif si mouvement possible
    *
    * On peut enlever une caisse qui etait sur le goal
    *
    * Test unitaire avec appel concepteur
    *
    * @param Direction (KeyCode), tableau(char[][])
    * @return tableau
    */

    public char[][] move(KeyCode c, char[][] tab){
        int[] dir = directionJoueur(c);
        int[] coordJ = {-1,-1};

        for(int i = 0; i < tab[0].length; i++){
            for(int j = 0; j < tab[1].length; j++)
                if(tab[i][j] == '@'){
                    coordJ[0] = i;
                    coordJ[1] = j;
                }
        }

        int[] voulu = {coordJ[0] + dir[0], coordJ[1] + dir[1]};

        //System.out.println(coordJ[0] + " " + coordJ[1]);
        //System.out.println(voulu[0] + " " + voulu[1]);

        if(tab[voulu[0]][voulu[1]] == ' '){
            tab[coordJ[0]][coordJ[1]] = ' ';
            tab[voulu[1]][voulu[0]] = '@';
        }

        return tab;
    }

    /**
     * Utilise dans move
     *
     * @param c la touche qui doit etre une fleche
     * @return 1e element represente le mouvmeent en x, le second en y
     */

    public int[] directionJoueur(KeyCode c){

        int[] res = {0,0};

        if(c.isArrowKey()) {
            switch (c.getName()) {
                case "Left":
                    res[0] = -1;
                    break;
                case "Right":
                    res[0] = 1;
                    break;
                case "Up":
                    res[1] = -1;
                    break;
                case "Down":
                    res[1] = 1;
                    break;
            }
        }

        return res;
    }
}
