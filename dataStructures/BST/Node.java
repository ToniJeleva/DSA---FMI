package Trees;

public class Node {
	public int data;
	public Node left;
	public Node right;
	
	public Node(){
		data=0;
		left=null;
		right=null;
	}
	
	public Node(Node left, int data, Node right){
		this.left=left;
		this.right=right;
		this.data=data;
	}
	
	 public boolean remove(int value, Node parent) {
         if (value < this.data) {
               if (left != null)
                     return left.remove(value, this);
               else
                     return false;
         } else if (value > this.data) {
               if (right != null)
                     return right.remove(value, this);
               else
                     return false;
         } else {
               if (left != null && right != null) {
                     this.data = right.minValue();
                     right.remove(this.data, this);
               } else if (parent.left == this) {
                     parent.left = (left != null) ? left : right;
               } else if (parent.right == this) {
                     parent.right = (left != null) ? left : right;
               }
               return true;
         }
   }

   public int minValue() {
         if (left == null)
               return data;
         else
               return left.minValue();
   }
	
	@Override
	public String toString(){
		return data+"";
	}

}
