package com.company;

public class Main {

    public static void main(String[] args) {
	GameBoard playerOneBoard = new GameBoard();
	GameBoard playerTwoBoard = new GameBoard();

	boolean end = false;

		System.out.println("Player One:");
		Players playerOne = new Players();
		playerOne.setShips(playerOne, playerOneBoard);

		System.out.println("Player Two:");
		Players playerTwo = new Players();
		playerOne.setShips(playerTwo, playerTwoBoard);

		while (true){
			playerTwoBoard.setBoard(playerOne.battle(playerOne, playerTwoBoard));
			playerOneBoard.setBoard(playerTwo.battle(playerTwo, playerOneBoard));
		}
    }
}
