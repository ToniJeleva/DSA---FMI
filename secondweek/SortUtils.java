package secondweek;

public class SortUtils {
	
	public static void init(int [] a){
		for (int i = 0; i < a.length; i++) {
			a[i]=(int)(Math.random()*100)+1;
			System.out.println(a[i]);
		}
	}
	
	public static void print(int [] a){
		System.out.print("[");
		for (int i = 0; i < a.length-1; i++) {
			System.out.print(a[i]+", ");
		}
		System.out.println(a[a.length-1]+"]");
	}
	
	private static void swap(int []a,int i, int j){
		int temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public static void sortBubble(int[] a){
		boolean swaped=true;
		while(swaped){
			swaped=false;
			for (int i = 0; i < a.length; i++) {
				
			}
		}
			
		
		
	}
	
	public static void selectionSort(int[] a){
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]<a[j])
					swap(a,i,j);
			}
		}
	}

	

}
