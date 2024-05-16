package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {

    private int animationSpeed,animationIndex, animationTick;

    private Point location;

    private BufferedImage[] frames;
    private double scale;

    public Animation(int x, int y,int animationSpeed, BufferedImage[] frames, double scale){
        this.scale = scale;
        location = new Point(x, y);
        this.animationSpeed = animationSpeed;
        animationIndex = 0;
        animationTick = 0;
        this.frames = frames;
    }
    private void updateAnimationIndex(){
        animationTick++;
        if(animationTick>=animationSpeed){
            animationTick = 0;
            animationIndex++;
            if(animationIndex>= frames.length){
                animationIndex = 0;
            }
        }
    }

    public int getAnimationSpeed() {
        return animationSpeed;
    }

    public int getAnimationIndex() {
        return animationIndex;
    }

    public int getAnimationTick() {
        return animationTick;
    }
    public void draw(Graphics g){
        updateAnimationIndex();
        g.drawImage(frames[animationIndex], location.x, location.y,(int) (frames[animationIndex].getWidth()*scale), (int) (frames[animationIndex].getHeight()*scale), null);
    }
}
