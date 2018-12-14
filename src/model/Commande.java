package model;

import javafx.scene.input.KeyCode;

/**
 * Created by hadji on 28/11/18.
 */
public interface Commande {

    /**
     * Va prendre le dernier element de ensInput et va le
     * transformer en mouvement. Prend en compte si une caisse
     * doit etre bougee ou non.
     *
     * Modifie tab, ensInput et nbUndo du controleur grace au
     * singleton.
     */

    void undo();

    /**
     * Re-execute le dernier undo
     *
     * Modifie tab, ensInput et nbUndo du controleur grace au
     * singleton.
     */

    void redo();

    /**
     * Determine si le joueur a gagner sa partie.
     * Se contente de regarde si il reste une caisse
     * qui n'est pas dans un trou.
     *
     * @return boolean gagner ou non
     */

    boolean aGagner();

    /**
     * Va modifier le tableau du controlleur pour
     * faire le mouvement dans la direction donnee en
     * parametre
     *
     * @param c la touche indiquant la direction
     * @param sansSuppEnsInput indique si il faut supprimer les coup precedent
     *        un redo ou non
     */

    void move(KeyCode c, boolean sansSuppEnsInput);
}
