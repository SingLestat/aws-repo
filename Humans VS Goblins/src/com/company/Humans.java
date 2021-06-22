package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Humans {
    private ArrayList<String> inventory = new ArrayList<>();
    private int health;
    private int str;
    private int def;
    private int speed;
    private String name;

    Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);

    Humans(String name){
        this.name = name;
        health = 100;
        str = 5;
        def = 5;
        speed = 0;
    }

    public static String userName(){
        try{
            System.out.println("Player Name: ");
            return scanner.nextLine();
        }catch (Exception e){
            System.out.println("Invalid");
            userName();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {this.str = str;}

    public int getDef() {
        return def;
    }

    public void setDef(int def) {this.def = def;}

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {this.speed = speed;}

    public void setInventory(String loot) {
        inventory.add(loot);
        if (loot.equals("Potion")){
            setHealth(getHealth() + 10);
        }
        else if(loot.equals("+1 Sword")){
            setStr(getStr()+1);
        }
        else if(loot.equals("+1 Shield")){
            setDef(getDef()+1);
        }
        else if(loot.equals("+1 Shoes")){
            setSpeed(getSpeed()+1);
        }
    }

    public void showInventory(){
        System.out.println("|-Inventory-|");
        for(int c = 0; c < inventory.size(); c++){
            System.out.println("-" + inventory.get(c));
        }
    }

    @Override
    public String toString() {
        return "Humans{" +
                "inventory=" + inventory +
                ", health=" + health +
                ", str=" + str +
                ", def=" + def +
                ", speed=" + speed +
                ", name='" + name + '\'' +
                '}';
    }
}
