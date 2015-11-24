public class BinaryTree {

	public class Node {

		private Node right;
		private Node left;
		private Object obj;

		public Node() {
			this.obj = null;
			this.right = null;
			this.left = null;
		}

		public Node(Object o) {
			this.obj = o;
			this.right = null;
			this.left = null;
		}

		public Node(Object o, Node r) {
			this.obj = o;
			this.right = r;
			this.left = null;
		}

		public Node(Object o, Node r, Node l) {
			this.obj = o;
			this.right = r;
			this.left = l;
		}

		public Object getObj() {
			return this.obj;
		}

		public void setObj(Object o) {
			this.obj = o;
		}

		public boolean hasObject() {
			return this.obj != null;
		}

		public void setRight(Node r) {
			this.right = r;
		}

		public void setLeft(Node l) {
			this.left = l;
		}

		public void createRight(Object o) {
			this.right = new Node(o, null, this);
		}

		public void createLeft(Object o) {
			this.left = new Node(o, this);
		}

		public Node getRight() {
			return this.right;
		}

		public Node getLeft() {
			return this.left;
		}

		public void removeRight() {
			this.right = null;
		}

		public void removeLeft() {
			this.left = null;
		}

		public String toString() {
			return this.obj.toString();
		}
	}

	//Constructs an empty tree
	public BinaryTree(){

	}

	//Constructs a tree with just a root node decorated with (i.e., referring to) obj
	public BinaryTree(Object obj) {

	}

	//Return true iff the tree contains an object equivalent to obj
	public boolean contains(Object obj) {

	}

	//Return true iff obj is a similar binary tree - i.e., obj must have identical structure (only)
	public boolean similar(Object obj) {

	}

	//Return true iff obj is an equivalent binary tree - i.e., obj must have identical structure and equivalent objects
	public boolean equals(Object obj) {

	}

	//Checks if tree is empty
	public boolean isEmpty() {

	}

	//Returns tree size
	public int size() {

	}

	//Returns tree hashcode
	public int hashcode() {

	}

	//Should returnn a preorder iterator over the tree
	public Iterator iterator() {

	}

	//Should return an inorder iterator over the tree
	public Iterator inOrder() {

	}

	//Returns false if this is an empty tree
	public boolean putCursorAtRoot() {

	}

	//Returns false if Node.leftSon is null
	public boolean putCursorAtLeftSon() {

	}

	//Returns false if Node.rightSon is null
	public boolean putCursorAtRightSon() {

	}

	//Returns false if Node.father is null
	public boolean putCursorAtFather() {

	}

	//Returns false if a Node.leftSon already exists
	public boolean attachLeftSonAtCursor(Object obj) {

	}

	//Returns false if a Node.rightSon already exists
	public boolean attachRightSonAtCursor(Object obj) {

	}

	//Removes everything that descends from the cursor, including the node to which the cursor refers, then relocates the cursor to the root node, returning true iff something (including the cursor) changed
	public boolean pruneFromCursor() {

	}
}