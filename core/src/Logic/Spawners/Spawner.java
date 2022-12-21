package Logic.Spawners;

import Mobs.Monster;
import Mobs.Spider;
import Mobs.StartingZone.Goblin;
import Mobs.StartingZone.Mutant;
import Mobs.StartingZone.Vampire;
import Mobs.StartingZone.Werewolf;

import java.util.Random;

public class Spawner {

    public static Monster[] monsterBase = new Monster[50];
    public static Monster[] forestBase = new Monster[50];
    public static Monster[] monsterBase2 = new Monster[50];
    public static Monster[] monsterBase3 = new Monster[50];
    public static Monster[] monsterBase4 = new Monster[50];
    public static Monster[] monsterBase5 = new Monster[50];
    public static Monster[] monsterBase6 = new Monster[50];
    public static Monster[] castleBase = new Monster[50];
    public static Monster[] beachBase = new Monster[50];
    public static int spawnedMonsters = 1;
    static double[] checkme = new double[500];

    public static void spawn(int mobsNumber, Monster[] monsterBase) {
        boolean properSpot = false;

        Random random = new Random();

        for (int i = 0; i < mobsNumber; i++) {
            double valueX = random.nextInt(8) + 1;
            double valueY = random.nextInt(8) + 1;


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
                if (valueY == 4) {
                    if (valueX != 6 && valueX != 7 && valueX != 8){
                        properSpot = true;
                    }
                    else {
                        properSpot = false;
                    }

                }
                if (valueX == 7){
                    properSpot = false;
                }
                if (valueX == 8 && valueY == 3){
                    properSpot = false;
                }

                if (valid < 1 && properSpot) {
                    spawnedMonsters++;
                    if (mobType < 21) {
                        monsterBase[i] = new Goblin(120, 50, valueX, valueY, "goblin", 40, 80, 2, 1);
                    } else if (mobType < 41 && mobType > 20) {
                        monsterBase[i] = new Spider(130, 40, valueX, valueY, "pająk", 20, 1, 1);
                    }
                    //
                    //        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
                    //
                    else if (mobType < 61 && mobType > 40) {
                        monsterBase[i] = new Werewolf(300, 60, valueX, valueY, "wilkołak", 60, 60, 4, 1);
                    } else if (mobType < 81 && mobType > 60) {
                        monsterBase[i] = new Vampire(210, 70, valueX, valueY, "wampir", 50, 80, 3, 1);
                    } else if (mobType > 80) {
                        monsterBase[i] = new Mutant(250, 80, valueX, valueY, "mutant", 60, 120, 5, 1);
                    }
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
