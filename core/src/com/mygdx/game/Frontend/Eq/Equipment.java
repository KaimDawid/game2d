package com.mygdx.game.Frontend.Eq;

import Logic.Inventory;
import Mobs.Monster;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Assets;
import com.mygdx.game.GameApp;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import static com.mygdx.game.GameApp.*;

public class Equipment {

    public static String itemDescription;


   public  static BitmapFont itemDescriptionBMP;

   public static float ix;
   public static float iy;

    public static int clickCount;

    public static float X = GameApp.playerSprite.getX() - 900;
    public static  float Y = GameApp.playerSprite.getY() + 300;
public static int eqSlot = 0;
public static void displayEQ() throws IndexOutOfBoundsException, NullPointerException {



    GameApp.inventorySP.setPosition(GameApp.playerSprite.getX() - 465, GameApp.playerSprite.getY() - 220);
    GameApp.inventorySP.setSize(700,600);
    GameApp.inventorySP.draw(GameApp.batch);
    for (int i = 0; i <= eqSlot - 1; i++) {


try {
    if (i < 10 && Monster.eqNumber[i].getIsON() == 0) {
        GameApp.eqList.get(i).setPosition((X + (i * 56)), Y);
    } else if (i < 20 && Monster.eqNumber[i].getIsON() == 0){
        GameApp.eqList.get(i).setPosition(X + ((i - 11) * 56), Y);
    }
    else if (i<30 && Monster.eqNumber[i].getIsON() == 0){
        GameApp.eqList.get(i).setPosition(X + ((i - 21) * 56), Y);
    }
    else if (Monster.eqNumber[i].getIsON() == 1){
        if (Monster.eqNumber[i].getIsWeapon() == 1 && Monster.eqNumber[i].getWeaponslot() == 1) {

            eqList.get(i).setPosition(playerSprite.getX() - 390, playerSprite.getY() - 170);
        }
        else if (Monster.eqNumber[i].getIsWeapon() == 1 && Monster.eqNumber[i].getWeaponslot() == 2) {

            eqList.get(i).setPosition(playerSprite.getX() - 260, playerSprite.getY() - 170);
        }
        else if (Monster.eqNumber[i].getIsHelmet() == 1){
            eqList.get(i).setPosition(playerSprite.getX() - 320, playerSprite.getY());
        }
        else if (Monster.eqNumber[i].getIsNeck() == 1){
            eqList.get(i).setPosition(playerSprite.getX() - 260, playerSprite.getY() - 27);
        }
        else if (Monster.eqNumber[i].getIsGloves() == 1){
            eqList.get(i).setPosition(playerSprite.getX() - 370, playerSprite.getY() - 50);
        }
        else if (Monster.eqNumber[i].getIsChest() == 1){
            eqList.get(i).setPosition(playerSprite.getX() - 320, playerSprite.getY() - 50);
        }
    }
    GameApp.eqList.get(i).setSize(40, 40);
    GameApp.eqList.get(i).draw(GameApp.batch);

    if (Gdx.input.justTouched()) {
        //unprojects the camera
        camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        try {
            if (eqList.get(i).getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                clickCount++;

              Timer timer1 = new Timer();


              timer1.schedule(new TimerTask() {
                  @Override
                  public void run() {
                      itemDescription = " ";
                  }
              },5000);
              timer1.schedule(new TimerTask() {
                  @Override
                  public void run() {
                      Assets.invbarSPR.setSize(0,0);
                  }
              }, 5000);

                if (clickCount == 1) {
                    timer1.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            clickCount = 0;
                        }
                    }, 500);
                    itemDescription = Monster.eqNumber[i].getShortName() + "\n \n HP: " + Monster.eqNumber[i].getHP() + "\n \n DMG: " + Monster.eqNumber[i].getDMG() +
                            "\n \n Magia: " + Monster.eqNumber[i].getMagic() + "\n \n Crit: " + Monster.eqNumber[i].getCrit() +"%";
                    batch.end();
                    batch.begin();
                    ix = eqList.get(i).getX() + 30;
                    iy = eqList.get(i).getY();
                   /* itemDescriptionBMP.draw(batch, itemDescription, eqList.get(i).getX()+20, eqList.get(i).getY());
                    Assets.invbarSPR.setPosition(eqList.get(i).getX(), eqList.get(i).getY()- 300);
                    Assets.invbarSPR.setSize(350,300);*/
                    itemDescriptionBMP.getData().setScale((float) 1.5);
                    batch.end();
                    batch.begin();

                }
                if (clickCount == 2){
                    Inventory.Slot(i, Dawid);
                    if (Monster.eqNumber[i].getIsON() == 1) {
                        System.out.println(playerSprite.getX());
                        System.out.println(playerSprite.getY());
                    }
                    clickCount = 0;
                    itemDescription = " ";





                  /*  batch1.begin();
                    eqList.get(i).setPosition(playerSprite.getX(), playerSprite.getY());
                    eqList.get(i).draw(batch1);
                    batch1.end();*/


                }
            }
        }
        catch (NullPointerException a){

        }
    }
}
catch (NullPointerException a){

}







        if (i > 9 && Y > GameApp.playerSprite.getY() + 250 || i > 18 && Y > GameApp.playerSprite.getY() + 210){
       Y = Y - 55;
        }

    }



}

public static void equipME()  throws IndexOutOfBoundsException, NullPointerException {

    for (int i = 0; i <= eqSlot - 1; i++) {
        Batch batch1 = new SpriteBatch();


    }
}

}
