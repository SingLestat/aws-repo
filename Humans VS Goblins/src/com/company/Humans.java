package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Humans {
    public ArrayList<String> inventory;
    ArrayList<ArrayList<Integer>> location = new ArrayList<>();
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

    public String userMovement(){
        String choice;

        try{
            System.out.println("What direction would you like to move?");
            Land.compassRose();

            choice = scanner.nextLine();

            if (choice.equals("N") || choice.equals("E") || choice.equals("S") || choice.equals("W")){
                return choice;
            }
            System.out.println("Invalid Choice");
            userMovement();

        } catch (Exception e){
            System.out.println("Invalid Choice");
            userMovement();
        }
        return "";
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStr() {
        return str;
    }

    public int getDef() {
        return def;
    }
}
