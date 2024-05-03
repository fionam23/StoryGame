package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Intro implements StateMethods{
    private static JLabel title;

    private Game game;
    public Intro(Game game){
        this.game = game;
        title = new JLabel("Escape or die");
        title.setFont(ResourceLoader.loadFont());
    }

    @Override
    public void update() {

    }

    public void draw(Graphics g){
        g.setFont(ResourceLoader.loadFont());
        g.drawString("This is a string", 100, 100);
    }

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
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseMoved() {

    }

    @Override
    public void keyPressed() {

    }
}
