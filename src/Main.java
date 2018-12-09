import javafx.scene.input.KeyCode;
import java.util.LinkedList;

public class Main{


    public static void main(String[] args) {

        LinkedList<KeyCode> ensInput = new LinkedList<>();
        int nbUndo = 0;

        ensInput.add(KeyCode.valueOf("A"));
        ensInput.add(KeyCode.valueOf("B"));
        ensInput.add(KeyCode.valueOf("C"));
        ensInput.add(KeyCode.valueOf("D"));
        ensInput.add(KeyCode.valueOf("E"));

        for(int i = 0; i < ensInput.size(); i++)
            System.out.println(ensInput.get(ensInput.size()-1-i));
        System.out.println();


        nbUndo = 20;
        for(int i = nbUndo; i > 0; i--) {
            if(!ensInput.isEmpty())
                ensInput.removeLast();
            nbUndo--;
        }

        System.out.println(nbUndo);

        ensInput.add(KeyCode.valueOf("Y"));

        for(int i = 0; i < ensInput.size(); i++)
            System.out.println(ensInput.get(ensInput.size()-1-i));


        /*
        Concepteur c = new Concepteur();

        char[][] tab = c.lectureFichier("Level1.xsb");
        Stack<KeyCode> stack = new Stack<KeyCode>();

        stack.push(KeyCode.valueOf("UP"));

        CommandeConcret cc = new CommandeConcret();
        char[][] res = cc.undo(stack, tab);

        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab[0].length; j++)
                System.out.print(res[i][j]);
            System.out.println("");
        }
        */
    }
}
