package com.company;

import java.util.Random;

public class Land {
    int boardWidth = 10;
    int boardHeight = 10;
    int boundsRand = 20;
    int playerRowLoc = 0;
    int playerColLoc = 0;

    String [][] board = new String [boardWidth][boardHeight];

    Random random = new Random();

    Land(){
        GenWorld();
    }

    Land(int width, int height, int bounds){
        boardWidth = width;
        boardHeight = height;
        boundsRand = bounds;
        GenWorld();
    }

    public void GenWorld(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int rand = random.nextInt(boundsRand);
                if(rand == 1){
                    board[row][col] = " T";
                }
                else if(rand == 3 || rand == 5){
                    board[row][col] = " G";
                }
                else {
                    board[row][col] = " -";
                }
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
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
    }

    //checks if player lands on a encounter.
    private void encounter(String Loc){
        if (Loc.equals(" G")){
            Goblins goblin = new Goblins();
            //attack
            //Win or Defeated
            //loot
        }
        else if (Loc.equals(" T")){
            //Treasure.addLoot();
        }
    }


    public void playerMove(String way){
        int tempRow = playerRowLoc;
        int tempCol = playerColLoc;

        try{
            if (way.equals("N")){
                //move C up
                playerRowLoc -= 1;
                board[playerRowLoc][playerColLoc].equals(" C");
            }
            else if (way.equals("E")){
                //move C right
                playerColLoc += 1;
                board[playerRowLoc][playerColLoc].equals(" C");
            }
            else if (way.equals("S")){
                //move C down
                playerRowLoc += 1;
                board[playerRowLoc][playerColLoc].equals(" C");
            }
            else if (way.equals("E")){
                //move C left
                playerColLoc -= 1;
                board[playerRowLoc][playerColLoc].equals(" C");
            }
        }
        catch (IndexOutOfBoundsException exception){
                System.out.println("Invalid Move.");
            //reset Loc.
                playerRowLoc = tempRow;
                playerColLoc = tempCol;
            }
        }
    }
