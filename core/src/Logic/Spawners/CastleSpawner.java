package Logic.Spawners;

import Mobs.Castle.WhiteKnight;
import Mobs.Monster;
import Mobs.Spider;
import Mobs.StartingZone.Goblin;
import Mobs.StartingZone.Mutant;
import Mobs.StartingZone.Vampire;
import Mobs.StartingZone.Werewolf;

import java.util.Random;

import static Logic.Spawners.Spawner.castleBase;

public class CastleSpawner {
    public static int spawnedMonsters = 1;
    static double[] checkme = new double[500];
    public static void spawn(int mobsNumber, Monster[] monsterBase) {
        boolean properSpot = false;

        Random random = new Random();

        for (int i = 0; i < mobsNumber; i++) {
            double valueX = random.nextInt(4) + 108;
            double valueY = random.nextInt(10) + 111;


            checkme[i] = (valueX * 100 + valueY);
            //
            // Potwory nie pojawią się na polach 2,5 -- 5,5 i tak dalej, żeby gracz miał trochę swojego miejsca
            //
            double mobType = random.nextInt(100);
            int valid = 0;

            for (int j = 0; j < i; j++) {

                if (checkme[i] == checkme[j]) {
                    valid = 1;
                    break;
                } else {

                }

            }
            if (((valueX > 5 || valueX < 3) || (valueY > 5 || valueY < 3))) {
                properSpot = true;
                if (valueX == 110) {
                    if (valueY != 114 && valueY != 115){
                        properSpot = true;
                    }
                    else {
                        properSpot = false;
                    }

                }


                if (valid < 1 && properSpot) {
                    spawnedMonsters++;
                    castleBase[i] = new WhiteKnight(500, 60, valueX, valueY, "White Knight", 100, 5, 1);

                    int emptyslots = mobsNumber;


                    //
                    // Jakbyś testował spawner to włącz sobie poniższe printy,
                    // wyświetlą info o każdym wygenerowanym potworku
                    //
                   /* System.out.println(monsterBase[i].getHp());
                    System.out.println(monsterBase[i].getDmg());
                    System.out.println("Rodzaj potwora: ");
                    System.out.println(monsterBase[i].getName());
                    System.out.println("Koordy:");
                    System.out.println(monsterBase[i].getX());
                    System.out.println(monsterBase[i].getY());
                    System.out.println("Piętro: " + monsterBase[i].getFloor());
                    System.out.println();
                    System.out.println(spawnedMonsters);*/

                } else {

                    i = i - 1;
                }
            } else {

                i = i - 1;
            }
        }
    }
}
