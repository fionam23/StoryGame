package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.TimerTask;
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
        for(int i = 0; i <=text.length();i++){
            System.out.println("bro");
            TimeUnit.MILLISECONDS.sleep(100);
            this.setFont(ResourceLoader.loadFont());

            this.text = text.substring(0, i);
        }
        System.out.println(this.text);
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

    public ArrayList<String> getQueuedText() {
        return queuedText;
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

    public void drawText(Graphics2D g, String text){
        text = "hi";
        AttributedString attributedString = new AttributedString(text);
        attributedString.addAttribute(TextAttribute.FONT, ResourceLoader.loadFont());
        AttributedCharacterIterator paragraph = attributedString.getIterator();
        int paragraphStart = paragraph.getBeginIndex();
        int paragraphEnd = paragraph.getEndIndex();
        FontRenderContext frc = g.getFontMetrics().getFontRenderContext();
        LineBreakMeasurer lineMeasurer = new LineBreakMeasurer(paragraph, frc);

        float breakWidth = (float) 100;
        float drawPosY = 0;
        lineMeasurer.setPosition(paragraphStart);
        while (lineMeasurer.getPosition() < paragraphEnd) {
            TextLayout layout = lineMeasurer.nextLayout(breakWidth);
            float drawPosX = layout.isLeftToRight() ? 0 : breakWidth - layout.getAdvance();
            drawPosY += layout.getAscent();
            layout.draw(g, drawPosX, drawPosY);
            drawPosY += layout.getDescent() + layout.getLeading();

        }
        repaint();

    }
}
