package game;

import player.Player;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game implements Runnable{
    private GamePanel gamePanel;
    private MainWindow window;
    private Player newPlayer;

    private Gamestate gamestate;

    private final int FPS_SET = 120;

    public final static int DEFAULT_TILE_SIZE = 32;

    public final static float SCALE = 1.0f;
    public final static int TILES_IN_WIDTH = 30;
    public final static int TILES_IN_HEIGHT = 14;

    public Game(){
        newPlayer = new Player();
        gamestate = Gamestate.INTRO;
        gamePanel = new GamePanel(newPlayer, gamestate);
        window = new MainWindow("Escape or Die", gamePanel);
        startGame();
        gamePanel.requestFocus();

    }
    public void startGame(){
            Thread gameThread = new Thread(this);
            gameThread.start();
    }

    @Override
    public void run() {
    }

    private void Event1(DialogueBox dialogueBox){
        dialogueBox.queueText("...");
        dialogueBox.queueText("'It's dark...'");
        dialogueBox.queueText("Struggle?");
    }
}