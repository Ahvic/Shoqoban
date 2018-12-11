package vue;


import controller.Controleur;

public class BuilderVue {

    protected Vue vue;

    public Vue getVue(){return vue;}

    public Vue creerVue(String nomVue){
        Vue vue = null;

        if (nomVue.equals("Menu")){
            vue = new VueMenu();
        }
        else if(nomVue.equals("Jeu")){
           //char[][] tabEtat = Controleur.getInstance().getEtat();
            vue = new VueJeu();
        }
        else if(nomVue.equals("Defaite")){
            vue = new VueFin(0);
        }
        else if(nomVue.equals("Victoire")){
            vue = new VueFin(1);
        }
        return vue;
    }




}
