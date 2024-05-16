package game;

import player.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing implements StateMethods{

    private Game game;

    private Player player;

    private DialogueBox dialogueBox;
    private ChoiceGui choiceGui;

    private int xMove;




    public Playing(Game game){
        this.game = game;
        player = game.getPlayer();
        dialogueBox = new DialogueBox("", game);
        choiceGui = new ChoiceGui();

    }
    @Override
    public void update() {

    }



    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setFont(ResourceLoader.loadFont());
        player.getCurrentMapLevel().drawMap(g);
        dialogueBox.draw(g2);
        choiceGui.draw(g, game.getGamePanel().getBounds());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!dialogueBox.isPlaying()){
            if(dialogueBox.getQueuedText().size()>1){
                dialogueBox.loadText(dialogueBox.getQueuedText().get(1));
            }
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
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_LEFT), (KeyEvent.VK_A) -> {
                System.out.println("Key is left");
                if (player.getCurrentLocation().getX() > 0) {
                    xMove = -1;
                    player.getCurrentLocation().setLocation(player.getCurrentLocation().getX() + xMove,player.getCurrentLocation().getY());
                }
            }
            case (KeyEvent.VK_D),(KeyEvent.VK_RIGHT) ->{
                System.out.println("Key is right");
                xMove = 1;
                player.getCurrentLocation().setLocation(player.getCurrentLocation().getX()+xMove,player.getCurrentLocation().getY());
            }
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

    public ChoiceGui getChoiceGui() {
        return choiceGui;
    }


    public DialogueBox getDialogueBox() {
        return dialogueBox;
    }
    public void start(){
    }
}
