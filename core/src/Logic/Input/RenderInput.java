package Logic.Input;

import Data.Quests.*;
import Logic.Drop.Miscelanous;
import Logic.Experience;
import Logic.Movement;
import Mobs.Player;
import Objects.Items.Item;
import Objects.ObjectCreator;
import Objects.Shop.Shop;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Backend;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.Frontend.Interfejs.TownMenu;

import java.util.TimerTask;

import static Data.Quests.Quests.quest2Stage;
import static Data.Quests.Quests.window2Open;
import static Objects.Shop.Shop.*;
import static com.mygdx.game.Frontend.Interfejs.TownMenu.townMenuOpen;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.Dawid;

public class RenderInput {

    public static int spriteClicked;

    public static boolean shopOpen;
    private static boolean invOpen;
    private static int HPPotionclicked;
    private static int MPPotionclicked;
    private static int grindingWheelclicked;
    private static int armorPotionclicked;
    private static int bombclicked;
    public static boolean rearangeEQ = false;

    public static boolean moveBlocked = false;
    public static boolean enterBlocked = false;
    public static boolean drawDungeon;

    public static void renderInteract(){
        if ((Dawid.getX() > 2 && Dawid.getX() < 6 && Dawid.getY() > 2 && Dawid.getY() < 6 ) || (Dawid.getX()>111 && Dawid.getY() > 123)){
            Assets.interactSPR.setPosition(playerSprite.getX()-50, playerSprite.getY()-200);
            Assets.interactSPR.setSize(200,100);
            Assets.interactSPR.draw(batch);
        }
        if (Dawid.getX() == 8 && Dawid.getY() == 3){
            Assets.interactSPR.setPosition(playerSprite.getX()-50, playerSprite.getY()-200);
            Assets.interactSPR.setSize(200,100);
            Assets.interactSPR.draw(batch);
        }
        if (Dawid.getX() == 15 && Dawid.getY() == 15){
            Assets.interactSPR.setPosition(playerSprite.getX()-50, playerSprite.getY()-200);
            Assets.interactSPR.setSize(200,100);
            Assets.interactSPR.draw(batch);
        }
        if (Dawid.getX() == 200 && Dawid.getY() == 202){
            Assets.interactSPR.setPosition(playerSprite.getX()-50, playerSprite.getY()-200);
            Assets.interactSPR.setSize(200,100);
            Assets.interactSPR.draw(batch);
        }

    }

