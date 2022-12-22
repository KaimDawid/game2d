package Data.Quests;

import Objects.Items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import java.util.TimerTask;

import static Data.Quests.CysiuQuest.cysiuSPR;
import static Data.Quests.Quests.quest2Stage;
import static com.mygdx.game.Assets.healthPotionSPR;
import static com.mygdx.game.GameApp.*;

public class RysiuQuest {
    public static boolean questActive;
    public static String rysiuQuestString;
    public static void Quest2Convo(){

        rysiuQuestString = "Gabbie killed: 0/1";

        if (quest2Stage == 1 && Quests.window2Open){
           /* dialogueChoice1SPR.setSize(1300,200);
            dialogueChoice1SPR.setPosition(playerSprite.getX(), playerSprite.getY());
            dialogueChoice1SPR.draw(batch);*/
            Quests.questStory = "I need you to do me a favor, there is a particular \n" +
                    "bitch I hate inside the castle chambers, she is surrounded \n" +
                    "by whiteknights, simps that adore her, absolutely disgusting";
            Quests.diaChoice1 = "So what's my job then?";
            Quests.diaChoice2 = "I am a simp myself and you do not disrespect a lady like that!";
            if (Gdx.input.justTouched()) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (Quests.dialogueChoice21SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    System.out.println("worked");
                    quest2Stage = 2; Soundtrack.ui.play();
Quests.blockscreen = true;



                }
                if (Quests.dialogueChoice22SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    Quests.quest2SPR.setSize(0, 0);
                    Quests.dialogueChoice21SPR.setSize(0, 0);
                    Quests.dialogueChoice22SPR.setSize(0, 0);
                    Quests.closeDialogue(); Soundtrack.ui.play();
                    Quests.window2Open = false;
                }

            }
        }

