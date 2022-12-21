package Data.Quests;

import Logic.Drop.Miscelanous;
import Logic.FightLogic.Fight;
import Logic.Inventory;
import Mobs.Monster;
import Mobs.Player;
import Mobs.Spider;
import Objects.Items.Item;
import Objects.Items.Weapons.Weapon;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

import static Data.Quests.FlorekQuest.florekNumber;
import static Data.Quests.FlorekQuest.unblockScreen;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.mygdx.game.Assets.*;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.Dawid;

@Getter @Setter
public class Quests {
    public static boolean moveMap;
    public static ArrayList<String> questDescriptions;
    public static ArrayList<BitmapFont> smallDescriptions;
    public static Texture quest2mapTXT, quest2TXT, dialoguechoice2TXT;
    public static Sprite quest2mapSPR, quest2SPR, dialogueChoice21SPR, dialogueChoice22SPR;
    public static Texture gabiTXT;
    public static Sprite gabiSPR, gabiOverworldSPR;

    public static int spidersNumber, rysiuNumber, cysiuNumber, banditNumber;

public static int quest2Stage = 1;
public static boolean window2Open = false;
    public static String diaChoice1;
    public static BitmapFont diaChoice1BitMap;
    public static String diaChoice2;
    public static BitmapFont diaChoice2BitmMap;
    public static String questStory;
    public static BitmapFont questStoryBitMap;
    public static String questInfo;
    public static BitmapFont questInfoBitMap;
    public static int questNumber = 0;
    static int questActive1 = 0;

static int questCompletion1 = 0;
    static int questActive2 = 0;

    static int questCompletion2 = 0;


    public static int raid1;
    public static int raid2;
    public static int raid3;
    public static String rysiuDescription, spidersDescription, sideDescription;
    public static BitmapFont questDescriptionBMP;
static int quest1Stage;
    public static boolean blockscreen = false;
    public static void BlockUnblock(){
        try {
            blockscreen = true;
            timer.schedule(unblockScreen, 800);
        }
        catch (IllegalStateException a){

        }
    }
    public static void updateDescription(){

       /* for (int i = 0; i < questDescriptions.size(); i++) {

            questDescriptions.set(spidersNumber, SpidersQuest.SQDescription);
            questDescriptions.set(florekNumber, FlorekQuest.florekSmallDescription);
            questDescriptions.set(cysiuNumber, CysiuQuest.CKDescription);
try {
    try {
        smallDescriptions.get(i).draw(batch, questDescriptions.get(i), playerSprite.getX() + 500, (playerSprite.getY() + 100) - (i * 50));
    } catch (IndexOutOfBoundsException a) {

    }
}catch (NullPointerException a){

            }
        }*/


        if (CysiuQuest.questActive){
            Fonts.questInfo = Miscelanous.gatheredWood + "/25";
        }
        if (SpidersQuest.questActive){
            Fonts.questInfo = Miscelanous.poisonSacks + "/" + Miscelanous.psRequirement;
        }


        if (gabbie.getHp() < 10 && quest2Stage < 7){
          /*  Dawid.setX(4);
            Dawid.setY(4);*/
            mapSprite.setColor(originalColor);
            fightscreenSP.setColor(originalColor);
            /*playerSprite.setPosition(2662, 1898);*/
            camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
            camera.update();


            QuestLog.activeQuest.get(rysiuNumber).setColor(Color.GREEN);
        }
if (questCompletion1 == 1){
    Miscelanous.poisonSacks = 6;
}
        spidersDescription = "Gather 6 spiders' glands and deliver \n" +
                "them to the town's medic. " + Miscelanous.poisonSacks + "/6";
if (questActive1 > 0) {
    try {
        QuestLog.questDescription.set(spidersNumber, spidersDescription);
    } catch (IndexOutOfBoundsException a) {

    }
}
if (Miscelanous.crayfishKilled > 0){
    FlorekQuest.florekDescription = "Kill 6 crayfish, then return to Florchan to pick up your reward \n" +
            "Crayfish killed: " + Miscelanous.crayfishKilled +"/" + Miscelanous.crayFishRequirement;
    if (FlorekQuest.questActive) {
        QuestLog.questDescription.set(FlorekQuest.florekNumber, FlorekQuest.florekDescription);
    }
}
    }
    public static void create(){
        sideDescription = new String();
        questDescriptions = new ArrayList<String>();
        smallDescriptions = new ArrayList<BitmapFont>();
        quest2mapTXT = new Texture("quest2map.png");
        quest2TXT = new Texture("quest2.png");
        quest2mapSPR = new Sprite(quest2mapTXT);
        quest2SPR = new Sprite(quest2TXT);
        quest2mapSPR.setPosition(20000,20000);
        gabiTXT = new Texture("gabi.png");
        gabiSPR = new Sprite(gabiTXT);
        gabiOverworldSPR = new Sprite(gabiTXT);
        gabiOverworldSPR.setRegion(0,0,100,180);
        gabiOverworldSPR.setSize(100,200);
        gabiSPR.setSize(300,600);
        gabiSPR.setRegion(0,0,100,180);
        dialoguechoice2TXT = new Texture("dialoguechoice2.png");
        dialogueChoice21SPR = new Sprite(dialoguechoice2TXT);
        dialogueChoice22SPR = new Sprite(dialoguechoice2TXT);
        rysiuDescription = "Sneak into the castle chambers and kill \n" +
                "Gabbie Flowers";
        spidersDescription = "Gather 6 spiders' glands and deliver \n" +
                "them to the town's medic. " + Miscelanous.poisonSacks + "/6";
        questDescriptionBMP = new BitmapFont();
        questDescriptionBMP = Fonts.fontGenerator.generateFont(Fonts.fontParameter);
        questDescriptionBMP.getData().setScale(0.7F);
    }


