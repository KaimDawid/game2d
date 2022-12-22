package com.mygdx.game.Frontend.Eq;

import Logic.FightLogic.Fight;
import Logic.FightLogic.FightLogic;
import Logic.Inventory;
import Objects.Items.Item;
import Objects.Items.Usables.HealthPotion;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.GameApp;

import java.util.Timer;
import java.util.TimerTask;

import static Objects.Items.Item.edible;
import static Objects.Items.Item.edibleslot2;
import static com.mygdx.game.Assets.usBagSPR;
import static com.mygdx.game.GameApp.*;

public class Equipment {

    public static Texture usableBagTXT;
    public static Sprite usableBagSPR;
    public static String usableDescription;
    public static BitmapFont usableDescriptionBMP;

    public static String itemDescription;


   public  static BitmapFont itemDescriptionBMP;

   public static float descriptionX = 0;
   public static float descriptionY = 0;

   public static float ix;
   public static float iy;

    public static int clickCount;

    public static float X = GameApp.playerSprite.getX() - 900;
    public static  float Y = GameApp.playerSprite.getY() + 300;
public static int eqSlot = 0;
    public static Item currentWeapon;


    public static void displayUsables(){
    batch.begin();
    usBagSPR.setPosition(playerSprite.getX() - 945, playerSprite.getY() - 220);
    usableList.get(0).setPosition(usBagSPR.getX()+ 30, usBagSPR.getY() - 30);
    
}
public static void displayEQ() throws IndexOutOfBoundsException, NullPointerException {

usableBagSPR.setSize(360,600);
usableBagSPR.setPosition(inventorySP.getX()-300, inventorySP.getY());
    GameApp.inventorySP.setPosition(GameApp.playerSprite.getX() - 465, GameApp.playerSprite.getY() - 220);
    GameApp.inventorySP.setSize(700,600);
    GameApp.inventorySP.draw(GameApp.batch);
    usableBagSPR.draw(batch);

    for (int i = 0; i < usableList.size(); i++) {
        if (i <4){
            usableList.get(i).setPosition((X - 335) + (i*82), Y + 16);
        }
        else if (i >=4 && i < 8){
            usableList.get(i).setPosition((X - 335) + ((i - 4)*82), Y - 60);
        }
        else if (i >= 8 && i < 12){
            usableList.get(i).setPosition((X - 335) + ((i - 8)*82), Y - 130);
        }
        else if (i >= 12 && i < 16){
            usableList.get(i).setPosition((X - 335) + ((i - 12)*82), Y - 203);
        }
        else if (i >= 16 && i < 20){
            usableList.get(i).setPosition((X - 335) + ((i - 16)*82), Y - 275);
        }
        else if (i >= 20 && i < 24){
            usableList.get(i).setPosition((X - 335) + ((i - 20)*82), Y - 346);
        }
        usableList.get(i).setSize(50,50);
        usableList.get(i).draw(batch);



        if (Gdx.input.justTouched()) {
            //unprojects the camera
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            try {
                if (usableList.get(i).getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    clickCount++;

                    Timer timer1 = new Timer();



                    if (clickCount == 1) {
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
                        timer1.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                clickCount = 0;
                            }
                        }, 500);
                        itemDescription = edible.get(i).getName();
                        batch.end();
                        batch.begin();
                        ix = usableList.get(i).getX() + 30;
                        iy = usableList.get(i).getY();
                   /* itemDescriptionBMP.draw(batch, itemDescription, eqList.get(i).getX()+20, eqList.get(i).getY());
                    Assets.invbarSPR.setPosition(eqList.get(i).getX(), eqList.get(i).getY()- 300);
                    Assets.invbarSPR.setSize(350,300);*/
                        itemDescriptionBMP.getData().setScale((float) 1.5);
                        descriptionX = usableList.get(i).getX()+30;
                        descriptionY = usableList.get(i).getY();

                        batch.end();
                        batch.begin();

                    }
                    if (clickCount == 2){
                        Soundtrack.potion.play();
                       Item.edible.get(i).Use(Dawid);
                       if (fightstart == 1){

                               Fight.attackConclude(Dawid, currentTarget);

                       }

                       usableList.remove(i);
                       Item.edible.remove(i);

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

    for (int i = 0; i <= eqSlot - 1; i++) {


try {
    if (i < 10 && Item.gearPiece[i].getIsON() == 0) {
        GameApp.eqList.get(i).setPosition((X + (i * 56)), Y);
    } else if (i < 20 && Item.gearPiece[i].getIsON() == 0){
        GameApp.eqList.get(i).setPosition(X + ((i - 11) * 56), Y);
    }
    else if (i<30 && Item.gearPiece[i].getIsON() == 0){
        GameApp.eqList.get(i).setPosition(X + ((i - 21) * 56), Y);
    }
    else if (Item.gearPiece[i].getIsON() == 1){
        if (Item.gearPiece[i].getIsWeapon() == 1 && Item.gearPiece[i].getWeaponslot() == 1) {
             currentWeapon = Item.gearPiece[i];
            eqList.get(i).setPosition(playerSprite.getX() - 390, playerSprite.getY() - 170);
        }
        else if (Item.gearPiece[i].getIsWeapon() == 1 && Item.gearPiece[i].getWeaponslot() == 2) {

            eqList.get(i).setPosition(playerSprite.getX() - 260, playerSprite.getY() - 170);
        }
        else if (Item.gearPiece[i].getIsHelmet() == 1){
            eqList.get(i).setPosition(playerSprite.getX() - 320, playerSprite.getY());
        }
        else if (Item.gearPiece[i].getIsNeck() == 1){
            eqList.get(i).setPosition(playerSprite.getX() - 260, playerSprite.getY() - 27);
        }
        else if (Item.gearPiece[i].getIsGloves() == 1){
            eqList.get(i).setPosition(playerSprite.getX() - 370, playerSprite.getY() - 50);
        }
        else if (Item.gearPiece[i].getIsChest() == 1){
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



                if (clickCount == 1) {
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
                    timer1.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            clickCount = 0;
                        }
                    }, 500);
                    itemDescription = Item.gearPiece[i].getShortName() + "\n \n HP: " + Item.gearPiece[i].getHP() + "\n \n DMG: " + Item.gearPiece[i].getDMG() +
                            "\n \n Magia: " + Item.gearPiece[i].getMagic() + "\n \n Crit: " + Item.gearPiece[i].getCrit() +"%";
                    batch.end();
                    batch.begin();
                    ix = eqList.get(i).getX() + 30;
                    iy = eqList.get(i).getY();
                   /* itemDescriptionBMP.draw(batch, itemDescription, eqList.get(i).getX()+20, eqList.get(i).getY());
                    Assets.invbarSPR.setPosition(eqList.get(i).getX(), eqList.get(i).getY()- 300);
                    Assets.invbarSPR.setSize(350,300);*/
                    itemDescriptionBMP.getData().setScale((float) 1.5);
                    descriptionX = eqList.get(i).getX()+30;
                    descriptionY = eqList.get(i).getY();

                    batch.end();
                    batch.begin();

                }
                if (clickCount == 2){
                    Soundtrack.equip.play();
                    Inventory.Slot(i, Dawid);
                    if (Item.gearPiece[i].getIsON() == 1) {
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

public static void create(){
    usableBagTXT = new Texture("usablebag.png");
    usableBagSPR = new Sprite(usableBagTXT);
}

}
