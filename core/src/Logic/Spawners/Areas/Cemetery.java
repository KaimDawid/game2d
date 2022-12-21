package Logic.Spawners.Areas;

import Mobs.Cemetery.*;
import Mobs.Dungeon.Imp;
import Mobs.Monster;
import Mobs.Spider;
import Mobs.StartingZone.Mutant;
import Mobs.StartingZone.Vampire;
import Mobs.Wolf;

import java.util.Random;

public class Cemetery {
    static int spawnedMonstersFloor2 = 1;

    public static Monster[] cemeteryBase = new Monster[50];

    public static void SPAWN(int mobsNumber, Monster[] monsterBase) {

        double checkme[] = new double[1000];
        Random random = new Random();


        for (int i = 0; i < mobsNumber; i++) {
            double valueX = random.nextInt(8) + 9;
            double valueY = random.nextInt(8) + 9;


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
                    monsterBase[i] = new Ghost(800, 110, valueX, valueY, "duch", 200, 14, 1);
                } else if (mobType < 41 && mobType > 20) {
                    monsterBase[i] = new Ghoul(1000, 100, valueX, valueY, "ghoul", 250, 8, 1);
                }
                //
                //        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
                //
                else if (mobType < 61 && mobType > 40) {
                    monsterBase[i] = new Skeleton(900, 70, valueX, valueY, "szkielet", 160, 40, 6, 1);
                } else if (mobType < 81 && mobType > 60) {
                    monsterBase[i] = new LumpOfFlesh(2000, 90, valueX, valueY, "góra mięsa", 400, 9, 1 );
                }
                else if (mobType > 80){
                    monsterBase[i] = new HeadlessHorseman(1500, 160, valueX, valueY, "jezdziec bez glowy", 600, 7, 10);
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
