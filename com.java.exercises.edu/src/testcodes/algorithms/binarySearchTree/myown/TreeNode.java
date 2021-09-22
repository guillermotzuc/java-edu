package testcodes.algorithms.binarySearchTree.myown;

import java.util.Optional;

public class TreeNode {

	private int data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode ( int data) {
		this.data = data;
	}
	
	public void insert (int data) {
		if(data > this.data) {
			if(right == null){
				this.right =new TreeNode(data);
			} else{
				this.right.insert(data);
			}
			
		}else {
			if(left == null) {
				this.left = new TreeNode(data);
			} else {
				this.left.insert(data);
			}
		}
	}
	
	public void traverseInOrder() {
		if(left!= null)
			left.traverseInOrder();
		
		System.out.println(" " + data);
		
		if(right != null)
			right.traverseInOrder();
	}
	
	public Optional<Integer> find (int data) {
		
		if(this.data == data) {
			return Optional.of(this.data);
		}
		if(this.data < data && this.right != null) {
			Optional<Integer>  value = this.right.find(data);
			if(value.isPresent())
				return value;
		}
		else if (this.left != null) {
			Optional<Integer>  value = this.left.find(data);
			if(value.isPresent())
				return value;
		}
		return Optional.empty();
	}
}
