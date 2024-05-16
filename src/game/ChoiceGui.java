package game;

import javax.swing.*;
import java.awt.*;

public class ChoiceGui{

    private Point location;
    private Rectangle choice1;
    private Rectangle choice2;
    private int highlightedChoice;
    private boolean visible;
    private String choice1Text;
    private String choice2Text;
    public ChoiceGui(){
        visible = false;
    }

    public void draw(Graphics g, Rectangle bounds){
        if(visible){
            g.setColor(Color.BLACK);
            g.fillRect(bounds.width-100, bounds.height-430, 70, 50);
            g.setColor(Color.WHITE);
            g.drawString(choice1Text, bounds.width- 100, bounds.height-400);
            g.drawString(choice2Text, bounds.width-100,bounds.height-300);
        }
    }
    public void newChoice(String choice1Text, String choice2Text){
        this.choice1Text = choice1Text;
        this.choice2Text = choice2Text;
        visible = true;
    }

}
