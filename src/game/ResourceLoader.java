package game;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ResourceLoader {
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
}
