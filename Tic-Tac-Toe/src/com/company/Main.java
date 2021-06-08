package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[] board;
    static String turn;
    static int choice;

    public static void main(String[] args) {
        board = new String[9];
        turn = "O";

        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();

        System.out.println(
                "O will play first.");

        while (winner == null) {

            if (turn.equals("X")){
                choice = Player();
            }
            else if (turn.equals("O")){
                choice = AIplayer();
            }

            if (board[choice - 1].equals(
                    String.valueOf(choice))) {
                board[choice - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }

        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                    "Congratulations! " + winner
                            + "'s have won! Thanks for playing.");
        }

    }

    static int Player(){
        int numInput = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a slot number to place X in:");

        try {
            numInput = in.nextInt();
            if (!(numInput > 0 && numInput <= 9)) {
                System.out.println(
                        "Invalid input; re-enter slot number:");
                Player();
            }
        }
        catch (InputMismatchException e) {
            if (turn.equals("X")){
                System.out.println(
                        "Invalid input; re-enter slot number:");
                Player();
            }
            else if (turn.equals("O")){
                AIplayer();
            }
        }

        return numInput;
    }

    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.
        if (turn.equals("X")){
            System.out.println(
                    turn + "'s turn; enter a slot number to place "
                            + turn + " in:");
        }
        else if (turn.equals("O")){
            System.out.println(turn + "'s turn;");
        }

        return null;
    }
    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    static int AIplayer(){
        Random random = new Random();
        int choice = random.nextInt(8);
        System.out.println(choice);

        return choice + 1;
    }
}
