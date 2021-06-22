package com.company;

import java.util.Random;

public class Combat {
    static Random random = new Random();

    public Combat(){};

    public static Object attack(Humans human, Goblins goblin){
        while (goblin.getHealth() >= 0) {
            int playerTurn = random.nextInt(10) + human.getSpeed();
            int goblinTurn = random.nextInt(10);

            if (playerTurn > goblinTurn) {
                goblin.setHealth(goblin.getHealth() - (human.getStr() - goblin.getDef()));
            } else {
                human.setHealth(human.getHealth() - (goblin.getStr() - human.getDef()));
                deathCheck(human, goblin);
            }
        }
        System.out.println(human.getName() + " killed " + goblin.getName());
        System.out.println(human.toString());
        System.out.println(goblin.toString());
        human.showInventory();
        return human;
    }

    private static void deathCheck(Humans humans, Goblins goblins){
        if (humans.getHealth() <= 0){
            System.out.println(humans.getName() + " has been killed by " + goblins.getName() + "!!!");
            System.out.println(humans.toString());
            humans.showInventory();
            System.out.println(goblins.toString());
            System.exit(0);
        }
    }
}
