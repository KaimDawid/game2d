package Objects.Items.Usables;

import Mobs.Monster;
import Mobs.Player;
import Objects.Items.Item;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import static com.mygdx.game.Frontend.Eq.Equipment.eqSlot;
@Getter@Setter
public class GrindingWheel extends Usables {

public static boolean success;

    public static boolean isSuccess() {
        return success;
    }

    public static void setSuccess(boolean success) {
        GrindingWheel.success = success;
    }

    public static int sellPrice = 35;
public static int buyPrice = 70;
public int maxStock = 3;
    public static String name = "Grinding wheel + 50 DMG to weapon";

public int addDmg = 25;
public int stock;

    public GrindingWheel(int stock, String name, boolean applyPoison, boolean applyStun, boolean leaveBattle, boolean isGear, boolean isUsable, int buyPrice, int sellPrice, int healMana, int healHP, int addMana, int addHP, int addArmor, int addCrit, int dealDMG) {
        super(stock, name, applyPoison, applyStun, leaveBattle, isGear, isUsable, buyPrice, sellPrice, healMana, healHP, addMana, addHP, addArmor, addCrit, dealDMG);
    }


    public void Use(Player player){
        success = false;
        if (Monster.weaponEQ > 0) {
            Equipment.currentWeapon.setDMG(Equipment.currentWeapon.getDMG() + addDmg);
            success = true;
            Fonts.topText = "Your weapon has gained" + addDmg + "extra damage";
            stock--;
        }


}
    public Sprite image = Assets.grindingWheelSPR;
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
