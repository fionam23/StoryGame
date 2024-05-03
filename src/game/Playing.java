package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing implements StateMethods{

    private Game game;

    private DialogueBox dialogueBox;
    public Playing(Game game){
        this.game = game;
    }
    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

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

    public DialogueBox getDialogueBox() {
        return dialogueBox;
    }
    public void start(){
        dialogueBox= new DialogueBox("");
        game.getGamePanel().add(dialogueBox);
    }
}
