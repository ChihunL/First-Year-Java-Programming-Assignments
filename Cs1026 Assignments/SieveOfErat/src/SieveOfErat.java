import java.util.Scanner;

public class SieveOfErat {
    public static void main(String[] args) {
        System.out.print("Enter int >=2 : ");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            int valueN = input.nextInt();
            if (valueN < 2) {
                System.out.println("Invalid input. Please try again with a number equal or greater than 2.");
            } else {
                int[] sievedSequence = sieve(valueN);
                String printSeq = notCrossedOUtSubseqToString(sievedSequence);
                System.out.println(printSeq);
            }
        } else {
            System.out.println("Invalid input. Try again.");
        }
        input.close();
    }

    public static int[] createSequence(int valueN) {
        int[] seq = new int[valueN + 1];
        for (int index = 2; index <= valueN; index++) {
            seq[index] = index;
        }
        return seq;
    }

    public static int[] crossOutHigherMultiples(int[] sigma, int number) {
        if (sigma != null) {

            for (int index = number; number * index <= sigma.length - 1; index++) {
                if (sigma[number * index] > 0)
                    sigma[number * index] *= -1;

            }

        }
        return sigma;
    }

    public static int[] sieve(int valueN) {
        int[] sigma = createSequence(valueN);
        String printSigma = sequenceToString(sigma);
        System.out.println(printSigma);
        for (int number = 2; number * number <= valueN; number++) {
            if (sigma[number] > 0) {
                sigma = crossOutHigherMultiples(sigma, number);
                printSigma = sequenceToString(sigma);
                System.out.println(printSigma);
            }
        }
        return sigma;
    }

    public static String sequenceToString(int[] sigma) {
        String sequence = "";
        boolean firstNumber = true;
        if (sigma != null) {

            for (int index = 0; index <= sigma.length - 1; index++) {
                int number = sigma[index];
                if (sigma[index] != 0) {
                    if (firstNumber) {
                        sequence += index;
                        firstNumber = false;
                    } else {
                        if (number > 0)
                            sequence += ", " + index;
                        else
                            sequence += ", [" + index + "]";
                    }
                }
            }
        }
        return sequence;
    }

    public static String notCrossedOUtSubseqToString(int[] sigma) {
        String sequence = "";
        boolean firstNumber = true;
        if (sigma != null) {

            for (int index = 0; index <= sigma.length - 1; index++) {
                int number = sigma[index];
                if (sigma[index] != 0)
                    if (firstNumber) {
                        sequence += index;
                        firstNumber = false;
                    } else if (number > 0) {
                        sequence += ", " + index;
                    }
            }
        }
        return sequence;
    }

}