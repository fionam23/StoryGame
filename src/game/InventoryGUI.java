package game;

import javax.swing.*;
import java.awt.*;
import player.Player;


public class InventoryGUI extends JPanel {

    private Item[][] inventory;
    private boolean inventoryOpen;
    public InventoryGUI(Player plr){
        inventory = plr.getInventory().getListInventory();
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawInventory(g);
    }

    public void DrawInventory(Graphics g){
        int xLocation = 0;
        int yLocation = 0;
        g.setColor(Color.BLACK);

        for(int r = 0; r<inventory.length; r++){
            for(int c = 0; c< inventory[r].length; c++){
                xLocation+=40;
                g.fillRect(xLocation, yLocation, 30, 30);
            }
            xLocation = 0;
            yLocation+=40;
        }
        g.drawImage(ItemList.key.getIcon(), 10, 10, null);
    }
    public void openInventory(){
        this.setVisible(true);
        inventoryOpen = true;
    }
    public void closeInventory(){
        this.setVisible(false);
        inventoryOpen = false;
    }

    public boolean isOpen() {
        return inventoryOpen;
    }
}
