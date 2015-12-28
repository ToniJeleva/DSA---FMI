package secondweek;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a name:");
		String input = scanner.next();
		while (!input.equals("q")) {
			System.out.println("Hallo, " + input + "!");
			System.out.print("Please enter a name:");
			input = scanner.next();
		}

	}

}
