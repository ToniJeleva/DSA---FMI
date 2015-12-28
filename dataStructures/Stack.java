package dataStructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.xml.sax.HandlerBase;

import sun.misc.Queue;

public class Stack {
	private SequentialList list;

	public Stack() {
		list = new SequentialList();
	}

	public void push(int element) {
		this.list.add(element);
	}

	public int pop() {
		int element = this.list.get(this.list.size() - 1);
		this.list.removeAt(this.list.size() - 1);
		return element;
	}

	public int size() {
		return list.size();
	}

	public int peek() {
		return this.list.get(this.list.size() - 1);
	}

	@Override
	public String toString() {
		return this.list.toString();
	}

	/*public static int min(Stack st) {
		int min = st.pop();
		int temp;
		Stack tempStack = new Stack();
		tempStack.push(min);
		for (int i = 0; i < st.size(); i++) {
			temp = st.pop();
			if (temp < min) {
				min = temp;
			}
			tempStack.push(temp);
		}
		
		for (int i = 0; i < st.size(); i++) {
			st.push(tempStack.pop());
		}
		
		return min;
	}*/
	
	public static int min(Stack st) {
		int min = Integer.MAX_VALUE;
		Queue middle = new Queue();
		int size = st.size();
		for (int i = 0; i < size; i++) {
			int element = st.pop();
			middle.enqueue(element);
			if (element < min) {
				min = element;
			}
		}
		System.out.println(middle);
		for (int i = 0; i < size; i++) {
			//st.push(Integer.parseInt((String) middle.dequeue()));
		}
		
		return min;
	}
}