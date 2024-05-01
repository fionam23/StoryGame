package game;

import javax.swing.*;
import java.awt.*;

public class Intro extends GameEvent {
    private static JLabel title;
    public Intro(int lvl){
        super(lvl);
        title = new JLabel("Escape or die");
        title.setFont(ResourceLoader.loadFont());
    }
    public static void draw(Graphics g){
        g.setFont(ResourceLoader.loadFont());
    }
}
