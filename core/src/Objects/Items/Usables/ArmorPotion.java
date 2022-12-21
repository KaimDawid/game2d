package Objects.Items.Usables;

import Mobs.Player;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArmorPotion extends Usables{

    public static int sellPrice = 400;
    public static int buyPrice =  800;
    public int maxStock = 1;
    public static boolean success;

    public static boolean isSuccess() {
        return success;
    }

    public static void setSuccess(boolean success) {
        ArmorPotion.success = success;
    }

    public static String name = "Armor potion + 20 armor";

    public  int addArmor = 20;
    public  int stock;

    public ArmorPotion(int stock, String name, boolean applyPoison, boolean applyStun, boolean leaveBattle, boolean isGear, boolean isUsable, int buyPrice, int sellPrice, int healMana, int healHP, int addMana, int addHP, int addArmor, int addCrit, int dealDMG) {
        super(stock, name, applyPoison, applyStun, leaveBattle, isGear, isUsable, buyPrice, sellPrice, healMana, healHP, addMana, addHP, addArmor, addCrit, dealDMG);
    }


    public void Use(Player player){
        player.setArmor(player.getArmor()+ addArmor);
        Fonts.topText = "You've gained " + addArmor + "armor";
        stock--;
        success = true;
    }

    public Sprite image;

    public Sprite getImage() {
        return image;
    }

    public void setImage(Sprite image) {
        this.image = image;
    }

















    @Override
    public void eqON(Player player) {

    }

    @Override
    public void eqOFF(Player player) {

    }
}
