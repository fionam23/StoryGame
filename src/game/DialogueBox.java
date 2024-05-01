package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.LineBreakMeasurer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DialogueBox extends JPanel implements MouseListener {
    protected PropertyChangeSupport propertyChangeSupport;
    private JTextArea label;
    private Font font;
    private String text;
    private ArrayList<String> queuedText;
    private Rectangle button;
    private boolean playing;
    public DialogueBox(String text){
        propertyChangeSupport = new PropertyChangeSupport(this);
        label = new JTextArea();
        label.setEditable(false);
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setSize(300,300);
        label.setLocation(100, 12);
        label.setFont(ResourceLoader.loadFont());
        label.setText(text);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.white);
        label.addMouseListener(this);
        queuedText = new ArrayList<>();
        queuedText.add(text);
        playing = false;
        this.add(label);
        button = new Rectangle(label.getX()-20, label.getY(), label.getWidth()+40, label.getHeight());
        this.setVisible(true);
        this.setLocation(100,100);
        setBounds(10, 10, 50, 20);
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        label.setText(text);
        button = new Rectangle(label.getX()-20, label.getY(), label.getWidth()+40, label.getHeight());
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
                System.out.println("Clicked");
                if(queuedText.size()>1){
                    loadText(queuedText.get(1));
                }
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
    public void replaceText(String text) throws InterruptedException {
        String oldText = this.text;

        for(int i = 0; i <=text.length();i++){
            TimeUnit.MILLISECONDS.sleep(100);
            this.setFont(ResourceLoader.loadFont());

            this.text = text.substring(0, i);
        }
        propertyChangeSupport.firePropertyChange("textChange",oldText, text);
    }
    public void loadText(String text){
        Thread loadText = new Thread(() -> {
            if(queuedText.size()>1){
                if (!isPlaying()){
                    playing = true;
                    try {
                        replaceText(text);
                        queuedText.remove(0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    playing = false;
                }
            }
        });
        loadText.start();
    }


    @Override
    public Font getFont() {
        return font;
    }

    public String getText() {
        return text;
    }

    public Rectangle getButton() {
        return button;
    }
    public void queueText(String txt){
        queuedText.add(txt);
    }

    public boolean isPlaying() {
        return playing;
    }
}
