package testcodes.patters.iterator.traversal.binarytree;

public class Node<T> {

	public T value;
	public Node<T> left, right, parent;

	public Node(T value)
	{
		this.value = value;
	}

	public Node(T value, Node<T> left, Node<T> right)
	{
		this.value = value;
		this.left = left;
		this.right = right;

		left.parent = right.parent = this;
	}

}
