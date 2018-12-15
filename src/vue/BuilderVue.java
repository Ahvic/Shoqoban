package vue;


public class BuilderVue {

    protected Vue vue;



    public Vue creerVue(String nomVue){
        Vue vue = null;

        if (nomVue.equals("Menu")){
            vue = new VueMenu();
        }
        else if(nomVue.equals("Jeu")){
            vue = new VueJeu();
        }
        else if(nomVue.equals("Fin")){
            vue = new VueFin();
        }else if(nomVue.equals("NbCoup")){
            vue = new VueNbCoup();
        }else if(nomVue.equals("UndoRedo")){
            vue = new VueUndoRedo();
        }

        return vue;
    }




}
