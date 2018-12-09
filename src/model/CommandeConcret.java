package model;
import javafx.scene.input.KeyCode;
import java.util.Stack;

public class CommandeConcret implements Commande{

    //TOUS LES ARGUMENTS DEMANDANT LE TABLEAU ET LA PILE SERONT DES APPELS A UNE VAR QUECPART

    public CommandeConcret(){

    }

    public char[][] undo(Stack<KeyCode> s, char[][] tab){

        KeyCode lastKey = s.pop();

        int[] JCVD = directionJoueur(lastKey);

        int xCoordJ = -1;
        int yCoordJ = -1;

        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab[0].length; j++)
                if(tab[i][j] == '@' || tab[i][j] == '+'){
                    xCoordJ = i;
                    yCoordJ = j;
                }
        }

        move(inversionTouche(lastKey), tab);

        //Si on a pousse une caisse
        char derLastDir = tab[xCoordJ + JCVD[0]][yCoordJ + JCVD[1]];

        if(derLastDir == '$'){
            if(tab[xCoordJ][yCoordJ] == ' ') tab[xCoordJ][yCoordJ] = '$';
            if(tab[xCoordJ][yCoordJ] == '.') tab[xCoordJ][yCoordJ] = '*';

            tab[xCoordJ + JCVD[0]][yCoordJ + JCVD[1]] = ' ';
        }

        if(derLastDir == '*'){
            if(tab[xCoordJ][yCoordJ] == ' ') tab[xCoordJ][yCoordJ] = '$';
            if(tab[xCoordJ][yCoordJ] == '.') tab[xCoordJ][yCoordJ] = '*';

            tab[xCoordJ + JCVD[0]][yCoordJ + JCVD[1]] = '.';
        }

        return tab;
    }

    private KeyCode inversionTouche(KeyCode c){

        if(c.isArrowKey()) {
            switch (c.getName()) {
                case "Left":
                    return KeyCode.valueOf("RIGHT");
                case "Right":
                    return KeyCode.valueOf("LEFT");
                case "Up":
                    return KeyCode.valueOf("DOWN");
                case "Down":
                    return KeyCode.valueOf("UP");
            }
        }

        return null;
    }

    /**
     * Verifie si la partie est termine en regardant si il
     * reste une caisse sur le tableau
     *
     * @param tab
     * @return vrai si fini, faux sinon
     */

    public boolean aGagner(char[][] tab){

        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab.length; j++){
                if(tab[i][j] == '$') return false;
            }
        }

        return true;
    }

    /**
     *
     * @param c le code de la touche appuye
     * @param tab le tableau a modifier, doit se trouver hors du "main" de javafx
     * @return le tableau modifie
     */

    public char[][] move(KeyCode c, char[][] tab){

        //Manque ajout des touches a la pile ssi le mouvement a ete valide

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
