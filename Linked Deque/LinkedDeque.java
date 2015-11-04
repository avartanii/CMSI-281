public class LinkedDeque {

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

	private Node right;
	private Node left;
	private int size;

	//Default constructor
	public LinkedDeque() {
		//this.right = new Node();
		//this.left = new Node();
		//this.right.setLeft(this.left);
		//this.left.setRight(this.right);
		this.size = 0;
	}

	public void insertLeft(Object o) {
		if (this.left == null && this.right == null) {
			this.left = new Node(o);
			this.right = this.left;
			this.size += 1;
		} else if (this.left == null && this.right != null) {
			this.left = new Node(o);
			this.size += 1;
		} else {
			this.left.createLeft(o);
			this.left = this.left.getLeft();
			this.size += 1;
		}
	}

	public void insertRight(Object o) {
		if (this.right == null && this.left == null) {
			this.right = new Node(o);
			this.left = this.right;
			this.size += 1;
		} else if (this.right == null && this.left != null) {
			this.right = new Node(o);
			this.size += 1;
		} else {
			this.right.createRight(o);
			this.right = this.right.getRight();
			this.size += 1;
		}
	}

	public void deleteLeft() {
		this.left = this.left.getRight();
		this.left.removeLeft();
		this.size -= 1;
	}

	public void deleteRight() {
		this.right = this.right.getLeft();
		this.right.removeRight();
		this.size -= 1;
	}

	//Returns the left element without modifying the deque
	public Node left() {
		return this.left;
	}

	//Returns the right element without modifying the deque
	public Node right() {
		return this.right;
	}

	public int size() {
		return this.size;
	}

	//Returns [obj][obj]...[obj]
	public String toString() {
		String s = "";
		Node current = this.left;
		int counter = 1;
		while(current.getRight() != null) {
			s += current.getObj() != null ? "[" + current.getObj().toString() + "]" : "[null]"; 
			current = current.getRight();
		}
		s += current.getObj() != null ? "[" + current.getObj().toString() + "]" : "[null]"; 
		return s;
	}

	//Runs a comprehensive set of unit tests
	public static void main(String[] args) {
		LinkedDeque d = new LinkedDeque();

		d.insertRight(new String("Hello"));
		System.out.println(d.toString());
		d.insertLeft(new Integer(9));
		System.out.println(d.toString());
		d.insertLeft(new Double(89.0));
		System.out.println(d.toString());
		d.insertLeft(new String("Goodbye"));
		System.out.println(d.toString());
		d.deleteRight();
		System.out.println("Last: " + d.toString());
		System.out.println();
		System.out.println();
		System.out.println(d.left().toString());
		System.out.println(d.right().toString());
	}
}