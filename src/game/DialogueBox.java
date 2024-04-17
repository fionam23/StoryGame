package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class DialogueBox extends JPanel implements MouseListener {
    JLabel label;
    Font font;
    public DialogueBox(String text){
        label = new JLabel();
        label.setFont(ResourceLoader.loadFont());
        label.setText(text);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.white);
        this.add(label);
        this.setVisible(true);
        this.setLocation(100,100);
        setBounds(10, 10, 50, 20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(label.getX(), label.getY(), label.getWidth(), label.getHeight());

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point clicked = e.getPoint();
        if(e.getButton() == 1){

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
}
