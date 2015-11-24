public class CircularList {

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

	Node cursor;
	int size;

	public CircularList() {
		this.size = 0;
	}

	public void add(Object o) {
		if (this.cursor == null) {
			this.cursor = new Node(o);
			this.cursor.setRight(this.cursor);
			this.cursor.setLeft(this.cursor);
		} else {
			this.cursor.getLeft().setRight(new Node(o, this.cursor, this.cursor.getLeft()));
		}
	}

}