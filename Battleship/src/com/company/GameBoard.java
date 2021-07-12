package com.company;

import java.util.Scanner;

import static com.company.Players.getPlacement;
import static com.company.Players.setShipCoordinates;

public class GameBoard{
    private String[][] board = new String[10][10];
    Scanner scanner = new Scanner(System.in);

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
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
//setting ship
    public Object setShip(GameBoard gameBoard,Ship ship){
        String placement;
        int[] coordinates = {0,0};
        GameBoard tempBoard = gameBoard;

        System.out.println("Enter the coordinates for the " + ship.getName() + ":");
        coordinates = setShipCoordinates();
        placement = getPlacement();

        try{
            if(placement.equals("h")){
                for(int col=coordinates[1]; col < ship.getSize()+coordinates[1]; col++){
                    if(tempBoard.board[coordinates[0]][col] != "~ "){
                        System.out.println("Invalid Choice h");
                        setShip(gameBoard, ship);
                        break;
                    }else{
                        tempBoard.board[coordinates[0]][col]=ship.getShipChar();
                    }
                }
            }
            if(placement.equals("v")){
                for(int row=coordinates[0]; row < ship.getSize()+coordinates[0]; row++){
                    if(tempBoard.board[row][coordinates[1]] != "~ "){
                        System.out.println("Invalid Choice v");
                        setShip(gameBoard, ship);
                        break;
                    }else{
                        tempBoard.board[row][coordinates[1]]=ship.getShipChar();
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Invalid Choice" + e);
            setShip(gameBoard, ship);
        }

        return tempBoard;
    }

    public String[][] getBoard(){
        return board;
    }

    public void setBoard(String[][] board){
        this.board=board;
    }
}
