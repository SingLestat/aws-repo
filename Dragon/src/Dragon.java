import java.util.Scanner;

public class Dragon {
    public static Scanner scan = new Scanner(System.in);
    public static int choice;

    public static void main(String[] args) {

        while (1 == 1) {
            if (choice == 1) {
                BadDragon();
                break;
            } else if (choice == 2) {
                GoodDragon();
                break;
            } else {
                Script();
            }
        }
    }

    public static void Script()
    {
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "\n" +
                "and will share his treasure with you. The other dragon\n" +
                "\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "\n" +
                "Which cave will you go into? (1 or 2)");

        choice = scan.nextInt();
    }

    public static void BadDragon(){
        System.out.println("You approach the cave...\n" +
                "\n" +
                "It is dark and spooky...\n" +
                "\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "\n" +
                "Gobbles you down in one bite!");
    }

    public static void GoodDragon(){
        System.out.println("You approach the cave...\n" +
                "\n" +
                "It is dark and spooky...\n" +
                "\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "\n" +
                "Shares his treasure");
    }
}
