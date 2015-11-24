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
			this.size += 1;
		} else {
			this.cursor.getLeft().setRight(new Node(o, this.cursor, this.cursor.getLeft()));
			this.cursor.setLeft(this.cursor.getLeft().getRight());
			this.size += 1;
		}
	}

	public String toString() {
		String s = "";
		int stringSize = (int) (Math.ceil(this.size / 2));
		String[] finalString = new String[stringSize];
		Node currentRight = this.cursor;
		Node currentLeft = stringSize % 2 == 0 ? this.cursor.getLeft() : null;

		for (int i = 0; i < stringSize / 2; i++) {
			s += 
		}










		/*
		for (int i = 0; i < stringSize / 2; i++) {
			for (int j = 0; j < i; j++) {
				s += "     ";
			}
			s += current.getObj() != null ? "[" + current.getObj().toString() + "]" : "[null]";
			finalString[i] += s;
			s = "";
		}
		for (int i = stringSize / 2; i < stringSize; i++) {
			for (int j = 0; j < stringSize - i - 1; j++) {
				s += "     ";
			}
			s += current.getObj() != null ? "[" + current.getObj().toString() + "]" : "[null]";
			finalString[i] += s;
			s = "";
		}
		for (int i = stringSize - 1; i >= stringSize / 2; i--) {
			for (int j = 0; j < stringSize - i - 1; j++) {
				s += "     ";
			}
			s += current.getObj() != null ? "[" + current.getObj().toString() + "]" : "[null]";
			finalString[i] += s;
			s = "";
		}
		for (int i = stringSize / 2 - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				s += "     ";
			}
			s += current.getObj() != null ? "[" + current.getObj().toString() + "]" : "[null]";
			finalString[i] += s;
			s = "";
		}
		for (int i = 0; i < finalString.length; i++) {
			s += finalString[i] + "\n";
		}
		*/






		/*
		for (int i = 0; i < this.size; i++) {
			s += current.getObj() != null ? "[" + current.getObj().toString() + "]" : "[null]"; 
			current = current.getRight();
		}
		//s += current.getObj() != null ? "[" + current.getObj().toString() + "]" : "[null]"; 
		*/
		return s;
	}

	public static void main(String[] args) {
		CircularList l = new CircularList();
		l.add(new String("Hello"));
		l.add(new String("Hello"));
		l.add(new String("Hello"));
		l.add(new String("Hello"));
		l.add(new String("Hello"));
		l.add(new Integer(1));
		l.add(new Integer(2));
		l.add(new Integer(3));
		l.add(new Integer(4));
		l.add(new Integer(5));
		System.out.println(l.toString());
	}

}