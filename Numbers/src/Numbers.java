import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        int tries = 0, ranNum, num;
        String name;
        String reset;

        ranNum = rand.nextInt(20) + 1;

        System.out.println("What is your name?");
        name = scan.nextLine();

        while (tries != 6) {
            System.out.println("Well," + name + ", I am thinking of a number between 1 and 20.");
            num = scan.nextInt();


            if (num == ranNum) {
                System.out.println("You got it!\n");
                System.out.println("Would you like to play again? (y or n)\n");
                reset = scan.nextLine();

                if (reset == "y" || reset == "n")
                {
                    tries = 0;
                }
                else {
                    break;
                }

            } else if (num > 20) {
                System.out.println("Your number needs to be between 1 and 20.");
            } else {
                System.out.println("Try again!");
                tries++;
            }
        }
    }
}
