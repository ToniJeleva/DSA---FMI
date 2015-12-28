package dataStructures;


public class Equation {

	public static void main(String[] args) {
		double D;                                   //x^2+3000.1x+3=0
		D=Math.pow(3000.1, 2)+4*3;
		double x1=(-3000.1+Math.pow(D, 0.5))/2;
		double x2=(-3000.1-Math.pow(D, 0.5))/2;
		System.out.println("x1:"+x1+" "+"x2:"+x2);
		
		/*float D;                                   //x^2+3000.1x+3=0
		D=Math.pow(3000.1, 2)+4*3;
		float x1=(-3000.1+Math.pow(D, 0.5))/2;
		double x2=(-3000.1-Math.pow(D, 0.5))/2;
		System.out.println("x1:"+x1+" "+"x2:"+x2);*/
	}

}
