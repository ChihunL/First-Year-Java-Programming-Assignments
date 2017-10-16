import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {

        In in0 = new In("record.txt");
        HarnessRecords myRecords = new HarnessRecords(in0);
        String make, climbingInstructor,member;
        int modelNumber;

        make = getMake();
        modelNumber = getModelNumber();
        climbingInstructor = getInstructor();
        Harness myHarness = new Harness(make, modelNumber, climbingInstructor);
        myRecords.addHarness(myHarness);

        boolean finished = false;
        while (!finished) {
            System.out.print("Enter in a model number you want removed: ");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                myRecords.removeHarness(input.nextInt());
                finished = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.println("Would you like to check a harness.(yes/no)");
        Scanner input = new Scanner(System.in);
        if(input.hasNext("yes")) {
            modelNumber = getModelNumber();
            climbingInstructor = getInstructor();
            myRecords.checkHarness(climbingInstructor, modelNumber);
        }

        System.out.println("Would you like to loan a harness.(yes/no)");
        input = new Scanner(System.in);
        if(input.hasNext("yes")) {
            member = getMember();
            myRecords.loanHarness(member);
        }

        System.out.println("Would you like to return a harness.(yes/no)");
        if(input.hasNext("yes")) {
            modelNumber = getModelNumber();
            myRecords.returnHarness(modelNumber);
        }


    }
    private static String getMake() {
        boolean finished = false;
        String make ="";
        while (!finished) {
            System.out.print("Enter in the make: ");
            Scanner input = new Scanner(System.in);
            if (input.hasNext()) {
                make = input.next();
                finished = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return make;
    }
    private static int getModelNumber() {
        int modelNumber = 0;
        boolean finished = false;
        while (!finished) {
            System.out.print("Enter in the model number: ");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                modelNumber = input.nextInt();
                finished = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return modelNumber;
    }
    private static String getInstructor() {
        boolean finished = false;
        String instructor ="";
        while (!finished) {
            System.out.print("Enter in the name of the climbing instructor who last checked the harness: ");
            Scanner input = new Scanner(System.in);
            if (input.hasNext()) {
                instructor = input.next();
                finished = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return instructor;
    }
    private static String getMember() {
        boolean finished = false;
        String member ="";
        while (!finished) {
            System.out.print("Enter in the name of the member who is being lent the harness: ");
            Scanner input = new Scanner(System.in);
            if (input.hasNext()) {
                member = input.next();
                finished = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return member;
    }



}
