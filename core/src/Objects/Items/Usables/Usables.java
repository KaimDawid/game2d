package Objects.Items.Usables;

import Mobs.Player;
import Objects.Items.Item;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.mygdx.game.Assets;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public abstract class Usables extends Item {

    public static boolean success;
    int stock;
    String name;
    public int maxStock;
    boolean applyPoison = false;
    boolean applyStun = false;
    boolean leaveBattle = false;
    boolean isGear = false;
    boolean isUsable = true;

    public int buyPrice;
    public int sellPrice;
    public int healMana;
    public int healHP;
    public int addMana;
    public int addHP;
    public int addArmor;
    public int addCrit;
    public int dealDMG;
    public Sprite image;
    public Sprite getImage() {
        return image;
    }

    public void setImage(Sprite image) {
        this.image = image;
    }


    public Usables(int stock, String name, boolean applyPoison, boolean applyStun, boolean leaveBattle, boolean isGear, boolean isUsable, int buyPrice, int sellPrice, int healMana, int healHP, int addMana, int addHP, int addArmor, int addCrit, int dealDMG) {
        this.stock = stock;
        this.name = name;
        this.applyPoison = applyPoison;
        this.applyStun = applyStun;
        this.leaveBattle = leaveBattle;
        this.isGear = isGear;
        this.isUsable = isUsable;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.healMana = healMana;
        this.healHP = healHP;
        this.addMana = addMana;
        this.addHP = addHP;
        this.addArmor = addArmor;
        this.addCrit = addCrit;
        this.dealDMG = dealDMG;
    }


    public static boolean isSuccess() {
        return success;
    }

    public static void setSuccess(boolean success) {
        Usables.success = success;
    }

    public static void setAllImages(){
        GameApp.healthPotion.setImage(Assets.healthPotionSPR);
        GameApp.manaPotion.setImage(Assets.manaPotionSPR);
        GameApp.grindingWheel.setImage(Assets.grindingWheelSPR);
        GameApp.bomb.setImage(Assets.bombSPR);
        GameApp.armorPotion.setImage(Assets.armorPotionSPR);

    }
public abstract void Use(Player player);


}