    public static void Quest3Convo(Player Dawid) throws InterruptedException {
        if (Miscelanous.banditsKilled > Miscelanous.bkRequirement){
            questCompletion2 = 1;
        }
        Scanner scanner = new Scanner(System.in);
        if (questActive2 == 0) {
            System.out.println("W ratuszu natrafiłeś na wodza miasteczka");
            PressButton();
            System.out.println("Jego twarz jest pokryta licznymi bliznami, reszta ciała jest odziana w zużytą zbroję");
            PressButton();
            System.out.println("Słyszałeś że został wodzem po tym jak uratował miasto przed atakiem bandytów");
            PressButton();
            System.out.println("Postanowiłeś zapytać go o pracę");
            PressButton();
            System.out.println("   (Wódz spogląda na Ciebie zmęczonymi oczami)\n" +
                    "                -  Dobrze że pytasz, na wschód od naszego miasta rozrósł się obóz bandytów.\n" +
                    "                   Nie chcemy powtórki z rozrywki, raz już nieźle przez nich oberwaliśmy.\n" +
                    "                   Proszę, idź na wschód i wytnij w pień 15 bandytów w ich obozie.");

            PressButton();
            System.out.println("      W zamian dam Ci swoją broń, służyła mi przez wiele lat, ale jestem już za stary by jej używać.\n" +
                    "                   Jak pomożesz naszemu kowalowi, to będzie on mógł dla Ciebie zatruć ten miecz, a wtedy bez problemu\n" +
                    "                   poradzisz sobie nawet z najsilniejszymi potworami.\n" +
                    "                   Powodzenia i wróć do nas żywy, proszę.");

            PressButton();
            questActive2 = 1;
        }
        else if (questActive2 ==1 && questCompletion2 == 0){
            System.out.println("- Pośpiesz się, z każdą chwilą ich obóz się rozrasta");

        }
        else if (questActive2 == 1 && questCompletion2 == 1){
            System.out.println("Udało Ci się ich zabić?");
            System.out.println("TAK , NIE");

            String input = scanner.nextLine().toUpperCase();
            switch (input){
                case "TAK":
                    System.out.println("Dziękuję ci! Tak jak obiecałem, moja broń należy do Ciebie");

                    Item.currentSlot++;
                    Item.gearPiece[Item.currentSlot] = new Weapon("Obsydianowy miecz dwuręczny", 30, 80, 7, 0, 2, 1, 1);
                    System.out.println("Korzystaj z niej mądrze i zawsze w dobrej sprawie");

                    System.out.println("Odwiedź naszego kowala a zatruje on ją dla ciebie. Dzięki ci raz jeszcze, bywaj! ");
                    PressButton();
                    questCompletion2 = 2;
                    break;

                case "NIE":
                    System.out.println("To spierdalaj.");
                    PressButton();
                    break;

            }

        }
        else if (questCompletion2 == 2){
            System.out.println("Dziękuję ci za pomoc, powodzenia w dalszej podróży!");
        }
    }

/* public static void Toxify(Player Dawid){
    if (Monster.weaponEQ != 0){
        Dawid.setToxify(1);
    }
 }*/
    public static void Toxify(Player Dawid){
        try {
            if (Inventory.equippedweapon.getIsSharp() == 1) {
                Inventory.equippedweapon.setIsToxic(1);
                Dawid.setToxify(1);
                Fonts.topText = "Twoja broń jest teraz zatruta!";

            }
        }
        catch (NullPointerException a){

        }

        }

