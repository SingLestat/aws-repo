package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Land land = new Land();
        Humans humans = new Humans(Humans.userName());

        while(true) {
            land.printBoard();
            humans = land.playerMove(land.userMovement(), humans);
        }

    }
}
