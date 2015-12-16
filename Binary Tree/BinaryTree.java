import java.util.Iterator;
import java.util.Arrays;
import java.util.Stack;

public class BinaryTree implements Iterable {

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
			return ("Node " + this.obj.toString());
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Node)) {
				return false;
			}
			Node n = (Node) obj;
			if (this.hasLeftSon() && n.hasLeftSon() && this.hasRightSon() && n.hasRightSon() && this.hasFather() && n.hasFather()) {
				return true;
			} else if (this.hasLeftSon() && n.hasLeftSon() && this.hasRightSon() && n.hasRightSon() && !this.hasFather() && !n.hasFather()) {
				return true;
			} else if (this.hasLeftSon() && n.hasLeftSon() && !this.hasRightSon() && !n.hasRightSon() && this.hasFather() && n.hasFather()) {
				return true;
			} else if (this.hasLeftSon() && n.hasLeftSon() && !this.hasRightSon() && !n.hasRightSon() && !this.hasFather() && !n.hasFather()) {
				return true;
			} else if (!this.hasLeftSon() && !n.hasLeftSon() && this.hasRightSon() && n.hasRightSon() && this.hasFather() && n.hasFather()) {
				return true;
			} else if (!this.hasLeftSon() && !n.hasLeftSon() && this.hasRightSon() && n.hasRightSon() && !this.hasFather() && !n.hasFather()) {
				return true;
			} else if (!this.hasLeftSon() && !n.hasLeftSon() && !this.hasRightSon() && !n.hasRightSon() && this.hasFather() && n.hasFather()) {
				return true;
			} else if (!this.hasLeftSon() && !n.hasLeftSon() && !this.hasRightSon() && !n.hasRightSon() && !this.hasFather() && !n.hasFather()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public class PreOrderIterator implements Iterator {

		private BinaryTree bt;
		private Stack<Node> stack;
		private Node cursor;
		private int counter;

		public PreOrderIterator(BinaryTree binTree) {
			this.bt = binTree;
			this.stack = new Stack<Node>();
			this.cursor = this.bt.getRoot();
			this.counter = this.bt.size();
		}

		public boolean hasNext() {
			return (this.cursor != null && (this.cursor.hasLeftSon() || this.cursor.hasRightSon() || !this.stack.isEmpty() || this.counter > 0));
		}

		public Object next() {
			Object obj = this.cursor.getObj();
			this.counter -= 1;
			if (this.cursor.hasLeftSon() && this.cursor.hasRightSon()) {
				this.stack.push(this.cursor.getRightSon());
				this.cursor = this.cursor.getLeftSon();
			} else if (this.cursor.hasLeftSon()) {
				this.cursor = this.cursor.getLeftSon();
			} else if (this.cursor.hasRightSon()) {
				this.cursor = this.cursor.getRightSon();
			} else if (!this.stack.isEmpty()) {
				this.cursor = this.stack.pop();
			}
			return obj;
		}

		public Object[] toArray() {
			PreOrderIterator preOr = new PreOrderIterator(bt);
			Object[] preOrder = new Object[this.bt.size()];
			for (int i = 0; i < preOrder.length && this.cursor != null; i++) {
				preOrder[i] = preOr.next();
			}
			return preOrder;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public class InOrderIterator implements Iterator {

		private BinaryTree bt;
		private Stack<Node> stack;
		private Node cursor;
		private int counter;
		private boolean stackInitialized;

		public InOrderIterator(BinaryTree binTree) {
			this.bt = binTree;
			this.stack = new Stack<Node>();
			this.cursor = this.bt.getRoot();
			this.counter = this.bt.size();
			this.stackInitialized = false;
		}

		public boolean hasNext() {
			return (this.cursor.hasLeftSon() || this.cursor.hasRightSon() || !this.stack.isEmpty() || this.counter > 0);
		}

		public void initializeStack() {
			while (this.cursor.hasLeftSon()) {
				this.stack.push(this.cursor);
				this.cursor = this.cursor.getLeftSon();
			}
			this.stackInitialized = true;
		}

		public Object next() {
			if (!this.stackInitialized) {
				this.initializeStack();
			}
			Object obj = this.cursor.getObj();
			this.counter -= 1;
			if (this.cursor.hasRightSon() && this.cursor.getRightSon().hasLeftSon()) {
				this.cursor = this.cursor.getRightSon();
				this.stackInitialized = false;
			} else if (this.cursor.hasRightSon()) {
				this.cursor = this.cursor.getRightSon();
			} else if (!this.stack.isEmpty()) {
				this.cursor = this.stack.pop();
			}
			return obj;
		}

		public Object[] toArray() {
			InOrderIterator inOr = new InOrderIterator(bt);
			Object[] inOrder = new Object[this.bt.size()];
			for (int i = 0; i < inOrder.length; i++) {
				inOrder[i] = inOr.next();
			}
			return inOrder;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class NodePreOrderIterator implements Iterator {

		private BinaryTree bt;
		private Stack<Node> stack;
		private Node cursor;
		private int counter;

		public NodePreOrderIterator(BinaryTree binTree) {
			this.bt = binTree;
			this.stack = new Stack<Node>();
			this.cursor = this.bt.getRoot();
			this.counter = this.bt.size();
		}

		public boolean hasNext() {
			return (this.cursor.hasLeftSon() || this.cursor.hasRightSon() || !this.stack.isEmpty() || this.counter > 0);
		}

		public Node next() {
			Node n = this.cursor;
			this.counter -= 1;
			if (this.cursor.hasLeftSon() && this.cursor.hasRightSon()) {
				this.stack.push(this.cursor.getRightSon());
				this.cursor = this.cursor.getLeftSon();
			} else if (this.cursor.hasLeftSon()) {
				this.cursor = this.cursor.getLeftSon();
			} else if (this.cursor.hasRightSon()) {
				this.cursor = this.cursor.getRightSon();
			} else if (!this.stack.isEmpty()) {
				this.cursor = this.stack.pop();
			}
			return n;
		}

		public Node[] toArray() {
			NodePreOrderIterator preOr = new NodePreOrderIterator(bt);
			Node[] preOrder = new Node[this.bt.size()];
			for (int i = 0; i < preOrder.length; i++) {
				preOrder[i] = preOr.next();
			}
			return preOrder;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class NodeInOrderIterator implements Iterator {

		private BinaryTree bt;
		private Stack<Node> stack;
		private Node cursor;
		private int nextIndex;
		private int counter;
		private boolean stackInitialized;

		public NodeInOrderIterator(BinaryTree binTree) {
			this.bt = binTree;
			this.stack = new Stack<Node>();
			this.cursor = this.bt.getRoot();
			this.counter = this.bt.size();
			this.stackInitialized = false;
		}

		public boolean hasNext() {
			return (this.cursor.hasLeftSon() || this.cursor.hasRightSon() || !this.stack.isEmpty() || this.counter > 0);
		}

		public void initializeStack() {
			while (this.cursor.hasLeftSon()) {
				this.stack.push(this.cursor);
				this.cursor = this.cursor.getLeftSon();
			}
			this.stackInitialized = true;
		}

		public Node next() {
			if (!this.stackInitialized) {
				this.initializeStack();
			}
			Node n = this.cursor;
			this.counter -= 1;
			if (this.cursor.hasRightSon() && this.cursor.getRightSon().hasLeftSon()) {
				this.cursor = this.cursor.getRightSon();
				this.stackInitialized = false;
			} else if (this.cursor.hasRightSon()) {
				this.cursor = this.cursor.getRightSon();
			} else if (!this.stack.isEmpty()) {
				this.cursor = this.stack.pop();
			}
			return n;
		}

		public Node[] toArray() {
			NodeInOrderIterator inOr = new NodeInOrderIterator(bt);
			Node[] inOrder = new Node[this.bt.size()];
			for (int i = 0; i < inOrder.length; i++) {
				inOrder[i] = inOr.next();
			}
			return inOrder;
		}

		public void remove() {
			throw new UnsupportedOperationException();
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
		this.root = new Node(obj);
		this.cursor = this.root;
		this.size = 1;
	}	

	//Returns root node of binary tree
	public Node getRoot() {
		return this.root;
	}

	public Node getCursor() {
		return this.cursor;
	}

	//Return true iff the tree contains an object equivalent to obj
	public boolean contains(Object obj) {
		PreOrderIterator it = new PreOrderIterator(this);
		Object[] arr = it.toArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	//Return true iff obj is a similar binary tree - i.e., obj must have identical structure (only)
	public boolean similar(Object obj) {
		BinaryTree t = (BinaryTree) obj;

		if (this.size != t.size()) {
			return false;
		}

		NodePreOrderIterator thispO = (NodePreOrderIterator) this.nodePreOrder();
		NodeInOrderIterator thisiO = (NodeInOrderIterator) this.nodeInOrder();
		NodePreOrderIterator thatpO = (NodePreOrderIterator) t.nodePreOrder();
		NodeInOrderIterator thatiO = (NodeInOrderIterator) t.nodeInOrder();
		
		return (Arrays.equals(thispO.toArray(), thatpO.toArray()) && Arrays.equals(thisiO.toArray(), thatiO.toArray()));
	}

	//Return true iff obj is an equivalent binary tree - i.e., obj must have identical structure and equivalent objects
	public boolean equals(Object obj) {
		BinaryTree t = (BinaryTree) obj;
		boolean objectsEqual = true;

		if (this.size != t.size()) {
			return false;
		}

		PreOrderIterator thispO = (PreOrderIterator) this.iterator();
		InOrderIterator thisiO = (InOrderIterator) this.inOrder();
		PreOrderIterator thatpO = (PreOrderIterator) t.iterator();
		InOrderIterator thatiO = (InOrderIterator) t.inOrder();

		for (int i = 0; i < thispO.toArray().length; i++) {
			if (!thispO.toArray()[i].equals(thatpO.toArray()[i]) || !thisiO.toArray()[i].equals(thatiO.toArray()[i])) {
				objectsEqual = false;
			}
		}

		return (objectsEqual && Arrays.equals(thispO.toArray(), thatpO.toArray()) && Arrays.equals(thisiO.toArray(), thatiO.toArray()));
	}

	//Checks if tree is empty
	public boolean isEmpty() {
		return this.size == 0;
	}

	//Returns tree size
	public int size() {
		return this.size;
	}

	public void assessSize() {
		this.size = 0;
		boolean enteredWhile = false;
		Stack<Node> sizeStack = new Stack<Node>();
		Node sizeCursor = this.root != null ? this.root : null;
		while((sizeCursor.hasLeftSon() && sizeCursor.hasRightSon()) || (sizeCursor.hasLeftSon()) || (sizeCursor.hasRightSon()) || (!sizeStack.isEmpty())) {
			if (!enteredWhile) enteredWhile = true;
			this.size += 1;
			if (sizeCursor.hasLeftSon() && sizeCursor.hasRightSon()) {
				sizeStack.push(sizeCursor.getRightSon());
				sizeCursor = sizeCursor.getLeftSon();
			} else if (sizeCursor.hasLeftSon()) {
				sizeCursor = sizeCursor.getLeftSon();
			} else if (sizeCursor.hasRightSon()) {
				sizeCursor = sizeCursor.getRightSon();
			} else if (!sizeStack.isEmpty()) {
				sizeCursor = sizeStack.pop();
			}
		}
		if (!sizeCursor.equals(this.root)) {
			this.size += 1;
		} else if (!enteredWhile) {
			this.size = 1;
		} else if (this.root.equals(null)) {
			this.size = 0;
		}
	}

	//Returns tree hashcode
	public int hashcode() {
		throw new UnsupportedOperationException();
	}

	//Should return a preorder iterator over the tree
	public PreOrderIterator iterator() {
		return new PreOrderIterator(this);
	}

	//Should return an inorder iterator over the tree
	public InOrderIterator inOrder() {
		return new InOrderIterator(this);
	}

	public Iterator nodePreOrder() {
		return new NodePreOrderIterator(this);
	}

	public Iterator nodeInOrder() {
		return new NodeInOrderIterator(this);
	}

	public void createRoot(Object obj) {
		this.root = this.root == null ? new Node(obj) : this.root;
		this.size += 1;
	}

	//Returns false if this is an empty tree
	public boolean putCursorAtRoot() {
		this.cursor = this.root != null ? this.root : null;
		return this.size > 0;
	}

	//Returns false if Node.leftSon is null
	public boolean putCursorAtLeftSon() {
		this.cursor = this.cursor.getLeftSon() != null ? this.cursor.getLeftSon() : this.cursor;
		return this.cursor.getLeftSon() != null ? true : false;
	}

	//Returns false if Node.rightSon is null
	public boolean putCursorAtRightSon() {
		this.cursor = this.cursor.getRightSon() != null ? this.cursor.getRightSon() : this.cursor;
		return this.cursor.getRightSon() != null ? true : false;
	}

	//Returns false if Node.father is null
	public boolean putCursorAtFather() {
		this.cursor = this.cursor.getFather() != null ? this.cursor.getFather() : this.cursor;
		return this.cursor.getFather() != null ? true : false;
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
		if (this.cursor.equals(this.root)) {
			this.root = null;
			this.size = 0;
			return true;
		}
		Node cutoff = this.cursor;
		this.cursor = this.cursor.getFather();
		if (this.cursor.hasLeftSon() && this.cursor.getLeftSon().equals(cutoff)) {
			this.cursor.removeLeftSon();
		} else if (this.cursor.hasRightSon() && this.cursor.getRightSon().equals(cutoff)) {
			this.cursor.removeRightSon();
		}

		this.cursor = this.root != null ? this.root : null;
		this.assessSize();
		return true;
	}
}