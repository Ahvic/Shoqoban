package controller;

import vue.Vue;

public class Controller {

    private static Controller instance = null;

    private static char tab_Etat[][];

    private static Vue vueJeu;

    private static Vue vueMenu;

    /*Constructeur privé*/
    private Controller(){

    }


    /*getInstance du singleton */

    public Controller getInstance() {
        if(Controller.instance == null){
            Controller.instance = new Controller();
        }
        return Controller.instance;
    }


    /*récuperation du tableau, création de vueJeu, utilisation de la méthode afficher de vueJeu
    * et attente d'une action pour actualiser la vue*/

    public void Jouer(){

    }


    /*création de vueMenu, affichage et attente d'une action*/

    public void Menu(){

    }


}
