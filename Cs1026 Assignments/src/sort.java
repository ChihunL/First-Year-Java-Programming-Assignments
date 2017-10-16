public class sort {

    public static void sort(int[] array) {

        if (array != null)

        {

            for (int index = 0; index < array.length - 1; index++)

            {

                int minimumIndex = index;

                for (int index2 = index + 1; index2 < array.length; index2++)

                {

                    if (array[index2] < array[minimumIndex])

                        minimumIndex = index2;

                }

                int temp = array[index];

                array[index] = array[minimumIndex];

                array[minimumIndex] = temp;

            }

        }
    }
}




