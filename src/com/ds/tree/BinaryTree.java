package com.ds.tree;


public class BinaryTree {
	class Node {
		private Node left;
		private Node right;
		private int data;
		
		public Node(int data) {
			this.data = data;
		}
	}

	private Node root = null;
	
	public void insert(int data) {
		root = insertRec(root,data);
	}
	
	private Node insertRec(Node root,int data) {
		if(root == null) {
			root = new Node(data);
		}else if(root.data > data) {
			root.left = insertRec(root.left,data);
		}else if(root.data < data) {
			root.right = insertRec(root.right,data);
		}
		return root;
	}
	
	public void preOrder(){
		preOrderRec(root);
	}
	
    private void preOrderRec(Node root){
    	if(root !=null) {
    		System.out.println(root.data + " ");
    		preOrderRec(root.left);
    		preOrderRec(root.right);
    	}
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();		
		binaryTree.insert(7);  
		binaryTree.insert(11);  
		binaryTree.insert(12);  
		binaryTree.insert(10);  
		binaryTree.insert(15); 
		binaryTree.insert(9);
		binaryTree.insert(8);
		binaryTree.preOrder();
	}
}
