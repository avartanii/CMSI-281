 import java.util.Arrays;

 public class BinaryTreeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_BinaryTreeCreation();
        test_similar();
        test_equals();
        test_iterators();


        /*
        test_size();
        test_pruneFromCursor();
        */

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_BinaryTreeCreation() {

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

    private static void test_iterators() {

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
}