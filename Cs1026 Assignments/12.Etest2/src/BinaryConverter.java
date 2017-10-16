import java.util.Scanner;

public class BinaryConverter
{
    public static void main(String[] args)
    {
        boolean finished = false;
        int newNumber;
        while(!finished)
        {
            System.out.print("Enter a number (or enter quit):  ");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt())
            {
                newNumber = input.nextInt();
                if (newNumber>=0)
                {
                    String binaryNumber =  convertToBinaryString(newNumber);

                    System.out.print("The number "+newNumber+" in binary is "+ binaryNumber);
                    if (isBinaryPalindromic(newNumber))
                    {
                        System.out.println(" which is palindromic." );
                    }
                    else
                    {
                        System.out.println(" which is not palindromic." );
                    }

                }
                else
                {
                    System.out.println(" Invalid input. Try again.");
                }
            }
            else if (input.hasNext("quit"))
            {
                System.out.println("Goodbye.");
                finished = true;
            }
            else
            {
                System.out.println(" Invalid input. Try again.");
            }
        }

    }
    public static String convertToBinaryString(int number)
    {
        int remainder = 0;
        String binaryNumber = "";
        while (number>0)
        {
            remainder = number%2;
            number = number/2;

            binaryNumber = remainder + binaryNumber;


        }
        return binaryNumber;
    }
    public static String reverseBinaryNumber(int number)
    {
        String reverseBinary = "";

        int remainder = 0;
        while (number>0)
        {
            remainder = number%2;
            number = number/2;

            reverseBinary = reverseBinary + remainder;
        }

        return reverseBinary;

    }
    public static boolean isBinaryPalindromic(int newNumber)
    {
        boolean palindromic = false;
        String reverseBinary = reverseBinaryNumber(newNumber);
        String newNumberBinary = convertToBinaryString(newNumber);
        if(reverseBinary.equals(newNumberBinary))
        {
            palindromic = true;
        }
        return palindromic;

    }

}