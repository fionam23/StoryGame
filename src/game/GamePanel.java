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



    private Playing playing;
    private Intro intro;
    private Menu menu;
    public GamePanel(Player plr, Game game){
        this.game = game;

        inventoryGUI = new InventoryGUI(plr);
        inventoryGUI.openInventory();
        addKeyListener(this);
        addMouseListener(this);
        setGamePanelSize();

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
        switch (game.getGamestate()){
            case INTRO -> game.getIntro().mousePressed(e);
            case MENU -> game.getMenu().mousePressed(e);
            case PLAYING -> game.getPlaying().mousePressed(e);
        }
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
        switch (game.getGamestate()){
            case MENU -> game.getMenu().keyPressed(e);
            case INTRO -> game.getIntro().keyPressed(e);
            case PLAYING -> game.getPlaying().keyPressed(e);
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(gameState == Gamestate.PLAYING){
                game.switchStates(Gamestate.MENU);
            } else {
                game.switchStates(Gamestate.INTRO);
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


    public void setPanelSize(){

    }

    public void loadAnimations(){

    }

    @Override
    public int getHeight() {
        return this.getBounds().height;
    }
    public int getWidth(){
        return this.getBounds().width;
    }
}
