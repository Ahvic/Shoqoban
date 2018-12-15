package model;

import javafx.util.Pair;
import javafx.scene.input.KeyCode;
import java.util.Stack;

public class DecoUndoRedo implements Modele{

    private  ModeleConcret cc;

    public DecoUndoRedo (ModeleConcret cc){
        this.cc = cc;
    }

    public boolean aGagner() {
        return cc.aGagner();
    }

    public void move(KeyCode c, int operation){
        cc.move(c, operation);
    }

    public int[] directionJoueur(KeyCode c) {
        return cc.directionJoueur(c);
    }

    /**
     * Permet de remettre le tableau et les piles dans
     * leurs etats initiaux
     */

    public void reset(){

        int size = cc.getInputValide().size();

        for(int i = 0; i < size; i++) {
            undo();
        }

        cc.getInputUndo().clear();
    }

    /**
     * Re-execute le dernier undo
     *
     * Modifie tab, ensInput et nbUndo du controleur grace au
     * singleton.
     */

    public void redo(){
        Stack<Pair> InputUndo = cc.getInputUndo();

        if(!InputUndo.empty()){
            Pair lastElem = InputUndo.pop();

            //System.out.println("Le pop de redo :" + lastElem.getKey() + "," + lastElem.getValue());

            KeyCode lastKey = (KeyCode) lastElem.getKey();
            move(lastKey, 2);
        }
    }

    /**
     * Va prendre le dernier element de ensInput et va le
     * transformer en mouvement. Prend en compte si une caisse
     * doit etre bougee ou non.
     *
     * Modifie tab, ensInput et nbUndo du controleur grace au
     * singleton.
     */

    public void undo(){
        char[][] tab = cc.getTab_Etat();
        Stack<Pair> InputValide = cc.getInputValide();
        Stack<Pair> InputUndo = cc.getInputUndo();

        if(!InputValide.empty()) {

            //On passe le dernier input d'une pile a l'autre
            Pair lastElem = InputValide.pop();
            InputUndo.add(lastElem);

            //System.out.println("Le pop :" + lastElem.getKey() + "," + lastElem.getValue());

            KeyCode lastKey = (KeyCode) lastElem.getKey();
            int lKCaisse = (int) lastElem.getValue();

            int[] JCVD = directionJoueur(lastKey);

            int xCoordJ = -1;
            int yCoordJ = -1;

            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[0].length; j++)
                    if (tab[i][j] == '@' || tab[i][j] == '+') {
                        xCoordJ = i;
                        yCoordJ = j;
                    }
            }

            move(inversionTouche(lastKey), 1);

            //Si on a pousse une caisse
            if (lKCaisse == 1) {

                char derLastDir = tab[xCoordJ + JCVD[0]][yCoordJ + JCVD[1]];

                //System.out.println(derLastDir + " (" + xCoordJ + JCVD[0] + "," + yCoordJ + JCVD[1] + ")");

                if (derLastDir == '$') {
                    if (tab[xCoordJ][yCoordJ] == ' ') tab[xCoordJ][yCoordJ] = '$';
                    if (tab[xCoordJ][yCoordJ] == '.') tab[xCoordJ][yCoordJ] = '*';

                    tab[xCoordJ + JCVD[0]][yCoordJ + JCVD[1]] = ' ';
                }

                if (derLastDir == '*') {
                    if (tab[xCoordJ][yCoordJ] == ' ') tab[xCoordJ][yCoordJ] = '$';
                    if (tab[xCoordJ][yCoordJ] == '.') tab[xCoordJ][yCoordJ] = '*';

                    tab[xCoordJ + JCVD[0]][yCoordJ + JCVD[1]] = '.';
                }
            }
        }
    }

    /**
     * Inverse la direction de la touche donnee
     * en parametre.
     * Utilise dans undo.
     *
     * @param c la touche a inverser
     * @return KeyCode la touche inversee
     */

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
}
