package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Land{
    int boardWidth=10;
    int boardHeight=10;
    int boundsRand=20;
    int playerRowLoc=0;
    int playerColLoc=0;
    static Scanner scanner=new Scanner(System.in);

    String[][] board=new String[boardWidth][boardHeight];

    Random random=new Random();

    Land(){
        GenWorld();
    }

    @Override
    public String toString(){
        return "Land{"+
                "boardWidth="+boardWidth+
                ", boardHeight="+boardHeight+
                ", boundsRand="+boundsRand+
                ", playerRowLoc="+playerRowLoc+
                ", playerColLoc="+playerColLoc+
                ", board="+Arrays.toString(board)+
                '}';
    }

    public void GenWorld(){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                int rand=random.nextInt(boundsRand);
                if(rand==1){
                    board[row][col]=" T";
                }else if(rand==3||rand==5){
                    board[row][col]=" G";
                }else{
                    board[row][col]=" -";
                }
            }
        }

        board[playerRowLoc][playerColLoc]=" C";
    }

    public void printBoard(){
        for(String[] strings : board){
            for(String string : strings){
                System.out.print(string);
            }
            System.out.println();
        }
    }

    //outputs compass
    public static void compassRose(){
        System.out.println("|-----------|");
        System.out.println("|---|-N-|---|");
        System.out.println("|-W-|-|-|-E-|");
        System.out.println("|---|-S-|---|");
        System.out.println("|-----------|");
        System.out.println("|I-Inventory|");
        System.out.println("|C-Character|");
    }

    //checks if player lands on a encounter.
    private void encounter(String Loc,Humans player){

        if(Loc.equals(" G") || Loc.equals(" C")){
            Goblins goblin=new Goblins();
            Combat.attack(player,goblin);

            if(!goblin.getLoot().equals("")){
                player.setInventory(goblin.getLoot());
                player.showInventory();
            }

        }else if(Loc.equals(" T")){
            player.setInventory(Treasure.genItem());
        }

    }

    public String userMovement(){
        String choice;

        try{
            System.out.println("What direction would you like to move?");
            Land.compassRose();

            choice=scanner.nextLine();

            if(choice.equals("N")||choice.equals("E")||choice.equals("S")||choice.equals("W")||choice.equals("I")||choice.equals("C")){
                return choice;
            }
            System.out.println("Invalid Choice");
            userMovement();

        }catch(Exception e){
            System.out.println("Invalid Choice");
            userMovement();
        }
        return "Fail";
    }

    public Humans playerMove(String way,Humans humans){
        int tempRow=playerRowLoc;
        int tempCol=playerColLoc;

        try{
            switch (way) {
                case "N" ->
                        //move C up
                        playerRowLoc-=1;
                case "E" ->
                        //move C right
                        playerColLoc+=1;
                case "S" ->
                        //move C down
                        playerRowLoc+=1;
                case "W" ->
                        //move C left
                        playerColLoc-=1;
                case "I" -> {
                    humans.showInventory();
                    playerMove(userMovement(),humans);
                }
                case "C" -> {
                    System.out.println(humans.toString());
                    playerMove(userMovement(),humans);
                }
            }

            encounter(board[playerRowLoc][playerColLoc],humans);
            board[playerRowLoc][playerColLoc]=" C";
            board[tempRow][tempCol]=" -";
            winCheck();
        }catch(IndexOutOfBoundsException exception){
            System.out.println("Invalid Move.");
            //reset Loc.
            playerRowLoc=tempRow;
            playerColLoc=tempCol;
            playerMove(userMovement(),humans);
        }
        return humans;
    }

    private void winCheck(){
        int goblinCount=0;

        for(String[] strings : board){
            for(String string : strings){
                if(string.equals(" G")){
                    goblinCount++;
                }
            }
        }

        if(goblinCount<=0){
            System.out.println("You Won!!!");
            System.exit(0);
        }
    }
}
