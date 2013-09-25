/* 	LevelOrderTraversal.java
 	Given a binary tree traverse the tree level wise

 			   12
 			 /   \
 		   10     15
 		  /  \	 /  \
 		 9   11 13  16

    Output is: 12, 10, 15, 9, 11, 13, 16

*/ 

import java.util.*;

class Node {
	int iData;
	Node leftChild;
	Node rightChild;
} // end of node class

class Tree {
	private Node root;
	Queue<Node> queue = new LinkedList<Node>(); // a queue of linked list type

	public void insert(int key) {
		Node newNode = new Node();
		newNode.iData = key;
		Node current=root;
		Node parent;
		if(root==null) {  // empty tree case
			root=newNode;
			return;
		}
		else {
			while(true) {
				parent = current;
				if(key < current.iData) {
					current = current.leftChild;
					if(current==null) {
						parent.leftChild = newNode;

						return;					
					}
				}
				else {
					current = current.rightChild;
					if(current==null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void InorderT(Node root) {
		if(root==null)
			return;
		else {
			InorderT(root.leftChild);
			System.out.print(" " + root.iData);
			InorderT(root.rightChild);
		}
	}

	// recursive level wise display
	void levelDisplayRecusive() {
		
	}

	void levelrecur() {
		levelDisplayRecusive();
	}


	// iterative level wise display
	public void levelDisplay() {
	/*
	1. 	go to root enqueue it 
	2. 	if(queue not empty then)
	3. 		current = dequeue (if right or leftChild enqueue both )
			print current
	*/
		queue.offer(root);			
		Node current;
		while(queue.isEmpty()!=true) {
			current = queue.remove();
			if(current.leftChild!=null)
				queue.offer(current.leftChild);
			if(current.rightChild!=null)
				queue.offer(current.rightChild);
			System.out.print(" " + current.iData);
		}
	}

	public void inorderT() {
		InorderT(root);
	}
}



public class LevelOrderTraversal {
	
	public static void main(String[] args) {
		Tree bst = new Tree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(5);
		bst.insert(15);
		bst.insert(35);
		bst.insert(25);
		// bst.inorderT();  // > works 
		bst.levelDisplay();  // > works

	}
} 