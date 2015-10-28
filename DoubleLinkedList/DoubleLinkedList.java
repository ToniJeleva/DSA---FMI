package dataStructures;

import java.util.HashSet;

import dataStructures.Node;

public class DoubleLinkedList<T extends Comparable<T>> {
	private Node<T> head;
	private Node<T> tail;

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public Node<T> getHead() {
		return head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
			tail = head;
			tail.setLeft(head);
			head.setRight(tail);

		} else {
			tail.setRight(newNode);
			newNode.setLeft(tail);
			tail = newNode;
		}

	}

	public void append(Node<T> newNode) {
		if (head == null) {
			head = newNode;
			tail = head;
			tail.setLeft(head);
			head.setRight(tail);

		} else {
			tail.setRight(newNode);
			newNode.setLeft(tail);
			tail = newNode;
		}
	}

	public int size() {
		int size = 0;
		Node<T> temp = head;
		if (head == tail) {
			size = 1;
		} else {
			while (temp != null) {
				temp = temp.getRight();
				size++;
			}
		}
		return size;
	}

	@Override
	public String toString() {
		String result = "";
		Node temp = head;

		while (temp != null) {
			result += temp.getData() + ", ";
			temp = temp.getRight();
		}
		return result;

	}

	public Node<T> get(int index) {
		Node<T> temp = head;
		if (head == null) {
			return null;
		} else {
			for (int i = 0; i < index; i++) {
				temp = temp.getRight();
			}
		}
		return temp;
	}

	public void insertNode(T element, Node<T> left) {
		Node<T> newNode = new Node<T>(element);
		if (left == null) {
			head.setLeft(newNode);
			newNode.setRight(head);
			head = newNode;
		} else {
			newNode.setLeft(left);
			newNode.setRight(left.getRight());
			left.setRight(newNode);
			newNode.getRight().setLeft(newNode);
		}
	}

	public void insertAfter(T element, int index) { // Inserting after index
		Node<T> newNode = new Node<T>(element);
		Node<T> temp = this.get(index);
		if (temp == tail) {
			newNode.setLeft(temp);
			temp.setRight(newNode);
			tail = newNode;
		} else {
			newNode.setLeft(temp);
			newNode.setRight(temp.getRight());
			temp.setRight(newNode);
			newNode.getRight().setLeft(newNode);
		}
	}

	// Removes the the given node from the list.
	public void removeAt(Node<T> node) {
		if (node == tail) {
			node.getLeft().setRight(null);
			tail = node.getLeft();
		} else if (node == head) {
			node.getRight().setLeft(null);
			head = node.getRight();
		} else {
			Node<T> temp = node.getLeft();
			temp.setRight(node.getRight());
			node.getRight().setLeft(temp);
		}

	}

	// Removes the first element with value @element if such an element exists
	// and returns true. Otherwise, returns false.
	boolean removeElement(T element) {
		for (int i = 0; i < this.size(); i++) {
			Node<T> temp = get(i);
			if (temp.getData().equals(element)) {
				this.removeAt(temp);
				return true;
			}
		}
		return false;
	}

	// Returns a copy of the entire list.
	public DoubleLinkedList<T> copy() {
		DoubleLinkedList<T> copied = new DoubleLinkedList<T>();
		Node<T> temp = head;
		while (temp != null) {
			copied.add(temp.getData());
			temp = temp.getRight();
		}
		return copied;
	}

	// Returns another list that has the same elements as the current list but
	// in reverse order.
	public DoubleLinkedList<T> reverse() {
		DoubleLinkedList<T> reversed = new DoubleLinkedList<T>();
		Node<T> temp = tail;
		while (temp != null) {
			reversed.add(temp.getData());
			temp = temp.getLeft();
		}

		return reversed;
	}

	// Returns true iff the current list is a palindrome.
	public boolean isPalindrome() {
		Node<T> temp1 = head;
		Node<T> temp2 = tail;
		for (int i = 0; i < size() / 2; i++) {
			if (temp1.getData() != temp2.getData()) {
				temp1 = temp1.getRight();
				temp2 = temp2.getLeft();
				return false;
			}
		}
		return true;
	}

	// Inserts all the elements of @other that are between @start and @end.
	void splice(DoubleLinkedList<T> other, Node<T> start, Node<T> end) {
		DoubleLinkedList<T> copied = other.copy();
		Node<T> temp = copied.head;
		int firstIndex = 0;
		int secondIndex = 0;
		while (temp.getData() != start.getData() && (temp != null)) {
			firstIndex++;
			temp = temp.getRight();
		}
		temp = start;
		secondIndex = firstIndex;
		while (temp.getData() != end.getData() && (temp != null)) {
			secondIndex++;
			temp = temp.getRight();
		}
		for (int i = firstIndex; i <= secondIndex; i++) {
			Node<T> newNode = new Node<T>(copied.get(i).getData());
			append(newNode);
		}

	}

	// Splits the list at the specified node(existing one). The nodes to the
	// left @node should remain in the current list.
	// The others are to be returned in another list.
	public DoubleLinkedList<T> splitAt(Node<T> node) {
		DoubleLinkedList<T> splitted = new DoubleLinkedList<T>();
		splitted.append(node);
		tail = node.getLeft();
		node.getLeft().setRight(null);
		node.setLeft(null);
		return splitted;
	}

	// Returns a new list that has the same elements as the current one but no
	// duplicates.

	// Without using HashSet
	public DoubleLinkedList<T> removeDuplicates1() {
		DoubleLinkedList<T> newList = this.copy();
		for (int i = 0; i < newList.size() - 1; i++) {
			for (int j = i + 1; j < newList.size(); j++) {
				if (newList.get(i).equals(newList.get(j)))
					newList.removeAt(get(j));
			}
		}
		return newList;
	}

	// Using HashSet
	public DoubleLinkedList<T> removeDuplicates2() {
		DoubleLinkedList<T> newList = new DoubleLinkedList<T>();
		HashSet<Node<T>> set = new HashSet<>();
		Node<T> temp = head;
		while (temp != null) {
			if (!set.contains(temp)) {
				newList.append(temp);
				set.add(temp);
			}
			temp = temp.getRight();
		}

		return newList;
	}

	public DoubleLinkedList<T> sortedMerge(DoubleLinkedList<T> other) {
		DoubleLinkedList<T> newList = new DoubleLinkedList<T>();
		Node<T> firstNode = head;
		Node<T> secondNode = other.getHead();
		while ((firstNode != null) && (secondNode != null)) {
			if (firstNode.getData().compareTo(secondNode.getData()) > 0) {
				newList.append(secondNode);
				secondNode = secondNode.getRight();
			} else {
				newList.append(firstNode);
				firstNode = firstNode.getRight();
			}
		}
		if (firstNode == null) {
			while (secondNode != null) {
				newList.append(secondNode);
			}
		} else {
			while (firstNode != null) {
				newList.append(firstNode);
			}
		}
		return newList;
	}
}
