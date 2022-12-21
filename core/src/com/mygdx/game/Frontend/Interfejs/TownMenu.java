package com.mygdx.game.Frontend.Interfejs;

import Data.Quests.FlorekQuest;
import Data.Quests.Quests;
import Data.Quests.RusakovQuest;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Backend.Soundtrack;

import static Logic.Input.RenderInput.shopOpen;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.touchPoint;

public class TownMenu {

    public static Texture townScreen, rysiuButton, florchanButton, medicButton, shopButton, rusakovButton;
    public static Sprite townScreenSPR, rysiuButtonSPR, florchanButtonSPR, medicButtonSPR, rusakovButttonSPR, shopButtonSPR;

    public static boolean townMenuOpen = false;

    public static void create(){

        townScreen = new Texture("townscreen.png");
        rysiuButton = new Texture("codylynxbutton.png");
        florchanButton = new Texture("florchanbutton.png");
        medicButton = new Texture("medicbutton.png");
        shopButton = new Texture("shopbutton.png");
        rusakovButton = new Texture("rusakovbutton.png");

        townScreenSPR = new Sprite(townScreen);
        rysiuButtonSPR = new Sprite(rysiuButton);
        florchanButtonSPR = new Sprite(florchanButton);
        medicButtonSPR = new Sprite(medicButton);
        rusakovButttonSPR = new Sprite(rusakovButton);
        shopButtonSPR = new Sprite(shopButton);

townScreenSPR.setSize(400,600);
rysiuButtonSPR.setSize(360,60);
florchanButtonSPR.setSize(360,60);
medicButtonSPR.setSize(360,60);
rusakovButttonSPR.setSize(360,60);
shopButtonSPR.setSize(360,60);
    }

    public static void render(){


        if (townMenuOpen) {
            townScreenSPR.setPosition(playerSprite.getX()- 200, playerSprite.getY()-300);
            rysiuButtonSPR.setPosition(townScreenSPR.getX()+20, townScreenSPR.getY()+440);
            shopButtonSPR.setPosition(townScreenSPR.getX()+20, townScreenSPR.getY()+375);
            medicButtonSPR.setPosition(townScreenSPR.getX()+20, townScreenSPR.getY()+310);
            rusakovButttonSPR.setPosition(townScreenSPR.getX()+20, townScreenSPR.getY()+245);
            florchanButtonSPR.setPosition(townScreenSPR.getX()+20, townScreenSPR.getY()+180);
            townScreenSPR.draw(batch);
            rysiuButtonSPR.draw(batch);
            shopButtonSPR.draw(batch);
            medicButtonSPR.draw(batch);
            rusakovButttonSPR.draw(batch);
            florchanButtonSPR.draw(batch);
            renderInput();
            if (Dawid.getX() < 3 || Dawid.getX() >5 || Dawid.getY() < 3 || Dawid.getY() > 5){
                townMenuOpen = false;
            }
        }

    }


   public static void renderInput(){
       if (Gdx.input.justTouched()) {
           camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
           if (rysiuButtonSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {

               Quests.window2Open = true;
               townMenuOpen = false;
               Soundtrack.ui.play();

           }
           if (shopButtonSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
               showequip = 1;
               shopOpen = true;
               townMenuOpen = false;
               Soundtrack.ui.play();

           }
           if (medicButtonSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
               windowOpen = true;
               Soundtrack.ui.play();
               townMenuOpen = false;

           }
           if (florchanButtonSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)){
               FlorekQuest.window3Open = true;
               townMenuOpen = false;
               Soundtrack.ui.play();
           }
if (rusakovButttonSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)){
    RusakovQuest.windowOpen = true;
    townMenuOpen = false;
    Soundtrack.ui.play();
}



       }
    }

}
