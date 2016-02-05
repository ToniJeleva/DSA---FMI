package avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

	private AVLNode head;

	public AVLTree() {
		head = null;
	}

	public void insert(int data) {
		head = insert(head, data);
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private int height(AVLNode node) {
		if (node == null)
			return -1;
		return node.height;
	}

	private AVLNode rightRotate(AVLNode x) {
		AVLNode y = x.left;
		x.left = y.right;
		y.right = x;
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), x.height) + 1;
		return y;
	}

	private AVLNode leftRotate(AVLNode x) {
		AVLNode y = x.right;
		x.right = y.left;
		y.left = x;
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.right), x.height) + 1;
		return y;
	}

	private int getBalance(AVLNode node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	private AVLNode insert(AVLNode node, int data) {
		if (node == null) {
			return (new AVLNode(data));
		}

		if (data < node.data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}

		node.height = max(height(node.left), height(node.right)) + 1;

		int balance = getBalance(node);

		if (balance > 1 && data < node.left.data) {
			return rightRotate(node);
		}

		if (balance < -1 && data > node.right.data) {
			return leftRotate(node);
		}

		if (balance > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void delete(int key) {
		head = deleteNode(head, key);
	}

	private AVLNode deleteNode(AVLNode root, int key) {

		if (root == null) {
			return root;
		}

		if (key < root.data) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.data) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.right == null) {
				root = root.left;
			} else {
				AVLNode temp = minValueNode(root.right);
				root.data = temp.data;
				root.right = deleteNode(root.right, temp.data);
			}
		}

		if (root == null) {
			return root;
		}

		root.height = max(height(root.left), height(root.right)) + 1;

		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.left) >= 0) {
			return rightRotate(root);
		}

		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if (balance < -1 && getBalance(root.right) <= 0) {
			return leftRotate(root);
		}

		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	private AVLNode minValueNode(AVLNode node) {
		AVLNode current = node;

		while (current.left != null)
			current = current.left;

		return current;
	}

	private void inorder(AVLNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}

	public AVLNode searchRecursively(int key) {
		return searchRecursively(key, head);
	}

	private AVLNode searchRecursively(int key, AVLNode currentNode) {
		if (currentNode.data == key) {
			return currentNode;
		} else if (currentNode.data > key) {
			return searchRecursively(key, currentNode.left);
		} else {
			return searchRecursively(key, currentNode.right);
		}
	}

	public int size() {
		return countNodes(head);
	}

	private int countNodes(AVLNode currentNode) {
		if (currentNode == null)
			return 0;
		else {
			int counter = 1;
			counter += countNodes(currentNode.left);
			counter += countNodes(currentNode.right);
			return counter;
		}
	}

	private void BFS_Tree(AVLNode root) {
		Queue<AVLNode> q = new LinkedList<AVLNode>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			AVLNode n = (AVLNode) q.remove();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}

	public void print() {
		BFS_Tree(head);
		System.out.println();
		printBinaryTree(head, 0);
	}

	private void printBinaryTree(AVLNode root, int level) {
		if (root == null)
			return;
		printBinaryTree(root.right, level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++)
				System.out.print("|\t");
			System.out.println("|-------" + root.data);
		} else
			System.out.println(root.data);
		printBinaryTree(root.left, level + 1);
	}

}
