package lab6;

/***********************************************************
 *
 * 08-722 Data Structures for Application Programmers
 * Lab 6. Comparing BST with Ordered Array and Linked List
 *
 * Very Simple Binary Search Tree Implementation
 *
 ***********************************************************/

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
			else
				// go left
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
	 *            value to be mapped and added to the tree
	 */
	@Override
	public void insert(int key) {
		Node newNode = new Node(key);
		if (root == null) // empty tree
			root = newNode;
		else {
			Node curr = root;
			Node parent; // keep track of parent

			while (true) {
				// no duplicates allowed
				if (key == curr.key)
					return;
				parent = curr;

				if (key < curr.key) { // go left
					curr = curr.left;
					if (curr == null) { // found a spot
						parent.left = newNode;
						return;
					}
				} else { // go right
					curr = curr.right;
					if (curr == null) { // found a spot
						parent.right = newNode;
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
		// the tree is empty
		if (root == null)
			return;

		Node curr = root;
		Node parent = root;
		boolean isLeftChild = true; // flag to check left child

		while (curr.key != key) {
			parent = curr;
			if (key < curr.key) { // go left
				isLeftChild = true;
				curr = curr.left;
			} else {
				isLeftChild = false;
				curr = curr.right;
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
			Node successor = getSuccessor(curr);

			if (curr == root)
				root = successor;
			else if (isLeftChild)
				parent.left = successor;
			else
				parent.right = successor;

			// need to take care of final connection with curr's left
			successor.left = curr.left;
		}

	}

	/**
	 * traverses the tree in an ascending order based on keys
	 */
	@Override
	public void traverse() {
		inOrderHelper(root);
		System.out.println("");
	}

	private void inOrderHelper(Node toVisit) {
		if (toVisit != null) {
			inOrderHelper(toVisit.left);
			System.out.print(toVisit.key + " ");
			inOrderHelper(toVisit.right);
		}
	}

	/*
	 * helper method to find the successor the the delNode This tries to find
	 * the smallest value of the right subtree of the delNode by going down to
	 * the far left node
	 */
	private Node getSuccessor(Node keyNode) {
		Node successorParent = keyNode;
		Node successor = keyNode;
		Node curr = keyNode.right;

		// move to left as far as possible in the right subtree
		while (curr != null) {
			successorParent = successor;
			successor = curr;
			curr = curr.left;
		}

		/*
		 * if successor is not the right child of the node to be deleted Then
		 * need to take care of two connections
		 */
		if (successor != keyNode.right) {
			successorParent.left = successor.right;
			successor.right = keyNode.right;
		}

		return successor;
	}

	// private static nested class for node
	private static class Node {
		private int key;
		private Node left, right;

		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

}