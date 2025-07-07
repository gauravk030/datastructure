package com.sample.ds.tree;

class ArrayImp {

	/**
	 * Sequential Representation of the trees:
	 * 
	 * 	Time complexity: O(log n) since using heap to create a binary tree
	 *	Space complexity: O(1)
		
		      A(0)    
		     /   \
		    B(1)  C(2)  
		  /   \      \
		 D(3)  E(4)   F(6) 
	 */
	
	static int root = 0;
	static String[] str = new String[10];

	// Creating root node
	public void root(String key) {
		str[0] = key;
	}

	// Creating left son of root
	public void setLeft(String key, int root) {
		int t = (root * 2) + 1;

		if (str[root] == null) {
			System.out.printf("Can't set child at %d, no parent found\n", t);
		} else {
			str[t] = key;
		}
	}

	// Creating right son of root
	public void setRight(String key, int root) {
		int t = (root * 2) + 2;

		if (str[root] == null) {
			System.out.printf("Can't set child at %d, no parent found\n", t);
		} else {
			str[t] = key;
		}
	}

	// To print our tree
	public void printTree() {

		// Iterating using for loop
		for (int i = 0; i < 10; i++) {
			if (str[i] != null)
				System.out.print(str[i]);
			else
				System.out.print("-");
		}
	}
}

public class BinaryTreeSeqRepresentation {

	public static void main(String[] args) {

		ArrayImp obj = new ArrayImp();

		// Setting root node
		obj.root("A");
		obj.setLeft("B", 0);
		obj.setRight("C", 0);
		obj.setLeft("D", 1);
		obj.setRight("E", 1);
		obj.setRight("F", 2);
		obj.printTree();
	
	}
}