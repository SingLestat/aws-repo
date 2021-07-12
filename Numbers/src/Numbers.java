import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();

    public static int tries = 0, ranNum, num;
    public static String name;

    public static void main(String[] args) {

        ranNum = rand.nextInt(20) + 1;

        System.out.println("What is your name?");
        name = scan.nextLine();

        while (true) {
            if (tries != 6){
                gameLoop();
                tries++;
            }
            else {
                setReset();
            }
        }
    }

    public static void gameLoop(){
        System.out.println("Well," + name + ", I am thinking of a number between 1 and 20.");

        num = scan.nextInt();
        
        if (num == ranNum) {
            System.out.println("You got it!\n");
            setReset();
        } else if (num > 20) {
            System.out.println("Your number needs to be between 1 and 20.");
        } else {
            System.out.println("Try again!");
        }
    }

    public static void setReset(){
        System.out.println("Want to play again?(Y or N)");
        String Choice = scan.nextLine();
        if (Choice.equals("Y")){
            tries = 0;
        }
        if (Choice.equals("N")){
            System.exit(0);
        }
        else {
            System.out.println("Invalid Choice.");
            setReset();
        }
    }
}
