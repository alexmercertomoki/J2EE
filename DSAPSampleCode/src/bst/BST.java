package bst;

/**********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lecture 15 Binary Trees, mainly Binary Search Trees
 *
 * A very simple Binary Search Tree implementation
 * No duplicate keys allowed
 *
 * This is only to help your understanding of the concept
 *
 **********************************************************/

public class BST implements BSTInterface {

	private Node root;

	public BST() {
		root = null;
	}

	/**
	 * finds key in the tree
	 *
	 * @param key
	 *            value to be found
	 * @return boolean value (true when found)
	 */
	@Override
	public boolean find(int key) {
		if (root == null)
			return false; // tree is empty

		Node curr = root;
		// while not found
		while (curr.key != key) {
			if (curr.key < key) // go right
				curr = curr.right;
			else // go left
				curr = curr.left;
			if (curr == null) // not found
				return false;
		}
		return true; // found
	}

	/**
	 * inserts a new key and value pair into the tree
	 *
	 * @param key
	 *            key value to be added
	 * @param value
	 *            value that is mapped to the key
	 */
	@Override
	public void insert(int key, double value) {
		Node newNode = new Node(key, value);
		if (root == null) // empty tree
			root = newNode;
		else {
			Node parent = root; // keep track of parent
			Node curr = root;

			while (true) {
				// no duplicate keys allowed
				// typically, overwrite existing node with the new one
				// but, leave the original one here
				if (curr.key == key)
					return;

				parent = curr; // update parent
				if (curr.key < key) { // go right
					curr = curr.right;
					if (curr == null) { // found a spot
						parent.right = newNode;
						return;
					}
				} else { // go left
					curr = curr.left;
					if (curr == null) { // found a spot
						parent.left = newNode;
						return;
					}
				} // end of if-else to go right or left
			} // end of while
		} // end of if-else to check empty BST or not
	} // end of insert method

	/**
	 * deletes a key and value (node) from the tree
	 *
	 * @param key
	 *            key value to delete
	 */
	@Override
	public void delete(int key) {
		if (root == null) // empty tree
			return;

		Node parent = root;
		Node curr = root;
		/*
		 * flag to check left child
		 *
		 * need this flag because actual deletion process happens
		 * after the while loop that is to find the key to delete
		 */
		boolean isLeftChild = true;

		while (curr.key != key) {
			parent = curr; // update parent first
			if (curr.key < key) { // go right
				isLeftChild = false;
				curr = curr.right;
			} else { // go left
				isLeftChild = true;
				curr = curr.left;
			}

			if (curr == null) // case 1: not found
				return;
		}

		if (curr.left == null && curr.right == null) { // case 2: leaf
			if (curr == root)
				root = null;
			else if (isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		} else if (curr.right == null) { // case 3: no right child
			if (curr == root)
				root = curr.left;
			else if (isLeftChild)
				parent.left = curr.left;
			else
				parent.right = curr.left;
		} else if (curr.left == null) { // case 3: no left child
			if (curr == root)
				root = curr.right;
			else if (isLeftChild)
				parent.left = curr.right;
			else
				parent.right = curr.right;
		} else { // case 4: with two children
			// here we use successor but using predecessor is an option
			Node successor = getSuccessor(curr);
			if(curr == root)
				root = successor;
			else if(isLeftChild)
				parent.left = successor;
			else
				parent.right = successor;

			// need to take care of final connection with curr's left
			successor.left = curr.left;
		}
	}

	/*
	 * helper method to find the successor of the toDelete node.
	 * This tries to find the smallest value of the right subtree
	 * of the delNode by going down to the far left node in the subtree
	 */
	private Node getSuccessor(Node toDelete) {
		Node successorParent = toDelete;
		Node successor = toDelete;
		Node curr = toDelete.right;

		// move down to left as far as possible in the right subtree
		while (curr != null) {
			successorParent = successor;
			successor = curr;
			curr = curr.left;
		}

		/*
		 * If successor is NOT the right child of the node to be deleted,
		 * then need to take care of two connections in the right subtree
		 */
		if (successor != toDelete.right) {
			successorParent.left = successor.right;
			successor.right = toDelete.right;
		}

		return successor;
	}

	/**
	 * traverse the tree and print values of the tree
	 * in ascending order based on keys
	 */
	public void traverse() {
		inOrderHelper(root);
		System.out.println();
	}

	// private helper method for in-order traversal
	private void inOrderHelper(Node toVisit) {
		if(toVisit != null) {
			inOrderHelper(toVisit.left);
			System.out.print("["+toVisit.key +", "+toVisit.value+"]");
			inOrderHelper(toVisit.right);
		}
	}

	// private static nested Node class
	private static class Node {
		private int key;
		private double value;
		private Node left, right;

		public Node(int key, double value) {
			this.key = key;
			this.value = value;
			left = right = null;
		}
	}

	// a few simple test cases
	public static void main(String[] args) {
		BST theBST = new BST();

		theBST.traverse();
		System.out.println(theBST.find(45));
		theBST.delete(45);

		theBST.insert(50, 0.5);
		theBST.insert(69, 0.4);
		theBST.insert(45, 1.4);
		theBST.insert(72, 3.4);
		theBST.insert(46, 3.3);
		theBST.insert(46, 3.4);

		theBST.traverse();
		System.out.println(theBST.find(45));
		theBST.delete(45);
		System.out.println(theBST.find(45));
		theBST.delete(40);
		theBST.traverse();
	}

}