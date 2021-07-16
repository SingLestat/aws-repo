package com.company;

import static com.company.Players.getPlacement;
import static com.company.Players.setShipCoordinates;

public class GameBoard{
    private String[][] board = new String[10][10];

    public GameBoard(){
        makeBoard();
    }

    private void makeBoard(){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                if(row==0){board[row][col] = col + " ";}
                else if(col==0){board[row][col] = row + " ";}
                else {board[row][col] = "~ ";}
            }
        }
    }

    public void printBoard(){
        for(String[] strings : board){
            for(String string : strings){
                System.out.print(string);
            }
            System.out.println();
        }
    }
//setting ship
    public void setShip(GameBoard gameBoard,Ship ship){
        String placement;
        int[] coordinates;

        System.out.println("Enter the coordinates for the " + ship.getName() + ":");
        coordinates = setShipCoordinates();
        placement = getPlacement();

        try{
            if(placement.equals("h")){
                for(int col=coordinates[1]; col < ship.getSize()+coordinates[1]; col++){
                    if(!gameBoard.board[coordinates[0]][col].equals("~ ")){
                        System.out.println("Invalid Choice h");
                        setShip(gameBoard, ship);
                        break;
                    }else{
                        gameBoard.board[coordinates[0]][col]=ship.getShipChar();
                    }
                }
            }
            if(placement.equals("v")){
                for(int row=coordinates[0]; row < ship.getSize()+coordinates[0]; row++){
                    if(!gameBoard.board[row][coordinates[1]].equals("~ ")){
                        System.out.println("Invalid Choice v");
                        setShip(gameBoard, ship);
                        break;
                    }else{
                        gameBoard.board[row][coordinates[1]]=ship.getShipChar();
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Invalid Choice" + e);
            setShip(gameBoard, ship);
        }

    }

    public String[][] getBoard(){
        return board;
    }

    public void setBoard(String[][] board){
        this.board=board;
    }
}
