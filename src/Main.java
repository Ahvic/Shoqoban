import vue.IHMFX;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                IHMFX i = new IHMFX();
                i.lance();
            }
        };

        thread.start();
    }
}