// leftView.java
/*	Given a bst print the left view of the tree

				  20
			    /   \
			  10    30
			 / \   /  \
			5  15 25  35
				\      \S
				17	   48
						\
						78
		Output should be:- 20, 10, 5, 17, 78			
*/
class Node {
	int iData;
	Node leftChild;
	Node rightChild;
}// node class

class Tree {
	private Node root;
	static int maxLevel=0;

	public void insert(int value) {
		Node newNode = new Node();
		newNode.iData = value; 
		Node current = root;
		Node parent;
		if(root==null) {
			root = newNode;
			return;
		}
		else {
			while(true) {
				parent = current;
				if(value < current.iData) {
					current = current.leftChild;
					if(current==null) {
						parent.leftChild=newNode;
						return;
					}
				}
				else {
					current = current.rightChild;
					if(current==null) {
						parent.rightChild= newNode;
						return;
					}
				}
			}
		}
	}

	public void inorder(Node root) {
		if(root==null)
			return;
		else{
			inorder(root.leftChild);
			System.out.println(" " + root.iData);
			inorder(root.rightChild);
		}
	}

	public void inorderOut() {
		inorder(root);
	}

	public int leftViewTree(Node root, int level, int maxLevel) {
		/*
			The reason we are returning int(maxLevel) is that in java we don't have refernces so there has to be a way to achieve it in java
			as we want to preserve the value of maxLevel in b/w stack calls. 

			** NOTE ** same can be achieved in c/c++ passing the reference to variable(technically an address) so whenever the value of maxLevel is changed it is changed for everyone.
			leftViewTree(root, 1, &maxLevel);  // in c/c++

			Efficiency :
			The algorithm is doing a simple traversal; Time complexity is O(n)
		*/
		if(root==null)  // base case
			return maxLevel;
		if(maxLevel < level) {
			// System.out.println("maxLevel is = " + maxLevel);
			// System.out.println("level is = " + level);
			System.out.println(" " + root.iData);
			maxLevel = level;
		}
		maxLevel = leftViewTree(root.leftChild, level+1, maxLevel);
		// System.out.println("entering right tree maxLevel is " + maxLevel);
		// System.out.println("entering right tree level is " + level);
		maxLevel = leftViewTree(root.rightChild, level+1, maxLevel);
		// System.out.println("Exiting the right tree for level : " + level);
		return maxLevel;
	}	

	public void leftView() {
		/*
		1. We keep a track of the maxlevel we have visited in a static variable(somehow this didn't work so we returned maxLevel instead from stack calls).
		2. and a local variable is passed to every stack call in recursion.
		3. We only print the node if the level becomes greater than maxlevel.
		*/

		int max = leftViewTree(root, 1, maxLevel);      // initially the level is 1 and maxlevel is 0.
	}

}
public class leftView {
	public static void main(String[] args) {
		Tree bst = new Tree();
		bst.insert(16);
		bst.insert(10);
		bst.insert(5);
		bst.insert(11);
		bst.insert(30);
		bst.insert(25);
		bst.insert(35);
		bst.insert(15);
		// bst.inorderOut();
		bst.leftView();
	}
}
