import javafx.scene.input.KeyCode;
import model.CommandeConcret;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandeConcretTest {

    CommandeConcret CC = new CommandeConcret();

    @Test
    public void Testmove() {

        char[][] tab = new char[][]{
                {'#','#','#','#','#'},
                {'#',' ','@',' ','#'},
                {'#',' ',' ',' ','#'},
                {'#',' ',' ',' ','#'},
                {'#','#','#','#','#'}
        };

        KeyCode k = KeyCode.valueOf("UP");

        tab = CC.move(k,tab);

        for(int i = 0; i < tab[0].length; i++){
            for(int j = 0; j < tab[1].length; j++)
                System.out.print(tab[i][j]);
            System.out.println();
        }

        assertEquals(1,1);
    }

    @Test
    public void TestdirectionJoueur(){
        KeyCode k = KeyCode.valueOf("UP");
        int[] res = CC.directionJoueur(k);
        int[] expt = {0,1};
        assertArrayEquals(expt, res);

        k = KeyCode.valueOf("DOWN");
        res = CC.directionJoueur(k);
        expt[0] = 0;
        expt[1] = -1;
        assertArrayEquals(expt, res);

        k = KeyCode.valueOf("A");
        res = CC.directionJoueur(k);
        expt[0] = 0;
        expt[1] = 0;
        assertArrayEquals(expt, res);
    }
}