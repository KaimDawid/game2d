package Objects.Items.Usables;
import Mobs.Monster;
import Mobs.Player;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

import static com.mygdx.game.Frontend.Fonts.topText;
import static com.mygdx.game.GameApp.currentTarget;

@Getter @Setter
public class Bomb extends Usables {

public static int buyPrice = 80;
public static int sellPrice = 40;
public int maxStock = 30;
    public static boolean useSuccessful;
    static int dealDMG = 150;
int stock;

public static boolean success;

    public Bomb(int stock, String name, boolean applyPoison, boolean applyStun, boolean leaveBattle, boolean isGear, boolean isUsable, int buyPrice, int sellPrice, int healMana, int healHP, int addMana, int addHP, int addArmor, int addCrit, int dealDMG) {
        super(stock, name, applyPoison, applyStun, leaveBattle, isGear, isUsable, buyPrice, sellPrice, healMana, healHP, addMana, addHP, addArmor, addCrit, dealDMG);
    }

/*
    public void Use(Player player, Monster monster){
       monster.setHp(monster.getHp() - dealDMG);
       Fonts.topText = "Zadales " + dealDMG + " obrazen";
       stock--;
   }
*/

public void Use(Player player){
currentTarget.setHp(currentTarget.getHp() - dealDMG);
topText = "You've dealt " + dealDMG + " points of damage to your target";
success = true;
}










    public Sprite image = Assets.bombSPR;

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
