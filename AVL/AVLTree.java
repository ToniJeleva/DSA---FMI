package AVL;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
	
	private AVLNode head;
	
	public AVLTree(){
		head = null;
	}
	
	 public void insert(int data)
     {
         head = insert(head,data);
     }
	
	private int max(int a, int b)
	{
	    return (a > b)? a : b;
	}
	
	private int height(AVLNode node)
	{
	    if (node == null)
	        return -1;
	    return node.height;
	}
	
	private AVLNode rightRotate(AVLNode x)
    {
        AVLNode y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = max( height( x.left ), height( x.right ) ) + 1;
        y.height = max( height( y.left ), x.height ) + 1;
        return y;
    }
	
	private AVLNode leftRotate(AVLNode x)
    {
        AVLNode y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = max( height( x.left ), height( x.right ) ) + 1;
        y.height = max( height( y.right ), x.height ) + 1;
        return y;
    }
	
	private int getBalance(AVLNode node)
	{
	    if (node == null)
	        return 0;
	    return height(node.left) - height(node.right);
	}
	
	private AVLNode insert(AVLNode node, int data)
	{
	    //Normal BST insertion
	    if (node == null){
	        return(new AVLNode(data));
	    }
	 
	    if (data < node.data){
	        node.left  = insert(node.left, data);
	    }
	    else{
	        node.right = insert(node.right, data);
	    }
	 
	    // Update height node 
	    node.height = max(height(node.left), height(node.right)) + 1;
	 
	   //Check for the first unbalanced node
	    int balance = getBalance(node);
	
	    // Left Left Case
	    if (balance > 1 && data < node.left.data){
	        return rightRotate(node);
	    }
	 
	    // Right Right Case
	    if (balance < -1 && data > node.right.data){
	        return leftRotate(node);
	    }
	 
	    // Left Right Case
	    if (balance > 1 && data > node.left.data){
	        node.left =  leftRotate(node.left);
	        return rightRotate(node);
	    }
	 
	    // Right Left Case
	    if (balance < -1 && data < node.right.data){
	        node.right = rightRotate(node.right);
	        return leftRotate(node);
	    }
	 
	    return node;
	}
	
	public void delete(int key){
		head = deleteNode(head, key);
	}
	
	private AVLNode deleteNode(AVLNode root, int key)
	{
	    // Normal BST deletion
	 
	    if (root == null){
	        return root;
	    }
	 
	    // If the key is smaller it should be in the left sub-tree
	    if ( key < root.data ){
	        root.left = deleteNode(root.left, key);
	    }
	 
	    // If the key is smaller it should be in the left sub-tree
	    else if( key > root.data ){
	        root.right = deleteNode(root.right, key);
	    }
	    
	    //If we found the desired data matching key
	    else{
	       if (root.right == null){
	    	   root = root.left;
	       }else{
	    	   AVLNode temp = minValueNode(root.right);
	    	   root.data = temp.data;
	    	   root.right=deleteNode(root.right, temp.data);
	       }
	    }
	 
	    // If the tree had only one node then return
	    if (root == null){
	      return root;
	    }
	 
	   // update height
	    root.height = max(height(root.left), height(root.right)) + 1;
	 
	   //Check for the first unbalanced node
	    int balance = getBalance(root);
	 
	    // Left Left Case
	    if (balance > 1 && getBalance(root.left) >= 0){
	        return rightRotate(root);
	    }
	 
	    // Left Right Case
	    if (balance > 1 && getBalance(root.left) < 0) {
	        root.left =  leftRotate(root.left);
	        return rightRotate(root);
	    }
	 
	    // Right Right Case
	    if (balance < -1 && getBalance(root.right) <= 0){
	        return leftRotate(root);
	    }
	 
	    // Right Left Case
	    if (balance < -1 && getBalance(root.right) > 0){
	        root.right = rightRotate(root.right);
	        return leftRotate(root);
	    }
	 
	    return root;
	}
	
		
	private AVLNode minValueNode(AVLNode node)
	{
	    AVLNode current = node;
	 
	    //loop to find the leftmost leaf of the right sub-tree
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
	
	public AVLNode searchRecursively(int key){
		return searchRecursively(key, head);
	}
	
	private AVLNode searchRecursively(int key, AVLNode currentNode){
		if(currentNode.data==key){
			return currentNode;
		}else if(currentNode.data>key){
			return searchRecursively(key, currentNode.left);
		}else{
			return searchRecursively(key,currentNode.right);
		}
	}
	
	public int size()
    {
        return countNodes(head);
    }
	
    private int countNodes(AVLNode currentNode)
    {
        if (currentNode == null)
            return 0;
        else
        {
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
	
	 public void print()
	    {
	        BFS_Tree(head);
	        System.out.println();
	    }
	
}
