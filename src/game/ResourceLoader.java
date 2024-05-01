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
    public static Font loadFont(){
        Font myFont;
        try{
           myFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/Fonts/dogica.ttf"));
           myFont = myFont.deriveFont(30.0F);
           return myFont;
        } catch (IOException | FontFormatException fileNotFound){
            System.out.println("Error loading file");
        }
        System.out.println("Error loading file");
        return null;
    }
    public static BufferedImage loadImage(String imageName){
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("resources/Images/"+imageName));
        } catch (IOException e) {
            System.out.println("Image not found in resources.");
        }
        return myImage;
    }

    public static void loadAnimations() throws IOException {
        walkAni = new BufferedImage[3];
        BufferedImage SpriteAtlas = ImageIO.read(new File("resources/Sprites/charsprite.png"));

        BufferedImage walk1 = SpriteAtlas.getSubimage(0,0, 50, 170);
        BufferedImage walk2 = SpriteAtlas.getSubimage(50, 0, 70, 170);
        BufferedImage walk3 = SpriteAtlas.getSubimage(120, 0, 70, 170);
        walkAni[0] = walk1;
        walkAni[1] = walk2;
        walkAni[2] = walk3;
        return walk3;
    }

    public static BufferedImage[] getWalkAni() throws IOException {
        loadAnimations();
        return walkAni;
    }
}
