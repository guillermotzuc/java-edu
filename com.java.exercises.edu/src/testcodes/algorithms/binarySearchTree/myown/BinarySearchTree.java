package testcodes.algorithms.binarySearchTree.myown;

import java.util.Optional;

public class BinarySearchTree {

	private TreeNode root;
	
	public void insert (int data) {
		if(this.root == null) {
			this.root = new TreeNode(data);
		} else {
			this.root.insert(data);
		}
	}
	
	public void traverseInOrder() {
		if(root != null)
			root.traverseInOrder();
	}
	
	public Optional<Integer> find(int data) {
		if(root != null)
			return root.find(data);
		
		return Optional.empty();
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(5);
		tree.insert(1);
		tree.insert(3);
		tree.insert(2);
		tree.insert(4);
		System.out.println();
		tree.traverseInOrder();
		System.out.println(tree.find(5));
	}
}
