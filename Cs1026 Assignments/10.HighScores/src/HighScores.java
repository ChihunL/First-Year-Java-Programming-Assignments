import java.util.Scanner;

public class HighScores
{
    public static void main(String[] args) {
        System.out.println("How many scores do you want to maintain?");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            int numbOfScores = input.nextInt();
            if (numbOfScores >= 0) {
                int[] highScores = new int[numbOfScores];
                initialiseHighScores(highScores);
                boolean done = false;
                while (!done) {
                    System.out.print("Enter a score(or enter exit): ");
                    input = new Scanner(System.in);
                    if (input.hasNextInt()) {
                        int newScore = input.nextInt();
                        if (higherThan(highScores, newScore)) {
                            insertScore(highScores, newScore);
                        }
                        printHighScores(highScores);
                    } else if (input.hasNext("exit")) {
                        printHighScores(highScores);
                        done = true;
                    } else {
                        System.out.println(" Invalid input. Try again.");
                    }
                }
            } else {
                System.out.println(" Invalid input. Try again.");
            }
        } else {
            System.out.println(" Invalid input. Try again.");
        }
        input.close();

    }

    public static void initialiseHighScores (int[]highScores)
    {
        if (highScores !=null)
        {
            for(int index = 0; index< highScores.length; index++)
            {
                highScores[index] = 0;
            }
        }
    }
    public static void printHighScores(int[]highScores)
    {

        if (highScores !=null)
        {
            String printString ="The high scores are ";
            for(int index = 0; index< highScores.length; index++)
            {
                if(highScores[index]!=0) {
                    printString += highScores[index] + ", ";
                }
            }
            printString = printString.substring(0, (printString.length()-2));
            System.out.println(printString);
        }

    }
    public static boolean higherThan(int[]highScores, int newScore)
    {
        boolean ifScoreHigher = false;
        if (highScores !=null)
        {

            int index =0;
            boolean finished = false;

            while (!finished)
            {

                if ( newScore ==0 || index == highScores.length)
                {
                    finished = true;

                }
                else if (newScore > highScores[index])
                {
                    finished = true;
                    ifScoreHigher = true;
                }

                index++;
            }
        }
        return ifScoreHigher;
    }
    public static void insertScore(int[] highScores, int newScore)
    {
        if (highScores !=null)
        {
            boolean finished =false;

            int index = 0;
            int[] temp = highScores.clone();
            while(!finished)
            {
                if(newScore > highScores[index])
                {
                    temp[index] = newScore;
                    for (index = index +1; index < highScores.length; index++)
                    {
                        temp[index] = highScores[index-1];
                    }
                    for (int count =0; count<highScores.length;count++)
                    {
                        highScores[count]=temp[count];
                    }
                    finished = true;
                }
                index++;
            }
        }
    }
}