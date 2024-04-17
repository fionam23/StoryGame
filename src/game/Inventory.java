package game;

import java.lang.reflect.Array;

public class Inventory {

    Item[][] inventory = new Item[2][5];
    public Inventory(){

    }

    /**setItem()
     * looks for the index of the first free inventory slot and places Item in Inventory
     * @param item
     * @return true if set was successful, false if not
     */
    public boolean setItem(Item item){
        //
        for(int r = 0; r<inventory.length; r++){
            for(int c = 0; c<inventory[r].length; c++){
                if(inventory[r][c].equals(null)){
                    inventory[r][c] = item;
                    return true;
                }
            }
        }
        return false;
    }
}
