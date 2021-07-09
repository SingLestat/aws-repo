package com.company;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

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

    public Object setShip(GameBoard gameBoard,Ship ship){
        String placement;
        int[] coordinates;

        System.out.println("Enter the coordinates for the " + ship.getName() + ":");
        coordinates = getCoordinates();
        placement = getPlacement();

        try{
            if(placement.equals("h")){
                for(int col=coordinates[1]; col < ship.getSize()+1; col++){
                    if(gameBoard.board[coordinates[0]][col] != "~ "){
                        System.out.println("Invalid Choice");
                        setShip(gameBoard, ship);
                    }
                    gameBoard.board[coordinates[0]][col] = ship.getShipChar();
                }
            }
            else if(placement.equals("v")){
                for(int row=coordinates[0]; row < ship.getSize()+1; row++){
                    if(gameBoard.board[row][coordinates[1]] != "~ "){
                        System.out.println("Invalid Choice");
                        setShip(gameBoard, ship);
                    }
                    gameBoard.board[row][coordinates[1]] = ship.getShipChar();
                }
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Invalid Choice");
            setShip(gameBoard, ship);
        }

        return gameBoard;
    }

    private int[] getCoordinates(){
        int[] coordinates=new int[2];

        try{
            System.out.println("Please enter x coordinate:");
            coordinates[0] =scanner.nextInt();
            System.out.println("Please enter y coordinate:");
            coordinates[1]=scanner.nextInt();

            if(coordinates[0] >= 10 || coordinates[1] >= 10){
                System.out.println("Invalid Choice");
                getCoordinates();
            }
        }
        catch(Exception e){
            System.out.println("Invalid Choice");
            getCoordinates();
        }

        return coordinates;
    }

    private String getPlacement(){
        String placement;

        try{
            System.out.println("Place horizontally or vertically (h or v)?");
            placement=scanner.next();
            if(placement.equals("h")||placement.equals("v")){
                return placement;
            }
            else{
                System.out.println("Invalid Choice:else");
                getPlacement();
            }
        }
        catch(Exception e){
            System.out.println("Invalid Choice" + e);
            getPlacement();
        }

        placement = "";
        return placement;
    }

    public String[][] getBoard(){
        return board;
    }

    public void setBoard(String[][] board){
        this.board=board;
    }
}
