package game.Levels;

import game.Animation;
import game.Game;
import game.ResourceLoader;
import player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Level {

    private String levelNumber;
    private int animationSpeed =10, animationIndex =0, aniTick = 0;


    private Player player;
    public Level(String levelNumber, Game game){

        player = game.getPlayer();
        this.levelNumber = levelNumber;
    }
    public String getLevelNumber(){
        return levelNumber;
    }
    public void buildLevel(){
    }

    public void drawMap(Graphics g){
        g.drawImage(ResourceLoader.getWalkAni()[animationIndex], player.getCurrentLocation().x, player.getCurrentLocation().y, (int) (ResourceLoader.getWalkAni()[animationIndex].getWidth()*1.5), (int) (ResourceLoader.getWalkAni()[animationIndex].getHeight()*1.5), null);
    }
    private void updateAnimationIndex(){
        aniTick++;
        if(aniTick>=animationSpeed){
            aniTick = 0;
            animationIndex++;
            if(animationIndex>= ResourceLoader.getWalkAni().length){
                animationIndex = 0;
            }
        }
    }

    public void drawTorch(Graphics g, int x, int y){

    }
}
