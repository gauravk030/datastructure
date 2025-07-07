package com.sample.ds.tree;

/**
 *     		   50   
		     /    \
		  30       60
		/    \       \
	   20    40      70
		               \ 
		               80
		 
		 
 */
//Node class representing each node in the BST
class TreeNode {
	int value;
	TreeNode left, right;

	TreeNode(int item) {
		value = item;
		left = right = null;
	}
}

class BinarySearchTree {
	TreeNode root;

	// Method to insert a new value
	void insert(int value) {
		root = insertRec(root, value);
	}

	// Recursive method to insert a new value
	TreeNode insertRec(TreeNode node, int value) {
		if (node == null) {
			node = new TreeNode(value);
			return node;
		}
		if (value < node.value) {
			node.left = insertRec(node.left, value);
		} else if (value > node.value) {
			node.right = insertRec(node.right, value);
		}
		return node;
	}

	// Method to perform an in-order traversal
	void inorder() {
		inorderRec(root);
	}

	// Recursive method to perform in-order traversal
	void inorderRec(TreeNode node) {
		if (node != null) {
			inorderRec(node.left);
			System.out.print(node.value + " ");
			inorderRec(node.right);
		}
	}
}

//Main class to test the BinarySearchTree implementation
public class TreeDynamicNodeRec {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);

		System.out.println("In-order traversal of the BST:");
		bst.inorder();
	}
}