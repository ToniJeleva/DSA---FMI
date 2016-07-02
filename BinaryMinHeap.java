package algo;

public class BinaryMinHeap {
	
	private int[] data;
	private int size;
	
	public BinaryMinHeap(){
		data = new int[0];
		size=0;
	}
	
	public boolean isEmpty(){
		if(size==0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getMinimum(){
		if(isEmpty()){
			throw new RuntimeException("The heap is empty.");
		}else{
			return data[0];
		}
	}
	
	public int getLeftIndex(int position){
		return 2*position+1;
	}
	
	public int getRightIndex(int position){
		return 2*position+2;
	}
	
	public int getParentIndex(int position){
		return (position-1)/2;
	}
	
	public void insert(int element){
		if(size == data.length){
			int[] temp = new int[size*2+1];
			for (int i = 0; i < size; i++) {
				temp[i]=data[i];
			}
			data=temp;
		}
			data[size]=element;
			heapify(size);
			size++;
		
	}

	private void heapify(int position) {
		if (position != 0) {
			int parentIndex = getParentIndex(position);
			if (data[parentIndex] > data[position]) {
				int temp = data[parentIndex];
				data[parentIndex] = data[position];
				data[position] = temp;
				heapify(parentIndex);
			}
		}
	}
	
	public void removeMin(){
		if(size==0){
			throw new RuntimeException("The heap is empty.");
		}else{
			data[0]=data[size-1];
			size--;
			if(size>0){
				heapifyDown(0);
			}
		}
	}
	
	private void heapifyDown(int position){
		int minIndex;
		int leftChildIndex = getLeftIndex(position);
        int rightChildIndex = getRightIndex(position);
        if (rightChildIndex >= size) {
              if (leftChildIndex >= size)
                    return;
              else
                    minIndex = leftChildIndex;
        } else {
              if (data[leftChildIndex] <= data[rightChildIndex])
                    minIndex = leftChildIndex;
              else
                    minIndex = rightChildIndex;
        }
        if (data[position] > data[minIndex]) {
              int temp = data[minIndex];
              data[minIndex] = data[position];
              data[position] = temp;
              heapifyDown(minIndex);
        }
  }
	
	
	@Override
	public String toString(){
		System.out.println(size);
		String str="";
		for (int i = 0; i < size-1; i++) {
			str+=data[i]+" ";
		}
		str+=data[size-1];
		return str;
	}
	
	
	public static void main(String[] args){
		BinaryMinHeap heap = new BinaryMinHeap();
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.removeMin();
		System.out.println(heap.toString());
	}

}
