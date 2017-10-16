import java.util.Scanner;

public class IncrementalStatistics
{
    public static void main(String[] args)
    {
        double numberOfNumbers = 0;
        double previousAverage ;
        double previousVariance = 0;
        double averageNumber;
        boolean finished = false;

        System.out.println("This program computes the average and variance of all numbers entered.");
        System.out.println("Enter a number (or type 'exit'): ");
        Scanner inputScanner = new Scanner(System.in);
        if (inputScanner.hasNextDouble())
        {
            double firstNumber = inputScanner.nextDouble();
            System.out.println("So far the average is " + firstNumber+ " and the variance is " + previousVariance);
            previousAverage = firstNumber;
            numberOfNumbers++;
            while (!finished)
            {
                System.out.println("Enter another number (or type 'exit'):");
                if (inputScanner.hasNextDouble())
                {
                    double newNumber = inputScanner.nextDouble();
                    ++numberOfNumbers;
                    averageNumber = previousAverage + ((newNumber - previousAverage)/numberOfNumbers);
                    double variance = ((previousVariance*(numberOfNumbers-1)) + (newNumber - previousAverage) * (newNumber - averageNumber))/ numberOfNumbers ;
                    previousAverage = averageNumber;
                    previousVariance = variance;
                    System.out.println("So far the average is " + averageNumber + " and the variance is " + variance );
                }
                else if (inputScanner.hasNext("exit"))
                {
                    System.out.println("Goodbye.");
                    finished = true;
                }
                else
                {
                    System.out.println("Not a valid whole number. Please restart the program.");
                    inputScanner.close();

                }
            }
        }
        else if (inputScanner.hasNext("exit"))
        {
            System.out.println("Goodbye.");
        }
        else
        {
            System.out.println("Not a valid number. Please restart the program.");
        }
        inputScanner.close();
    }
}
