package Data.Quests;

import Logic.Drop.Miscelanous;
import Logic.Input.RenderInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.GameApp;

import java.util.Date;
import java.util.TimerTask;

import static com.mygdx.game.GameApp.*;

public class RusakovQuest {

    public static Texture dungeonMapTXT, dungeonMap2TXT, dialogueChoice51TXT, quest5TXT, rusakovQuestTXT;
    public static Sprite dungeonMapSPR, dungeonMap2SPR, dialogueChoice51SPR, dialogueChoice52SPR, quest5SPR, rusakovQuestSPR;
    public static String rusakovDescription;
    public static int questStage, rusakovNumber;
    public static boolean moveDungeon, windowOpen, questActive;

    public static void create() {
        dungeonMap2TXT = new Texture("dungmap2.png");
        dungeonMapTXT = new Texture("dungmap.png");
        dungeonMapSPR = new Sprite(dungeonMapTXT);
        dialogueChoice51TXT = new Texture("dialoguechoice5.png");
        quest5TXT = new Texture("quest5.png");
        rusakovQuestTXT = new Texture("rusakovquest.png");
        rusakovQuestSPR = new Sprite(rusakovQuestTXT);
        dialogueChoice51SPR = new Sprite(dialogueChoice51TXT);
        dialogueChoice52SPR = new Sprite(dialogueChoice51TXT);
        quest5SPR = new Sprite(quest5TXT);
        dungeonMap2SPR = new Sprite(dungeonMap2TXT);
        dungeonMap2SPR.setSize(5700,3420);
        dialogueChoice51SPR.setSize(1200,90);
        dialogueChoice52SPR.setSize(1200,90);
        quest5SPR.setSize(1500,900);
        dungeonMapSPR.setSize(0, 0);

        rusakovDescription = "Find the magic flute in the cemetery, play it at \n " +
                " the bridge, defeat the boss and return for your reward.";

    }

    public static void enterDungeon() {
        dungeonMapSPR.setSize(5700, 3420);
        dungeonMap2SPR.setSize(5700,3420);
        RusakovQuest.dungeonMapSPR.setPosition(playerSprite.getX() - 2104, playerSprite.getY() - 1410);
         dungeonMap2SPR.setPosition(playerSprite.getX()-2104, playerSprite.getY() - 1410);
        Dawid.setX(200);
        Dawid.setY(202);
        RenderInput.drawDungeon = true;
        RenderInput.enterBlocked = true;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                RenderInput.enterBlocked = false;
            }
        }, 400);

    }

    public static void leaveDungeon() {

        RenderInput.drawDungeon = false;
        Dawid.setX(15);
        Dawid.setY(15);
        dungeonMapSPR.setSize(0,0);
        dungeonMap2SPR.setSize(0,0);
        playerSprite.setPosition(Gdx.graphics.getWidth() / 2 + 9264, Gdx.graphics.getHeight() / 2 + 4572);
        RenderInput.enterBlocked = true;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                RenderInput.enterBlocked = false;
            }
        }, 400);
        dungeonMapSPR.setSize(0, 0);
    }

    public static void QuestConvo() {
        if (Miscelanous.magicFlute) {
            dungeonMapSPR.set(dungeonMap2SPR);
            if (questStage!= 4 && questStage != 3){
                questStage = 2;
            }
        }


        if (windowOpen) {
            quest5SPR.setPosition(GameApp.playerSprite.getX()-900, GameApp.playerSprite.getY()-400);
            dialogueChoice51SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() + 32);
            dialogueChoice52SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() - 75);

            if (questStage == 0) {

                Quests.questStory = "Hello!, I've found the way to defeat the bridge guardian. \n" +
                        "You must find the magic flute in the cemetery's dungeon, then \n" +
                        "take the flute to the bridge and play it to weaken the guardian";
                Quests.diaChoice1 = "I will do it right after I finish all other errands.";
                Quests.diaChoice2 = "This quest is way too difficult for me.";
                if (Gdx.input.justTouched()) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (dialogueChoice51SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        QuestLog.activeQuest.add(rusakovQuestSPR);
                        QuestLog.questDescription.add(rusakovDescription);

                  /*  Quests.questDescriptions.add(CKDescription);
                    Quests.smallDescriptions.add(Fonts.cysiuInfoBMP);*/

                        rusakovNumber = Quests.questNumber;
                        questStage = 1;
                        Quests.questNumber++;
                        System.out.println("worked");
                        questStage = 1;

                        questActive = true;
                        Soundtrack.ui.play();

                    }
                    if (dialogueChoice52SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();
                    }
                }


            }

            if (questStage == 1) {
                Quests.questStory = "What are you waiting for! Go to the dungeon \n";
                Quests.diaChoice1 = "I'm on my way.";
                Quests.diaChoice2 = "Forget it, I'm not that crazy.";
                if (Gdx.input.justTouched()) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (dialogueChoice51SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();

                    }
                    if (dialogueChoice52SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();
                    }
                }


            }

            if (questStage == 2) {
                Quests.questStory = "I see you've found the flute, well done! \n" +
                        "Go to the bridge, play the flute and defeat the guardian. \n" +
                        "After you're done, you can leave the island";
                Quests.diaChoice1 = "I'm on my way.";
                Quests.diaChoice2 = "I need to prepare properly, give me some time";
                if (Gdx.input.justTouched()) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (dialogueChoice51SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();

                    }
                    if (dialogueChoice52SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();
                    }
                }
            }

            if (questStage == 3){
                Quests.questStory = "I knew you could do it! Here, have my gear, you will \n" +
                        "need it on the other side of the bridge";
                Quests.diaChoice1 = "Thank you!";
                Quests.diaChoice2 = "Thanks";
                if (Gdx.input.justTouched()) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (dialogueChoice51SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();
                        questStage = 4;

                    }
                    if (dialogueChoice52SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();
                        questStage = 4;
                    }
                }
            }
            if (questStage == 4){
                Quests.questStory = "Hello hero! Well done once more!";
                Quests.diaChoice1 = "Leave";
                Quests.diaChoice2 = "Leave";
                if (Gdx.input.justTouched()) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (dialogueChoice51SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();

                    }
                    if (dialogueChoice52SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        quest5SPR.setSize(0, 0);
                        dialogueChoice51SPR.setSize(0, 0);
                        dialogueChoice52SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Soundtrack.ui.play();
                    }
                }
            }


        }
        if (windowOpen){
            dialogueChoice51SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() + 32);
            dialogueChoice52SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() - 75);
            dialogueChoice51SPR.setSize(1200,90);
            dialogueChoice52SPR.setSize(1200,90);
            quest5SPR.setSize(1500,900);
            quest5SPR.draw(batch);
            dialogueChoice51SPR.draw(batch);
            dialogueChoice52SPR.draw(batch);
        }
        else {
            dialogueChoice51SPR.setSize(0,0);
            dialogueChoice52SPR.setSize(0,0);
            quest5SPR.setSize(0,0);

        }

    }
}
