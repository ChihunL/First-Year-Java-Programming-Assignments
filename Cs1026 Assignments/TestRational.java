import java.util.Scanner;

public class TestRational {
    public static void main(String[] args) {
        Rational r1 = getUserInput();
        Rational r2 = getUserInput();
        String r1String = r1.toString();
        String r2String = r2.toString();
        Rational r3 = r1.add(r2);
        String r3String = r3.toString();
        System.out.println(r1String + "+" + r2String +"="+ r3String);
        r3 = r1.subract(r2);
        r3String = r3.toString();
        System.out.println(r1String + "-" + r2String +"="+ r3String);
        r3 = r1.multiply(r2);
        r3String = r3.toString();
        System.out.println(r1String + "*" + r2String +"="+ r3String);
        r3 = r1.divide(r2);
        r3String = r3.toString();
        System.out.println(r1String + "÷" + r2String +"="+ r3String);
        boolean isEqual = r1.equals(r2);
        System.out.println("Are the two rational numbers "+r1String + " and " + r2String +" equal: "+ isEqual);
        boolean isLess = r1.isLessThan(r2);
        System.out.println("Is "+r1String + " less than " + r2String +": "+ isLess);
        r1.simplify();
        r2.simplify();
        r1String = r1.toString();
        r2String = r2.toString();
        System.out.println("The two fractions simplified are " + r1String +" and "+ r2String);
    }


    public static Rational getUserInput() {
        boolean finished = false;
        Rational r1 = new Rational(0,1);
        while (!finished) {
            System.out.println("Enter in a rational number in the form of a fraction(Eg 5/6): ");
            Scanner input = new Scanner(System.in);
            if (input.hasNext()) {
                String string = input.next();
                Scanner inputString = new Scanner(string);
                inputString.useDelimiter("/");
                if (inputString.hasNextInt()) {
                    int numerator = inputString.nextInt();
                    if (inputString.hasNextInt()) {
                        int denominator = inputString.nextInt();
                        if (denominator != 0) {
                            r1 = new Rational(numerator, denominator);
                            return r1;
                        } else
                            System.out.println("0 cannot be denominator.");
                    }
                    else
                        System.out.println("Invalid input. Please try again.");
                }
                else
                    System.out.println("Invalid input. Please try again.");
            }
            else
                System.out.println("Invalid input.");
        }
        return r1;

    }
}
