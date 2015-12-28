package dataStructures;

public class Num {

	public static void main(String[] args) {
		float x1;
		float x2;
		x1 = (float) ((-3000.01 - Math.sqrt(3000.01 * 3000.01 - 12)) / 2);
		x2 = (float) ((-3000.01 + Math.sqrt(3000.01 * 3000.01 - 12)) / 2);

		double x_1;
		double x_2;
		x_1 =( Math.sqrt(3000.01 * 3000.01 - 12)-3000.01);
		System.out.println(-0.00199/2);
		x_2 = (-3000.01 + Math.sqrt(3000.01 * 3000.01 - 12)) / 2;

		System.out.println("float:" + x1 + " " + x2);
		System.out.println("double:" + x_1 + " " + x_2);
		

	}

}
