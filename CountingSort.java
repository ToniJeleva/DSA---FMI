package wftool;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int arr[]=new int []{1,2,1,3,6,3};
		System.out.println(Arrays.toString(sort(arr,7)));
		
	}
	
	public static int[] sort(int[] input, int range){
		int[] output = new int[input.length];
		int[] count = new int[range];
		for (int i = 0; i < input.length; i++) {
			count[input[i]]++;
		}
		for(int i=1;i<=count.length-1;i++){
			count[i]=count[i]+count[i-1];
		}
		for (int i = 0; i < input.length; i++) {
			output[count[input[i]]-1]=input[i]; //-1 because indexing starts from 0
			count[input[i]]--;
		}

		return output;
	}
	
	
	
	
	

}
