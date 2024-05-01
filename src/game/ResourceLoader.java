package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {

    public static final
    private BufferedImage[] curtainAni;

    public ResourceLoader(){
        loadAnimations();
    }
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

    public static void loadAnimations(){

    }
    public static int[][]GetLevelData(){

    }

    public BufferedImage[] getCurtainAni() {
        return curtainAni;
    }
}
