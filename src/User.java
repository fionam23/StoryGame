public class User {
    private int level;
    private boolean dead;
    public User(){
        level = 0;
        dead = false;
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
