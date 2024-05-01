package game;

import javax.swing.*;
import java.awt.*;

public class ChoiceGui extends JPanel {
    private Button choice1;
    private Button choice2;
    public ChoiceGui(String choice1Text, String choice2Text){
        choice1 = new Button(choice1Text);
        choice2 = new Button(choice2Text);
        choice1.setFont(ResourceLoader.loadFont());
        choice2.setFont(ResourceLoader.loadFont());
    }
}
