public class BinaryTree {

	public class Node {

		private Node leftSon;
		private Node rightSon;
		private Node father;
		private Object obj;

		public Node() {
			this.obj = null;
			this.leftSon = null;
			this.rightSon = null;
			this.father = null;
		}

		public Node(Object o) {
			this.obj = o;
			this.leftSon = null;
			this.rightSon = null;
			this.father = null;
		}

		public Node(Object o, Node l) {
			this.obj = o;
			this.leftSon = l;
			this.rightSon = null;
			this.father = null;
		}

		public Node(Object o, Node l, Node r) {
			this.obj = o;
			this.leftSon = l;
			this.rightSon = r;
			this.father = null;
		}

		public Node(Object o, Node l, Node r, Node f) {
			this.obj = o;
			this.leftSon = l;
			this.rightSon = r;
			this.father = f;
		}

		public Node(Node n) {
			this.obj = n.getObj();
			this.leftSon = n.getLeftSon();
			this.rightSon = n.getRightSon();
			this.father = n.getFather();
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

		public boolean hasLeftSon() {
			return this.leftSon != null;
		}

		public boolean hasRightSon() {
			return this.rightSon != null;
		}

		public boolean hasFather() {
			return this.father != null;
		}

		public void setLeftSon(Node l) {
			this.leftSon = l;
		}

		public void setRightSon(Node r) {
			this.rightSon = r;
		}

		public void setFather(Node f) {
			this.father = f;
		}

		public void createLeftSon(Object o) {
			this.leftSon = new Node(o, null, null, this);
		}

		public void createRightSon(Object o) {
			this.rightSon = new Node(o, null, null, this);
		}

		public void createFatherFromLeft(Object o) {
			this.father = new Node(o, this, null, null);
		}

		public void createFatherFromRight(Object o) {
			this.father = new Node(o, null, this, null);
		}

		public Node getLeftSon() {
			return this.leftSon;
		}

		public Node getRightSon() {
			return this.rightSon;
		}

		public Node getFather() {
			return this.father;
		}

		public void removeLeftSon() {
			this.leftSon = null;
		}

		public void removeRightSon() {
			this.rightSon = null;
		}

		public void removeFather() {
			this.father = null;
		}

		public String toString() {
			return this.obj.toString();
		}
	}

	private Node cursor;
	private Node root;
	private int size;

	//Constructs an empty tree
	public BinaryTree(){
		this.cursor = null;
		this.size = 0;
	}

	//Constructs a tree with just a root node decorated with (i.e., referring to) obj
	public BinaryTree(Object obj) {
		this.root = new Node(o);
		this.cursor = this.root;
		this.size = 1;
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
		return this.size == 0;
	}

	//Returns tree size
	public int size() {
		return this.size;
	}

	//????????????????????????????????????????????
	//????????????????????????????????????????????
	//????????????????????????????????????????????
	//Returns tree hashcode
	public int hashcode() {

	}

	//????????????????????????????????????????????
	//????????????????????????????????????????????
	//????????????????????????????????????????????
	//Should return a preorder iterator over the tree
	public Iterator iterator() {

	}

	//????????????????????????????????????????????
	//????????????????????????????????????????????
	//????????????????????????????????????????????
	//Should return an inorder iterator over the tree
	public Iterator inOrder() {

	}

	//Returns false if this is an empty tree
	public boolean putCursorAtRoot() {
		cursor = this.root;
	}

	//Returns false if Node.leftSon is null
	public boolean putCursorAtLeftSon() {
		cursor = this.leftSon;
	}

	//Returns false if Node.rightSon is null
	public boolean putCursorAtRightSon() {
		cursor = this.rightSon;
	}

	//Returns false if Node.father is null
	public boolean putCursorAtFather() {
		cursor = this.father;
	}

	//Returns false if a Node.leftSon already exists
	public boolean attachLeftSonAtCursor(Object obj) {
		if (!cursor.hasLeftSon()) {
			cursor.createLeftSon(obj);
			this.size += 1;
			return true;
		}
		return false;
	}

	//Returns false if a Node.rightSon already exists
	public boolean attachRightSonAtCursor(Object obj) {
		if (!cursor.hasRightSon()) {
			cursor.createRightSon(obj);
			this.size += 1;
			return true;
		}
		return false;
	}

	//Removes everything that descends from the cursor, including the node to which the cursor refers, then relocates the cursor to the root node, returning true iff something (including the cursor) changed
	public boolean pruneFromCursor() {
		Node cutoff = new Node(this.cursor);
		this.cursor = this.cursor.getFather();
		cutoff.setFather(null);
		if (this.cursor.getLeftSon().getObj().equals(cutoff.getObj())) {
			this.cursor.setLeftSon(null);
		} else if (this.cursor.getRightSon().getObj().equals(cutoff.getObj())) {
			this.cursor.setRightSon(null);
		}
		this.cursor = this.root;
		return true;
	}
}