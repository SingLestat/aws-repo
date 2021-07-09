package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Goblins {
    private int health;
    private int str;
    private int def;
    private String name;
    private String loot = "";

    Random rand = new Random();

    public Goblins(){
        health = rand.nextInt(50);
        str = rand.nextInt(5);
        def = rand.nextInt(5);
        name = GenWord.getWord();

        if (rand.nextInt(5) == 4){
            loot.equals(Treasure.genItem());
        }
    }

    //For testing and Bosses
    public Goblins(int health, int str, int def){
        this.health = health;
        this.str = str;
        this.def = def;
        name = GenWord.getWord();

        if (rand.nextInt(5) == 4){
            loot.equals(Treasure.genItem());
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public String getLoot() {
        return loot;
    }

    @Override
    public String toString() {
        return "Goblins{" +
                "health=" + health +
                ", str=" + str +
                ", def=" + def +
                ", name='" + name + '\'' +
                ", loot='" + loot + '\'' +
                '}';
    }
}
