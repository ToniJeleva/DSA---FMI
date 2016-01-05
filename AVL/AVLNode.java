package AVL;

class AVLNode {

	/*The class, members and constructor are package-private,
	 * because we only need them for the AVLTree class and 
	 * the code is clearer without getters and setters
	 */
	
	AVLNode right;
	AVLNode left;
	int data;
	int height;

	AVLNode(int n) {
		right = null;
		left = null;
		data = n;
		height = 0;
	}

}
