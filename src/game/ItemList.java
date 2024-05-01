package game;

import game.Item;
import game.ResourceLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ItemList {

    public static Item key = new Item("Key", "A metal key. Might be useful for opening a door.", ResourceLoader.loadImage("Key.png"));

}
