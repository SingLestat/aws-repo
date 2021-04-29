import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main extends GenWord{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean weArePlaying = true;
        while(weArePlaying){
            System.out.println("Lets Start Playing Hangman");
            char randomWordToGuess[] = getWord().toCharArray();
            int amountOfGuesses = randomWordToGuess.length; //total tries to guess a word.
            char playerGuess[] = new char[amountOfGuesses]; // "_ _ _ _ _ _ _ _"

            for(int i=0; i<playerGuess.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
                playerGuess[i] =  '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while(!wordIsGuessed && tries != amountOfGuesses){
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d ammount of tries left.\n", amountOfGuesses-tries);
                System.out.println("Enter a single character: ");
                char input = scanner.next().charAt(0);
                tries++;

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

    public static void print(char array[]){
        for(int i=0; i<array.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array){
        boolean condition = true;
        for(int i=0; i<array.length; i++){
            if(array[i] == '_'){
                condition = false;
            }
        }
        return condition;
    }
}
