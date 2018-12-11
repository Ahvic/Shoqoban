package controller;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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

    private static char[][] tab_Etat;

    private static VueJeu vuejeu;


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
        Controleur.tab_Etat = concepteur.lectureFichier("/home/calgary/IdeaProjects/Shoqoban/sokoban01.xsb");
        System.out.println(tab_Etat[0][0]);
        Controleur.vuejeu = new VueJeu(Controleur.tab_Etat);
        vuejeu.dessine(tab_Etat);

    }



    public void Jouer(KeyCode c){
        Controleur.tab_Etat = Controleur.commande.move(c, Controleur.tab_Etat);//opère une modification sur le tableau
        Controleur.vuejeu.dessine(Controleur.tab_Etat);
    }


    /*création de vueMenu, affichage*/

    public void Menu(){

    }

    public GridPane getGridPane(){
        return vuejeu.getGridPane();
    }


}
