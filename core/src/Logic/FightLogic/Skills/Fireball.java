package Logic.FightLogic.Skills;

import Logic.FightLogic.Fight;
import Logic.Movement;
import Objects.ObjectCreator;
import Objects.Shop.Shop;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Backend.Backend;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;
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
    public static boolean animFire = false, animMobFire = false;
    public static boolean learned = false;

    // A variable for tracking elapsed time for the animation
    float stateTime;
    public static Texture fireBallTXT, fireball2TXT;
    public static Sprite fireballSPR, fireball2SPR;
    public static int movedFrames, movedFrames2;
    public static int cooldown;
    public static int fireValue, fireValue2;
    public static int finalframes = 40;
    public static Stage stage;
    public static Actor fireActor;
    public static int finalframes2 = 40;

    public void createFire(){
fireball2TXT = new Texture("fireballanim2.png");
fireball2SPR = new Sprite(fireball2TXT);
fireball2SPR.setSize(600,600);
        fireBallTXT = new Texture("fireballanim.png");
        fireballSPR = new Sprite(fireBallTXT);
        fireballSPR.setSize(600,600);
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

                        if (movedFrames < finalframes) {

                            camera.update();
                            fireballSPR.setX(fireballSPR.getX() + 17);
                            movedFrames++;
                        }  else if (movedFrames == finalframes) {
                            camera.update();
                 Fight.inputBlocked = false;
                            animFire = false;
                            movedFrames = 0;
                            fireballSPR.setPosition(battleStance.getX()+300, battleStance.getY()-100);


                        }
                        if (movedFrames < 2){
                            fireballSPR.setPosition(battleStance.getX()+300, battleStance.getY()-100);
                        }
                        if (movedFrames < finalframes * 0.1){
                            fireballSPR.setRegion(0,50,300,150);
                        }
                        if (movedFrames > finalframes * 0.1 && movedFrames < finalframes *0.2){
                            fireballSPR.setRegion(300,50,300,150);
                        }
                        if (movedFrames > finalframes * 0.2 && movedFrames < finalframes *0.3){
                            fireballSPR.setRegion(0,210,300,160);
                        }
                        if (movedFrames > finalframes * 0.3 && movedFrames < finalframes *0.4){
                            fireballSPR.setRegion(300,210,300,160);
                        }
                        if (movedFrames > finalframes * 0.4 && movedFrames < finalframes *0.5){
                            fireballSPR.setRegion(0,370,300,160);
                        }
                        if (movedFrames > finalframes * 0.5 && movedFrames < finalframes *0.6){
                            fireballSPR.setRegion(300,370,300,160);
                        }
                        if (movedFrames > finalframes * 0.6 && movedFrames < finalframes *0.7){
                            fireballSPR.setRegion(0,540,300,160);
                        }
                        if (movedFrames > finalframes * 0.7 && movedFrames < finalframes *0.8){
                            fireballSPR.setRegion(300,540,300,160);
                        }
                        if (movedFrames > finalframes * 0.8 && movedFrames < finalframes *0.9){
                            fireballSPR.setRegion(0,710,300,160);
                        }
                        if (movedFrames > finalframes * 0.9 && movedFrames < finalframes){
                            fireballSPR.setRegion(300,710,300,160);
                        }

                        fireValue = 1;


                    }
                },  (long) 0.000001f);
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
        if (fightstart == 1 && learned && fightscreenSP.getHeight()>800){

            sprite.draw(batch);
            if (cooldown > 0) {
                cooldownBMP.draw(batch, cooldown + "", sprite.getX(), sprite.getY());
            }

        }

    }


    public void dispose() { // SpriteBatches and Textures must always be disposed
        spriteBatch.dispose();
        fireSpellTexture.dispose();
    }
    
    
    public static void animMobFire(){
        if (animMobFire) {

fireball2SPR.draw(batch);




            do {
                fireValue2 = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        GameApp.moveValue = GameApp.moveValue + 1;
                        if (movedFrames2 < finalframes2) {

                            camera.update();
                                  fireball2SPR.setX(fireball2SPR.getX() - 17);
                            movedFrames2++;
                        }  else if (movedFrames2 == finalframes2) {
                            camera.update();

                            animMobFire = false;
                            movedFrames2 = 0;
                            fireball2SPR.setPosition(battleStance.getX()+900, battleStance.getY()-100);


                        }
                        if (movedFrames2 < 2){
                            fireball2SPR.setPosition(battleStance.getX()+900, battleStance.getY()-100);
                        }
                        if (movedFrames2 < finalframes2 * 0.1){
                           fireball2SPR.setRegion(0,50,300,150);
                        }
                        if (movedFrames2 > finalframes2 * 0.1 && movedFrames2 < finalframes2 *0.2){
                          fireball2SPR.setRegion(300,50,300,150);
                        }
                        if (movedFrames2 > finalframes2 * 0.2 && movedFrames2 < finalframes2 *0.3){
                            fireball2SPR.setRegion(0,210,300,160);
                        }
                        if (movedFrames2 > finalframes2 * 0.3 && movedFrames2 < finalframes2 *0.4){
                            fireball2SPR.setRegion(300,210,300,160);
                        }
                        if (movedFrames2 > finalframes2 * 0.4 && movedFrames2 < finalframes2 *0.5){
                            fireball2SPR.setRegion(0,370,300,160);
                        }
                        if (movedFrames2 > finalframes2 * 0.5 && movedFrames2 < finalframes2 *0.6){
                            fireball2SPR.setRegion(300,370,300,160);
                        }
                        if (movedFrames2 > finalframes2 * 0.6 && movedFrames2 < finalframes2 *0.7){
                            fireball2SPR.setRegion(0,540,300,160);
                        }
                        if (movedFrames2 > finalframes2 * 0.7 && movedFrames2 < finalframes2 *0.8){
                            fireball2SPR.setRegion(300,540,300,160);
                        }
                        if (movedFrames2 > finalframes2 * 0.8 && movedFrames2 < finalframes2 *0.9){
                            fireball2SPR.setRegion(0,710,300,160);
                        }
                        if (movedFrames2 > finalframes2 * 0.9 && movedFrames2 < finalframes2){
                            fireball2SPR.setRegion(300,710,300,160);
                        }
                        camera.update();
                       fireValue2 = 1;
                        camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);

                    }
                },  (long) 0.000001f);
            }
            while (animMobFire && fireValue2 == 1);
        }
    }
    
}
