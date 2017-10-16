import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

public class GraphOfErat {

	public static void main(String[] args) {

		System.out.print("Enter int >=2 : ");

		Scanner input = new Scanner(System.in);
		if (input.hasNextInt()) {
			int valueN = input.nextInt();
			if (valueN < 2)
			{
				System.out.println("Invalid input. Please try again with a number equal or greater than 2.");
			} else {
				if(valueN<463) {

					StdDraw.setCanvasSize(720, 720);
					int[] sigma = sieve(valueN);
				}
				else{
					System.out.println("Sorry. The number you have entered is too big to display graphically. The max value is 462");
				}
			}
		} else {
			System.out.println("Invalid input. Try again.");
		}
		input.close();

	}

	public static int[] sieve(int valueN) {
		int[] sigma = createSequence(valueN);
		int prime_count = 0;
		displayNumbers2ToN(valueN);
		for (int number = 2; number * number <= valueN; number++) {
			if (sigma[number] > 0) {

				++prime_count;

				for (int index = number; index * number <= valueN; index++) {
					displayComposite(sigma[number * index], prime_count, valueN);
				}
				sigma = crossOutHigherMultiples(sigma, number);

			}
		}
		prime_count = 0;
		{
			Font arial_italic_10pt = new Font("Arial", Font.ITALIC, 10);
			StdDraw.setFont(arial_italic_10pt);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(.9, .998, "Prime Numbers:");


			for (int count = 2; count <= valueN; count++) {
				if (sigma[count] > 0) {
					++prime_count;
					displayPrime(count, prime_count);

				}
			}


			return sigma;
		}
	}

	public static void displayNumber(int n, Color c, int valueN) {

		if(n>0) {
			StdDraw.setPenColor(c);
			int noOfColumns = (int) Math.sqrt(valueN) + 1;
			double space = .035;
			double boxSize = .015;
			String number = "" + n;
			StdDraw.filledSquare(0.0001 + (((n - 1) % noOfColumns) * space), 0.998 - (((n - 1) / noOfColumns) * space), boxSize);
			Font arial_italic_10pt = new Font("Arial", Font.ITALIC, 10);
			StdDraw.setFont(arial_italic_10pt);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(0.0001 + (((n - 1) % noOfColumns) * space), 0.998 - (((n - 1) / noOfColumns) * space), number);
		}
		StdDraw.show(0);
	}

	public static void displayNumbers2ToN(int valueN) {

		Color gray = StdDraw.LIGHT_GRAY;
		for (int index = 2; index <= valueN; index++) {
			displayNumber(index, gray, valueN);
		}

	}

	public static void displayComposite(int m, int prime_count, int valueN) {
		StdDraw.show(50);
		Color [] compositeColor ={ Color.LIGHT_GRAY,Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.CYAN
				,Color.GREEN, Color.RED, Color.YELLOW, Color.PINK,Color.LIGHT_GRAY};
		displayNumber(m, compositeColor[prime_count], valueN);

	}

	public static void displayPrime(int p, int prime_count) {
		StdDraw.show(0);
		int noOfColumns = 5;
		String number = "" + p;
		Font arial_italic_10pt = new Font("Arial", Font.ITALIC, 10);
		StdDraw.setFont(arial_italic_10pt);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.8 + (((prime_count - 1) % noOfColumns) * .05), 0.95 - (((prime_count - 1) / noOfColumns) * .05), number);
		StdDraw.show(0);
		
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
				if (sigma[number * index] > 0) {
					sigma[number * index] *= -1;
				}
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