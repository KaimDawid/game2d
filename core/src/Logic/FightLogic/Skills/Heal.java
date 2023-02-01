package Logic.FightLogic.Skills;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import static com.badlogic.gdx.graphics.Color.*;
import static com.mygdx.game.Frontend.Fonts.impactFont;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.batch;

@Getter@Setter
public class Heal  extends Spells {
    public static Texture texture;
    public static Sprite sprite;
    public static int cooldown;
    public static boolean learned = false;
public static BitmapFont cooldownBMP;

    public static void create(){

        texture = new Texture("healbutton.png");
        sprite = new Sprite(texture);
        sprite.setSize(200,60);
        cooldownBMP = Fonts.Impact.generateFont(impactFont);
        cooldownBMP.setColor(ORANGE);
        cooldownBMP.getData().setScale(0.8F);
    }

    public static void render(){

        sprite.setPosition(playerSprite.getX()+300, playerSprite.getY()-250);
        if (fightstart == 1 && learned && fightscreenSP.getHeight()>800){

            sprite.draw(batch);
            if (cooldown > 0) {
                cooldownBMP.draw(batch, cooldown + "", sprite.getX(), sprite.getY());
            }

        }

    }
}
