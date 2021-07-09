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

    Land(int width,int height,int bounds){
        boardWidth=width;
        boardHeight=height;
        boundsRand=bounds;
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
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]);
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
    private Humans encounter(String Loc,Humans player){
        Humans human = player;

        if(Loc.equals(" G") || Loc.equals(" C")){
            Goblins goblin=new Goblins();
            Combat.attack(human,goblin);

            if(goblin.getLoot()!=""){
                human.setInventory(goblin.getLoot());
                human.showInventory();
            }

        }else if(Loc.equals(" T")){
            human.setInventory(Treasure.genItem());
        }

        return human;
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
            if(way.equals("N")){
                //move C up
                playerRowLoc-=1;
            }else if(way.equals("E")){
                //move C right
                playerColLoc+=1;
            }else if(way.equals("S")){
                //move C down
                playerRowLoc+=1;
            }else if(way.equals("W")){
                //move C left
                playerColLoc-=1;
            }else if(way.equals("I")){
                humans.showInventory();
                playerMove(userMovement(),humans);
            }else if(way.equals("C")){
                System.out.println(humans.toString());
                playerMove(userMovement(),humans);
            }

            humans = encounter(board[playerRowLoc][playerColLoc],humans);
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

    public Humans goblinMove(Humans humans){
        int tempRow;
        int tempCol;
        Humans player = humans;

        try{
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    if(board[i][j]==" G"){
                        tempRow=i;
                        tempCol=j;

                        try{
                            if(playerRowLoc<i){
                                if(i-1!=0){
                                    if(board[i-1][j]==" C"){
                                        player = encounter(" C", player);
                                    }
                                    board[i-1][j]=" G";
                                    board[tempRow][tempCol]=" -";
                                }
                            }
                        }catch(Exception e){

                        }
                        try{
                            if(playerRowLoc>i){
                                if(i+1>board.length){
                                    if(board[i+1][j]==" C"){
                                        player = encounter(" C", player);
                                    }
                                    board[i+1][j]=" G";
                                    board[tempRow][tempCol]=" -";
                                }
                            }
                        }catch(Exception e){

                        }
                        try{
                            if(playerColLoc>j){
                                if(j-1!=0){
                                    if(board[i][j-1]==" C"){
                                        player = encounter(" C", player);
                                    }
                                    board[i][j-1]=" G";
                                    board[tempRow][tempCol]=" -";
                                }
                            }
                        }catch(Exception e){

                        }
                        try{
                            if(playerColLoc<j){
                                if(j+1>board[i].length){
                                    if(board[i][j+1]==" C"){
                                        player = encounter(" C", player);
                                    }
                                    board[i][j+1]=" G";
                                    board[tempRow][tempCol]=" -";
                                }
                            }
                        }catch(Exception e){

                        }
                    }
                }
            }
        }catch(IndexOutOfBoundsException exception){

        }
        return player;
    }

    private void winCheck(){
        int goblinCount=0;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==" G"){
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
