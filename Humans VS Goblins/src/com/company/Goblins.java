package com.company;

import java.util.Random;

public class Goblins {
    private int health;
    private final int str;
    private final int def;
    private final String name;
    private final String loot = "";

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
