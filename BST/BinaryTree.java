package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	public Node head;
	
	public BinaryTree(){
		head=null;
	}
	
	public BinaryTree(int [] data){
		for(int i=0;i<data.length;i++){
			add(data[i]);
		}
		return;
	}
	
	public void add(int data){
		if(head==null){
			head=new Node(null,data,null);
			return;
		}
		Node node=head; //current node
		while(true){
			if(data<node.data){
				if(node.left==null){
					node.left=new Node(null,data,null);
					break;
				}
				node=node.left; //points to the left subtree
			}else{
				if(node.right==null){
					node.right=new Node(null,data,null);
					break;
				}
				node=node.right; //points to the right subtree
			}
		}
	}
	
	public void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}
	
	public Node searchRecursively(int key,Node currentNode){
		if(currentNode.data==key){
			return currentNode;
		}else if(currentNode.data>key){
			return searchRecursively(key, currentNode.left);
		}else{
			return searchRecursively(key,currentNode.right);
		}
	}
	
	public void postorder(Node node){
		if(node!=null){
			
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data +" ");
			}
		
	}
	
	public void BFS_Tree(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
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
	    }
	 
	 public boolean remove(int value) {
         if (head == null)
               return false;
         else {
               if (head.data == value) {
                     Node auxRoot = new Node();
                     auxRoot.left=head;
                     boolean result = head.remove(value, auxRoot);
                     head = auxRoot.left;
                     return result;
               } else {
                     return head.remove(value, null);
               }
         }
   }
	 
	 	 
	 public int findMin(Node node){
		 if(node.left==null){
			 return node.data;
		 }else{
			 return findMin(node.left);
		 }
	 }

}
