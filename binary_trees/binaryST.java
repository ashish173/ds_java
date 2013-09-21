// BST in java
import java.io.*;

class Node {
	int iData;
	Node leftChild;
	Node rightChild;

	Node() {  // constructor

	}
} // end of Node class

class Tree {
	private Node root;
	static boolean isLeftChild = false;   // keeps track of node in find
	static boolean isLeftInorderSuccessor = false;  // keeps track of whether the Inorder successor is 
	// Inorder InorderTraversal                   // left or right node
	public void InorderTraversal(Node node)  {
		if(node==null)
			return;
		else {
			InorderTraversal(node.leftChild);
			System.out.print(" " + node.iData);
			InorderTraversal(node.rightChild);
		}
	}
	public int max(int a, int b) {
		if(a>b)
			return a;
		else
			return b;
	}

	// postorder traversal
	public void PostOrderTraversal(Node node) {
		if(node==null)
			return;
		else {
			PostOrderTraversal(node.leftChild);
			PostOrderTraversal(node.rightChild);
			System.out.print(" " + node.iData);
		}
	}


	public void PreOrderTraversal(Node node) {
		if(node==null)
			return;
		else {
			System.out.print(" "+ node.iData);
			PreOrderTraversal(node.leftChild);
			PreOrderTraversal(node.rightChild);
		}
	}

	public void Inorder() {
		InorderTraversal(root);
	}
	public void PostOrder() {
		PostOrderTraversal(root);
	}
	public void PreOrder() {
		PreOrderTraversal(root);
	}
	// function to find the height of a tree
	public int heightTree(Node node) {
		if(node==null)
			return -1;
		else {
			return(1 + max(heightTree(node.leftChild), heightTree(node.rightChild)));
		}
	}

	public int height() {
		return heightTree(root);
	}
	public int findMin() {
		Node current = root;
		Node parent;
		while(true) {
			parent = current;
			current = current.leftChild;
			if(current==null)
				return parent.iData;
		}
	}

	public int findMax() {
		Node current = root;
		Node parent;
		while(true) {
			parent = current;
			current = current.rightChild;
			if(current==null)
				return parent.iData;
		}
	}

	// method to find the presence of keys in a binary search tree
	public Node find(int key) {
		Node current = root;
		Node parent = root;
		while(true) {

			if(current.iData==key)
				return parent;
			if(key < current.iData) {  	// go to left subtree
				parent = current; 		// store the parent
				isLeftChild = true;
				current = current.leftChild;
				if(current == null)
					return null;
			}
			else {                      // go to right subtree  
				parent = current;
				isLeftChild = false;       				
				current = current.rightChild;
				if(current==null)
					return null;
			}
		}
	}

	// insert function
	public void insert(int iData) {
		Node newNode = new Node();
		newNode.iData = iData;
		if(root==null) { // no values in the tree
			root = newNode;
		}
		else {  // if there are certain values already present in the tree
			Node current = root;  // start at the root node
			Node parent;
			while(true) {
				parent = current; // assign current to the parent
				if(iData < current.iData) { // go left side of tree
					current = current.leftChild; // making the leftchild 
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
				}// end of else
			} // end of while
		}  // end of else
	}    // end of insert
	
	// finding inorder successor of a node
	public Node inorderSuccessor(Node nodeToBeDeleted) {
		Node current = nodeToBeDeleted.rightChild;
		Node parentInorderSuccessor = nodeToBeDeleted;      // should be intialized to nodeToBeDeleted
		while(current.leftChild!=null) {
			isLeftInorderSuccessor = true;
			parentInorderSuccessor = current;
			current = current.leftChild;
		}
		return parentInorderSuccessor;
	}


	// delete function
	public void delete(int key) {
		Node match = find(key); // match holds the parent of key found
		Node found;
		Node inorderSuccessor;
		System.out.println("parent: "+ match.iData);
		if(isLeftChild)     // finding the node to be deleted
			found = match.leftChild;
		else
			found = match.rightChild;
			
			// if(found.rightChild!=null || found.leftChild!=null)
			//	System.out.println("Match found");
			if(found.rightChild!=null && found.leftChild!=null) {
				// when the node to be deleted has two children
				System.out.println("has two children");
				// find the inorder successor
				Node parentInorderSuccessor = inorderSuccessor(found); // stores parent of inorder successor
				// System.out.println("parent of inorder successor: " + parentInorderSuccessor.iData);	
				// find the node to be deleted 
				// System.out.println("Left Inorder successor: " + isLeftInorderSuccessor);
				if(isLeftInorderSuccessor)
					inorderSuccessor = parentInorderSuccessor.leftChild;
				else
					inorderSuccessor = parentInorderSuccessor.rightChild;

				if(found!=parentInorderSuccessor) {  // in case of parentIS same as the node to be removed
					// move right node of IS to parentIS's left child
					parentInorderSuccessor.leftChild = inorderSuccessor.rightChild;
					if(isLeftChild)
						match.leftChild = inorderSuccessor;
					else
						match.rightChild = inorderSuccessor;
					inorderSuccessor.rightChild = found.rightChild;
					inorderSuccessor.leftChild = found.leftChild;
				}
				else {
					if(isLeftChild)
						match.leftChild = inorderSuccessor;
					else
						match.rightChild = inorderSuccessor;
					inorderSuccessor.leftChild = found.leftChild;
					//System.out.println("right chlid od 12" + inorderSuccessor.rightChild.iData);
				}

			}
			else if(found.rightChild!=null || found.leftChild!=null) {
				// when node to be deleted has only one child
				Node toBePreserved;   // stores the child of the node to be deleted
				System.out.println("has only one child");
				if(found.leftChild!=null)
					toBePreserved = found.leftChild;
				else
					toBePreserved = found.rightChild;
				if(isLeftChild)
					match.leftChild = toBePreserved;
				else
					match.rightChild = toBePreserved;
			}
			else { // when node to be deleted has no child
				System.out.println("has no child");
				if(isLeftChild)
					match.leftChild=null;
				else
					match.rightChild=null;
			}
		//}catch(Exception ex) {}
	}

} // end Tree class

public class binaryST {
	public static void main(String[] args) throws Exception {
		Tree bst = new Tree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(8);
		bst.insert(12);
		bst.insert(15);
		bst.insert(30);
		bst.insert(25);
		bst.insert(35);
		bst.insert(6);
		bst.insert(27);
		bst.insert(32);
		bst.insert(39);
		bst.insert(31);
		bst.insert(50);
		bst.insert(90);
		bst.insert(100);
		//bst.insert(90);
		/* boolean result = bst.find(30);
		if(result)
			System.out.println("match found");
		else
			System.out.println("match not found");
		*/
		
		// >>>Traversals	
		// Inorder traversal tree 	
		// bst.Inorder();  // this works()
		// bst.PostOrder();  // this also works
		// bst.PreOrder();	 // this also works
		
		// finding Max/Min	
		// System.out.println("Minimum is " + bst.findMin());  
		// System.out.println("Maximum is " + bst.findMax()); // ^both these work
		// >>>Deletion
		// when node to be deleted has only one child
		// bst.delete(35);  // works for every node except root node
        // bst.Inorder();  // this works()
		System.out.print("height of tree " + bst.height());
		/*while(true) {
			System.out.println("Binary search tree");
			System.out.println("1. Insert");
			//System.out.println("Binary search tree");
			//System.out.println("Binary search tree");
			System.out.println("4.Exit");
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(ir);
			String str = br.readLine();
		}*/
	}
}