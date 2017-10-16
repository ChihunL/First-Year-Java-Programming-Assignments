import java.util.Scanner;
import javax.swing.JOptionPane;

public class DayOfTheWeek
{
    public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
    public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
    public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
    public static final int DAYS_IN_MOST_MONTHS = 31;
    public static final int NUMBER_OF_MONTHS = 12;

    public static void main(String []args)
    {

        String inputInt = JOptionPane.showInputDialog("Please type in date in the form: dd/mm/yyyy");
        Scanner input = new Scanner(inputInt);
        input.useDelimiter("/");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();
        input.close();
        String numberEnding = numberEnding(day);
        String dayOfTheWeek = dayOfTheWeek(day, month, year);
        String monthName = monthName(month);

        if (validDate(day, month, year))
        {
            JOptionPane.showMessageDialog(null, "" + dayOfTheWeek + ", " + day + numberEnding + " " + monthName +" " + year);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid date entered");
        }
    }
    // This function was taken from code written by Professor Kenneth Dawson-Howe
    public static boolean validDate( int day, int month, int year)
    {
        return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&
                (day >= 1) && (day <= daysInMonth( month, year )));
    }
    // This function was taken from code written by Professor Kenneth Dawson-Howe
    public static int daysInMonth( int month, int year )
    {
        int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
        switch (month)
        {
            case 2:
                numberOfDaysInMonth = isLeapYear( year ) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
                        DAYS_IN_FEBRUARY_NORMALLY;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
                break;
            default:
                numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
                break;
        }
        return numberOfDaysInMonth;
    }
    // This function was taken from code written by Professor Kenneth Dawson-Howe
    public static boolean isLeapYear( int year )
    {
        return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
    }


    public static String numberEnding(int day)
    {
        String numEnd = "";

        if ((day == 1) || (day == 21) || (day == 31))
        {
            numEnd = "st";
        }
        else if ((day == 2) || (day == 22))
        {
            numEnd = "nd";
        }
        else if ((day ==3) || (day == 13))
        {
            numEnd = "rd";
        }
        else
            numEnd = "th";

        return  numEnd;
    }
    public static String monthName(int month)
    {
        String monthName = "";
        switch(month)
        {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "Febuary";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }
    public static String dayOfTheWeek(int day, int month, int year)
    {
        String dayOfTheWeek = "" ;
        double dayInNumberDouble =0;
        if (month <= 2)
        {
            year--;
        }
        int y = year % 100;
        int c =  year / 100;
        dayInNumberDouble = (day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + Math.floor(y/4) + Math.floor(c/4) - (2*c));
        int dayInNumberInt = (int)Math.floor(dayInNumberDouble);
        dayInNumberInt = dayInNumberInt % 7;
        if (dayInNumberInt<0)
        {
            dayInNumberInt += 7;
        }
        switch(dayInNumberInt)
        {
            case 0:
                dayOfTheWeek = "Sunday";
                break;
            case 1:
                dayOfTheWeek = "Monday";
                break;
            case 2:
                dayOfTheWeek = "Tuesday";
                break;
            case 3:
                dayOfTheWeek = "Wednesday";
                break;
            case 4:
                dayOfTheWeek = "Thursday";
                break;
            case 5:
                dayOfTheWeek = "Friday";
                break;
            case 6:
                dayOfTheWeek = "Saturday";
                break;
        }
        return dayOfTheWeek;
    }
}