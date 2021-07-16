package com.company;

import java.util.Random;

public class Treasure {
    private static final String[] loot = {"Potion","+1 Sword","+1 Shield","+1 Shoes"};

    protected static Random random = new Random();

    public Treasure(){
        random.nextInt(4);
    }

    public static String genItem(){
        return loot[random.nextInt(loot.length)];
    }
}
