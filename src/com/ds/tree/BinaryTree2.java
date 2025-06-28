package com.ds.tree;

public class BinaryTree2 {

	private Node root;
	class Node {
		int key;
		Node left,right;
		public Node(int key){
			this.key = key;
		}
	}
	
	public BinaryTree2() {
		this.root = null;
	}
	
	public void insert(int key) {
		this.root = insertRec(this.root,key);
	}
	
	private Node insertRec(Node node,int key) {
		if(node == null) {
			return new Node(key);
		}
		
		if(key < node.key) {
			node.left = insertRec(node.left,key);
		}else if(key > node.key) {
			node.right = insertRec(node.right,key);
		}
		
		return node;
	}
	
	public void inorder() {
		inorderRec(this.root);
		System.out.println("");
	}
	
	private void inorderRec(Node node) {
		if(node != null) {
			inorderRec(node.left);
			System.out.print(node.key+" ");
			inorderRec(node.right);
		}
	}
	
	public boolean search(int key) {
		return searchRec(this.root,key);
	}
	
	private boolean searchRec(Node node,int key) {
		if(node == null) {
			return false;
		}
		
		if(node.key == key) {
			return true;
		}
		
		if(node.key > key) {
			return searchRec(node.left,key);
		}else {
			return searchRec(node.right,key);
		}		
	}
	
	public int findMin() {
		return recFindMin(this.root).key;
	}
	
	public Node recFindMin(Node node) {
		if(node == null) {
			 throw new IllegalStateException("Tree is empty");
		}
		
		if(node.left == null) {
			return node;
		}
		
		if(node.key > node.left.key)
			node = recFindMin(node.left);
		
		return node;
	}
	
	public int findMax() {
		return recFindMax(this.root).key;
	}
	
	public Node recFindMax(Node node) {
		if(node == null) {
			 throw new IllegalStateException("Tree is empty");
		}
		
		if(node.left == null) {
			return node;
		}
		
		if(node.key < node.right.key)
			node = recFindMax(node.right);
		
		return node;
	}
	
	public static void main(String[] args) {
		BinaryTree2 tree = new BinaryTree2();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
		
        tree.inorder();
        
        boolean isPresent = tree.search(60);
        if(isPresent) {
        	System.out.println("Key is present");
        }else {
        	System.out.println("Key is not present");
        }
      
        System.out.println("Min node is "+tree.findMin());
        
        System.out.println("Max node is "+tree.findMax());
        
	}

}
