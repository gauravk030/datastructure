package com.sample.ds.tree;

/**
 *                 11(0)
 *               /     \
 *              3      20(1)
 *              \     /    \
 *               9   16     42(2)
 *              / \ 	   /	\
 *             4   10     32	54(3)
 *                
 */

class Node {
	public int data;
	public Node leftChild;
	public Node rightChild;

	public Node() {
	}

	public void display() {
		System.out.print("(" + data + ")");
	}
}

class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public Node search(int data) {
		Node current = root;
		System.out.print("Visiting elements: ");
		while (current.data != data) {
			if (current != null)
				System.out.print(current.data + " ");
			// go to left tree
			if (current.data > data) {
				current = current.leftChild;
			} // else go to right tree
			else {
				current = current.rightChild;
			}
			// not found
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	public void insert(int data) {
		Node tempNode = new Node();
		tempNode.data = data;

		// if tree is empty
		if (root == null) {
			root = tempNode;
		} else {
			Node current = root;
			Node parent = null;

			while (true) {
				parent = current;
				// go to left of the tree
				if (data < parent.data) {
					current = current.leftChild;
					// insert to the left
					if (current == null) {
						parent.leftChild = tempNode;
						return;
					}
				} // go to right of the tree
				else {
					current = current.rightChild;
					// insert to the right
					if (current == null) {
						parent.rightChild = tempNode;
						return;
					}
				}
			}
		}
	}

	public void traverse(int traversalType) {
		switch (traversalType) {
		case 1:
			System.out.print("\nPreorder traversal: ");
			preOrder(root);
			break;
		case 2:
			System.out.print("\nInorder traversal: ");
			inOrder(root);
			break;
		case 3:
			System.out.print("\nPostorder traversal: ");
			postOrder(root);
			break;
		}
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print(root.data + " ");
			inOrder(root.rightChild);
		}
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print(root.data + " ");
		}
	}
}

public class TreeWithBasicOpertion {
	public static void main(String[] args) {
		Tree tree = new Tree();

		/*
		 * 11 //Level 0
		 */
		tree.insert(11);
		/*
		 * 11 //Level 0 | |---20 //Level 1
		 */
		tree.insert(20);
		/*
		 * 11 //Level 0 | 3---|---20 //Level 1
		 */
		tree.insert(3);
		/*
		 * 11 //Level 0 | 3---|---20 //Level 1 | |--42 //Level 2
		 */
		tree.insert(42);
		/*
		 * 11 //Level 0 | 3---|---20 //Level 1 | |--42 //Level 2 | |--54 //Level 3
		 */
		tree.insert(54);
		/*
		 * 11 //Level 0 | 3---|---20 //Level 1 | 16--|--42 //Level 2 | |--54 //Level 3
		 */
		tree.insert(16);
		/*
		 * 11 //Level 0 | 3---|---20 //Level 1 | 16--|--42 //Level 2 | 32--|--54 //Level
		 * 3
		 */
		tree.insert(32);
		/*
		 * 11 //Level 0 | 3---|---20 //Level 1 | | |--9 16--|--42 //Level 2 | 32--|--54
		 * //Level 3
		 */
		tree.insert(9);
		/*
		 * 11 //Level 0 | 3---|---20 //Level 1 | | |--9 16--|--42 //Level 2 | | 4--|
		 * 32--|--54 //Level 3
		 */
		tree.insert(4);
		/*
		 * 11 //Level 0 | 3---|---20 //Level 1 | | |--9 16--|--42 //Level 2 | | 4--|--10
		 * 32--|--54 //Level 3
		 */
		tree.insert(10);
		Node node = tree.search(32);
		if (node != null) {
			System.out.print("Element found.");
			node.display();
			System.out.println();
		} else {
			System.out.println("Element not found.");
		}

		Node node1 = tree.search(2);
		if (node1 != null) {
			System.out.println("Element found.");
			node1.display();
			System.out.println();
		} else {
			System.out.println("Element not found.");
		}

		// pre-order traversal
		// root, left ,right
		tree.traverse(1);
		// in-order traversal
		// left, root ,right
		tree.traverse(2);
		// post order traversal
		// left, right, root
		tree.traverse(3);
	}
}
