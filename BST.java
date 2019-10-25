public class BST<T extends Comparable<T>>
{
	protected Node root;
	public void print() {
		print(root);
	}
	private void print(Node node) {//Helper function for printing the tree
		if (node != null) {
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}
	public boolean find(Comparable item) {
		return find(root, item);
	}
	public boolean find(Node node, Comparable item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}
		if (node.data.compareTo(item) < 0) {
			return find(node.right, item);
		}
		else {
			return find(node.left, item);
		}
	}
	public void insert(Comparable item) {
		root = insert(root, item);
	}
	public Node insert(Node node, Comparable item) {
		if (node == null) {
			return new Node(item);
		}
		else if (node.data.compareTo(item) < 0) {
			node.right = insert(node.right, item);
			return node;
		}
		else {
			node.left = insert(node.left, item);
			return node;
		}
	}
	public void delete(Comparable item) {
		root = delete(root, item);
	}
	public Node delete(Node node, Comparable item) {//This function deletes from the binary tree
		if (node == null) {
			return null;
		}
		if(node.data == item) {
			if(node.left == null) {
				return node.right;
			} 
			else if(node.right == null) {
				return node.left;
			} 
			else if(node.right.left == null) {
				node.data = node.right.data;
				node.right = node.right.right;
				return node;
			} 
			else {
				node.data = removeSmallest(node.right);
				return node;
			}
		} 
		else if(node.data.compareTo(item) > 0) {
			node.left = delete(node.left, item);
		} 
		else {
			node.right = delete(node.right, item);
		}
		return node;
	}
	public Comparable removeSmallest(Node node) {
		if(node.left.left == null) {
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		return removeSmallest(node.left);
	}
}