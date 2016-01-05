package AVL;

public class Main {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		tree.insert(13);
		tree.insert(17);
		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(3);
		tree.insert(2);
		tree.print();
		tree.delete(2);
		tree.print();

	}

}
