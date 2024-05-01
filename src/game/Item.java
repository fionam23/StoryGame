package game;

import java.awt.image.BufferedImage;

public class Item {
    private String Description;
    private String name;
    private BufferedImage icon;
    public Item(String name, String Description, BufferedImage icon){
        this.name = name;
        this.Description = Description;
        this.icon = icon;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getIcon() {
        return icon;
    }
}
