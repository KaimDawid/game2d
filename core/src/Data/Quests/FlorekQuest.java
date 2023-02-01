package Data.Quests;

import Logic.Drop.Miscelanous;
import Objects.Items.Chests.ChestArmor;
import Objects.Items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import java.util.Date;
import java.util.TimerTask;

import static Data.Quests.Quests.BlockUnblock;
import static com.mygdx.game.Assets.healthPotionSPR;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.batch;

public class FlorekQuest {


    public static boolean window3Open, questActive = false;
    public static int quest3Stage, florekNumber;
    public static Texture dialogueChoice31TXT, dialogueChoice32TXT, quest3TXT, florekQuestTXT, crayfishTXT;
    public static Sprite dialogueChoice31SPR, dialogueChoice32SPR, quest3SPR, florekQuestSPR, crayfishSPR;
    public static String florekDescription, florekSmallDescription;
    public static TimerTask unblockScreen;



    public static void create(){
        florekSmallDescription = new String();
        dialogueChoice31TXT = new Texture("dialoguechoice3.png");
        quest3TXT = new Texture("quest3.png");
        dialogueChoice32SPR = new Sprite(dialogueChoice31TXT);
        dialogueChoice31SPR = new Sprite(dialogueChoice31TXT);
        quest3SPR = new Sprite(quest3TXT);
        florekQuestTXT = new Texture("florekquest.png");
        florekQuestSPR = new Sprite(florekQuestTXT);
        florekDescription = new String("Kill 6 crayfish, then return to Florchan to pick up your reward \n" +
                "Crayfish killed: " + Miscelanous.crayfishKilled +"/" + Miscelanous.crayFishRequirement);

        unblockScreen = new TimerTask() {
            @Override
            public void run() {
                Quests.blockscreen = false;
            }
        };
    }


    public static void Quest3Convo(){
florekSmallDescription = "Crayfish killed: " + Miscelanous.crayfishKilled + "/" + Miscelanous.crayFishRequirement;
        if (quest3Stage == 0 && window3Open){
           /* dialogueChoice1SPR.setSize(1300,200);
            dialogueChoice1SPR.setPosition(playerSprite.getX(), playerSprite.getY());
            dialogueChoice1SPR.draw(batch);*/
            Quests.questStory = "I am a cray-fisherman and I need the help of a brave adventurer \n" +
                    "This season there is a huge overpopulation of \n crayfish at the beach " +
                    "moreover, they seem to have evolved! \n I need you to kill 6 of them";
            Quests.diaChoice1 = "Sounds easy, I'll be back before you say CRAYFISH CRAZY";
            Quests.diaChoice2 = "I'm far too powerful to play around with crayfish";
            if (Gdx.input.justTouched() && Quests.blockscreen == false) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice31SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    QuestLog.activeQuest.add(florekQuestSPR);
                    QuestLog.questDescription.add(florekDescription);
                    Quests.questDescriptions.add(florekSmallDescription);
                    Quests.smallDescriptions.add(Fonts.florekInfoBMP);
                    florekNumber = Quests.questNumber;
                    Soundtrack.ui.play();
                    Quests.questNumber++;
                    System.out.println("worked");
                    quest3Stage = 1;
                    Quests.blockscreen = true;
                    BlockUnblock();
                    questActive = true;


                }
                if (dialogueChoice32SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    window3Open = false;
                    Soundtrack.ui.play();
                }

            }
        }

        if (quest3Stage == 1 && window3Open){

            Quests.questStory = "The beach is to the west, be careful because these \n" +
                    "crayfish have evolved to be extremely dangerous \n";
            Quests.diaChoice1 = "I'm on my way";
            Quests.diaChoice2 = "I'm on my way";
            if (Gdx.input.justTouched() && window3Open && !Quests.blockscreen) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice31SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    window3Open = false;
quest3Stage = 2;
                    Fonts.topText = "Slay 6 crayfish";
                    Soundtrack.ui.play();


                }
                if (dialogueChoice32SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    window3Open = false;
                    Soundtrack.ui.play();
                }

            }
        }

        if (quest3Stage == 2 && window3Open){

            Quests.questStory = "Have you killed them yet?";
            Quests.diaChoice1 = "Yes";
            Quests.diaChoice2 = "No";
            if (Gdx.input.justTouched() && Quests.blockscreen == false) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice31SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Miscelanous.crayfishKilled >= Miscelanous.crayFishRequirement) {
                    quest3Stage = 3;
                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    Soundtrack.ui.play();
                    BlockUnblock();
                    Soundtrack.questcomplete.play();


                    Quests.questInfo = " ";

                }
                if (dialogueChoice32SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    Quests.closeDialogue(); Soundtrack.ui.play();
                    window3Open = false;
                }

            }


        }

        if (quest3Stage == 3 && window3Open){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Quests.blockscreen = false;
                }
            }, 800);
            Quests.questStory = "Thank you so much for your help!, I've got a strong armor for you, \n" +
                    "which I've made out of crayfish scales";
            Quests.diaChoice1 = "You're welcome and thank you for the armor";
            Quests.diaChoice2 = "It was way too easy for me, give me a greater challenge next time";
            if (Gdx.input.justTouched() && Quests.blockscreen == false) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice31SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    Item.gear.add(new ChestArmor("Fish scale Armor [CHEST]", 180, 20, 4, 25, 1));

                    GameApp.eqList.add(Assets.fisharmorSPR);

                    Equipment.eqSlot++;
                    Item.currentSlot++;
                    Dawid.setGold(Dawid.getGold()+400);
                    Dawid.setXP(Dawid.getXP() + 100);
                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    QuestLog.activeQuest.get(florekNumber).setColor(Color.DARK_GRAY);
                    quest3Stage = 4;
                    window3Open = false;
                    Quests.closeDialogue();
                    BlockUnblock();
                    Soundtrack.ui.play();
                }
                if (dialogueChoice32SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    Dawid.setGold(Dawid.getGold()+1000);
                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    QuestLog.activeQuest.get(florekNumber).setColor(Color.DARK_GRAY);
                    window3Open = false;
                    Quests.closeDialogue();
                    quest3Stage = 4; Soundtrack.ui.play();
                }

            }
        }
        if (quest3Stage == 4 && window3Open){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Quests.blockscreen = false;
                }
            }, 800);
            Quests.questStory = "Thank you once more!";
            Quests.diaChoice1 = "Leave";
            Quests.diaChoice2 = "Leave";
            if (Gdx.input.justTouched() && Quests.blockscreen == false) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (dialogueChoice31SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    Soundtrack.ui.play();
                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    BlockUnblock();
                    Quests.closeDialogue();
                    window3Open = false;




                }
                if (dialogueChoice32SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {

                    quest3SPR.setSize(0, 0);
                    dialogueChoice31SPR.setSize(0, 0);
                    dialogueChoice32SPR.setSize(0, 0);
                    Soundtrack.ui.play();
                    Quests.closeDialogue();
                    window3Open = false;
                }

            }

        }


        if (window3Open){
            dialogueChoice31SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() + 32);
            dialogueChoice32SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() - 75);
            dialogueChoice31SPR.setSize(1200,90);
            dialogueChoice32SPR.setSize(1200,90);
            quest3SPR.setSize(1500,900);
            quest3SPR.draw(batch);
            dialogueChoice31SPR.draw(batch);
            dialogueChoice32SPR.draw(batch);
        }
        else {
            dialogueChoice31SPR.setSize(0,0);
            dialogueChoice32SPR.setSize(0,0);
            quest3SPR.setSize(0,0);

        }
    }
}
