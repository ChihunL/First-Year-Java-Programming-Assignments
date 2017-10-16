public class TriangularStars
{
    /*MAX_VALUE_FOR_NUMBER is calculated by equating the formula for triangle number(n*(n-1)/2) to the Integer.MAX_VALUE. The values for n is found
    and the minus n value is discarded. The remaining n value is MAX_VALUE_FOR_NUMBER*/
    public static final int MAX_VALUE_FOR_NUMBER = 65535;
    public static void main(String[] args)
    {
        int number = 1;
        int triangleNumber=0;
        while(number< MAX_VALUE_FOR_NUMBER)
        {
            triangleNumber +=number;
            ++number;
            if(isStarNumber(triangleNumber))
            {
                System.out.println(triangleNumber);
            }
        }
    }
    public static boolean isStarNumber(int number )
    {
        int index = 1;
        int starNumber = 0;
        while(number > starNumber && starNumber>=0)
        {
            starNumber = determineStarNumber( index );
            index++;
        }
        if (number == starNumber)
        {
            return true;
        }
        else return false;
    }
    public static int determineStarNumber(int index )
    {

        return (6*index)*(index-1)+1;
    }
}
