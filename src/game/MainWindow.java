package game;

import game.DialogueBox;
import game.GamePanel;

import javax.swing.*;

public class MainWindow extends JFrame implements Runnable{
    private Thread windowThread;
    private GamePanel gamePanel;
    public MainWindow(String display, GamePanel panel) {
        super(display);
        int frameWidth = 500;
        int frameHeight = 500;
        gamePanel = panel;
        add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(600, 100);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        startThread();
    }
    public void startThread(){
        windowThread = new Thread(this);
        windowThread.start();
    }
    public void run() {
        while (true) {
            gamePanel.repaint();
        }
    }

}