    public static void LoadInput() throws InterruptedException {



        if (Gdx.input.isKeyPressed(Input.Keys.W) && fightstart == 0 && moveBlocked == false) {

            CheckViablity.Check(Dawid.getX(), Dawid.getY()+1);

            if (CheckViablity.viable) {
                if (Movement.moveUP == false && Movement.moveRIGHT == false && Movement.moveDOWN == false && Movement.moveLEFT == false && fightscreenSP.getHeight() < 10 && !moveBlocked) {
                    ObjectCreator.UpdateShopPosition(Shop.shopList);
                    Movement.moveUP = true;
                    drawSource = true;
                    moveBlocked = true;
                    Soundtrack.steps.play();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            moveBlocked = false;
                        }
                    },1000);
                }
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W) && Dawid.getY() < Backend.borderY && fightstart == 0 && moveBlocked == false) {
            CheckViablity.Check(Dawid.getX(), Dawid.getY()+1);

            if (CheckViablity.viable) {
                Soundtrack.steps.play();
                if (Movement.moveRIGHT == false && Movement.moveLEFT == false && Movement.moveDOWN == false && fightscreenSP.getHeight() < 10) {
                    drawSource = true;


                    Movement.moveUP = true;
                }

                Experience.expCounter(Dawid);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && fightstart == 0 && moveBlocked == false) {

            CheckViablity.Check(Dawid.getX(), Dawid.getY()-1);

            if (CheckViablity.viable) {
                if (Movement.moveUP == false && Movement.moveRIGHT == false && Movement.moveDOWN == false && Movement.moveLEFT == false && fightscreenSP.getHeight() < 10) {
                    ObjectCreator.UpdateShopPosition(Shop.shopList);
                    Movement.moveDOWN = true;
                    Soundtrack.steps.play();
                    drawSource = true;
                    moveBlocked = true;
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            moveBlocked = false;
                        }
                    },1000);
                }
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S) && fightstart == 0 && moveBlocked == false) {
            CheckViablity.Check(Dawid.getX(), Dawid.getY() - 1);

            if (CheckViablity.viable) {
                Soundtrack.steps.play();
                if (Movement.moveUP == false && Movement.moveLEFT == false && Movement.moveRIGHT == false && fightscreenSP.getHeight() < 10) {
                    drawSource = true;
                    Movement.moveDOWN = true;
                }

                Experience.expCounter(Dawid);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && fightstart == 0 && moveBlocked == false) {

            CheckViablity.Check(Dawid.getX() + 1, Dawid.getY());

            if (CheckViablity.viable) {
                if (Movement.moveUP == false && Movement.moveRIGHT == false && Movement.moveDOWN == false && Movement.moveLEFT == false && fightscreenSP.getHeight() < 10) {
                    ObjectCreator.UpdateShopPosition(Shop.shopList);
                    Movement.moveRIGHT = true;
                    Soundtrack.steps.play();
                    drawSource = true;
                    moveBlocked = true;
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            moveBlocked = false;
                        }
                    },900);
                }
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.D) && fightstart == 0 && moveBlocked == false) {

            CheckViablity.Check(Dawid.getX() + 1, Dawid.getY());
            if (CheckViablity.viable == true) {
                Soundtrack.steps.play();
                if (Movement.moveUP == false && Movement.moveLEFT == false && Movement.moveDOWN == false && fightscreenSP.getHeight() < 10) {
                    Movement.moveRIGHT = true;
                    drawSource = true;
                }

                Experience.expCounter(Dawid);

            }
        }


        if (Gdx.input.isKeyPressed(Input.Keys.A)&& fightstart == 0 && moveBlocked == false) {

            CheckViablity.Check(Dawid.getX() - 1, Dawid.getY());
            if (CheckViablity.viable == true) {

                if (Movement.moveUP == false && Movement.moveRIGHT == false && Movement.moveDOWN == false && Movement.moveLEFT == false && fightscreenSP.getHeight() < 10) {
                    ObjectCreator.UpdateShopPosition(Shop.shopList);
                    Movement.moveLEFT = true;
                    drawSource = true;
                    Soundtrack.steps.play();
                    moveBlocked = true;
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            moveBlocked = false;
                        }
                    },900);
                }
            }
        }


        if (Gdx.input.isKeyJustPressed(Input.Keys.A) && fightstart == 0 && moveBlocked == false) {


            CheckViablity.Check(Dawid.getX() - 1, Dawid.getY());

            if (CheckViablity.viable == true) {
                Soundtrack.steps.play();
                if (Movement.moveUP == false && Movement.moveRIGHT == false && Movement.moveDOWN == false && fightscreenSP.getHeight() < 10) {
                    ObjectCreator.UpdateShopPosition(Shop.shopList);
                    Movement.moveLEFT = true;
                    drawSource = true;
                }

                Experience.expCounter(Dawid);
            }

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.G)){



playerSprite.setColor(originalColor);



/*

         timer.schedule(new TimerTask() {
             @Override
             public void run() {
                 playerSprite.setSize(600,600);
             }
         },5000);

            batch.begin();

            mapSprite.setColor(color.b, color.r, color.g ,0.05f);
            fightscreenSP.setColor(originalColor2.b, originalColor2.r, originalColor2.g, 0.05f);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mapSprite.setColor(color.b,color.r,color.g, 5);
                    fightscreenSP.setColor(originalColor2.b, originalColor2.r, originalColor2.g, 5);
                }
            },2000);


            batch.end();
*/





        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
            playerSprite.rotate(1f);

           /* GameApp.batch.begin();
            mapSprite.setColor(originalColor.r, originalColor.g, originalColor.b, 0.05f);
            fightscreenSP.setColor(color2.r, color2.g, color2.b, 0.05f);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mapSprite.setColor(originalColor.r, originalColor.g, originalColor.b, 5);
                    fightscreenSP.setColor(color2.r, color2.g, color2.b, 5);
                }
            },2000);

            batch.end();*/

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

            if (Dawid.getX() == 15 && Dawid.getY() == 15 && !enterBlocked){
               RusakovQuest.enterDungeon();
            }
            if (Dawid.getX() == 201 && Dawid.getY() == 207){
                Miscelanous.magicFlute = true;
            }
            if (Dawid.getX() == 200 && Dawid.getY() == 202 && !enterBlocked){
               RusakovQuest.leaveDungeon();
            }

            if (Dawid.getX() == 8 && Dawid.getY() == 3){
                Soundtrack.door.play();
    CysiuQuest.window4Open = true;


            }


            if (gabbie.getHp() < 10 && Dawid.getY() > 123 && Dawid.getX() > 111) {


                quest2Stage = 6;
                Dawid.setX(4);
                Dawid.setY(4);
                playerSprite.setPosition((Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2) + 7130, (Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2) + 3385);

                camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
                camera.update();
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && fightstart == 0 && (Dawid.getX() >2 && Dawid.getX() < 6) && (Dawid.getY() > 2 && Dawid.getY() < 6) && townMenuOpen == false){
            townMenuOpen = true;
            Soundtrack.door.play();

        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && fightstart == 0 && (Dawid.getX() >2 && Dawid.getX() < 6) && (Dawid.getY() > 2 && Dawid.getY() < 6) && townMenuOpen){
            townMenuOpen = false;
            Soundtrack.door.play();

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.O) && fightstart == 0 && (Dawid.getX() >2 && Dawid.getX() < 6) && (Dawid.getY() > 2 && Dawid.getY() < 6) && window2Open == false){
            window2Open = true;

        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.O) && fightstart == 0 && (Dawid.getX() >2 && Dawid.getX() < 6) && (Dawid.getY() > 2 && Dawid.getY() < 6) && window2Open){
            window2Open = false;

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
            System.out.println("Rzeczy do zrobienia:");
            System.out.println("- 4 nowe questy");
            System.out.println("- Naprawić sklep i ekwipunek");
            System.out.println("- Poprawić transition, spiderSprite się buguje");
            System.out.println("- UI : Menu główne, okno z questami, okno z posiadanymi skillami, INFO");

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.C)){
            if (statsscreen == 0){
                statsscreen = 1;
            }
            else if (statsscreen == 1){
                statsscreen = 0;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.L)){
            if (QuestLog.showLog == false){
                QuestLog.questString = " ";
                QuestLog.showLog = true;
            }
            else if (QuestLog.showLog == true){
                QuestLog.showLog = false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            Fonts.playerInfo = "Punkty zdrowia: " + Dawid.getHP() + "/" + Dawid.getMaxHP() + "         Mana: " +Dawid.getMana() +
                    "\n Doświadczenie: " + Dawid.getXP() + "/" + Experience.levelCap + "         Poziom: " + Dawid.getLevel() +
                    "\n Punkty obrażeń: " + Dawid.getDMG();
            batch.begin();
            Fonts.playerInfoBitMap.draw(batch, Fonts.playerInfo, playerSprite.getX(), playerSprite.getY());
batch.end();

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)){
            Dawid.setDMG(1000);
            Dawid.setGold(5000);
            /*Dawid.setX(4);
            Dawid.setY(4);*/
            Miscelanous.gatheredWood = 30;
            Miscelanous.poisonSacks = 8;
            Miscelanous.crayfishKilled = 10;
            Miscelanous.banditsKilled = 25;
        }
	/*	if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
			Dawid.Attack(monsterBase[1], Dawid);
		}*/
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
           shopOpen = false;
           windowOpen = false;
           window2Open = false;
          townMenuOpen = false;
          FlorekQuest.window3Open = false;
          CysiuQuest.window4Open = false;
          RusakovQuest.windowOpen = false;
          statsscreen = 0;
          showequip = 0;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {

            if (showequip == 0){
                showequip = 1;
                rearangeEQ = true;
            }
            else if (showequip == 1){
                showequip = 0;
                Equipment.itemDescription = " ";
            }


        }
    }

    public static void loadShop(){
        if (shopOpen == true){

            Shop.shopSprite.setPosition(playerSprite.getX() + 360, playerSprite.getY()-300);


            sellHP.setPosition(playerSprite.getX() + 390, playerSprite.getY() + 230);
           sellBOMB.setPosition(playerSprite.getX() + 470, playerSprite.getY() + 230);
           sellMANA.setPosition(playerSprite.getX() + 550, playerSprite.getY() + 230);
            sellGW.setPosition(playerSprite.getX() + 630, playerSprite.getY() + 230);

           sellAP.setPosition(playerSprite.getX() + 390, playerSprite.getY() + 160);

            sellHP.setSize(50,50);
            sellAP.setSize(50,50);
            sellGW.setSize(50,50);
            sellBOMB.setSize(50,50);
            sellMANA.setSize(50,50);


            Shop.shopSprite.draw(batch);
            sellHP.draw(batch);
            sellMANA.draw(batch);
           sellAP.draw(batch);
           sellGW.draw(batch);
           sellBOMB.draw(batch);

            //
            // nie działa :(
            //

            Shop.shopList.add(sellHP);
            Shop.shopList.add(sellBOMB);
            Shop.shopList.add(sellMANA);
            Shop.shopList.add(sellGW);
            Shop.shopList.add(sellAP);

            Shop.shopList.get(0).draw(batch);
            Shop.shopList.get(1).draw(batch);
            Shop.shopList.get(2).draw(batch);
            Shop.shopList.get(3).draw(batch);
            Shop.shopList.get(4).draw(batch);

            Assets.sellBMP.draw(batch,Assets.sellText, playerSprite.getX()+ 520, playerSprite.getY()- 250);
            Assets.sellBMP.getData().setScale(0.9F);
            Assets.buyBMP.draw(batch,Assets.buyText, playerSprite.getX()+500, playerSprite.getY()-120);
            Assets.buyBMP.getData().setScale(0.9F);
            Assets.shopNameBMP.draw(batch,Assets.shopNameText, playerSprite.getX()+410, playerSprite.getY()-60);
            Assets.shopNameBMP.getData().setScale(0.7F);
        }
/*displayItem(Dawid, healthPotion, HPPotionclicked, Assets.healthPotionSPR);*/





        displayItem(Dawid,healthPotion, HPPotionclicked, sellHP);
        displayItem(Dawid, manaPotion, MPPotionclicked, sellMANA);
        displayItem(Dawid, grindingWheel, grindingWheelclicked, sellGW);
        displayItem(Dawid,armorPotion, armorPotionclicked, sellAP);
        displayItem(Dawid, bomb, bombclicked, sellBOMB);

      /*  if (Gdx.input.justTouched()) {
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.bombSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                if (bombclicked == 1 && Bomb.maxStock > 0 && Dawid.getGold() > Bomb.buyPrice ){
                    Shop.checkRequirement(Bomb.buyPrice, Dawid, bomb);
                   bottomText = "test";

                    Bomb.maxStock--;

                }
                if (Dawid.getGold() < Bomb.buyPrice && bombclicked == 1){
                    topText = "Masz za malo srodkow";
                }
                Assets.sellText = Bomb.sellPrice + "g";
                Assets.buyText = Bomb.buyPrice + "g";
                bombclicked++;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        bombclicked = 0;
                    }
                }, 500);


            }
        }*/
    }
public void Yeet(int HPPotionclicked){
    this.HPPotionclicked = HPPotionclicked;
}
    public static void displayItem(Player Dawid, Item item, int timesClicked, Sprite itemSprite){

        if (Gdx.input.justTouched()) {
            timesClicked = spriteClicked;
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (itemSprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                if (timesClicked == 1){
                    Shop.checkRequirement(item.getBuyPrice(), Dawid, item);
                     if (item.getMaxStock() == 0){
                         itemSprite.setColor(Color.GRAY);
                     }


                }
                Assets.sellText = item.getSellPrice() + "g";
                Assets.buyText = item.getBuyPrice() + "g";
                Assets.shopNameText = item.getName();
                spriteClicked++;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        spriteClicked = 0;
                    }
                }, 500);


            }
        }
    }


}
