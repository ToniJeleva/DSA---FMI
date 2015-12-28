package dataStructures;

import java.util.LinkedList;

public class MainLinked {

	public static void main(String[] args) {
		/*
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		DoubleLinkedList<Integer> list2 = new DoubleLinkedList<Integer>();
		DoubleLinkedList<Integer> list3 = new DoubleLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(4);
		Node<Integer> one = new Node<Integer>(3);
		Node<Integer> two = new Node<Integer>(5);
		Node<Integer> three = new Node<Integer>(6);
		Node<Integer> four = new Node<Integer>(6);
		list2.append(one);
		list2.append(two);
		list2.append(three);
		list3=list2.sortedMerge(list);
		System.out.println(list3.size());*/

		/*SequentialList newList1 = new SequentialList();
		SequentialList newList2 = new SequentialList();
		SequentialList newList3 = new SequentialList();
		
			newList1.add(1);
			newList1.add(3);
			newList1.add(5);
		
			newList2.add(2);
			newList2.add(4);
			newList2.add(6);
		
			newList3=newList1.sortedMerge(newList2);
		
		for (int i = 0; i < newList3.size(); i++) {
			System.out.println(newList3.get(i));
		}*/
		
		Stack stack = new Stack();
		stack.push(2);
		stack.push(1);
		stack.push(1);
		stack.push(3);
		System.out.println(stack.peek());
		//System.out.println(Stack.min(stack));
	}
}