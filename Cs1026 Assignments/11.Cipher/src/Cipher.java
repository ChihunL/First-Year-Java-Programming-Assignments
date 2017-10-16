import java.util.Random;
import java.util.Scanner;

public class Cipher
{
    public static void main(String []args)
    {

        System.out.println("Type in some test you would like to encrypt: ");
        Scanner input = new Scanner(System.in);
        if(input.hasNextLine())
        {
            String text = input.nextLine();
            String lowercaseText = text.toLowerCase();
            char[] textArray = lowercaseText.toCharArray();
            boolean isString = true;
            for (char c : textArray)
            {
                if(!Character.isLetter(c)&&!Character.isWhitespace(c))
                {
                    isString=false;
                }
            }
            if (isString==true)
            {
                char[] cipherArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
                createCipher(cipherArray);

                encrypt(cipherArray, textArray);
                String printEncrypt = new String( textArray );
                System.out.println("Encrypted text: -"+printEncrypt+"-");

                System.out.print("Would like to decrypt the text?(Y/N): ");
                input = new Scanner(System.in);
                if (input.hasNext("Y")||input.hasNext("y"))
                {
                    crypt(cipherArray, textArray);
                    String printDecrypt = new String( textArray );
                    System.out.println( "Decrypted text: -"+printDecrypt+"-");
                }
                else if (input.hasNext("N")||input.hasNext("n"))
                {
                    System.out.print("Goodbye.");
                }
                else
                {
                    System.out.println(" Invalid input. Try again.");
                }

            }
            else
                System.out.print("Invalid input entered. Try again.");
            input.close();
        }
    }
    public static void createCipher(char[] cipherArray)
    {
        randomiseOrder(cipherArray);

    }
    public static void encrypt(char[] cipherArray, char[] textArray)
    {
        char[] characterArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
        if ((textArray!=null)&&(cipherArray!=null))
        {
            for (int index=0; index<textArray.length; index++ )
            {
                boolean finished = false;
                int index2 =0;
                while(!finished)
                {
                    if (textArray[index]==characterArray[index2])
                    {
                        finished = true;
                        textArray[index] = cipherArray[index2];
                    }
                    ++index2;
                }
            }
        }
    }
    public static void crypt(char[] cipherArray, char[] textArray)
    {
        char[] characterArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

        if ((textArray!=null)&&(cipherArray!=null))
        {
            for (int index=0; index<textArray.length; index++ )
            {
                boolean finished = false;
                int index2 =0;
                while(!finished)
                {
                    if (textArray[index]==cipherArray[index2])
                    {
                        finished = true;
                        textArray[index] = characterArray[index2];
                    }
                    ++index2;
                }
            }
        }
    }
    // This randomzise function is a modified version of a function that was provided by Professor Dawson-Howe.
    public static void randomiseOrder( char[] array )
    {
        if (array!=null)
        {
            Random generator = new Random();
            for (int index=0; index<array.length; index++ )
            {
                int otherIndex = generator.nextInt(array.length);
                char temp = array[index];
                array[index] = array[otherIndex];
                array[otherIndex] = temp;
            }
        }
    }
}