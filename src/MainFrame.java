

import game.DialogueBox;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Runnable{
    private Thread windowThread;
    private DialogueBox dialogueBox;
    public MainFrame(String display) {
        super(display);
        int frameWidth = 500;
        int frameHeight = 500;
        dialogueBox = new DialogueBox("Hi there!");
        this.add(dialogueBox);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(600, 100);
        this.setVisible(true);
        startThread();
    }
    public void startThread(){
        windowThread = new Thread(this);
        windowThread.start();
    }
    public void run() {
        while (true) {
            dialogueBox.repaint();
        }
    }
}
