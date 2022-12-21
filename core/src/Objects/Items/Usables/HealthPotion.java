package Objects.Items.Usables;

import Mobs.Player;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HealthPotion extends Usables {
    public static boolean success;

    public static boolean isSuccess() {
        return success;
    }

    public static void setSuccess(boolean success) {
        HealthPotion.success = success;
    }

    public static int sellPrice = 20;
    public static int buyPrice = 50;
    public int maxStock = 30;
    public static String name = "Health potion + 300 HP";
public static int healHP = 300;
public int stock;

    public HealthPotion(int stock, String name, boolean applyPoison, boolean applyStun, boolean leaveBattle, boolean isGear, boolean isUsable, int buyPrice, int sellPrice, int healMana, int healHP, int addMana, int addHP, int addArmor, int addCrit, int dealDMG) {
        super(stock, name, applyPoison, applyStun, leaveBattle, isGear, isUsable, buyPrice, sellPrice, healMana, healHP, addMana, addHP, addArmor, addCrit, dealDMG);
    }


    public void Use(Player player){
        player.setHP(player.getHP() + healHP);
        double overHeal = (player.getHP() - player.getMaxHP());
        if (overHeal >= 0){
            player.setHP(player.getHP() - overHeal);
        }
        success = true;
        stock--;
        Fonts.topText = "Uleczyles sie za " + healHP + " pkt. zycia";


    }
    public Sprite image = Assets.healthPotionSPR;










    @Override
    public void eqON(Player player) {

    }

    @Override
    public void eqOFF(Player player) {

    }
}
