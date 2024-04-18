package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class DialogueBox extends JPanel implements MouseListener {
    private JLabel label;
    private Font font;
    private String text;
    private Rectangle button;
    public DialogueBox(String text){
        label = new JLabel();
        label.setFont(ResourceLoader.loadFont());
        this.text = text;
        label.setText(text);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.white);
        this.add(label);
        this.addMouseListener(this);
        button = new Rectangle(100, 100,100, 100);
        this.setVisible(true);
        this.setLocation(100,100);
        setBounds(10, 10, 50, 20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        label.setText(text);
        g.setColor(Color.BLACK);
        g.fillRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point clicked = e.getPoint();
        if(e.getButton() == 1){
            if(button.contains(clicked)){
                System.out.println("hoi");
            }
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
