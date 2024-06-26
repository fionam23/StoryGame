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

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("holidaly");
        if(e.getButton() == 1){
            System.out.println("clicked");
            game.switchStates(Gamestate.PLAYING);
        }
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
