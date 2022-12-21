package Logic.Spawners.Areas;

import Mobs.Beach.Crayfish;
import Mobs.Castle.WhiteKnight;
import Mobs.Monster;

import java.util.Random;

import static Logic.Spawners.Spawner.castleBase;

public class Beach {
    public static int spawnedMonsters = 1;
    static double[] checkme = new double[500];

    public static void spawn(int mobsNumber, Monster[] monsterBase) {
        boolean properSpot = false;

        Random random = new Random();

        for (int i = 0; i < mobsNumber; i++) {
            double valueX = random.nextInt(3);
            double valueY = random.nextInt(8);


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

                properSpot = true;



                if (valid < 1 && properSpot) {
                    spawnedMonsters++;
                    monsterBase[i] = new Crayfish(300, 50, valueX-2, valueY, "Crayfish", 60, 50, 1,1);

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

        }
    }
}
