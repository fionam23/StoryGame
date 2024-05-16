package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

public class ResourceLoader {

    private static BufferedImage[] walkAni;
    private static BufferedImage[] torchAni;
    public static Font loadFont(){
        Font myFont;
        try{
           myFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/Fonts/dogica.ttf"));
           myFont = myFont.deriveFont(10.0F);
           return myFont;
        } catch (IOException | FontFormatException fileNotFound){
            System.out.println("Error loading file");
        }
        System.out.println("Error loading file");
        return null;
    }
    public static BufferedImage loadImage(String imageName){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("resources/Images/"+imageName));
        } catch (IOException e) {
            System.out.println("Image not found in resources.");
        }
        return image;
    }

    public static BufferedImage loadMap(String mapName){
        BufferedImage map = null;
        try {
            map = ImageIO.read(new File("resources/Map/"+mapName));
        } catch (IOException e) {
            System.out.println("Map not found in resources.");
        }
        return map;
    }

    public static void loadAnimations(){
        walkAni = new BufferedImage[4];
        torchAni = new BufferedImage[2];
        BufferedImage SpriteAtlas = null;
        try {
            SpriteAtlas = ImageIO.read(new File("resources/Sprites/charsprite.png"));
            BufferedImage walk1 = SpriteAtlas.getSubimage(0,0, 50, 170);
            BufferedImage walk2 = SpriteAtlas.getSubimage(50, 0, 70, 170);
            BufferedImage walk3 = SpriteAtlas.getSubimage(0, 0, 50, 170);
            BufferedImage walk4 = SpriteAtlas.getSubimage(120, 0, 70, 170);
            walkAni[0] = walk1;
            walkAni[1] = walk2;
            walkAni[2] = walk3;
            walkAni[3] = walk4;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            SpriteAtlas = ImageIO.read(new File("resources/Sprites/torch.png"));
            torchAni[0] = SpriteAtlas.getSubimage(0, 0, 8, 21);
            torchAni[1] = SpriteAtlas.getSubimage(14, 0, 9, 21);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static BufferedImage[] getWalkAni(){
        loadAnimations();
        return walkAni;
    }
    public static BufferedImage[] getTorchAni(){
        loadAnimations();
        return torchAni;
    }
}
