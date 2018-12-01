package controller;

import model.CommandeConcret;
import model.Concepteur;
import vue.Vue;

public class Controleur {

    private static Controleur instance = null;

    private static char tab_Etat[][];

    private static Vue vueJeu;

    private static Vue vueMenu;

    private static Concepteur concepteur;

    private static CommandeConcret commande;

    /*Constructeur privé*/
    private Controleur(){

    }


    /*getInstance du singleton */

    public Controleur getInstance() {
        if(Controleur.instance == null){
            Controleur.instance = new Controleur();
        }
        return Controleur.instance;
    }


    /*récuperation du tableau, création de vueJeu, utilisation de la méthode afficher de vueJeu
     * et attente d'une action pour actualiser la vue*/

    public void Jouer(){

    }


    /*création de vueMenu, affichage et attente d'une action*/

    public void Menu(){

    }


}
