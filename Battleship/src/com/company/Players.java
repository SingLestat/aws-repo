package com.company;

import java.util.Scanner;

public class Players{
    Scanner scan = new Scanner(System.in);
    Carrier carrier = new Carrier();
    Battleship battleship = new Battleship();
    Destroyer destroyer = new Destroyer();
    Submarine submarine = new Submarine();
    PatrolBoat patrolBoat = new PatrolBoat();
    GameBoard boardView = new GameBoard();

    private int hits = 0;

    private String playerName;

    public Players(){
        setPlayerName(enterPlayerName());
    }

    private String enterPlayerName(){
        System.out.println("Enter Player Name: ");
        return scan.nextLine();
    }

    public void setShips(Players player, GameBoard gameBoard){
        System.out.println(player.getPlayerName() + ", lets set your board.");
        gameBoard.printBoard();
        System.out.println("please enter the coordinates for your ships");
        gameBoard.setShip(gameBoard, carrier);
        gameBoard.printBoard();
        gameBoard.setShip(gameBoard, battleship);
        gameBoard.printBoard();
        gameBoard.setShip(gameBoard, destroyer);
        gameBoard.printBoard();
        gameBoard.setShip(gameBoard, submarine);
        gameBoard.printBoard();
        gameBoard.setShip(gameBoard, patrolBoat);
        gameBoard.printBoard();
    }

    public String[][] battle(Players player, GameBoard opponentBoard){
        int[] coordinates=new int[2];
        String[][] opponentBoardTemp = opponentBoard.getBoard();
        String[][] playerBoardTemp = boardView.getBoard();

        try{
            System.out.println("What coordinates would " + player.getPlayerName() + " like to hit.");
            boardView.printBoard();
            System.out.println("Please enter x coordinate:");
            coordinates[0] =scan.nextInt();
            System.out.println("Please enter y coordinate:");
            coordinates[1]=scan.nextInt();

            if(opponentBoardTemp[coordinates[0]][coordinates[1]] != "~ "){
                System.out.println("HIT");
                player.setHits(player.getHits()+1);
                playerBoardTemp[coordinates[0]][coordinates[1]] = "H ";
                opponentBoardTemp[coordinates[0]][coordinates[1]] = "H ";
                checkWinner(player);
            }
            else {
                System.out.println("MISS");
                playerBoardTemp[coordinates[0]][coordinates[1]] = "M ";

            }

            boardView.setBoard(playerBoardTemp);
            return opponentBoardTemp;
        }
        catch(Exception e){
            System.out.println("Invalid Choice");
            battle(player, opponentBoard);
        }

        boardView.setBoard(playerBoardTemp);
        return opponentBoardTemp;
    }

    private void checkWinner(Players player){
        if(player.getHits() == 17){
            System.out.println(player.getPlayerName() + " has won!");
            System.exit(0);
        }
    }

    public int getHits(){
        return hits;
    }

    public void setHits(int hits){
        this.hits=hits;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerName(String playerName){
        this.playerName=playerName;
    }
}
