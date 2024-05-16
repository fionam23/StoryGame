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

    private Game game;
    private JTextArea label;
    private Font font;

    private Point location;
    private Dimension size;
    private String text = "hi";
    private ArrayList<String> queuedText;
    private Rectangle button;
    private boolean playing;
    public DialogueBox(String text, Game game){

        this.game = game;
        button = new Rectangle();

        queuedText = new ArrayList<>();
        queuedText.add(text);
        this.setVisible(true);
        this.setLocation(100,100);
        setBounds(10, 10, 50, 20);
        requestFocus();
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
        playing = false;
    }
    public Thread loadText(String text){
        Thread loadText = new Thread(() -> {
            synchronized (this){
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
                notify();
            }


        }
        );
        loadText.start();
        return loadText;
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

    public void draw(Graphics2D g){
        g.setColor(Color.BLACK);
        size = new Dimension(500, 200);
        location = new Point(((game.getGamePanel().getWidth()-size.width)/2), game.getGamePanel().getHeight()-(size.height+10));
        button.setLocation(location);
        button.setSize(size);
        ;
        g.fillRect(location.x, location.y, size.width, size.height);
        if(text.length()>0){
            AttributedString attributedString = new AttributedString(text);
            attributedString.addAttribute(TextAttribute.FONT, ResourceLoader.loadFont());
            attributedString.addAttribute(TextAttribute.FOREGROUND, Color.WHITE);
            AttributedCharacterIterator paragraph = attributedString.getIterator();
            int paragraphStart = paragraph.getBeginIndex();
            int paragraphEnd = paragraph.getEndIndex();
            FontRenderContext frc = g.getFontMetrics().getFontRenderContext();
            LineBreakMeasurer lineMeasurer = new LineBreakMeasurer(paragraph, frc);

            float breakWidth = (float) size.width;
            float drawPosY = location.y+10;
            lineMeasurer.setPosition(paragraphStart);
            while (lineMeasurer.getPosition() < paragraphEnd) {
                TextLayout layout = lineMeasurer.nextLayout(breakWidth);
                float drawPosX = (layout.isLeftToRight() ? 0 : breakWidth - layout.getAdvance())+location.x;
                drawPosY += layout.getAscent();
                layout.draw(g, drawPosX, drawPosY);
                drawPosY += layout.getDescent() + layout.getLeading();

            }
            repaint();

        }
        }

        public void waitForDialogueEnd(){
            while(queuedText.size()>1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}
