package model;

import javafx.scene.input.KeyCode;

/**
 * Created by hadji on 28/11/18.
 */
public interface Commande {

    char[][] move(KeyCode c, char[][] tab);

}
