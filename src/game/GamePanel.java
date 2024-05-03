package game;

import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.AttributedString;

public class GamePanel extends JPanel implements MouseListener, KeyListener {
    private DialogueBox currentDialogue;

    private InventoryGUI inventoryGUI;
    private Game game;
    private Gamestate gameState;
    private int xMove;
    private Point currentLocation;

    private Playing playing;
    private Intro intro;
    public GamePanel(Player plr, Game game){
        this.game = game;
        currentDialogue = new DialogueBox("");
        inventoryGUI = new InventoryGUI(plr);
        inventoryGUI.openInventory();
        addKeyListener(this);
        addMouseListener(this);
        setGamePanelSize();
        currentLocation = new Point(100,100);
        add(inventoryGUI);

    }

    private void setGamePanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        setFont(ResourceLoader.loadFont());
        g2.setFont(ResourceLoader.loadFont());
        currentDialogue.drawText(g2, currentDialogue.getText());
        repaint();
        switch (game.getGamestate()){
            case INTRO -> {
                game.getIntro().draw(g);
            }
            case PLAYING -> {
                game.getPlaying().draw(g);
            }
        }


    }

    //inputs
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentDialogue.loadText("Yo mama");
        System.out.println(currentDialogue.getText()+"!");
        if(inventoryGUI.isOpen()){
            inventoryGUI.closeInventory();
        } else {
            inventoryGUI.openInventory();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("works");

        switch (e.getKeyCode()) {
            case (KeyEvent.VK_LEFT), (KeyEvent.VK_A) -> {
                System.out.println("Key is left");
                if (currentLocation.getX() > 0) {
                    xMove = -1;
                    currentLocation.setLocation(currentLocation.getX() + xMove, currentLocation.getY());
                }
            }
            case (KeyEvent.VK_D),(KeyEvent.VK_RIGHT) ->{
                System.out.println("Key is right");
                xMove = 1;
                currentLocation.setLocation(currentLocation.getX()+xMove,currentLocation.getY());
            }
            case(KeyEvent.VK_ESCAPE) ->{
                if(gameState == Gamestate.PLAYING){
                    game.switchStates(Gamestate.MENU);
                } else {
                    game.switchStates(Gamestate.INTRO);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public DialogueBox getCurrentDialogue() {
        return currentDialogue;
    }

    public InventoryGUI getInventoryGUI() {
        return inventoryGUI;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setPanelSize(){

    }

    public void loadAnimations(){

    }
}
