// BSTTraversal.java
// a programe to implement traversing iteratively
import java.util.*;

class Node {
	int iData;
	Node leftChild;
	Node rightChild;
}

class Tree {
	private Node root;

	public Stack<Node> st = new Stack<Node>();

	public void insert(int nodeValue) {
		Node newNode = new Node();
		newNode.iData = nodeValue;
		Node current = root;
		Node parent;

		if(root==null) {  // if the tree is empty
			root = newNode;
			return;
		}
		else {  // if the tree is not empty
			while(true) {
				if(nodeValue < current.iData) {
					parent = current;
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					parent = current;
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	/*  // recursive for testing purposes
	public void inorderTraversal(Node root) {
		if(root==null)
			return;
		else {
			inorderTraversal(root.leftChild);
			System.out.print(" "+root.iData);
			inorderTraversal(root.rightChild);
		}
	}
	
	public void IOTRecursive() {
		inorderTraversal(root);
	}
	*/

	// iterative inorder traversal
	public void inorderTraversalIter(Node root) {
		//st.push(root);
		// System.out.println("in iterative method");
		Node current = root;
		while(st.isEmpty()!=true || current!=null) {
			//System.out.println("in While");
			if(current!=null) {
				st.push(current);
				current = current.leftChild;
			//	System.out.println("in if");
			}
			else {
				current = st.pop();
				System.out.println(" " + current.iData);
				current = current.rightChild;		
			//	System.out.println("in else");
			}
		}
	}

	// iterative pre order traversal 
	public void preorderTraversalIter(Node root) {
		Node current = root;
		// Node parent=current;
		while(st.isEmpty()!=true || current!=null) {
			if(current!=null) {
				st.push(current);
				System.out.print(" " + current.iData);
				current= current.leftChild;
			}
			else {
				current = st.pop();
				current = current.rightChild;
			}
		}
	}
	
	// iterative postorder traversal 
	public void postorderTraversalIter(Node root) {
		// using a flag to check if the right node is visited
		Node current = root;
		Node parent;
		Boolean isRightChildVisited=false;   // keeps track if the right child is visited

		while(st.isEmpty()!=true || current!=null) {
			if(current!=null) {
				st.push(current);
				current = current.leftChild;
				isRightChildVisited = false;
			}
			else {
				if(!isRightChildVisited) {
					parent = st.pop();
					st.push(parent);
					current = parent.rightChild;
					isRightChildVisited = true;
				}
				else {
					current = st.pop();
					System.out.println(" " + current.iData);
					current = st.pop();
					isRightChildVisited=true;
				}
			} 
		}
	}

	public void InOTIterative() {
		inorderTraversalIter(root);
	}
	public void PreOTIterative() {
		preorderTraversalIter(root);
	}
	public void PostOTIterative() {
		postorderTraversalIter(root); 
	}
}

// main class
public class BSTTraversal {
	public static void main(String[] args) {
		Tree bst = new Tree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(5);
		bst.insert(15);
		bst.insert(25);
		// bst.IOTRecursive();  //> works
		// bst.InOTIterative();  //> works
		// bst.PreOTIterative(); //> works
		bst.PostOTIterative(); 
	}
}