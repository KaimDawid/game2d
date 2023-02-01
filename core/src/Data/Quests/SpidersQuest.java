package Data.Quests;

import Logic.Drop.Miscelanous;
import Logic.Inventory;
import Mobs.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import java.util.TimerTask;

import static Data.Quests.Quests.questNumber;
import static Data.Quests.Quests.spidersNumber;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.Dawid;

public class SpidersQuest {
    public static boolean questActive;
    public static String SQDescription;
    public static void QuestConvo(Player Dawid) throws InterruptedException {
SQDescription = "Collected sacks: " + Miscelanous.poisonSacks + "/" + Miscelanous.psRequirement;


        if (windowOpen){
    Assets.dialogueChoice1SPR.setSize(1100,90);
    Assets.dialogueChoice2SPR.setSize(1100,90);
    Assets.quest1SPR.setSize(1500,900);

}
else {
    Assets.dialogueChoice1SPR.setSize(0,0);
    Assets.dialogueChoice2SPR.setSize(0,0);
    Assets.quest1SPR.setSize(0,0);
    Quests.closeDialogue();
}

            if (Miscelanous.poisonSacks >= 6) {
                Quests.questCompletion1 = 1;
                try {
                    QuestLog.activeQuest.set(spidersNumber, QuestLog.spiderQuestCompleteSPR);
                }
                catch (IndexOutOfBoundsException a){

                }
            }

            if (Quests.questActive1 == 0 && GameApp.windowOpen) {

                Quests.questStory = " I need your help, we must find more spider's venom to craft\n" +
                        "   the antidote. If you manage to find 6 spider's glands, I will use\n" +
                        "  some of it to enhance your weapon. Just bring me some of them .\n" +
                        "  once you find them. Oh, and make sure it's a sharp weapon,\n" +
                        "   I can't imbue a mage staff.    Good luck!";
                Quests.diaChoice1 = "Start quest";
                Quests.diaChoice2 = "Leave";
             /*   System.out.println("Podchodzi do ciebie barczysty mężczyzna o ciemnej skórze i jasnobłękitnych oczach");

                System.out.println("Pochodzi on z krainy Kaim, rozpoznałeś to po jego specyficznym wyglądzie");

                System.out.println("Kaeńczycy są znani ze swojej potężnej postury i hipnotyzujących oczu");

                System.out.println("Są oni jednak bardzo łagodni, nigdy nie wdają się w bitwy i trudzą się jedynie rzemiosłem");

                System.out.println(" - Witaj! nie widziałem cię tu wcześniej, a nasze miasteczko jest tak małe że łatwo rozpoznać turystę\n" +
                        "                  (śmiech)\n" +
                        "                  Jestem tutejszym kowalem, widziałem z daleka twój oręż i domyślam się że nie obawiasz się walki.");

                System.out.println("  Potrzebuję pomocy, w tutejszym szpitalu brakuje jadu do produkcji antidotum na pająki.\n" +
                        "                   Jeśli uda Ci się zebrać 6 odwłoków tych paskudztw, wykorzystam trochę trucizny aby\n" +
                        "                   wzmocnić twój oręż. Po prostu wróć do mnie gdy będziesz gotowy.\n" +
                        "                   Aaa, myślę że się domyślasz, ale przynieś mi coś ostrego, bez sensu żebym smarował trucizną kostur dla maga.\n" +
                        "                   Powodzenia!");
*/

                if (Gdx.input.justTouched() && windowOpen) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (Assets.dialogueChoice1SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {


                        QuestLog.activeQuest.add(QuestLog.spiderQuestSPR);
                        spidersNumber = Quests.questNumber;
                        QuestLog.questDescription.add(Quests.spidersDescription);
                        Quests.questDescriptions.add(SQDescription);
                        Quests.smallDescriptions.add(Fonts.spidersInfoBMP);
                        Soundtrack.ui.play();

                        questActive = true;
                        spidersNumber = questNumber;
                        Quests.questNumber++;
                        Quests.questActive1 = 1;
                        Assets.quest1SPR.setSize(0, 0);
                        Assets.dialogueChoice1SPR.setSize(0, 0);
                        Assets.dialogueChoice2SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false;
                        Fonts.topText = "New Quest!";




                                Quests.questInfo = "Spider's glands: " + Miscelanous.poisonSacks + "/6";

                    }
                    if (Assets.dialogueChoice2SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        Assets.quest1SPR.setSize(0, 0);
                        Assets.dialogueChoice1SPR.setSize(0, 0);
                        Assets.dialogueChoice2SPR.setSize(0, 0);
                        Quests.closeDialogue();
                        windowOpen = false; Soundtrack.ui.play();
                    }

                }
            } else if (Quests.questActive1 == 1 && Quests.questCompletion1 == 0 && windowOpen) {
                Quests.questStory = "What are you doing here, I've asked you to bring me something";
                Quests.diaChoice1 = "Sorry boss ";
                Quests.diaChoice2 = "I'm not your errand boy";
                if (Gdx.input.justTouched()) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (Assets.dialogueChoice1SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)
                            || Assets.dialogueChoice2SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        Quests.closeDialogue(); Soundtrack.ui.play();
                        Assets.quest1SPR.setSize(0, 0);
                        Assets.dialogueChoice1SPR.setSize(0, 0);
                        Assets.dialogueChoice2SPR.setSize(0, 0);
                        windowOpen = false;
                    }

                }
            }
            try {

            if (Quests.questActive1 == 1 && Quests.questCompletion1 == 1 && windowOpen && Inventory.equippedweapon.getIsToxic() == 0 && Quests.quest1Stage != 4 && Quests.quest1Stage != 5 && Quests.quest1Stage != 6) {
                    Quests.questStory = "Have you found those glands?";
                    Quests.diaChoice1 = "Yes";
                    Quests.diaChoice2 = "No";
                    if (Gdx.input.justTouched()) {
                        camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                        if (Assets.dialogueChoice1SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                            Quests.questCompletion1 = 1;
                            Quests.quest1Stage = 4;
                            Quests.blockscreen = true;

                            QuestLog.activeQuest.get(spidersNumber).setColor(Color.DARK_GRAY);
                           /* QuestLog.questDescription.get(Quests.spidersNumber);*/
                            /*Decrement.questNumber();*/
                            QuestLog.questString = " "; Soundtrack.ui.play();
                        }

                    }
                    if (Assets.dialogueChoice2SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        Quests.closeDialogue();
                        Assets.quest1SPR.setSize(0, 0);
                        Assets.dialogueChoice1SPR.setSize(0, 0);
                        Assets.dialogueChoice2SPR.setSize(0, 0);
                        windowOpen = false; Soundtrack.ui.play();
                        Quests.blockscreen = true;
                    }


                }
            }
            catch (NullPointerException a){
                Quests.questStory = "You have no weapon on!";
            }
            if (Quests.questActive1 == 1 && Quests.questCompletion1 == 1 && windowOpen && Inventory.equippedweapon.getIsToxic() == 1) {
                Quests.questStory = "Thank you once more!";
                Quests.diaChoice1 = "Leave";
                Quests.diaChoice2 = "Leave";
                if (Gdx.input.justTouched()) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (Assets.dialogueChoice1SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) ||
                            Assets.dialogueChoice2SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y )) {
windowOpen = false;
                        Soundtrack.ui.play();
                    }
                    }
            }
            if (Quests.quest1Stage == 4){
                windowOpen = true;

                Quests.questStory = "Thank you, you've saved many lives today! \n " +
                        "Every single day someone gets bitten by those dreadful beasts  \n " +
                        "Give me your weapon, so I can imbue it with poison";
                Quests.diaChoice1 = "Thank you, here's my weapon";
                Quests.diaChoice2 = "Man fuck all yo bitch ass sorcery, I don't need that shit dawg";
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Quests.blockscreen = false;
                    }
                },500);

                if (Gdx.input.justTouched() && Quests.blockscreen == false) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (Assets.dialogueChoice1SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        Quests.quest1Stage = 5;
                        Soundtrack.questcomplete.play();
                        Dawid.setXP(Dawid.getXP() + 100);
                        Soundtrack.ui.play();
                }
            }

            }
            else if (Quests.quest1Stage == 5){
                windowOpen = true;
                Quests.Toxify(Dawid);
                if (Dawid.getToxify() == 1) {
                    Miscelanous.poisonSacks = Miscelanous.poisonSacks - 6;
                    Quests.questStory = "Your weapon has been poisoned";
                } else {
                    Quests.questStory = "I cannot imbue this weapon.";
                }
                Quests.diaChoice1 = "Thank you";
                if (Gdx.input.justTouched()) {
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (Assets.dialogueChoice1SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        Soundtrack.ui.play();
                        Quests.quest1Stage = 6;
                    }
                    else if (Assets.dialogueChoice2SPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)){
                       Quests.quest1Stage = 6; Soundtrack.ui.play();
                    }
                }
            }
            else if (Quests.quest1Stage == 6){
                if (windowOpen) {
                    Quests.questStory = "Thanks for your help";
                    Quests.diaChoice1 = "Ok";
                    Quests.diaChoice2 = "Ok";
                }
            }


/*
                switch (input) {
                    case "TAK":
                        System.out.println("");

                        System.out.println("Codziennie ktoś pada ofiarą zatrucia przez te potworne bestie");

                        System.out.println("Daj mi swoją broń, a zatruję ją żebyś mógł ją użyć przeciwko wrogom");
                        Toxify(Dawid);
                        if (Dawid.getToxify() == 1) {
                            Miscelanous.poisonSacks = Miscelanous.poisonSacks - 6;
                        } else {
                            System.out.println("Nie mogę zatruć tej bronii, wybacz.");
                        }
                        break;

                    case "NIE":
                        System.out.println("To spierdalaj.");
                        PressButton();
                        break;

                }
*/

            }
}
