import game.GamePanel;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class GameRunner implements Runnable{
    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        MainWindow window = new MainWindow("Escape or Die", gamePanel);
        gamePanel.requestFocus();
        }
    public void startGame(){
            Thread gameThread = new Thread(this::run);
            gameThread.start();
    }

    @Override
    public void run() {
        User profile = new User()
    }
}