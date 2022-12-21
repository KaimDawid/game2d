package Logic.FightLogic.Skills;

import Logic.FightLogic.Fight;
import Logic.Movement;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.TimerTask;

import static com.badlogic.gdx.graphics.Color.*;
import static com.mygdx.game.Frontend.Fonts.impactFont;
import static com.mygdx.game.GameApp.*;
@Getter@Setter
public class Icebolt  extends Spells {
    public static boolean learned = false;
    private static final int FRAME_COLS = 5, FRAME_ROWS = 1;
    Animation<TextureRegion> fireSpellAnimation; // Must declare frame type (TextureRegion)
    Texture fireSpellTexture;
    SpriteBatch spriteBatch;
    public static boolean animIce = false;

    // A variable for tracking elapsed time for the animation
    float stateTime;
    public static Texture iceBoltTXT;
    public static Sprite iceBoltSPR;
    public static int movedFrames;
    public static int iceValue;
    public static int cooldown;
    public static int finalframes = 60;
    public static Stage stage;
    public static Actor fireActor;
    public static Texture texture;
    public static Sprite sprite;
    public static void createIce(){

        iceBoltTXT = new Texture("iceboltanim.png");
        iceBoltSPR = new Sprite(iceBoltTXT);
        iceBoltSPR.setSize(300,300);
        iceBoltSPR.setPosition(playerSprite.getX(),playerSprite.getY());

    }
    public static void animateIce(){

        if (animIce) {
            Fight.inputBlocked = true;
            iceBoltSPR.draw(batch);





            do {
                iceValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        iceValue = iceValue - 1;
                        if (movedFrames < finalframes) {
                            System.out.println("dodaję wartość");
                            movedFrames++;
                        }  else if (movedFrames ==finalframes) {
                            animIce = false;
                            movedFrames = 0;
                            Fight.inputBlocked = false;
                            System.out.println("koniec animaji");

                        }
                        if (movedFrames < finalframes*0.1){
                            iceBoltSPR.setPosition(playerSprite.getX()-100, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.1 && movedFrames < finalframes*0.2){
                            iceBoltSPR.setRegion(100,0,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX()-50, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.2 && Movement.movedTiles < finalframes*0.3){
                            iceBoltSPR.setRegion(200,0,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX(), playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.3 && Movement.movedTiles < finalframes*0.4){
                            iceBoltSPR.setRegion(300,0,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX()+50, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.4 && movedFrames < finalframes *0.5){
                            iceBoltSPR.setRegion(400,0,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX()+100, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.5 && movedFrames < finalframes*0.6){
                            iceBoltSPR.setRegion(0,65,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX()+150, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.6 && movedFrames < finalframes*0.7){
                            iceBoltSPR.setRegion(100,65,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX()+200, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.7 && Movement.movedTiles < finalframes*0.8){
                            iceBoltSPR.setRegion(200,65,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX()+250, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.8 && Movement.movedTiles < finalframes*0.9){
                            iceBoltSPR.setRegion(300,65,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX()+300, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.9){
                            iceBoltSPR.setRegion(400,65,100,60);
                            iceBoltSPR.setPosition(playerSprite.getX()+300, playerSprite.getY());
                        }
                        camera.update();
                        iceValue = 1;


                    }
                }, (long) 0.000001f);
            }
            while (iceValue == 1 && animIce);
        }
     /*   for (int i = 0, frames = 5; i < frames; i++, x++) {
          if (movedFrames < finalframes* )
        }*/
    }
public static BitmapFont cooldownBMP;
    public static void create(){

        texture = new Texture("iceboltbutton.png");
        sprite = new Sprite(texture);
        sprite.setSize(200,60);
        cooldownBMP = Fonts.Impact.generateFont(impactFont);
        cooldownBMP.setColor(ORANGE);
        cooldownBMP.getData().setScale(0.8F);
    }

    public static void render(){

        sprite.setPosition(playerSprite.getX()+50, playerSprite.getY()-250);
        if (fightstart == 1 && learned && fightscreenSP.getHeight()>1070){
            batch.begin();
            sprite.draw(batch);
            if (cooldown > 0) {
                cooldownBMP.draw(batch, cooldown + "", sprite.getX(), sprite.getY());
            }
            batch.end();
        }

    }



}
