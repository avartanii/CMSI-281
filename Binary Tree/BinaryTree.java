import java.util.Iterator;
import java.util.Arrays;

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
			return ("Node" + this.obj.toString());
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Node)) {
				return false;
			}
			Node n = (Node) obj;
			/*if (!this.obj.equals(n.getObj())) {
				return false;
			}*/
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
		private Node[] stack;
		private Node cursor;
		private int nextIndex;

		public PreOrderIterator(BinaryTree binTree) {
			this.bt = binTree;
			this.stack = new Node[this.bt.size()];
			this.cursor = this.bt.getRoot();
			this.nextIndex = 0;
		}

		public boolean hasNext() {
			return (this.cursor.hasLeftSon() || this.cursor.hasRightSon() || this.stack[0] != null);
		}

		public Object next() {
			Object obj = this.cursor.getObj();
			if (this.cursor.hasLeftSon() && this.cursor.hasRightSon()) {
				this.stack[nextIndex] = this.cursor.getRightSon();
				this.nextIndex += 1;
				this.cursor = this.cursor.getLeftSon();
			} else if (this.cursor.hasLeftSon()) {
				this.cursor = this.cursor.getLeftSon();
			} else if (this.cursor.hasRightSon()) {
				this.cursor = this.cursor.getRightSon();
			} else if (this.stack[0] != null) {
				this.cursor = this.stack[nextIndex - 1];
				this.stack[nextIndex - 1] = null;
				this.nextIndex -= 1;
			}
			return obj;
		}

		public Object[] toArray() {
			PreOrderIterator preOr = new PreOrderIterator(bt);
			Object[] preOrder = new Object[this.bt.size()];
			for (int i = 0; i < preOrder.length; i++) {
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
		private Node[] stack;
		private Node cursor;
		private int nextIndex;
		private boolean stackInitialized;

		public InOrderIterator(BinaryTree binTree) {
			this.bt = binTree;
			this.stack = new Node[this.bt.size()];
			this.cursor = this.bt.getRoot();
			this.nextIndex = 0;
			this.stackInitialized = false;
		}

		public boolean hasNext() {
			return (this.cursor.hasLeftSon() || this.cursor.hasRightSon() || this.stack[0] != null);
		}

		public void initializeStack() {
			while (this.cursor.hasLeftSon()) {
				this.stack[nextIndex] = this.cursor;
				this.cursor = this.cursor.getLeftSon();
				this.nextIndex += 1;
			}
			this.stackInitialized = true;
		}

		public Object next() {
			if (!this.stackInitialized) {
				this.initializeStack();
			}
			Object obj = this.cursor.getObj();
			if (this.cursor.hasRightSon() && this.cursor.getRightSon().hasLeftSon()) {
				this.cursor = this.cursor.getRightSon();
				this.stackInitialized = false;
			} else if (this.cursor.hasRightSon()) {
				this.cursor = this.cursor.getRightSon();
			} else if (this.stack[0] != null) {
				this.cursor = this.stack[nextIndex - 1];
				this.stack[nextIndex - 1] = null;
				this.nextIndex -= 1;
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
		private Node[] stack;
		private Node cursor;
		private int nextIndex;

		public NodePreOrderIterator(BinaryTree binTree) {
			this.bt = binTree;
			this.stack = new Node[this.bt.size()];
			this.cursor = this.bt.getRoot();
			this.nextIndex = 0;
		}

		public boolean hasNext() {
			return (this.cursor.hasLeftSon() || this.cursor.hasRightSon() || this.stack[0] != null);
		}

		public Node next() {
			Node n = this.cursor;
			if (this.cursor.hasLeftSon() && this.cursor.hasRightSon()) {
				this.stack[nextIndex] = this.cursor.getRightSon();
				this.nextIndex += 1;
				this.cursor = this.cursor.getLeftSon();
			} else if (this.cursor.hasLeftSon()) {
				this.cursor = this.cursor.getLeftSon();
			} else if (this.cursor.hasRightSon()) {
				this.cursor = this.cursor.getRightSon();
			} else if (this.stack[0] != null) {
				this.cursor = this.stack[nextIndex - 1];
				this.stack[nextIndex - 1] = null;
				this.nextIndex -= 1;
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
		private Node[] stack;
		private Node cursor;
		private int nextIndex;
		private boolean stackInitialized;

		public NodeInOrderIterator(BinaryTree binTree) {
			this.bt = binTree;
			this.stack = new Node[this.bt.size()];
			this.cursor = this.bt.getRoot();
			this.nextIndex = 0;
			this.stackInitialized = false;
		}

		public boolean hasNext() {
			return (this.cursor.hasLeftSon() || this.cursor.hasRightSon() || this.stack[0] != null);
		}

		public void initializeStack() {
			while (this.cursor.hasLeftSon()) {
				stack[nextIndex] = this.cursor;
				this.cursor = this.cursor.getLeftSon();
				nextIndex += 1;
			}
			this.stackInitialized = true;
		}

		public Node next() {
			if (!this.stackInitialized) {
				this.initializeStack();
			}
			Node n = this.cursor;
			if (this.cursor.hasRightSon() && this.cursor.getRightSon().hasLeftSon()) {
				this.cursor = this.cursor.getRightSon();
				this.stackInitialized = false;
			} else if (this.cursor.hasRightSon()) {
				this.cursor = this.cursor.getRightSon();
			} else if (this.stack[0] != null) {
				this.cursor = this.stack[nextIndex - 1];
				this.stack[nextIndex - 1] = null;
				this.nextIndex -= 1;
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
		Node cutoff = new Node(this.cursor);
		this.cursor = this.cursor.getFather();
		cutoff.setFather(null);
		if (this.cursor.getLeftSon().getFather() == null) {
			this.cursor.setLeftSon(null);
		} else if (this.cursor.getRightSon().getFather() == null) {
			this.cursor.setRightSon(null);
		}
		this.cursor = this.root;
		PreOrderIterator pO = (PreOrderIterator) new PreOrderIterator(this);
		this.size = pO.toArray().length;
		return true;
	}
}