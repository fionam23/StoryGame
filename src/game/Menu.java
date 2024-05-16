package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu implements StateMethods{

    Game game;
    Rectangle resumeButton;


    public Menu(Game game){
        this.game = game;
        resumeButton = new Rectangle(80, 40);
    }

    @Override
    public void update() {

    }

    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(resumeButton.x, resumeButton.y, resumeButton.width, resumeButton.height);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == 1){
            if(resumeButton.contains(e.getPoint())){
                game.switchStates(Gamestate.PLAYING);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            game.switchStates(Gamestate.MENU);
        }
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
