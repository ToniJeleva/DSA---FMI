package secondweek;

import java.util.Scanner;

public class Spiral {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		printMatrix(spiralTraversal(n));
	}

	public static int[][] spiralTraversal(int n) {
		int[][] numbers = new int[n][n];
		int enlarger = 1;
		int k = 0;
		while (k != (int) Math.ceil((double) numbers.length / 2)) {
			int i = k;
			int j;
			for (j = k; j < n; j++) {
				numbers[i][j] = enlarger;
				enlarger++;
			}
			for (i = i + 1, j--; i < n; i++) {
				numbers[i][j] = enlarger;
				enlarger++;
			}
			for (--i, j = i - 1; j >= k; j--) {
				numbers[i][j] = enlarger;
				enlarger++;
			}
			for (--i, j++; i >= k + 1; i--) {
				numbers[i][j] = enlarger;
				enlarger++;
			}
			n--;
			k++;
		}
		return numbers;
	}
	
	public static void printMatrix(int [][]numbers){
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				System.out.print(numbers[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
}
