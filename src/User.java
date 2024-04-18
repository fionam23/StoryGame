import game.Inventory;

public class User {
    private int level;
    private boolean dead;
    private Inventory inventory;
    public User(){
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
}
