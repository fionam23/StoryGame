package player;

import game.Game;
import game.Inventory;
import game.Levels.Level;
import game.Levels.Level1;

import java.awt.*;

public class Player {
    private int level;
    private boolean dead;
    private Inventory inventory;
    private Point currentLocation;

    private Level currentMapLevel;
    public Player(Game game){
        level = 0;
        dead = false;
        inventory = new Inventory();
        currentLocation = new Point(100,350);
        currentMapLevel = new Level1(game);
    }

    public boolean isDead() {
        return dead;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public Point getCurrentLocation() {
        return currentLocation;
    }
    public Level getCurrentMapLevel(){
        return currentMapLevel;
    }

    public void setCurrentMapLevel(Level currentMapLevel) {
        this.currentMapLevel = currentMapLevel;
    }
}
