package model;

import javafx.scene.input.KeyCode;

/**
 * Created by hadji on 28/11/18.
 */
public interface Commande {

    void undo();
    void redo();
    boolean aGagner();
    void move(KeyCode c);

}
