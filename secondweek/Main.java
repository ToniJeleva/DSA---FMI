package secondweek;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int []arr = new int[n];
		SortUtils.init(arr);
		SortUtils.print(arr);
		SortUtils.selectionSort(arr);
		SortUtils.print(arr);

	}

}
