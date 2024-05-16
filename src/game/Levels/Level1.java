package game.Levels;

import game.Animation;
import game.Game;
import game.ResourceLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Level1 extends Level{
    public BufferedImage background;
    private ArrayList<Animation> animations;

    private int roomOffset;

    public Level1(Game game) {
        super("Level 1", game);
        roomOffset = 183;
        animations = new ArrayList<>();
        animations.add(new Animation(50, roomOffset+50, 50, ResourceLoader.getTorchAni(), 3.5));
        animations.add(new Animation(400, roomOffset+50, 50, ResourceLoader.getTorchAni(), 3.5));
    }

    public void buildLevel(){
        ResourceLoader.getTorchAni();
    }

    public void drawMap(Graphics g){

        g.drawImage(ResourceLoader.loadMap("room1.png"), 0, 0, ResourceLoader.loadMap("room1.png").getWidth()*3,ResourceLoader.loadMap("room1.png").getHeight()*3, null);
        for (Animation single: animations) {
            single.draw(g);
        }
    }

}
