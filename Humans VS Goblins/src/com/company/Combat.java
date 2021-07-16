package com.company;

import java.util.Random;

public class Combat {
    static Random random = new Random();

    public Combat(){}

    public static void attack(Humans human,Goblins goblin){
        while (goblin.getHealth() >= 0) {
            int playerTurn = random.nextInt(10) + human.getSpeed();
            int goblinTurn = random.nextInt(10);

            if (playerTurn > goblinTurn) {
                goblin.setHealth(goblin.getHealth() - Math.abs(human.getStr() - goblin.getDef()));
            } else {
                human.setHealth(human.getHealth() - Math.abs(goblin.getStr() - human.getDef()));
                deathCheck(human, goblin);
            }
        }
        System.out.println(human.getName() + " killed " + goblin.getName());
        System.out.println(human);
        System.out.println(goblin);
        human.showInventory();
    }

    private static void deathCheck(Humans humans, Goblins goblins){
        if (humans.getHealth() <= 0){
            System.out.println(humans.getName() + " has been killed by " + goblins.getName() + "!!!");
            System.out.println(humans);
            humans.showInventory();
            System.out.println(goblins);
            System.exit(0);
        }
    }
}
