package Objects.Items.Usables;

import Mobs.Player;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ManaPotion extends Usables {
    public static boolean success;

    public static boolean isSuccess() {
        return success;
    }

    public static void setSuccess(boolean success) {
        ManaPotion.success = success;
    }

    public static int sellPrice = 15;
    public static int buyPrice = 30;
    public int maxStock = 30;
public static String name = "Mana potion + 100 mana";
    public static int healMP = 100;
    public int stock;

    public ManaPotion(int stock, String name, boolean applyPoison, boolean applyStun, boolean leaveBattle, boolean isGear, boolean isUsable, int buyPrice, int sellPrice, int healMana, int healHP, int addMana, int addHP, int addArmor, int addCrit, int dealDMG) {
        super(stock, name, applyPoison, applyStun, leaveBattle, isGear, isUsable, buyPrice, sellPrice, healMana, healHP, addMana, addHP, addArmor, addCrit, dealDMG);
    }


    public void Use(Player player){
        player.setMana(player.getMana()+ healMP);
        double overHeal = (player.getMana() - player.getMaxMana());
        if (overHeal >= 0) {
            player.setMana(player.getMana() - overHeal);
            Fonts.topText = "Zregenerowałeś" + healMP + "pkt. many";
            stock--;
            success = true;
        }
    }
    public Sprite image = Assets.manaPotionSPR;
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
