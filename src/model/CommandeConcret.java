package model;

import controller.Controleur;
import javafx.scene.input.KeyCode;
import javafx.util.Pair;

import javax.naming.ldap.Control;
import java.util.ArrayList;

public class CommandeConcret implements Commande{

    public CommandeConcret(){

    }

    public void undo(){

    }

    public void redo(){}

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

    public boolean aGagner(){
        Controleur control = Controleur.getInstance();
        char[][] tab = control.getEtat();

        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab.length; j++){
                if(tab[i][j] == '$') return false;
            }
        }

        return true;
    }

    public void move(KeyCode c){
        Controleur control = Controleur.getInstance();

        char[][] tab = control.getEtat();
        ArrayList<Pair> ensInput = control.getEnsInput();
        int nbUndo = control.getNbUndo();

        for(int i = nbUndo; i > 0; i--) {
            if(!ensInput.isEmpty())
                ensInput.remove(ensInput.size()-1);
            nbUndo--;
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

        //if(mouvement.getKey() != null) ensInput.add(mouvement);

        control.setNbUndo(nbUndo);
        control.setEtat(tab);
        control.setEnsInput(ensInput);
    }

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