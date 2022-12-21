package Logic.FightLogic.Skills;

import Logic.FightLogic.Fight;
import Logic.FightLogic.FightLogic;
import Mobs.Monster;
import Mobs.Player;
import com.badlogic.gdx.Gdx;

import static com.mygdx.game.GameApp.*;

public abstract class Spells {




    public static void create(){
        Adrenaline.create();
        Autoattack.create();
        Cleave.create();
        DualWield.create();
        Fireball.create();
        Heal.create();
        Icebolt.create();
        Ironskin.create();
    }


    public static void render(){
        Adrenaline.render();
        Autoattack.render();
        Cleave.render();
        DualWield.render();
        Fireball.render();
        Heal.render();
        Icebolt.render();
        Ironskin.render();
    }


public static void runAway(Player player, Monster monster){

    FightLogic.StatusConclude(player, monster);
    System.out.println("Udało Ci się uciec, Twoje koordynaty to: X: " + player.getX() + ", Y: " + player.getY());
    Dawid.setX(4);
    Dawid.setY(4);
    playerSprite.setPosition((Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2) + 7130, (Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2) + 3385);
    FightLogic.hideAssets();
    fightstart = 0;
    Fight.escape = 1;
    player.setEscapeInvulnerability(1);
    Fight.doubleStrike = 0;
    if (fightscreenSP.getHeight() > 1070) {
        transitionOut = true;
    }
}


public static void resetCooldown(){
        Fireball.cooldown = 0;
        Ironskin.cooldown = 0;
        Icebolt.cooldown = 0;
        Heal.cooldown = 0;
        Adrenaline.cooldown = 0;
        Cleave.cooldown = 0;


}

public static void lowerCooldown(){

        if (Ironskin.cooldown > 0){
            Ironskin.cooldown--;
        }
    if (Heal.cooldown > 0){
        Heal.cooldown--;
    }
    if (Adrenaline.cooldown > 0){
        Adrenaline.cooldown--;
    }
    if (Icebolt.cooldown > 0){
        Icebolt.cooldown--;
    }
    if (Cleave.cooldown > 0){
        Cleave.cooldown--;
    }
    if (Fireball.cooldown > 0){
        Fireball.cooldown--;
    }

}

}
