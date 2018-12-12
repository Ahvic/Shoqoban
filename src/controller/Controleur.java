package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import model.CommandeConcret;
import model.Concepteur;
import vue.BuilderVue;
import vue.Vue;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Controleur {

    private static Controleur instance = null;

    private static Concepteur concepteur;

    private static CommandeConcret commande;

    private static BuilderVue bld;

    private static GridPane gridPane;

    private static char[][] tab_Etat;

    private static Vue vue;

    private static ArrayList<Pair> ensInput;

    private static int nbUndo;

    private static ArrayList<String> niveaux;


    /*Constructeur privé*/
    private Controleur(){
        Controleur.concepteur = new Concepteur();
        Controleur.commande = new CommandeConcret();
        Controleur.ensInput = new ArrayList<>();
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


    public void InitVue() throws FileNotFoundException {
        Controleur.bld = new BuilderVue();
        Controleur.niveaux = concepteur.lectureNiveaux();
        //Controleur.tab_Etat = concepteur.lectureFichier("sokoban01.xsb");
        //System.out.println(tab_Etat[0][0]);
        Controleur.vue = Controleur.bld.creerVue("Menu");
        for (int i=0; i<vue.getButton().length;i++) {
            vue.getButton()[i].setOnAction(new ActionReset(vue.getButton()[i]));
        }

        //Controleur.tab_Etat = concepteur.lectureFichier("sokoban01.xsb");
        Controleur.gridPane = vue.getGridPane();
        vue.dessine();
    }



    private void Jouer(KeyCode c){
        Controleur.commande.move(c);//opère une modification sur le tableau
        Controleur.vue.dessine();
    }

    public void play(String s){
        Controleur.tab_Etat = concepteur.lectureFichier(s);
        Controleur.vue = Controleur.bld.creerVue("Jeu");
        Controleur.gridPane = vue.getGridPane();
        Controleur.gridPane.setOnKeyPressed(new EventHandler<KeyEvent>() {


            public void handle(KeyEvent event) {
                KeyCode input = event.getCode();
                Jouer(input);
                if(Controleur.commande.aGagner()){
                    System.out.println("Gagné !");
                    Controleur.gridPane.setOnKeyPressed(null);
                }
            }
        });

        Controleur.gridPane.requestFocus();


    }

    class ActionReset implements EventHandler<ActionEvent> {
        Button b;
        public ActionReset(Button b){
            this.b = b;
        }
        public void handle(ActionEvent event) {
            Controleur.choose(this.b);
        }

    }

    private static void choose(Button b) {
        Controleur.play(b.getName());
    }


    /*création de vueMenu, affichage*/

    public void Menu(){
        Controleur.vue = Controleur.bld.creerVue("Menu");
    }

    public GridPane getGridPane(){
        return vue.getGridPane();
    }

    public char[][] getEtat(){
        return Controleur.tab_Etat;
    }

    public void setEtat(char[][] tab){
        Controleur.tab_Etat = tab;
    }

    public ArrayList<Pair> getEnsInput(){
        return Controleur.ensInput;
    }

    public void setEnsInput(ArrayList<Pair> a){
        Controleur.ensInput = a;
    }

    public int getNbUndo(){
        return Controleur.nbUndo;
    }

    public void setNbUndo(int a){
        Controleur.nbUndo = a;
    }

    public ArrayList<String> getNiveaux(){
        return Controleur.niveaux;
    }


}