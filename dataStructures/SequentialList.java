package dataStructures;

import java.util.HashSet;

public class SequentialList {
	private static final int INITIAL_SIZE = 2;
    private static final double SIZE_MULTIPLIER = 2;
    
    private int[] array;
    private int elementCount;
    
    public SequentialList() {
        this.array = new int[INITIAL_SIZE];
        this.elementCount = 0;
    }
    
    public void add(int element) {
        this.tryGrow();
        this.array[this.elementCount] = element;
        this.elementCount++;
    }
    
    public void insert(int element, int index) {
        if (index >= this.elementCount) {
            this.add(element);
            return;
        }
        this.tryGrow();
        for (int i = this.elementCount - 1; i >= index ; i--) {
            this.array[i + 1] = this.array[i]; 
        }
        this.array[index] = element;
        this.elementCount++;
    }
    
    public void removeAt(int index) {
        for (int i = index; i < this.elementCount - 1; i++) {
            this.array[i] = this.array[i + 1]; 
        }
        this.elementCount--;
    }
    
    public int get(int index)
    {
        return this.array[index];
    }
    
    public int size() {
        return this.elementCount;
    }
    
    public int indexOf(int element) {
        for (int i = 0; i < this.elementCount; i++) {
            if (this.array[i] == element)
                return i;
        }
        return -1;
    }
    
    private void tryGrow() {        
        if (this.elementCount >= this.array.length) {
            int[] newArray = new int[(int)(this.array.length * SIZE_MULTIPLIER)];
            for (int i = 0; i < this.array.length; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
    }
    
  // Removes the element at the specified index. If @index is negative, 
 // it should remove the element at list.Length + index (in other words, count from the end).
    public  void removeAtIndex(int index){
    	if(index<0)
    	index=elementCount+index;
    		for (int i = index; i < this.elementCount-1; i++) {
				array[i]=array[i+1];
		}

		elementCount--;
	}

	// Removes the first element with value @element if such an element exists
	// and returns true. Otherwise, returns false.
	public boolean removeElement(int element) {
		for (int i = 0; i < elementCount; i++) {
			if (array[i] == element) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}

	// Returns a copy of the entire list.
	public SequentialList copy() {
		SequentialList copied = new SequentialList();
		for (int i = 0; i < elementCount; i++) {
			copied.add(array[i]);

		}
		return copied;
	}

	// Returns another list that has the same elements as the current list but
	// in reverse order.
	public SequentialList reverse(){
		SequentialList reversed = new SequentialList();
		for (int i = elementCount-1; i >=0; i--) {
			reversed.add(array[i]);

		}
		return reversed;
	}
	
	// Returns true if the current list and @other have the same size, elements and are in the same order.
	public boolean equals(SequentialList other){
		for (int i = 0; i < this.elementCount; i++) {
			if(array[i]!=other.get(i)){
				return false;
			}
		}
		return true;
	}
	
	// Returns true iff the current list is a palindrome.
	public boolean isPalindrome(){
		for (int i = 0,j=elementCount-1; i < elementCount/2; i++,j--) {
			if(array[i]!=array[j])
				return false;
		}
		return true;                      //could be done return equals(reverse()), but that's faster
	}
	
	//merging two sequential list in one, resulting in new list
	 public SequentialList merge(SequentialList other){      
		 SequentialList newSqList = new SequentialList();
		 newSqList=this.copy();
		 for (int i = 0; i < other.size(); i++) {
			newSqList.add(other.get(i));
		}
		 return newSqList;
	 }
	 
	// Inserts all the elements of @other whose indices are >= @start and < @end into the current one.
	public void splice(SequentialList other, int start, int end){
		for (int i = start; i < end; i++) {
			this.insert(other.get(i), i);
		}
	}
	
	// Returns a new list that has the same elements as the current one but no duplicates.
	public SequentialList removeDuplicates() {
		SequentialList newSqList = this.copy();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < this.size(); i++) {
			if (!set.contains(get(i))) {
				newSqList.add(get(i));
				set.add(get(i));
			}

		}

		return newSqList;
	}
	 
	public SequentialList sortedMerge(SequentialList other){
		SequentialList newSqList = new SequentialList();
		int i=0;
		int j=0;
		while ((i != this.size()) && (j != other.size())) {
			if (this.get(i)>other.get(j)) {
				newSqList.add(other.get(j));
				j++;
			} else {
				newSqList.add(this.get(i));
				i++;
			}
		}
		if (i == this.size()) {
			while (j != other.size()) {
				newSqList.add(other.get(j));
				j++;
			}
		} else {
			while (i != this.size()) {
				newSqList.add(this.get(i));
				i++;
			}
		}
		return newSqList;
	}
	
	public SequentialList splitAt(int index) {
		SequentialList newSqList = new SequentialList();
		for (int i = index; i < this.size(); i++) {
			newSqList.add(this.get(i));
		}
		for (int i = index; i < this.size(); i++) {
			this.removeAt(i);
			;
		}
		return newSqList;
	}

}
