package Logic.Drop;

import Data.Quests.CysiuQuest;
import Data.Quests.Quests;
import lombok.Getter;
import lombok.Setter;

import static Logic.Drop.Miscelanous.gatheredWood;
import static Logic.Drop.Miscelanous.woodLogs;
import static com.badlogic.gdx.math.MathUtils.random;
import static com.mygdx.game.Frontend.Fonts.topText;
import static com.mygdx.game.GameApp.Dawid;
import static com.mygdx.game.GameApp.touchPoint;

@Getter
@Setter
public class Wood {


        public int X;
        public int Y;
        public int dropAmount;

        public Wood(int x, int y, int dropAmount) {
            X = x;
            Y = y;
            this.dropAmount = dropAmount;
        }

        public static void Spawn(){
            for (int i = 0; i < 30; i++) {
                int X = random.nextInt(8);
                int Y = random.nextInt(8) + 8;
                int dropAmount = random.nextInt(2) + 2;
                woodLogs.add(new Logic.Drop.Wood(X,Y,dropAmount));
            }



        }

        public static void check(){

            if (CysiuQuest.questActive) {

                for (int i = 0; i < woodLogs.size(); i++) {
                    if (woodLogs.get(i).getX() == Dawid.getX() && woodLogs.get(i).getY() == Dawid.getY()) {
                        gatheredWood = gatheredWood + woodLogs.get(i).getDropAmount();
                        if (woodLogs.get(i).getDropAmount() > 0) {
                            topText = "You've found " + woodLogs.get(i).getDropAmount() + " wood logs";
                            Quests.sideDescription = "Wood: " + gatheredWood + "/20";
                        }
                        woodLogs.get(i).setDropAmount(0);

                    }

                }
            }
        }



}
