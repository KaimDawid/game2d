package Data.Quests;

import Logic.Drop.Miscelanous;
import Mobs.Monster;
import Objects.Items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import java.util.TimerTask;

import static Logic.Drop.Miscelanous.woodLogs;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.batch;

public class CysiuQuest {

public static String cysiuDescription, CKDescription;
public static boolean questActive;
    public static Texture dialogueChoice4TXT, quest4TXT, cysiuQuestTXT, cysiuTXT;
    public static Sprite dialogueChoice41SPR, dialogueChoice42SPR, quest4SPR, cysiuQuestSPR, cysiuSPR;
public static int  quest4Stage = 0, cysiuNumber;
public static boolean window4Open;


public static void create(){

    dialogueChoice4TXT = new Texture("dialoguechoice4.png");
    cysiuQuestTXT = new Texture("cysiuquest.png");
quest4TXT = new Texture("quest4.png");
cysiuTXT = new Texture("cysiuow.png");
cysiuSPR = new Sprite(cysiuTXT);
cysiuSPR.setRegion(0,0,1000,1000);
cysiuSPR.setPosition(playerSprite.getX()+1820, playerSprite.getY()+500);
cysiuSPR.setSize(350,280);
Monster.minotaurSPR.setSize(300,300);
    Monster.minotaurSPR.setPosition(cysiuSPR.getX()+1890, cysiuSPR.getY()+160);

dialogueChoice41SPR = new Sprite(dialogueChoice4TXT);
dialogueChoice42SPR = new Sprite(dialogueChoice4TXT);
cysiuQuestSPR = new Sprite(cysiuQuestTXT);
quest4SPR = new Sprite(quest4TXT);

cysiuDescription = new String("Collect 20 wood pieces and bring them back to Cysiu");

}


    public static void Quest4Convo(){
        CKDescription = "Gathered wood: " + Miscelanous.gatheredWood + "/25";
        if (quest4Stage == 0 && window4Open){
           /* dialogueChoice1SPR.setSize(1300,200);
            dialogueChoice1SPR.setPosition(playerSprite.getX(), playerSprite.getY());
            dialogueChoice1SPR.draw(batch);*/
            Quests.questStory = "Hello!, I need some materials to finish the construction \n" +
                    "of my house. Please bring me 20 wood logs from the forest \n" +
                    "I will reward you handsomely if you manage to do it";
            Quests.diaChoice1 = "I will go to the forest and bring you these wood logs";
            Quests.diaChoice2 = "I'm not interested.";
            if (Gdx.input.justTouched()) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice41SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    QuestLog.activeQuest.add(cysiuQuestSPR);
                    QuestLog.questDescription.add(cysiuDescription);
                  /*  Quests.questDescriptions.add(CKDescription);
                    Quests.smallDescriptions.add(Fonts.cysiuInfoBMP);*/

                    cysiuNumber = Quests.questNumber;
quest4Stage = 1;
                    Quests.questNumber++;
                    System.out.println("worked");
                    quest4Stage = 1;
                    Quests.blockscreen = true;
               questActive = true;
                    Soundtrack.ui.play();

                }
                if (dialogueChoice42SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    quest4SPR.setSize(0, 0);
                    dialogueChoice41SPR.setSize(0, 0);
                    dialogueChoice42SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    window4Open = false; Soundtrack.ui.play();
                }

            }
        }

        if (quest4Stage == 1 && window4Open){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Quests.blockscreen = false;
                }
            },500);
            Quests.questStory = "Have you found my wood logs? \n";
            Quests.diaChoice1 = "Yes, here you go";
            Quests.diaChoice2 = "Not yet";
            if (Gdx.input.justTouched() && window4Open && !Quests.blockscreen) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice41SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Miscelanous.gatheredWood >= 20) {
                    Dawid.setXP(Dawid.getXP() + 100);
                    quest4Stage = 2;
                    quest4SPR.setSize(0, 0);
                    dialogueChoice41SPR.setSize(0, 0);
                    dialogueChoice42SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    window4Open = false;
                    Soundtrack.ui.play();
                     cysiuSPR.setRegion(1000,0,1000,1000);



                }
                if (dialogueChoice42SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    quest4SPR.setSize(0, 0);
                    dialogueChoice41SPR.setSize(0, 0);
                    dialogueChoice42SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    window4Open = false; Soundtrack.ui.play();
                }

            }
        }

        if (quest4Stage == 2 && window4Open){

            Quests.questStory = "Here's your reward! I will give you an armor potion \n" +
                    "and a grinding wheel for your weapon";
            Quests.diaChoice1 = "Thank you!";
            Quests.diaChoice2 = "Thanks, cya!";
            if (Gdx.input.justTouched() && window4Open) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice41SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    GameApp.usableList.add(Assets.grindingWheelSPR);
                    Item.edible.add(grindingWheel);
                    usableList.add(Assets.armorPotionSPR);
                    Item.edible.add(armorPotion);
                    quest4SPR.setSize(0, 0);
                    dialogueChoice41SPR.setSize(0, 0);
                    dialogueChoice42SPR.setSize(0, 0);
                    Soundtrack.ui.play();

                    quest4Stage = 3;


                    Quests.questInfo = " ";

                }
                if (dialogueChoice42SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    quest4SPR.setSize(0, 0);
                    dialogueChoice41SPR.setSize(0, 0);
                    dialogueChoice42SPR.setSize(0, 0);
                    Quests.closeDialogue(); Soundtrack.ui.play();
                    window4Open = false;
                }

            }


        }


        if (quest4Stage == 3 && window4Open){
            Quests.questStory = "Thank you once more!";
            Quests.diaChoice1 = "Leave";
            Quests.diaChoice2 = "Leave";
            if (Gdx.input.justTouched() && window4Open) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice41SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {

                    quest4SPR.setSize(0, 0);
                    dialogueChoice41SPR.setSize(0, 0);
                    dialogueChoice42SPR.setSize(0, 0);
                    Soundtrack.ui.play();
                    Quests.closeDialogue();
                    window4Open = false;




                }
                if (dialogueChoice42SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {

                    quest4SPR.setSize(0, 0);
                    dialogueChoice41SPR.setSize(0, 0);
                    dialogueChoice42SPR.setSize(0, 0);
                    Soundtrack.ui.play();
                    Quests.closeDialogue();
                    window4Open = false;
                }

            }

        }


        if (window4Open){
            dialogueChoice41SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() + 32);
            dialogueChoice42SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() - 75);
            dialogueChoice41SPR.setSize(1200,90);
            dialogueChoice42SPR.setSize(1200,90);
            quest4SPR.setSize(1500,900);
            quest4SPR.draw(batch);
            dialogueChoice41SPR.draw(batch);
            dialogueChoice42SPR.draw(batch);
        }
        else {
            dialogueChoice41SPR.setSize(0,0);
            dialogueChoice42SPR.setSize(0,0);
            quest4SPR.setSize(0,0);

        }
    }
}
