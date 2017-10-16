import java.util.Scanner;
import java.util.Random;


public class HiLoGame {
    public static final int MAX_VALUE = 13;
    public static final int MAX_CORRECT = 4;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    public static void main(String[] args) {
        boolean finished = false;
        Random generator = new Random();
        int number = generator.nextInt(MAX_VALUE) + 2;
        int count =0;
        Scanner input;

        while (!finished) {

            if (number == JACK) {
                System.out.println("Your card is Jack");
            } else if (number == QUEEN) {
                System.out.println("Your card is Queen.");
            } else if (number == KING) {
                System.out.println("Your card is King.");
            } else if (number == ACE) {
                System.out.println("Your card is Ace");
            } else {
                System.out.println("Your card is " + number + ".");
            }
            int newNumber = generator.nextInt(MAX_VALUE) + 2;
            System.out.print("Will the next card be higher or lower or equal?(hi/lo/eq) or type 'quit': ");
            input = new Scanner(System.in);
            if (input.hasNext("hi")) {

                if (number < newNumber) {
                    System.out.println("Correct. The card was higher.");
                    count++;
                    number = newNumber;
                } else {
                    if (newNumber == JACK) {
                        System.out.println("You guessed incorrectly. The card was Jack. Game over.");
                        finished = true;
                    } else if (newNumber == QUEEN) {
                        System.out.println("You guessed incorrectly. The card was Queen. Game over.");
                        finished = true;
                    } else if (newNumber == KING) {
                        System.out.println("You guessed incorrectly. The card was King. Game over.");
                        finished = true;
                    } else if (newNumber == ACE) {
                        System.out.println("You guessed incorrectly. The card was Ace. Game over.");
                        finished = true;
                    } else {
                        System.out.println("You guessed incorrectly.The card was " + newNumber + ". Game over.");
                        finished = true;
                    }

                }
            } else if (input.hasNext("lo")) {

                if (newNumber < number) {
                    System.out.println("Correct. The card was lower.");
                    count++;
                    number = newNumber;
                } else {
                    if (newNumber == JACK) {
                        System.out.println("You guessed incorrectly. The card was Jack. Game over.");
                        finished = true;
                    } else if (newNumber == QUEEN) {
                        System.out.println("You guessed incorrectly. The card was Queen. Game over.");
                        finished = true;
                    } else if (newNumber == KING) {
                        System.out.println("You guessed incorrectly. The card was King. Game over.");
                        finished = true;
                    } else if (newNumber == ACE) {
                        System.out.println("You guessed incorrectly. The card was Ace. Game over.");
                        finished = true;
                    } else {
                        System.out.println("You guessed incorrectly.The card was " + newNumber + ". Game over.");
                        finished = true;
                    }
                }
            } else if (input.hasNext("eq")) {
                if (newNumber == number) {
                    System.out.println("Correct. The card was the same");
                    count++;
                    number = newNumber;
                } else {
                    if (newNumber == JACK) {
                        System.out.println("You guessed incorrectly. The card was Jack. Game over.");
                        finished = true;
                    } else if (newNumber == QUEEN) {
                        System.out.println("You guessed incorrectly. The card was Queen. Game over.");
                        finished = true;
                    } else if (newNumber == KING) {
                        System.out.println("You guessed incorrectly. The card was King. Game over.");
                        finished = true;
                    } else if (newNumber == ACE) {
                        System.out.println("You guessed incorrectly. The card was Ace. Game over.");
                        finished = true;
                    } else {
                        System.out.println("You guessed incorrectly.The card was " + newNumber + ". Game over.");
                        finished = true;
                    }
                }
            } else if (input.hasNext("quit")) {
                System.out.println("Goodbye.");
                finished = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            if(count==MAX_CORRECT){
                System.out.println("Congratulations. You won!");
                finished = true;
            }

        }


    }
}