package Logic.Spawners;

import Mobs.*;
import Mobs.Cemetery.Skeleton;
import Mobs.Dungeon.Imp;
import Mobs.StartingZone.Mutant;
import Mobs.StartingZone.Vampire;

import java.util.Random;

public class SpawnFloor2 {
    public static void SPAWN(int mobsNumber, Monster[] monsterBase) {
        double checkme[] = new double[1000];
        Random random = new Random();
int spawnedMonstersFloor2 = 1;

        for (int i = 0; i < mobsNumber; i++) {
            double valueX = random.nextInt(8) + 1;
            double valueY = random.nextInt(8) + 1;


            checkme[i] = (valueX * 100 + valueY);

            double mobType = random.nextInt(100);
            int valid = 0;

            for (int j = 0; j < i; j++) {

                if (checkme[i] == checkme[j]) {
                    valid = 1;
                    break;
                } else {

                }

            }

                if (valid < 1) {
                    spawnedMonstersFloor2++;
                    if (mobType < 21) {
                        monsterBase[i] = new Mutant(500, 70, valueX, valueY, "mutant", 60, 80, 6, 2);
                    } else if (mobType < 41 && mobType > 20) {
                        monsterBase[i] = new Imp(400, 80, valueX, valueY, "imp", 50, 20, 5, 2);
                    }
                    //
                    //        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
                    //
                    else if (mobType < 61 && mobType > 40) {
                        monsterBase[i] = new Skeleton(400, 50, valueX, valueY, "szkielet", 100, 20, 5, 2);
                    } else if (mobType < 81 && mobType > 60) {
                        monsterBase[i] = new Vampire(600, 70, valueX, valueY, "elite wampir", 160, 50, 3,2 );
                    }
                    else if (mobType > 80){
                        monsterBase[i] = new Mutant(700, 90, valueX, valueY, "elite mutant", 200, 70, 5, 2);
                    }
                    int emptyslots = mobsNumber;


                    //
                    // Jakbyś testował spawner to włącz sobie poniższe printy,
                    // wyświetlą info o każdym wygenerowanym potworku
                    //
                /*    System.out.println(monsterBase[i].getHp());
                    System.out.println(monsterBase[i].getDmg());
                    System.out.println("Rodzaj potwora: ");
                    System.out.println(monsterBase[i].getName());
                    System.out.println("Koordy:");
                    System.out.println(monsterBase[i].getX());
                    System.out.println(monsterBase[i].getY());
                    System.out.println();
                    System.out.println(spawnedMonstersFloor2);*/
                } else {

                    i = i - 1;
                }

        }
    }
}
