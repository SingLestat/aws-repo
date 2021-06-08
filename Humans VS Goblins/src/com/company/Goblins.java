package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Goblins {
    private int health;
    private int str;
    private int def;
    private String name;
    private String loot;
    ArrayList<ArrayList<Integer>> location = new ArrayList<>();

    Random rand = new Random();

    public Goblins(){
        health = rand.nextInt(20);
        str = rand.nextInt(9);
        def = rand.nextInt(9);

        if (rand.nextInt(5) == 4){
            loot.equals(Treasure.genItem());
        }
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getStr() {
        return str;
    }

    public int getDef() {
        return def;
    }
}
