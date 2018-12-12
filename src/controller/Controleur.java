package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.CommandeConcret;
import model.Concepteur;
import vue.BuilderVue;
import vue.Vue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


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

    private static Stage primaryStage;

    private static ArrayList<String> niveaux;


    /*Constructeur privé*/
    private Controleur(){
        Controleur.concepteur = new Concepteur();
        Controleur.commande = new CommandeConcret();
        Controleur.ensInput = new ArrayList<>();
        Controleur.bld = new BuilderVue();
    }


    /*getInstance du singleton */

    public static Controleur getInstance() {
        if(Controleur.instance == null){
            Controleur.instance = new Controleur();
        }
        return Controleur.instance;
    }

    public static void setPrimary(Stage primaryStage) {
        Controleur.primaryStage = primaryStage;
    }


    /*récuperation du tableau, création de vueJeu, utilisation de la méthode afficher de vueJeu
     * et attente d'une action pour actualiser la vue*/


    public void Init() throws FileNotFoundException {
        Controleur.niveaux = concepteur.lectureNiveaux();
        // Controleur.tab_Etat = concepteur.lectureFichier("Niveaux/sokoban01.xsb");
        // System.out.println(tab_Etat[0][0]);
        Controleur.vue = Controleur.bld.creerVue("Menu");
        for (Map.Entry<Button, String> entry : Controleur.vue.getButtonMap().entrySet()) {
            entry.getKey().setOnAction(new MyAction(entry.getValue()));
        }
        Controleur.gridPane = vue.getGridPane();
    }



    public void Jouer(KeyCode c){
        Controleur.commande.move(c, false);//opère une modification sur le tableau
        Controleur.vue.dessine();
    }

    public void play(String indice){
        Controleur.tab_Etat = concepteur.lectureFichier("src/Niveaux/"+indice);
        System.out.println(indice);
        Controleur.vue = Controleur.bld.creerVue("Jeu");
        Controleur.gridPane = vue.getGridPane();
        Controleur.primaryStage.setScene(new Scene(Controleur.gridPane, 800, 400));
        primaryStage.show();
        Controleur.vue.dessine();
        Controleur.gridPane.setOnKeyPressed(new EventHandler<KeyEvent>() {


            public void handle(KeyEvent event) {
                KeyCode input = event.getCode();
                Jouer(input);
                if (Controleur.commande.aGagner()){
                    Controleur.gridPane.setOnKeyPressed(null);
                    Controleur.vue = Controleur.bld.creerVue("Fin");
                    Controleur.gridPane = vue.getGridPane();
                    Controleur.primaryStage.setScene(new Scene(Controleur.gridPane, 800, 400));
                    primaryStage.show();

                }
            }
        });
        Controleur.gridPane.requestFocus();

    }


    class MyAction implements EventHandler<ActionEvent> {
        String indice;

        MyAction(String indice) {
            this.indice = indice;
        }

        @Override
        public void handle(ActionEvent event) {
            Controleur.getInstance().play(indice);
        }
    }


    /*création de vueMenu, affichage*/

    public void Menu(){
        Controleur.vue = bld.creerVue("Menu");
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