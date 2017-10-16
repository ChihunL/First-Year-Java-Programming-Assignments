import java.util.Scanner;

public class ChuckALuck {
    public static void main(String[] args) {
        System.out.print("How much money do you have in your wallet? : €");
        Scanner input = new Scanner(System.in);
        if (input.hasNextDouble()) {
            double money = input.nextDouble();
            Wallet myWallet = new Wallet();
            myWallet.put(money);
            boolean finished = false;
            while (!finished) {
                if (myWallet.check() != 0) {
                    System.out.println("The types of bets you can place are: Triple, Field, High and Low.");
                    System.out.print("What bet would you like to place?(or enter quit): ");
                    input = new Scanner(System.in);
                    if (input.hasNext("Triple") || input.hasNext("Field")
                            || input.hasNext("High") || input.hasNext("Low")|| input.hasNext("field")
                            || input.hasNext("high") || input.hasNext("low")|| input.hasNext("triple")) {
                        String s = input.next();
                        s.toLowerCase();
                        resolveBet(s, myWallet);
                    } else if (input.hasNext("quit")) {
                        finished = true;
                    } else
                        System.out.println("Invalid input. Please try again.");
                } else {
                    finished = true;
                    System.out.println("You have no money left.");
                }
            }
            if(myWallet.check()>money){
                double moneyMade=myWallet.check()-money;
                System.out.println("You made €"+moneyMade);
            }
            else if(myWallet.check()<money){
                double moneyLost= money-myWallet.check();
                System.out.println("You lost €"+moneyLost);
            }
            else if (myWallet.check()==money)
                System.out.println("You made and lost nothing.");
        } else
            System.out.println("Invalid input. You must enter in a valid figure.");
    }

    public static boolean isTriple(Dice[] dices) {
        int count = 0;
        for (int i = 0; i < dices.length - 1; i++) {
            if (dices[0] == dices[i + 1])
                count++;
        }
        if (count == 2) {
            return true;
        } else
            return false;
    }

    public static int getSum(Dice[] dices) {
        int sum = 0;
        for (int i = 0; i < dices.length; i++) {
            sum += dices[i].topFace();
        }
        return sum;
    }

    public static void resolveBet(String s, Wallet myWallet) {
        System.out.print("How much money would you like to bet(in euros)?: ");
        Scanner myScanner = new Scanner(System.in);
        boolean finished = false;
        while (!finished) {
            if (myScanner.hasNextDouble()) {
                finished = true;
                double bet = myScanner.nextDouble();
                if (myWallet.get(bet)) {
                    Dice[] dices = new Dice[3];
                    System.out.print("The dices are");
                    for (int i = 0; i < dices.length; i++) {
                        dices[i] = new Dice();
                        dices[i].roll();
                        System.out.print(" " + dices[i].topFace());
                    }
                    System.out.println(".");
                    if (s.equals("triple")) {
                        boolean notOneOrSix = true;
                        for (int i = 0; i < dices.length; i++) {
                            if (dices[i].topFace() == 1 || dices[i].topFace() == 6) {
                                notOneOrSix = false;
                            }
                        }
                        if (notOneOrSix && isTriple(dices)) {
                            myWallet.put(bet * 31);
                            System.out.println("You won!");
                        } else
                            System.out.println("Unfortunately you lost.");
                    } else if (s.equals("field")) {
                        int sum = getSum(dices);
                        if (sum < 8 || sum > 12) {
                            myWallet.put(bet * 2);
                            System.out.println("You won!");
                        } else
                            System.out.println("Unfortunately you lost.");
                    } else if (s.equals("high")) {
                        int sum = getSum(dices);
                        if (sum > 10 && !isTriple(dices)) {
                            myWallet.put(bet * 2);
                            System.out.println("You won!");
                        } else
                            System.out.println("Unfortunately you lost.");
                    } else if (s.equals("low")) {
                        int sum = getSum(dices);
                        if (sum < 11 && !isTriple(dices)) {
                            myWallet.put(bet * 2);
                            System.out.println("You won!");
                        } else
                            System.out.println("Unfortunately you lost.");
                    }
                    System.out.println(myWallet.toString());
                } else
                    System.out.println("Sorry you don't have enough money.");
            } else
                System.out.println("Invalid input. Please try again.");
        }
    }
}
