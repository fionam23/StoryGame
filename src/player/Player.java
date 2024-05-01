package player;

import game.Inventory;

public class Player {
    private int level;
    private boolean dead;
    private Inventory inventory;
    public Player(){
        level = 0;
        dead = false;
        inventory = new Inventory();
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
}
