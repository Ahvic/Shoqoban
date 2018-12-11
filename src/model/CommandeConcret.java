package model;
import javafx.scene.input.KeyCode;

public class CommandeConcret implements Commande{


    public CommandeConcret(){

    }

    /**
     *
     * @param c le code de la touche appuye
     * @param tab le tableau a modifier, doit se trouver hors du "main" de javafx
     * @return le tableau modifie
     */


    public char[][] move(KeyCode c, char[][] tab){
        int[] dir = directionJoueur(c);
        int xCoordJ = -1;
        int yCoordJ = -1;

        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab[0].length; j++)
                if(tab[i][j] == '@' || tab[i][j] == '+'){
                    xCoordJ = i;
                    yCoordJ = j;
                }
        }

        int[] voulu = {xCoordJ + dir[0], yCoordJ + dir[1]};

        //System.out.println(xCoordJ + " " + yCoordJ);
        //System.out.println(voulu[0] + " " + voulu[1] + " " + dir[0] + " " + dir[1]);

        if(tab[voulu[0]][voulu[1]] == ' '){
            if (tab[xCoordJ][yCoordJ] == '@'){
                tab[xCoordJ][yCoordJ] = ' ';
                tab[voulu[0]][voulu[1]] = '@';
            }

            if (tab[xCoordJ][yCoordJ] == '+'){
                tab[xCoordJ][yCoordJ] = '.';
                tab[voulu[0]][voulu[1]] = '@';
            }
        }

        if(tab[voulu[0]][voulu[1]] == '.'){
            if (tab[xCoordJ][yCoordJ] == '@'){
                tab[xCoordJ][yCoordJ] = ' ';
                tab[voulu[0]][voulu[1]] = '+';
            }

            if (tab[xCoordJ][yCoordJ] == '+'){
                tab[xCoordJ][yCoordJ] = '.';
                tab[voulu[0]][voulu[1]] = '+';
            }
        }

        if(tab[voulu[0]][voulu[1]] == '$'){

            boolean aBouge = false;

            if(tab[voulu[0] + dir[0]][voulu[1] + dir[1]] == ' ') {
                tab[voulu[0] + dir[0]][voulu[1] + dir[1]] = '$';
                aBouge = true;
            }

            if(tab[voulu[0] + dir[0]][voulu[1] + dir[1]] == '.') {
                tab[voulu[0] + dir[0]][voulu[1] + dir[1]] = '*';
                aBouge = true;
            }

            if(aBouge) {
                if (tab[xCoordJ][yCoordJ] == '@') {
                    tab[xCoordJ][yCoordJ] = ' ';
                    tab[voulu[0]][voulu[1]] = '@';
                }

                if (tab[xCoordJ][yCoordJ] == '+') {
                    tab[xCoordJ][yCoordJ] = '.';
                    tab[voulu[0]][voulu[1]] = '@';
                }
            }
        }

        if(tab[voulu[0]][voulu[1]] == '*'){

            boolean aBouge = false;

            if(tab[voulu[0] + dir[0]][voulu[1] + dir[1]] == ' ') {
                tab[voulu[0] + dir[0]][voulu[1] + dir[1]] = '$';
                aBouge = true;
            }

            if(tab[voulu[0] + dir[0]][voulu[1] + dir[1]] == '.') {
                tab[voulu[0] + dir[0]][voulu[1] + dir[1]] = '*';
                aBouge = true;
            }

            if(aBouge) {
                if (tab[xCoordJ][yCoordJ] == '@') {
                    tab[xCoordJ][yCoordJ] = ' ';
                    tab[voulu[0]][voulu[1]] = '+';
                }

                if (tab[xCoordJ][yCoordJ] == '+') {
                    tab[xCoordJ][yCoordJ] = '.';
                    tab[voulu[0]][voulu[1]] = '+';
                }
            }
        }

        return tab;
    }

    /**
     * Utilise dans move, retourne la direction du mouvment au format [y,x]
     *
     * @param c la touche qui doit etre une fleche
     * @return un tableau de taille 2, [y,x]
     */

    private int[] directionJoueur(KeyCode c){

        int[] res = {0,0};

        if(c.isArrowKey()) {
            switch (c.getName()) {
                case "Left":
                    res[1] = -1;
                    break;
                case "Right":
                    res[1] = 1;
                    break;
                case "Up":
                    res[0] = -1;
                    break;
                case "Down":
                    res[0] = 1;
                    break;
            }
        }

        return res;
    }

}
