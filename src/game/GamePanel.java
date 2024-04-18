package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener, KeyListener {
    private DialogueBox currentDialogue;
    private int xMove;
    private Point currentLocation;
    private boolean inventoryOpen;

    public GamePanel(){
        currentDialogue = new DialogueBox("Hi there!");
        addKeyListener(this);
        currentLocation = new Point(100,100);
        add(currentDialogue);

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect((int) currentLocation.getX(), 100, 10, 10);
    }

    //inputs
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
    public void openInventory(){
        inventoryOpen = true;
    }
    public void closeInventory(){
        inventoryOpen = false;
    }

    public void DrawInventory(Graphics g, ){
        int xLocation = 0;
        int yLocation = 0;
        for(int r = 0; r<inventory.length; r++){
            for(int c = 0; c< inventory[r].length; c++){
                xLocation+=40;
                g.fillRect(xLocation, yLocation, 30, 30);
            }
            yLocation+=40;
        }
    }

}
