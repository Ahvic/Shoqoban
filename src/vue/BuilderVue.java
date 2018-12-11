package vue;


import controller.Controleur;

public class BuilderVue {

    protected Vue vue;



    public Vue creerVue(String nomVue){
        Vue vue = null;

        if (nomVue.equals("Menu")){
            vue = new VueMenu();
        }
        else if(nomVue.equals("Jeu")){
            char[][] tabEtat = Controleur.getInstance().getEtat();
            vue = new VueJeu(tabEtat);
        }
        else if(nomVue.equals("Fin")){
            vue = new VueFin();
        }

        return vue;
    }




}
