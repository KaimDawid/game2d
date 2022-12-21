package Data.Quests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.touchPoint;

public class QuestLog {

    public static Texture questLogTXT, rysiuQuestTXT, cysiuQuestTXT, banditQuestTXT, spiderQuestTXT, spiderQuestCompleteTXT;
    public static Sprite questLogSPR, rysiuQuestSPR, cysiuQuestSPR, banditQuestSPR, spiderQuestSPR, spiderQuestCompleteSPR;

    public static ArrayList<String> questDescription;
    public static ArrayList<Sprite> activeQuest;
    public static String questString;

    public static boolean showLog = false;


    public static void create(){
        questLogTXT = new Texture("questlog.png");
        rysiuQuestTXT = new Texture("rysiuquest.png");
        cysiuQuestTXT = new Texture("cysiuquest.png");
        banditQuestTXT = new Texture("banditquest.png");
        spiderQuestTXT = new Texture("spiderquest.png");
        spiderQuestCompleteTXT = new Texture("spiderquestcomplete.png");
        spiderQuestCompleteSPR = new Sprite(spiderQuestTXT);
        spiderQuestCompleteSPR.setSize(1000,124);
        rysiuQuestSPR = new Sprite(rysiuQuestTXT);
        cysiuQuestSPR = new Sprite(cysiuQuestTXT);
        banditQuestSPR = new Sprite(banditQuestTXT);
        spiderQuestSPR = new Sprite(spiderQuestTXT);
        spiderQuestSPR.setSize(1000,124);
        rysiuQuestSPR.setSize(1000,124);
        questLogSPR = new Sprite(questLogTXT);
        activeQuest = new ArrayList<Sprite>();
        questDescription = new ArrayList<String>();
        questLogSPR.setSize(1400,800);
questString = new String(" ");
    }

    public static void showLog(){



        questLogSPR.setPosition(playerSprite.getX()-800, playerSprite.getY()-400);
        questLogSPR.draw(batch);
        for (int i = 0; i < activeQuest.size(); i++) {
            activeQuest.get(i).setSize(1000, 62);

            activeQuest.get(i).setPosition(questLogSPR.getX() + 270, questLogSPR.getY() + 650 - (i * 62));
            activeQuest.get(i).draw(batch);
            if (Gdx.input.justTouched()) {
                camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (activeQuest.get(i).getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                    questString = questDescription.get(i);

                }

            }
        }
        Quests.questDescriptionBMP.draw(batch, questString, playerSprite.getX()- 500, playerSprite.getY()- 190);


    }

}
