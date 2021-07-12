import java.util.Arrays;
import java.util.Scanner;

public class Main extends GenWord{
    private static int tries;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean weArePlaying = true;
        while(weArePlaying){
            System.out.println("Lets Start Playing Hangman");
            char[] randomWordToGuess= getWord().toCharArray();
            int amountOfGuesses = randomWordToGuess.length; //total tries to guess a word.
            char[] playerGuess= new char[amountOfGuesses]; // "_ _ _ _ _ _ _ _"

            // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            Arrays.fill(playerGuess,'_');

            boolean wordIsGuessed = false;
            tries = 0;

            while(!wordIsGuessed && tries != amountOfGuesses){
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d amount of tries left.\n", amountOfGuesses-tries);
                System.out.println("Enter a single character: ");
                char input = scanner.next().charAt(0);
                tries++;
                hangmanImage(randomWordToGuess.length);

                if(input == '-'){
                    wordIsGuessed = true;
                    weArePlaying = false;
                } else{
                    for(int i=0; i<randomWordToGuess.length; i++){
                        if(randomWordToGuess[i] == input){
                            playerGuess[i] = input;
                        }
                    }

                    if(isTheWordGuessed(playerGuess)){
                        wordIsGuessed = true;
                        System.out.println("Congratulations");
                    }
                }
            } /* End of wordIsGuessed */
            if(!wordIsGuessed){
                System.out.println("You ran out of guesses.");
            }

        }/*End of We Are Playing*/

        System.out.println("Game Over!");
    }

    public static void print(char[] array){
        for(char c : array){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            System.out.print(c+" ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array){
        boolean condition = true;
        for(char c : array){
            if(c=='_'){
                condition=false;
                break;
            }
        }
        return condition;
    }
    public static void hangmanImage(int wordLength) {
        if (tries == 1) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (tries == 2) {
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (tries == 3) {
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (tries == Math.abs(wordLength/2)) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (tries == 5) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (tries == 6) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (tries == wordLength) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
    }
}
