public class TwelveDays
{
    public static void main(String[] args)
    {
        boolean finished = false;
        int dayOfChristmas = 0;
        String day1 = "a Partridge in a Pear Tree.";
        String day2 = "2 Turtle Doves,";
        String day3 = "3 French Hens,";
        String day4 = "4 Calling Birds,";
        String day5 = "5 Golden Rings,";
        String day6 = "6 Geese a Laying,";
        String day7 = "7 Swans a Swimming,";
        String day8 = "8 Maids a Milking,";
        String day9 = "9 Ladies Dancing,";
        String day10 = "10 Lords a Leaping,";
        String day11 = "11 Pipers Piping,";
        String day12 = "12 Drummers Drumming,";
        while (!finished)
        {
            ++dayOfChristmas;
            System.out.print("On the ");
            switch (dayOfChristmas)
            {
                case 1:
                    System.out.print("first");
                    break;
                case 2:
                    System.out.print("second");
                    break;
                case 3:
                    System.out.print("third");
                    break;
                case 4:
                    System.out.print("fourth");
                    break;
                case 5:
                    System.out.print("fifth");
                    break;
                case 6:
                    System.out.print("sixth");
                    break;
                case 7:
                    System.out.print("seventh");
                    break;
                case 8:
                    System.out.print("eighth");
                    break;
                case 9:
                    System.out.print("ninth");
                    break;
                case 10:
                    System.out.print("tenth");
                    break;
                case 11:
                    System.out.print("eleventh");
                    break;
                case 12:
                    System.out.print("twelfth");
                    break;
            }
            System.out.println(" day of Christmas");
            System.out.println("my true love sent to me:");
            switch (dayOfChristmas)
            {
                case 12:
                    System.out.println(day12);
                    finished = true;
                case 11:
                    System.out.println(day11);
                case 10:
                    System.out.println(day10);
                case 9:
                    System.out.println(day9);
                case 8:
                    System.out.println(day8);
                case 7:
                    System.out.println(day7);
                case 6:
                    System.out.println(day6);
                case 5:
                    System.out.println(day5);
                case 4:
                    System.out.println(day4);
                case 3:
                    System.out.println(day3);
                case 2:
                    System.out.println(day2);
                    System.out.print("and ");
                case 1:
                    System.out.println(day1);
                    break;
            }
        }
    }
}