package game;

import player.Player;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game implements Runnable{
    private GamePanel gamePanel;
    private MainWindow window;
    private Player player;

    private Gamestate gamestate;

    private Intro intro;
    private Playing playing;

    private Menu menu;


    private final int FPS_SET = 120;

    public final static int DEFAULT_TILE_SIZE = 32;

    public final static float SCALE = 1.0f;
    public final static int TILES_IN_WIDTH = 30;
    public final static int TILES_IN_HEIGHT = 14;

    public Game(){
        player = new Player(this);
        intro = new Intro(this);

        gamePanel = new GamePanel(player, this);
        playing = new Playing(this);
        menu = new Menu(this);
        gamestate = Gamestate.INTRO;
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
        Event1(playing.getDialogueBox(), playing.getChoiceGui());
        System.out.println("hi");
    }

    public Intro getIntro() {
        return intro;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Gamestate getGamestate() {
        return gamestate;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public Menu getMenu() {
        return menu;
    }

    public Player getPlayer() {
        return player;
    }

    private void Event1(DialogueBox dialogueBox, ChoiceGui choiceGui) {
        dialogueBox.queueText("...");
        dialogueBox.queueText("'It's dark...'");
        dialogueBox.queueText("Struggle?");
        dialogueBox.waitForDialogueEnd();
        choiceGui.newChoice("Do it", "Do not");
    }
    public void switchStates(Gamestate state){
        gamestate = state;
    }
}