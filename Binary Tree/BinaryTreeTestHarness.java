 import java.util.Iterator;
 import java.util.Arrays;
 import java.util.Stack;

 public class BinaryTreeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_BinaryTreeCreation();
        test_similar();
        test_equals();
        test_iterator();
        test_inOrder();
        test_size();
        test_pruneFromCursor();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_BinaryTreeCreation() {

        System.out.println("Testing BinaryTreeCreation...");

        BinaryTree t = new BinaryTree();
        BinaryTree b = new BinaryTree();

        try {
            displaySuccessIfTrue(t.equals(new BinaryTree()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.createRoot(new Integer(2));
        b.createRoot(new Integer(2));

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.attachLeftSonAtCursor(new Integer(5));
        t.attachRightSonAtCursor(new Integer(6));
        b.attachLeftSonAtCursor(new Integer(5));
        b.attachRightSonAtCursor(new Integer(6));

        try {
            displaySuccessIfTrue(t.equals(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        t.attachLeftSonAtCursor(new Integer(10));
        t.attachRightSonAtCursor(new Integer(12));
        b.attachLeftSonAtCursor(new Integer(10));
        b.attachRightSonAtCursor(new Integer(12));

        try {
            displaySuccessIfTrue(t.equals(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtRightSon();
        b.putCursorAtRightSon();

        t.attachRightSonAtCursor(new Integer(15));
        b.attachRightSonAtCursor(new Integer(15));

        try {
            displaySuccessIfTrue(t.equals(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        for (int i = 0; i < 100; i++) {
            t.putCursorAtRightSon();
            b.putCursorAtRightSon();

            t.attachRightSonAtCursor(new Integer(i));
            b.attachRightSonAtCursor(new Integer(i));
        }

        try {
            displaySuccessIfTrue(t.equals(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_similar() {

        System.out.println("Testing similar()...");

        BinaryTree t = new BinaryTree();
        BinaryTree b = new BinaryTree();

        try {
            displaySuccessIfTrue(t.similar(new BinaryTree()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.createRoot(new Integer(2));
        b.createRoot(new Integer(4));

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.attachLeftSonAtCursor(new Integer(5));
        t.attachRightSonAtCursor(new Integer(6));
        b.attachLeftSonAtCursor(new Integer(7));
        b.attachRightSonAtCursor(new Integer(8));

        try {
            displaySuccessIfTrue(t.similar(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        t.attachLeftSonAtCursor(new Integer(10));
        t.attachRightSonAtCursor(new Integer(12));
        b.attachLeftSonAtCursor(new Integer(14));
        b.attachRightSonAtCursor(new Integer(16));

        try {
            displaySuccessIfTrue(t.similar(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtRightSon();
        b.putCursorAtRightSon();

        t.attachRightSonAtCursor(new Integer(15));
        b.attachRightSonAtCursor(new Integer(17));

        try {
            displaySuccessIfTrue(t.similar(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        for (int i = 0; i < 100; i++) {
            t.putCursorAtRightSon();
            b.putCursorAtRightSon();

            t.attachRightSonAtCursor(new Integer(i));
            b.attachRightSonAtCursor(new Integer(i * 2));
        }

        try {
            displaySuccessIfTrue(t.similar(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_equals() {

        System.out.println("Testing equals()...");

        BinaryTree t = new BinaryTree();
        BinaryTree b = new BinaryTree();

        try {
            displaySuccessIfTrue(t.equals(new BinaryTree()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.createRoot(new Integer(2));
        b.createRoot(new Integer(2));

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.attachLeftSonAtCursor(new Integer(5));
        t.attachRightSonAtCursor(new Integer(6));
        b.attachLeftSonAtCursor(new Integer(5));
        b.attachRightSonAtCursor(new Integer(6));

        try {
            displaySuccessIfTrue(t.equals(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        t.attachLeftSonAtCursor(new Integer(10));
        t.attachRightSonAtCursor(new Integer(12));
        b.attachLeftSonAtCursor(new Integer(10));
        b.attachRightSonAtCursor(new Integer(12));

        try {
            displaySuccessIfTrue(t.equals(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtRightSon();
        b.putCursorAtRightSon();

        t.attachRightSonAtCursor(new Integer(15));
        b.attachRightSonAtCursor(new Integer(15));

        try {
            displaySuccessIfTrue(t.equals(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        for (int i = 0; i < 100; i++) {
            t.putCursorAtRightSon();
            b.putCursorAtRightSon();

            t.attachRightSonAtCursor(new Integer(i));
            b.attachRightSonAtCursor(new Integer(i));
        }

        try {
            displaySuccessIfTrue(t.equals(b));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        BinaryTree tr = new BinaryTree();
        BinaryTree bi = new BinaryTree();

        try {
            displaySuccessIfTrue(tr.equals(new BinaryTree()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        tr.createRoot(new Integer(2));
        bi.createRoot(new Integer(4));

        tr.putCursorAtRoot();
        bi.putCursorAtRoot();

        tr.attachLeftSonAtCursor(new Integer(5));
        tr.attachRightSonAtCursor(new Integer(6));
        bi.attachLeftSonAtCursor(new Integer(5));
        bi.attachRightSonAtCursor(new Integer(6));

        try {
            displaySuccessIfTrue(!tr.equals(bi));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        tr.putCursorAtLeftSon();
        bi.putCursorAtLeftSon();

        tr.attachLeftSonAtCursor(new Integer(10));
        tr.attachRightSonAtCursor(new Integer(12));
        bi.attachLeftSonAtCursor(new Integer(10));
        bi.attachRightSonAtCursor(new Integer(12));

        try {
            displaySuccessIfTrue(!tr.equals(bi));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        tr.putCursorAtRoot();
        bi.putCursorAtRoot();

        tr.putCursorAtRightSon();
        bi.putCursorAtRightSon();

        tr.attachRightSonAtCursor(new Integer(15));
        bi.attachRightSonAtCursor(new Integer(15));

        try {
            displaySuccessIfTrue(!tr.equals(bi));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        tr.putCursorAtRoot();
        bi.putCursorAtRoot();

        tr.putCursorAtLeftSon();
        bi.putCursorAtLeftSon();

        for (int i = 0; i < 100; i++) {
            tr.putCursorAtRightSon();
            bi.putCursorAtRightSon();

            tr.attachRightSonAtCursor(new Integer(i));
            bi.attachRightSonAtCursor(new Integer(i));
        }

        try {
            displaySuccessIfTrue(!tr.equals(bi));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_iterator() {

        System.out.println("Testing iterator()...");

        BinaryTree t = new BinaryTree(new Integer(2));
        BinaryTree b = new BinaryTree(new Integer(20));

        Iterator tIt = t.iterator();
        Iterator bIt = b.iterator();

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(20)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.attachLeftSonAtCursor(new Integer(5));
        t.attachRightSonAtCursor(new Integer(6));
        b.attachLeftSonAtCursor(new Integer(50));
        b.attachRightSonAtCursor(new Integer(60));

        tIt = t.iterator();
        bIt = b.iterator();

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(5)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(6)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(20)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(50)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(60)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        t.attachLeftSonAtCursor(new Integer(10));
        t.attachRightSonAtCursor(new Integer(12));
        b.attachLeftSonAtCursor(new Integer(100));
        b.attachRightSonAtCursor(new Integer(120));

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtRightSon();
        b.putCursorAtRightSon();

        t.attachRightSonAtCursor(new Integer(15));
        b.attachRightSonAtCursor(new Integer(150));

        tIt = t.iterator();
        bIt = b.iterator();

        for (int i = 0; i < 4; i++) {
            tIt.next();
            bIt.next();
        }

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(6)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(15)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(60)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(150)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_inOrder() {

        System.out.println("Testing inOrder()...");

        BinaryTree t = new BinaryTree(new Integer(2));
        BinaryTree b = new BinaryTree(new Integer(20));

        Iterator tIt = t.inOrder();
        Iterator bIt = b.inOrder();

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(20)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.attachLeftSonAtCursor(new Integer(5));
        t.attachRightSonAtCursor(new Integer(6));
        b.attachLeftSonAtCursor(new Integer(50));
        b.attachRightSonAtCursor(new Integer(60));

        tIt = t.inOrder();
        bIt = b.inOrder();

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(5)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(6)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(50)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(20)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(60)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        t.attachLeftSonAtCursor(new Integer(10));
        t.attachRightSonAtCursor(new Integer(12));
        b.attachLeftSonAtCursor(new Integer(100));
        b.attachRightSonAtCursor(new Integer(120));

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtRightSon();
        b.putCursorAtRightSon();

        t.attachRightSonAtCursor(new Integer(15));
        b.attachRightSonAtCursor(new Integer(150));

        tIt = t.inOrder();
        bIt = b.inOrder();

        for (int i = 0; i < 4; i++) {
            tIt.next();
            bIt.next();
        }

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(6)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(tIt.next().equals(new Integer(15)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!tIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(60)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(bIt.next().equals(new Integer(150)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!bIt.hasNext());
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_size() {

        System.out.println("Testing size()...");

        BinaryTree t = new BinaryTree();
        BinaryTree b = new BinaryTree();

        try {
            displaySuccessIfTrue(t.equals(new BinaryTree()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(t.size() == 0);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.createRoot(new Integer(2));
        b.createRoot(new Integer(2));

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        try {
            displaySuccessIfTrue(t.size() == 1);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.attachLeftSonAtCursor(new Integer(5));
        t.attachRightSonAtCursor(new Integer(6));
        b.attachLeftSonAtCursor(new Integer(5));
        b.attachRightSonAtCursor(new Integer(6));

        try {
            displaySuccessIfTrue(t.size() == 3);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        t.attachLeftSonAtCursor(new Integer(10));
        t.attachRightSonAtCursor(new Integer(12));
        b.attachLeftSonAtCursor(new Integer(10));
        b.attachRightSonAtCursor(new Integer(12));

        try {
            displaySuccessIfTrue(t.size() == 5);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtRightSon();
        b.putCursorAtRightSon();

        t.attachRightSonAtCursor(new Integer(15));
        b.attachRightSonAtCursor(new Integer(15));

        try {
            displaySuccessIfTrue(t.size() == 6);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtRoot();
        b.putCursorAtRoot();

        t.putCursorAtLeftSon();
        b.putCursorAtLeftSon();

        for (int i = 0; i < 100; i++) {
            t.putCursorAtRightSon();
            b.putCursorAtRightSon();

            t.attachRightSonAtCursor(new Integer(i));
            b.attachRightSonAtCursor(new Integer(i));
        }

        try {
            displaySuccessIfTrue(t.size() == 106);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_pruneFromCursor() {

        System.out.println("Testing pruneFromCursor()...");

        BinaryTree t = new BinaryTree();

        t.createRoot(new Integer(2));

        t.putCursorAtRoot();

        t.attachLeftSonAtCursor(new Integer(5));
        t.attachRightSonAtCursor(new Integer(6));

        t.putCursorAtLeftSon();

        t.attachLeftSonAtCursor(new Integer(10));
        t.attachRightSonAtCursor(new Integer(12));

        t.putCursorAtRoot();

        t.putCursorAtRightSon();

        t.attachRightSonAtCursor(new Integer(15));

        Integer[] intPreOr = new Integer[]{new Integer(2), new Integer(5), new Integer(10), new Integer(12), new Integer(6), new Integer(15)};
        Integer[] intInOr = new Integer[]{new Integer(10), new Integer(5), new Integer(12), new Integer(2), new Integer(6), new Integer(15)};

        try {
            displaySuccessIfTrue(Arrays.equals(t.iterator().toArray(), intPreOr));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(Arrays.equals(t.inOrder().toArray(), intInOr));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.pruneFromCursor();

        intPreOr = new Integer[]{new Integer(2), new Integer(5), new Integer(10), new Integer(12)};
        intInOr = new Integer[]{new Integer(10), new Integer(5), new Integer(12), new Integer(2)};

        try {
            displaySuccessIfTrue(Arrays.equals(t.iterator().toArray(), intPreOr));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(Arrays.equals(t.inOrder().toArray(), intInOr));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.putCursorAtLeftSon();

        t.pruneFromCursor();

        intPreOr = new Integer[]{new Integer(2)};
        intInOr = new Integer[]{new Integer(2)};

        try {
            displaySuccessIfTrue(Arrays.equals(t.iterator().toArray(), intPreOr));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(Arrays.equals(t.inOrder().toArray(), intInOr));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        t.pruneFromCursor();

        intPreOr = new Integer[]{};
        intInOr = new Integer[]{};

        try {
            displaySuccessIfTrue(Arrays.equals(t.iterator().toArray(), intPreOr));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(Arrays.equals(t.inOrder().toArray(), intInOr));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }
}