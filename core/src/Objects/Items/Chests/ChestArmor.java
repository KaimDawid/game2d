package Objects.Items.Chests;

import Mobs.Player;
import Objects.Items.Gear;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ChestArmor extends Gear {

    public static Texture fishScaleTXT;
    public static Sprite fishScaleSPR;

    public static void create(){
        fishScaleTXT = new Texture("fishscalearmor.png");
        fishScaleSPR = new Sprite(fishScaleTXT);

    }



    int isChest = 1;
    public int getHP() {
        return HP;
    }

    public int getIsChest() {
        return isChest;
    }

    public void setIsChest(int isChest) {
        this.isChest = isChest;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDMG() {
        return DMG;
    }

    public void setDMG(int DMG) {
        this.DMG = DMG;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public int getHelmEquip() {
        return helmEquip;
    }

    public void setHelmEquip(int helmEquip) {
        this.helmEquip = helmEquip;
    }

    public int getChestEquip() {
        return chestEquip;
    }

    public void setChestEquip(int chestEquip) {
        this.chestEquip = chestEquip;
    }

    public int getHandsEquip() {
        return handsEquip;
    }

    public void setHandsEquip(int handsEquip) {
        this.handsEquip = handsEquip;
    }

    public int getWeaponEquip() {
        return weaponEquip;
    }

    public void setWeaponEquip(int weaponEquip) {
        this.weaponEquip = weaponEquip;
    }

    public int getNeckEquip() {
        return neckEquip;
    }

    public void setNeckEquip(int neckEquip) {
        this.neckEquip = neckEquip;
    }

    public int getIsON() {
        return isON;
    }

    public void setIsON(int isON) {
        this.isON = isON;
    }

    public int getEqValue() {
        return eqValue;
    }

    public void setEqValue(int eqValue) {
        this.eqValue = eqValue;
    }

    int HP;
    int DMG;
    int crit;
    int magic;

    int stock = 0;
    String shortName;

    String longName = getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)";
    int helmEquip;
    int chestEquip = 1;
    int handsEquip;
    int weaponEquip;
    int neckEquip;
    int isON = 0;
    int eqValue;

    public ChestArmor(String shortName, int HP, int DMG, int crit, int magic, int stock) {
        this.HP = HP;
        this.DMG = DMG;
        this.crit = crit;
        this.magic = magic;
        this.stock = stock;
        this.shortName = shortName;
    }



    @Override
    public void eqON(Player player) {
        if (chestEquip < 2) {
            player.setMaxHP(player.getMaxHP() + HP);
            player.setHP(player.getHP() + HP);
            player.setDMG(player.getDMG() + DMG);
            player.setCritChance(player.getCritChance() + crit);
            player.setMagic(player.getMagic() + magic);
            chestEquip = 2;
            longName();
            System.out.println("Założyłeś: " +getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
            isON = 1;
            eqValue = 1;

        }
        else if (chestEquip > 1){
            player.setMaxHP(player.getMaxHP() - HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - DMG);
            player.setCritChance(player.getCritChance() - crit);
            player.setMagic(player.getMagic() - magic);

            chestEquip = 1;
            System.out.println("Zdjąłeś: "+getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
            longName();
            eqValue = 0;
        }
        else if (eqValue>0){
            System.out.println("Najpierw zdejmij swoją poprzednią zbroję");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (chestEquip > 1) {
            player.setMaxHP(player.getMaxHP() - HP);
            if (player.getHP() - HP < 1){
                player.setHP(1);
            }
            else {
                player.setHP(player.getHP() - HP);
            }
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - DMG);
            player.setCritChance(player.getCritChance() - crit);
            player.setMagic(player.getMagic() - magic);
            chestEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }

    @Override
    public void Use(Player player) {

    }

    @Override
    public boolean isEquip() {
        return false;
    }

    @Override
    public void setEquip(boolean equip) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }


}
