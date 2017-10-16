import java.util.Random;

public class randomiseOrder {


    public static void randomiseOrder( int[] array )

    {

        if (array!=null)

        {

            Random generator = new Random();

            for (int index=0; index<array.length; index++ )

            {

                int otherIndex = generator.nextInt(array.length);

                int temp = array[index];

                array[index] = array[otherIndex];

                array[otherIndex] = temp;

            }

        }

    }

}