        public static void PressButton(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("(Wciśnij dowolny przycisk żeby kontynuować)");
            String next = scanner.nextLine();

        }

       /* public static void Raid(int X, int Y, int calledMobs){
        try {
            for (int i = 0; i < calledMobs; i++) {
                raidBase[i] = new Bandit(500, 80, 12, 1, "bandyta", 150, 100, 5, 1);

            }
            GameApp.baseNumber = baseNumber + calledMobs;
        }
        catch (NullPointerException a){

        }


        }*/
/*
        public static void checkRaid(){
            for (int i = 0; i < 5 - 1; i++) {
                try {
                    GameApp.checker(Dawid,raidBase[i]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
*/
        public static int rewardViable;
    public static int yourMom = 1;
    public static void closeDialogue(){
        diaChoice1 = " ";
        diaChoice2 = " ";
        questStory = " ";
    }
        public static void questReward(int X, int Y, int goldReward, int expReward, Item item, Sprite sprite){

        if (Dawid.getX() == X && Dawid.getY() == Y && rewardViable == 1){
            Dawid.setGold(Dawid.getGold() + goldReward);
            Dawid.setXP(Dawid.getXP() + expReward);
            Item.gearPiece[Item.currentSlot] = item;
            GameApp.eqList.add(sprite);
            Item.currentSlot++;
            System.out.println("penis");
            rewardViable = 0;

        }
        }


        public static void checkThatRaid(Monster[] monster, int X, int Y) {

            try {

                        if (Dawid.getX() == X && Dawid.getY() == Y) {
                            fightON = 1;

                            Fonts.topText = "Walcz!";
                            Fonts.leftText = " ";

                            Assets.attackSpr.setSize(200, 80);
                            Assets.runSpr.setSize(200, 80);
                            fightscreenSP.setPosition(playerSprite.getX() - 960, playerSprite.getY() - 540);
                            fightscreenSP.setSize(1920, 1080);
                          /*  sprite.setPosition(fightscreenSP.getX() + 1000, fightscreenSP.getY() + 360);
                            sprite.setSize(200, 200);*/
                         /*   checkSuccesful = 1;*/

                                try {
                                    Fight.Turn(Dawid, monster[0]);
                                    if (monster[0].getHp() < 1){
                                        Fight.Turn(Dawid, monster[1]);
                                    }
                                    if (monster[1].getHp() < 1){
                                        Fight.Turn(Dawid, monster[2]);
                                    }
                                    if (monster[2].getHp() < 1){
                                        Fight.Turn(Dawid, monster[3]);
                                    }
                                    if (monster[3].getHp() < 1){
                                        Fight.Turn(Dawid, monster[4]);
                                    }
                                    if (monster[4].getHp() < 1 && yourMom == 1){
                                        yourMom = 0;
                                        rewardViable = 1;
                                        Quests.questReward(12,1,200,800,
                                                new Weapon("Meteor sword", 10, 120, 12, 60, 2,1,1), twohandedswordSPR);
                                    }
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }


                        } else {
                            fightON = 0;
                        }

                }
            catch (NullPointerException a) {

            }

        }

    }



