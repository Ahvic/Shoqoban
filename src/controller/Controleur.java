package controller;

import model.CommandeConcret;
import model.Concepteur;
import model.ModelConcret;

public class Controleur {

    private static Controleur instance = null;

    private static Concepteur concepteur;

    private static CommandeConcret commande;

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

    public void Jouer(){
        char [][] tab_Etat = concepteur.lectureFichier("something.xsb");
        /*VUE sera ici*/
        CommandeConcret commande = new CommandeConcret();
        /*tant qu'on a pas gagner, demander une commande"*/
        commande.move();//opère une modification sur le tableau
        /*actualiser la vue puis recommencer*/

    }


    /*création de vueMenu, affichage et attente d'une action*/

    public void Menu(){



        Jouer();

    }


}
