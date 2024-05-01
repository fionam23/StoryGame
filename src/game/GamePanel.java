package game;

import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements MouseListener, KeyListener {
    private DialogueBox currentDialogue;

    private InventoryGUI inventoryGUI;
    private Gamestate gameState;
    private int xMove;
    private Point currentLocation;

    private LayoutManager layoutManager;

    private BufferedImage[] walkAni;
    public GamePanel(Player plr, Gamestate gamestate){
        gameState = gamestate;
        currentDialogue = new DialogueBox("");
        inventoryGUI = new InventoryGUI(plr);
        inventoryGUI.openInventory();
        addKeyListener(this);
        addMouseListener(this);
        setGamePanelSize();
        currentLocation = new Point(100,100);
        add(inventoryGUI);
        add(currentDialogue);

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
        switch (gameState){
            case INTRO -> {


                try {
                    g.drawImage(ResourceLoader.loadAnimations(),0, 0, null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case PLAYING -> {
                g.fillRect((int) currentLocation.getX(), 100, 10, 10);
            }
        }


    }

    //inputs
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
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
        if(e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("Key is left");
            if(currentLocation.getX()>0){
                xMove = -1;
                currentLocation.setLocation(currentLocation.getX()+xMove,currentLocation.getY());
            }

        }
        if(e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT){
            System.out.println("Key is right");
            xMove = 1;
            currentLocation.setLocation(currentLocation.getX()+xMove,currentLocation.getY());
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
