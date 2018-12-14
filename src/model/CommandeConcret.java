package model;

import controller.Controleur;
import javafx.scene.input.KeyCode;
import javafx.util.Pair;
import java.util.ArrayList;

public class CommandeConcret implements Commande{

    /**
     * Va prendre le dernier element de ensInput et va le
     * transformer en mouvement. Prend en compte si une caisse
     * doit etre bougee ou non.
     *
     * Modifie tab, ensInput et nbUndo du controleur grace au
     * singleton.
     */

    public void undo(){
        Controleur control = Controleur.getInstance();

        char[][] tab = control.getEtat();
        ArrayList<Pair> ensInput = control.getEnsInput();
        int nbUndo = control.getNbUndo();

        if (!ensInput.isEmpty()) {
            nbUndo++;
            int indexElemVoulu = ensInput.size()-nbUndo;

            if(indexElemVoulu >= 0){
                Pair lastElem = ensInput.get(indexElemVoulu);
                KeyCode  lastKey = (KeyCode) lastElem.getKey();
                int  lKCaisse = (int) lastElem.getValue();

                System.out.println("Last elem: " + "(" + lastKey + "," + lKCaisse + ")");

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

                move(inversionTouche(lastKey), true);

                //Si on a pousse une caisse
                if(lKCaisse == 1){

                    char derLastDir = tab[xCoordJ + JCVD[0]][yCoordJ + JCVD[1]];

                    System.out.println(derLastDir + " (" + xCoordJ + JCVD[0] + "," + yCoordJ + JCVD[1] + ")");

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
                }

                control.setNbUndo(nbUndo);
                control.setEtat(tab);
                control.setEnsInput(ensInput);
            }
        }
    }

    /**
     * Re-execute le dernier undo
     *
     * Modifie tab, ensInput et nbUndo du controleur grace au
     * singleton.
     */

    public void redo(){
        Controleur control = Controleur.getInstance();

        ArrayList<Pair> ensInput = control.getEnsInput();
        int nbUndo = control.getNbUndo();

        int indexElemVoulu = ensInput.size()-nbUndo;

        if(indexElemVoulu < ensInput.size()) {
            KeyCode mouv = (KeyCode) ensInput.get(indexElemVoulu).getKey();
            move(mouv, true);

            nbUndo--;
            control.setNbUndo(nbUndo);
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

    /**
     * Determine si le joueur a gagner sa partie.
     * Se contente de regarde si il reste une caisse
     * qui n'est pas dans un trou.
     *
     * @return boolean gagner ou non
     */

    public boolean aGagner(){
        Controleur control = Controleur.getInstance();
        char[][] tab = control.getEtat();

        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab[0].length; j++){
                if(tab[i][j] == '$') return false;
            }
        }

        return true;
    }

    /**
     * Va modifier le tableau du controlleur pour
     * faire le mouvement dans la direction donnee en
     * parametre
     *
     * @param c la touche indiquant la direction
     * @param sansSuppEnsInput indique si il faut supprimer les coup precedent
     *        un redo ou non
     */

    public void move(KeyCode c, boolean sansSuppEnsInput){
        Controleur control = Controleur.getInstance();

        char[][] tab = control.getEtat();
        ArrayList<Pair> ensInput = control.getEnsInput();
        int nbUndo = control.getNbUndo();

        if(!sansSuppEnsInput) {
            for (int i = nbUndo; i > 0; i--) {
                if (!ensInput.isEmpty())
                    ensInput.remove(ensInput.size() - 1);
                nbUndo--;
            }
        }

        //0 sans caisse, 1 avec caisse

        Pair mouvement = new Pair(null, 0);

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

        if(tab[voulu[0]][voulu[1]] == ' '){
            if (tab[xCoordJ][yCoordJ] == '@'){
                tab[xCoordJ][yCoordJ] = ' ';
                tab[voulu[0]][voulu[1]] = '@';
            }

            if (tab[xCoordJ][yCoordJ] == '+'){
                tab[xCoordJ][yCoordJ] = '.';
                tab[voulu[0]][voulu[1]] = '@';
            }

            mouvement = new Pair(c, 0);
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

            mouvement = new Pair(c, 0);
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

                mouvement = new Pair(c, 1);
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

                mouvement = new Pair(c, 1);
            }
        }

        if(mouvement.getKey() != null && !sansSuppEnsInput)
            ensInput.add(mouvement);

        control.setNbUndo(nbUndo);
        control.setEtat(tab);
        control.setEnsInput(ensInput);
    }

    /**
     * Transforme la touche rentree en parametre en direction
     * au format [y,x]
     *
     * @param c la touche a convertir
     * @return in[2] contenant la direction du mouvement au format [y,x]
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