        if (quest2Stage == 2 && Quests.window2Open){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Quests.blockscreen = false;
                }
            },500);
            Quests.questStory = "You must sneak into the castle, break through all the guards and \n" +
                    "murder her. The guards change their shift at 7 p.m, that's your \n" +
                    "chance to sneak in undetected. But when you're inside, prepare for a fight";
            Quests.diaChoice1 = "I'm in, I will bring you her head on a silver platter";
            Quests.diaChoice2 = "Let me think this through";
            if (Gdx.input.justTouched() && Quests.window2Open && !Quests.blockscreen) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (Quests.dialogueChoice21SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    quest2Stage = 3;
                   Quests.quest2SPR.setSize(0, 0);

 if (!questActive) {
     QuestLog.activeQuest.add(QuestLog.rysiuQuestSPR);
     QuestLog.questDescription.add(Quests.rysiuDescription);
     Quests.rysiuNumber = Quests.questNumber;
 }
                    questActive = true;

             /*      Quests.questDescriptions.add(rysiuQuestString);
                    Quests.smallDescriptions.add(Fonts.rysiuInfoBMP);*/

                    Quests.dialogueChoice21SPR.setSize(0, 0);
                    Quests.dialogueChoice22SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    Quests.window2Open = false;

                    Soundtrack.ui.play();

                    Quests.questNumber++;
                    Fonts.topText = "You can now sneak into the castle";

                    Quests.questInfo = "Bitch murdered: 0/1";

                }
                if (Quests.dialogueChoice22SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    Quests.quest2SPR.setSize(0, 0);
                    Quests.dialogueChoice21SPR.setSize(0, 0);
                    Quests.dialogueChoice22SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    Quests.window2Open = false; Soundtrack.ui.play();
                }

            }
        }

        if (quest2Stage == 3 && Quests.window2Open){
            Quests.questStory = "You can now sneak into the castle";
            Quests.diaChoice1 = "Sneak in";
            Quests.diaChoice2 = "I need some time to prepare";
            if (Gdx.input.justTouched() && Quests.window2Open) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (Quests.dialogueChoice21SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {

                    Quests.quest2SPR.setSize(0, 0);
                    Quests.dialogueChoice21SPR.setSize(0, 0);
                   Quests.dialogueChoice22SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    Quests.window2Open = false;
                    Quests.moveMap = true;
                    quest2Stage = 4;
                    Fonts.topText = "Break through the guards and defeat Gabbie!";
                    Soundtrack.ui.play();
                    Quests.questInfo = " ";

                }
                if (Quests.dialogueChoice22SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    Quests.quest2SPR.setSize(0, 0);
                    Quests.dialogueChoice21SPR.setSize(0, 0);
                    Quests.dialogueChoice22SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    Quests.window2Open = false; Soundtrack.ui.play();
                }

            }
        }
        if (quest2Stage == 4){
            if (Quests.moveMap){
                Dawid.setX(110);
                Dawid.setY(110);
                Quests.quest2mapSPR.setPosition(playerSprite.getX()-3720, playerSprite.getY()-1420);
                Quests.gabiOverworldSPR.setPosition(Quests.quest2mapSPR.getX()+3750, Quests.quest2mapSPR.getY()-2150);
                GameApp.usableList.add(healthPotionSPR);
                Item.edible.add(healthPotion);
                GameApp.usableList.add(healthPotionSPR);
                Item.edible.add(healthPotion);
                GameApp.usableList.add(healthPotionSPR);
                Item.edible.add(healthPotion);
                GameApp.usableList.add(healthPotionSPR);
                Item.edible.add(healthPotion);
                quest2Stage = 5;
                Quests.moveMap = false;
            }

        }
        if (quest2Stage == 5){
        cysiuSPR.setSize(0,0);
        }
        else {
            cysiuSPR.setSize(350,280);
        }

        if (quest2Stage == 6 && Quests.window2Open){
            Quests.questStory = "Thank you for killing that bitch!, here's a \n" +
                    "1000 gold for your help";
            Quests.diaChoice1 = "It was my pleasure";
            Quests.diaChoice2 = "I never want to see you again, sicko";
            if (Gdx.input.justTouched() && Quests.window2Open) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (Quests.dialogueChoice21SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
Dawid.setGold(Dawid.getGold()+1000);
                    Quests.quest2SPR.setSize(0, 0);
                    Quests.dialogueChoice21SPR.setSize(0, 0);
                    Quests.dialogueChoice22SPR.setSize(0, 0); Soundtrack.questcomplete.play();
                    QuestLog.activeQuest.get(Quests.rysiuNumber).setColor(Color.DARK_GRAY);
                    Soundtrack.ui.play();
                  /* Decrement.questNumber();*/
                    QuestLog.questString = " ";
                    Quests.closeDialogue();
                    Quests.window2Open = false;

                    quest2Stage = 7;


                }
                if (Quests.dialogueChoice22SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    Dawid.setGold(Dawid.getGold()+1000);
                    Quests.quest2SPR.setSize(0, 0);
                    Quests.dialogueChoice21SPR.setSize(0, 0);
                    Quests.dialogueChoice22SPR.setSize(0, 0);
                    QuestLog.activeQuest.remove(QuestLog.rysiuQuestSPR);
                    QuestLog.questDescription.remove(Quests.rysiuDescription);
                    Quests.questNumber--;
                    QuestLog.questString = " ";
                    Quests.closeDialogue();
                    Quests.window2Open = false;
                    Soundtrack.ui.play();
                    quest2Stage = 7;
                }

            }


        }
        if (quest2Stage == 7 && Quests.window2Open){
            Quests.questStory = "Pleasure doing business with you, \n" +
                    "I hope to see you again some time";
            Quests.diaChoice1 = "Leave";
            Quests.diaChoice2 = "Leave";
            if (Gdx.input.justTouched() && Quests.window2Open) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (Quests.dialogueChoice21SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {

                    Quests.quest2SPR.setSize(0, 0);
                    Quests.dialogueChoice21SPR.setSize(0, 0);
                    Quests.dialogueChoice22SPR.setSize(0, 0);
                    Quests.closeDialogue();
                    Quests.window2Open = false;
                    Soundtrack.ui.play();


                }
                if (Quests.dialogueChoice22SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    Quests.quest2SPR.setSize(0, 0);
                    Quests.dialogueChoice21SPR.setSize(0, 0);
                    Quests.dialogueChoice22SPR.setSize(0, 0);
                    Soundtrack.ui.play();
                    Quests.closeDialogue();
                    Quests.window2Open = false;

                }

            }
        }
        if (Quests.window2Open){
            Quests.dialogueChoice21SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() + 32);
            Quests.dialogueChoice22SPR.setPosition(GameApp.playerSprite.getX() - 750, GameApp.playerSprite.getY() - 75);
            Quests.dialogueChoice21SPR.setSize(1200,90);
            Quests.dialogueChoice22SPR.setSize(1200,90);
            Quests.quest2SPR.setSize(1500,900);
Quests.quest2SPR.draw(batch);
Quests.dialogueChoice21SPR.draw(batch);
Quests.dialogueChoice22SPR.draw(batch);
        }
        else {
            Assets.dialogueChoice1SPR.setSize(0,0);
            Assets.dialogueChoice2SPR.setSize(0,0);
            Assets.quest1SPR.setSize(0,0);
            Quests.closeDialogue();
        }
    }
}
