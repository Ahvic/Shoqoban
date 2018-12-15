package model;

import javafx.scene.input.KeyCode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Stack;

public class ModeleConcret implements Modele{

    private static char[][] tab_Etat;
    private Stack<Pair> inputValide;
    private Stack<Pair> inputUndo;

    public ModeleConcret(){
        Concepteur c = new Concepteur();

        tab_Etat = c.lectureFichier("Level1.xsb");
        inputValide = new Stack<>();
        inputUndo = new Stack<>();
    }

    /**
     * Determine si le joueur a gagner sa partie.
     * Se contente de regarde si il reste une caisse
     * qui n'est pas dans un trou.
     *
     * @return boolean gagner ou non
     */

    public boolean aGagner(){

        for(int i = 0; i < tab_Etat.length; i++){
            for(int j = 0; j < tab_Etat[0].length; j++){
                if(tab_Etat[i][j] == '$') return false;
            }
        }

        return true;
    }

    /**
     * Move utilise hors des fonction undo/redo
     * @param c la touche indiquant la direction
     */

    public void move(KeyCode c){
        move(c, 0);
    }

    /**
     * Va modifier le tableau du controlleur pour
     * faire le mouvement dans la direction donnee en
     * parametre
     *
     * @param c la touche indiquant la direction
     * @param operation indique si le type d'action a effectue
     *                  0 avance normalement
     *                  1 si appel venant de Undo
     *                  2 si appel venant de Redo
     */

    public void move(KeyCode c, int operation){

        if(operation == 0)
            inputUndo.clear();

        Pair mouvement = new Pair(null, 0);

        int[] dir = directionJoueur(c);
        int xCoordJ = -1;
        int yCoordJ = -1;

        for(int i = 0; i < tab_Etat.length; i++){
            for(int j = 0; j < tab_Etat[0].length; j++)
                if(tab_Etat[i][j] == '@' || tab_Etat[i][j] == '+'){
                    xCoordJ = i;
                    yCoordJ = j;
                }
        }

        int[] voulu = {xCoordJ + dir[0], yCoordJ + dir[1]};

        if(tab_Etat[voulu[0]][voulu[1]] == ' '){
            if (tab_Etat[xCoordJ][yCoordJ] == '@'){
                tab_Etat[xCoordJ][yCoordJ] = ' ';
                tab_Etat[voulu[0]][voulu[1]] = '@';
            }

            if (tab_Etat[xCoordJ][yCoordJ] == '+'){
                tab_Etat[xCoordJ][yCoordJ] = '.';
                tab_Etat[voulu[0]][voulu[1]] = '@';
            }

            mouvement = new Pair(c, 0);
        }

        if(tab_Etat[voulu[0]][voulu[1]] == '.'){
            if (tab_Etat[xCoordJ][yCoordJ] == '@'){
                tab_Etat[xCoordJ][yCoordJ] = ' ';
                tab_Etat[voulu[0]][voulu[1]] = '+';
            }

            if (tab_Etat[xCoordJ][yCoordJ] == '+'){
                tab_Etat[xCoordJ][yCoordJ] = '.';
                tab_Etat[voulu[0]][voulu[1]] = '+';
            }

            mouvement = new Pair(c, 0);
        }

        if(tab_Etat[voulu[0]][voulu[1]] == '$'){

            boolean aBouge = false;

            if(tab_Etat[voulu[0] + dir[0]][voulu[1] + dir[1]] == ' ') {
                tab_Etat[voulu[0] + dir[0]][voulu[1] + dir[1]] = '$';
                aBouge = true;
            }

            if(tab_Etat[voulu[0] + dir[0]][voulu[1] + dir[1]] == '.') {
                tab_Etat[voulu[0] + dir[0]][voulu[1] + dir[1]] = '*';
                aBouge = true;
            }

            if(aBouge) {
                if (tab_Etat[xCoordJ][yCoordJ] == '@') {
                    tab_Etat[xCoordJ][yCoordJ] = ' ';
                    tab_Etat[voulu[0]][voulu[1]] = '@';
                }

                if (tab_Etat[xCoordJ][yCoordJ] == '+') {
                    tab_Etat[xCoordJ][yCoordJ] = '.';
                    tab_Etat[voulu[0]][voulu[1]] = '@';
                }

                mouvement = new Pair(c, 1);
            }
        }

        if(tab_Etat[voulu[0]][voulu[1]] == '*'){

            boolean aBouge = false;

            if(tab_Etat[voulu[0] + dir[0]][voulu[1] + dir[1]] == ' ') {
                tab_Etat[voulu[0] + dir[0]][voulu[1] + dir[1]] = '$';
                aBouge = true;
            }

            if(tab_Etat[voulu[0] + dir[0]][voulu[1] + dir[1]] == '.') {
                tab_Etat[voulu[0] + dir[0]][voulu[1] + dir[1]] = '*';
                aBouge = true;
            }

            if(aBouge) {
                if (tab_Etat[xCoordJ][yCoordJ] == '@') {
                    tab_Etat[xCoordJ][yCoordJ] = ' ';
                    tab_Etat[voulu[0]][voulu[1]] = '+';
                }

                if (tab_Etat[xCoordJ][yCoordJ] == '+') {
                    tab_Etat[xCoordJ][yCoordJ] = '.';
                    tab_Etat[voulu[0]][voulu[1]] = '+';
                }

                mouvement = new Pair(c, 1);
            }
        }

        if(operation == 0 || operation == 2)
            inputValide.add(mouvement);
    }

    /**
     * Transforme la touche rentree en parametre en direction
     * au format [y,x]
     *
     * @param c la touche a convertir
     * @return in[2] contenant la direction du mouvement au format [y,x]
     */

    public int[] directionJoueur(KeyCode c){

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



    public static char[][] getTab_Etat() {
        return tab_Etat;
    }

    public static void setTab_Etat(char[][] tab_Etat) {
        ModeleConcret.tab_Etat = tab_Etat;

        System.out.println("I've been set");
    }

    public Stack<Pair> getInputValide() {
        return inputValide;
    }

    public void setInputValide(Stack<Pair> inputValide) {
        this.inputValide = inputValide;
    }

    public Stack<Pair> getInputUndo() {
        return inputUndo;
    }

    public void setInputUndo(Stack<Pair> inputUndo) {
        this.inputUndo = inputUndo;
    }
}