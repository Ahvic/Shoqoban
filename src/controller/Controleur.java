package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import model.CommandeConcret;
import model.Concepteur;
import vue.BuilderVue;
import vue.VueJeu;
import vue.VueMenu;


public class Controleur {

    private static Controleur instance = null;

    private static Concepteur concepteur;

    private static CommandeConcret commande;

    private static BuilderVue bld;

    private static GridPane gridPane;

    private char[][] tab_Etat;


    /*Constructeur privé*/
    private Controleur(){
        Controleur.concepteur = new Concepteur();
        Controleur.commande = new CommandeConcret();
    }


    /*getInstance du singleton */

    public static Controleur getInstance() {
        if(Controleur.instance == null){
            Controleur.instance = new Controleur();
        }
        return Controleur.instance;
    }


    /*récuperation du tableau, création de vueJeu, utilisation de la méthode afficher de vueJeu
     * et attente d'une action pour actualiser la vue*/


    public void Init(){

        tab_Etat = concepteur.lectureFichier("something.xsb");
        //VueJeu vue = (VueJeu) bld.getVue();
        //gridPane = vue.getGridPane();
        CommandeConcret commande = new CommandeConcret();

    }



    public void Jouer(KeyCode c){

        tab_Etat = commande.move(c, tab_Etat);//opère une modification sur le tableau

        /*actualiser la vue*/

    }


    /*création de vueMenu, affichage*/

    public void Menu(){

    }



    public GridPane getGridPane(){
        return Controleur.gridPane;

    }


}
