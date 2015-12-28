package secondweek;

public class dd {
	 public static void main(String[] args) {
         
	        int[] array = new int[]{6,5,4,3,5};
	                
	        int element;
	        int size=array.length;
	        int br=0;
	                
	        for (int i=1;i<size;i++){
	                for (int j=size-1;j>=i;j--){ 
	                        if (array[j-1]>array[j]){
	                                element = array[j-1];
	                                array[j-1]=array[j];
	                                array[j]=element;
	                                br++;
	                        }
	                }       
	        }
	        for (int i=0;i<size;i++){
	                System.out.print(" "+array[i]);
	                System.out.println(br);
	        }
	                        
	    }
	}