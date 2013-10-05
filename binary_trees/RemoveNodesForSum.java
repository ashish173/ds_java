// RemoveNodesForSum.java

class Node {
	int iData;
	Node leftChild;
	Node rightChild;
}

class Tree {
	private Node root;
	static int limit = 13;
	static boolean isLeftChild=false, isLeftInorderSuccessor=false;

	public void insert(int key) {
		Node newNode = new Node();
		newNode.iData = key;
		Node parent;
		Node current = root;
		if(root==null) {
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

	public void inorderTest(Node root) {
		if(root==null) 
			return;
		else {
			inorderTest(root.leftChild);
			System.out.print(" " + root.iData); 
			inorderTest(root.rightChild);
		}
	}

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

	public void delete(int key) {
		Node match = find(key); // match holds the parent of key found
		Node found;
		Node inorderSuccessor;
		// System.out.println("parent: "+ match.iData);
		if(isLeftChild)     // finding the node to be deleted
			found = match.leftChild;
		else
			found = match.rightChild;
			
			// if(found.rightChild!=null || found.leftChild!=null)
			//	System.out.println("Match found");
			if(found.rightChild!=null && found.leftChild!=null) {
				// when the node to be deleted has two children
				// System.out.println("has two children");
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
				// System.out.println("has only one child");
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
				// System.out.println("has no child");
				if(isLeftChild)
					match.leftChild=null;
				else
					match.rightChild=null;
			}
		//}catch(Exception ex) {}
	}


	public void inorder() {
		inorderTest(root);
	}

	public void removing(Node root, int max) {
		if(root == null)
			return;
		else {
			max = max + root.iData;
			System.out.println("calling left tree of: " + root.iData);
			removing(root.leftChild, max);
			if(max < limit) { 
				System.out.println("calling right tree of: " + root.iData);
				removing(root.rightChild, max);
			    // this only deletes the nodes that are leaf node
				// and has no cotribution in sum of other branches
				if(max < limit && root.rightChild == null && root.leftChild == null) {
					System.out.println("deleting for max: " + max);
					delete(root.iData);
				}
			}
			return;
		}
	}

	public void testing() {
		int max=0;
		removing(root, max);
	}

}



public class RemoveNodesForSum {
	public static void main(String[] args) {
		Tree bst = new Tree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);
		bst.insert(6);
		bst.insert(8);
		bst.testing();
		bst.inorder();
	}
}