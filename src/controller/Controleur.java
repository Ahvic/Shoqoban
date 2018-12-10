package controller;

import model.CommandeConcret;
import model.Concepteur;
import vue.BuilderVue;
import vue.Vue;


public class Controleur {

    private static Controleur instance = null;

    private static Concepteur concepteur;

    private static CommandeConcret commande;

    BuilderVue fabrique;

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
    //Tout ce qui se rapproche à la vue

    public Controleur(BuilderVue fabrique){
        this.fabrique = fabrique;
    }

    Vue choixVue(String nomVue){
        Vue vue;

        vue = fabrique.creerVue(nomVue);

        return vue;
    }

    /*récuperation du tableau, création de vueJeu, utilisation de la méthode afficher de vueJeu
     * et attente d'une action pour actualiser la vue*/

    private void Jouer(){
        char[][] tab_Etat = concepteur.lectureFichier("something.xsb");
        /*VUE sera ici*/
        CommandeConcret commande = new CommandeConcret();
        /*tant qu'on a pas gagner, demander une commande"*/

        // tab_Etat = commande.move(, tab_Etat);//opère une modification sur le tableau
        /*actualiser la vue puis recommencer*/

    }


    /*création de vueMenu, affichage et attente d'une action*/

    public void Menu(){



         Jouer();

    }


}
