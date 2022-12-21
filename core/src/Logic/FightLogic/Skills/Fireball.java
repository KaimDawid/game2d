package Logic.FightLogic.Skills;

import Logic.FightLogic.Fight;
import Logic.Movement;
import com.badlogic.gdx.Gdx;
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
public class Fireball extends Spells {
    public static Texture texture;
    public static Sprite sprite;
    private static final int FRAME_COLS = 5, FRAME_ROWS = 1;
    Animation<TextureRegion> fireSpellAnimation; // Must declare frame type (TextureRegion)
    Texture fireSpellTexture;
    SpriteBatch spriteBatch;
    public static boolean animFire = false;
    public static boolean learned = false;

    // A variable for tracking elapsed time for the animation
    float stateTime;
    public static Texture fireBallTXT;
    public static Sprite fireballSPR;
    public static int movedFrames;
    public static int cooldown;
    public static int fireValue;
    public static int finalframes = 30;
    public static Stage stage;
    public static Actor fireActor;

    public void createFire(){

        fireBallTXT = new Texture("fireballanim.png");
        fireballSPR = new Sprite(fireBallTXT);
        fireballSPR.setSize(300,300);
        fireballSPR.setPosition(playerSprite.getX(),playerSprite.getY());
        
    }
    public void animateFire(){
 
        if (animFire) {
            Fight.inputBlocked = true;
            fireballSPR.draw(batch);




            do {
                fireValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        fireValue = fireValue - 1;
                        if (movedFrames < finalframes) {
                            System.out.println("dodaję wartość");
                            movedFrames++;
                        }  else if (movedFrames ==finalframes) {
                            animFire = false;
                            movedFrames = 0;
                           Fight.inputBlocked = false;
                            System.out.println("koniec animaji");
                        
                        }
                        if (movedFrames < finalframes*0.2){
                            fireballSPR.setPosition(playerSprite.getX(), playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.2 && movedFrames < finalframes*0.4){
                            fireballSPR.setRegion(100,0,100,50);
                            fireballSPR.setPosition(playerSprite.getX()+50, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.4 && Movement.movedTiles < finalframes*0.6){
                            fireballSPR.setRegion(200,0,100,50);
                            fireballSPR.setPosition(playerSprite.getX()+100, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.6 && Movement.movedTiles < finalframes*0.8){
                            fireballSPR.setRegion(300,0,100,50);
                            fireballSPR.setPosition(playerSprite.getX()+200, playerSprite.getY());
                        }
                        if (movedFrames > finalframes*0.8){
                            fireballSPR.setRegion(400,0,100,50);
                            fireballSPR.setPosition(playerSprite.getX()+270, playerSprite.getY());
                        }
                        camera.update();
                        fireValue = 1;


                    }
                }, (long) 0.000001f);
            }
            while (fireValue == 1 && animFire);
        }
    
}
public static BitmapFont cooldownBMP;
    public static void create(){

        texture = new Texture("fireballbutt.png");
        sprite = new Sprite(texture);
        sprite.setSize(200,60);
        cooldownBMP = Fonts.Impact.generateFont(impactFont);
        cooldownBMP.setColor(ORANGE);
        cooldownBMP.getData().setScale(0.8F);
    }

    public static void render(){

        sprite.setPosition(playerSprite.getX()-200, playerSprite.getY()-250);
        if (fightstart == 1 && learned && fightscreenSP.getHeight()>1070){
            batch.begin();
            sprite.draw(batch);
            if (cooldown > 0) {
                cooldownBMP.draw(batch, cooldown + "", sprite.getX(), sprite.getY());
            }
            batch.end();
        }

    }


    public void dispose() { // SpriteBatches and Textures must always be disposed
        spriteBatch.dispose();
        fireSpellTexture.dispose();
    }
}
