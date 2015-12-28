package secondweek;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class ReverseSquareRootCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		printSquareRoots(readNumbers(n));

	}

	public static int[] readNumbers(int n) {
		Scanner scan = new Scanner(System.in);
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scan.nextInt();
		}
		return numbers;
	}

	public static void printSquareRoots(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			double result = Math.sqrt(numbers[i]);
			DecimalFormat df = new DecimalFormat("#.000000");
			System.out.println(df.format(result));
		}

	}

}
