package secondweek;

import java.util.Scanner;

public class Strange {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		printMatrix(strangeTraversal(n));

	}

	public static int[][] strangeTraversal(int n) {

		int[][] numbers = new int[n][n];
		int enlarger = 1;
		int k = 0;
		int pom=0;
		while (pom!=3) {
			int i = k;
			int j;
			for (j = k; j < n; j++) {
				numbers[i][j] = enlarger;
				enlarger++;
				System.out.println("i:" + i + "j:" + j);
			}
			for (i = i + 1, j--; i < n; i++) {
				numbers[i][j] = enlarger;
				enlarger++;
				System.out.println("i:" + i + "j:" + j);
			}
			for (i--,j--; i >=1;i--) {
				numbers[i][j] = enlarger;
				enlarger++;
				System.out.println("i:" + i + "j:" + j);
			}
			System.out.println("third ");
			for (i++,j--;j>=0;j--) {
				numbers[i][j] = enlarger;
				enlarger++;
				System.out.println("i:" + i + "j:" + j);
			}
			System.out.println("fourth");
			n=n-2;
			k=k+2;
			pom++;
		}
		return numbers;
	}

	public static void printMatrix(int[][] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
