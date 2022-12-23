package Objects.Items;

import Mobs.Player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public abstract class Item {
    public static boolean success;
    public static int twojastara;

    public static Item[] gearPiece = new Item[100];

    public static int currentSlot = 0;
    public static ArrayList<Item> gear = new ArrayList<>();
    public static ArrayList<Item> edible = new ArrayList<>();
    public static int edibleSlot;

    public int maxStock;


    public static Item[] edible2 = new Item[100];
    public static int edibleslot2;
    int sellPrice;
    int buyPrice;

    public Sprite getImage() {
        return image;
    }

    public void setImage(Sprite image) {
        this.image = image;
    }

    public Sprite image;


    int isSharp;
    int isToxic;
    int helmEquip;
    int chestEquip;
    int handsEquip;
    int weaponEquip;
    int neckEquip;
    int isON = 0;
    boolean isGear = false;
    boolean isUsable = false;
    int stock;
    String name;

    int isChest = 0;
    int isWeapon = 0;
    int isGloves = 0;
    int isNeck = 0;
    int isHelmet = 0;

    int weaponslot = 0;


/*public static void NewItem(String shortName, double hp, double DMG, double crit, int mana, int magic, Player player ){
        public static void eqON(Player player) {
            if (chestEquip < 2) {
                player.setMaxHP(player.getMaxHP() + this.HP);
                player.setHP(player.getHP() + this.HP);
                player.setDMG(player.getDMG() + this.DMG);
                player.setCritChance(player.getCritChance() + this.crit);
                player.setMagic(player.getMagic() + this.magic);
                chestEquip = 2;
                System.out.println("Założyłeś " + shortName);
                isON = 1;
                eqValue = 1;

            }
            else if (chestEquip > 1){
                player.setMaxHP(player.getMaxHP() - this.HP);
                if (player.getHP() > player.getMaxHP()){
                    double difference = (player.getHP() - player.getMaxHP());
                    player.setHP(player.getHP() - difference);
                }
                player.setDMG(player.getDMG() - this.DMG);
                player.setCritChance(player.getCritChance() - this.crit);
                player.setMagic(player.getMagic() - this.magic);
                msEquip = false;
                chestEquip = 1;
                System.out.println("Zdjąłeś " + shortName);
                eqValue = 0;
            }
            else if (eqValue>0){
                System.out.println("Najpierw zdejmij swoją poprzednią zbroję");
            }

        }
    }*/



    int HP;
    int DMG;
    int crit;
    int magic;
    String shortName;
    int eqValue;



    public static boolean isSuccess() {
        return success;
    }

    public static void setSuccess(boolean success) {
        Item.success = success;
    }

    public abstract void eqON(Player player);

    public abstract void eqOFF(Player player);

    public String longName(){
        return shortName + " (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)";
        /*System.out.println(shortName + " (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");*/
    }

    public abstract void Use(Player player);

}
