package exam2_201720.bst;

import java.util.ArrayList;

/**
 *
 * Exam 2a. Tree methods.
 * 
 * @author
 */

/*
 * TODO: Directions: Implement the methods below. See the paper for details.
 */
public class BinarySearchTree {

	BinaryNode root;

	// The -17 is arbitrary -any int would be fine since we never refer to it.
	final BinaryNode NULL_NODE = new BinaryNode(-17); 

	public BinarySearchTree() {
		root = NULL_NODE;
	}
	
	/**
	 * Counts the number of nodes in the tree that have only a single child.
	 */
	public int countOneChildParents() {
		// TODO: Implement this method!
		return -5;
	}

	/**
	 * Prunes (removes) all leaves in the tree.
	 */
	public void pruneLeaves() {
		// TODO: Implement this method!
	}

	/**
	 * Given two Integers, consider the path by which a binary search on the BST
	 * would search for these Integers. The method returns the value of the "branch point":
	 * i.e., the deepest common node of these two search paths. If both searches would be 
	 * unsuccessful and there were no branch points, then the method should return null. 
	 */
	public Integer branchPoint(Integer x, Integer y) {
		// TODO: Implement this method!
		return new Integer(-5);
	}



	// The next methods are used by the unit tests
	public void insert(Integer e) {
		root = root.insert(e);
	}

	/**
	 * Feel free to call from tests to use to verify the shapes of your trees
	 * while debugging. Just remove the calls you are done so the output isn't
	 * cluttered.
	 * 
	 * @return A string showing a traversal of the nodes where children are
	 *         indented so that the structure of the tree can be determined.
	 * 
	 */
	public String toIndentString() {
		return root.toIndentString("");
	}


	public String toListString() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		root.toArrayList(al);
		return al.toString();
	}
	
	@Override
	public String toString() {
		return root.toString();
	}

	
	// /////////////// BinaryNode
	public class BinaryNode {

		public Integer data;
		public BinaryNode left;
		public BinaryNode right;

		// The rest of the methods are used by the unit tests and for debugging
		public BinaryNode(Integer element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public BinaryNode insert(Integer e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e < data) {
				left = left.insert(e);
			} else if (e > data) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}

		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.data + right.toString();
		}


		public void toArrayList(ArrayList<Integer> al) {
			if (this == NULL_NODE) {
				return;
			}
			left.toArrayList(al);
			al.add(this.data);
			right.toArrayList(al);
		}

		public String toIndentString(String indent) {
			if (this == NULL_NODE) {
				return "";
			}
			String myInfo = indent + String.format("%d\n", this.data);
			return myInfo + this.left.toIndentString(indent + "  ") + this.right.toIndentString(indent + "  ");
		}
	}

}