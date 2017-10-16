public class SquareAges
{
    public static final int MAX_AGE = 123;
    public static final int CURRENT_YEAR = 2016;

    public static void main(String[] args)
    {
        for(int age = 0; age <= MAX_AGE; age++)
        {
            int squaredAge = age * age;
            boolean isSquareAge = (squaredAge > (CURRENT_YEAR - (MAX_AGE-age)))
                    && (squaredAge < (CURRENT_YEAR + (MAX_AGE-age)));
            if(isSquareAge)
            {
                System.out.print(String.format("There is possibly a person living today who had/will have an age which, "
                        + "is the square of the year they are living in. That age is %d and the corresponding "
                        + "year %dAD" , age, squaredAge));
            }
        }
    }
}