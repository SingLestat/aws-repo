package com.company;

import java.util.Random;

public class Treasure {
    private static int number;
    private static String[] loot = {"Potion","+1 Sword","+1 Shield","+1 Shoes","Magnifying Glass"};

    protected static Random random = new Random();

    public Treasure(){
        number = random.nextInt(4);
    }

    public static String genItem(){
        return loot[random.nextInt(loot.length)];
    }

    public static void addLoot(Humans humans){
        humans.inventory.add(genItem());
    }
}
