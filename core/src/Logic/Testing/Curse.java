package Logic.Testing;

import Mobs.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Frontend.Fonts;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.mygdx.game.Assets.csBMP;
import static com.mygdx.game.GameApp.*;

public class Curse {

    public static void Rogue(Player player){
        player.setRogue(1);
        player.setMagic(-500);
        Fonts.curseTEXT = "You have obtained the Rogue curse, \n you attack twice, \n" +
                "but your spells heal your enemy!";
        player.setDMG(player.getDMG()-30);
        player.setCritChance(player.getCritChance() + 10);
        setCurseBMP();
        CurseTextDisappear();
    }

    public static void GlassCannon(Player player){


        Fonts.curseTEXT = "You have obtained the Fragile curse, \n your physical damage is increased greatly, \n" +
                "but you have significantly lower health and armor!";
        player.setDMG((int) (player.getDMG()*1.8));
        if (player.getMaxHP() < 500) {
            player.setMaxHP(250);
            player.setHP(250);
        }
        else {
            player.setMaxHP(player.getMaxHP() - 250);
            player.setHP(player.getMaxHP());
        }
        player.setArmor(player.getArmor()-20);
        player.setGC(1);
        setCurseBMP();
        CurseTextDisappear();

    }

    public static void Decay(Player player){
        player.setDecay(1);
        Fonts.curseTEXT = "You have obtained the Decay curse, \n you heal for more, \n" +
                "but you receive poison damage each turn!";
     setCurseBMP();
CurseTextDisappear();

    }

public static void CurseTextDisappear(){
    if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                Fonts.curseTEXT = " ";
                csBMP.setSize(0,0);
            }




    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            Fonts.curseTEXT = " ";
            csBMP.setSize(0,0);
        }
    }, 4000);
}
public static void setCurseBMP(){
    csBMP.setSize(1600,600);
    csBMP.setPosition(playerSprite.getX()- 750, playerSprite.getY()-250);
}

    public static void drawCurse(Player player){
        Random random = new Random();
        int curse = random.nextInt(100);
        if (curse < 34 && player.getGC() == 0){
            GlassCannon(player);
        }
        else if (curse > 33 && curse < 67 && player.getDecay() == 0){
            Decay(player);
        }
        else if (curse > 66 && player.getRogue() == 0) {
            Rogue(player);
        }
    }


}
