import java.util.Arrays;

public class LinkedDequeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_LinkedDequeCreation();
        test_insertLeft();
        test_insertRight();
        test_insertBoth();
        test_deleteLeft();
        test_deleteRight();
        test_deleteBoth();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_LinkedDequeCreation() {

        LinkedDeque d = new LinkedDeque();

        try {
            displaySuccessIfTrue(d.left() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(d.right() == null);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        d.insertLeft(new String("Test"));
        String compare = "[Test]";

        try {
            displaySuccessIfTrue(d.toString().equals(compare));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        d = new LinkedDeque();
        d.insertRight(new String("Test"));

        try {
            displaySuccessIfTrue(d.toString().equals(compare));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_insertLeft() {

        LinkedDeque d = new LinkedDeque();

        String compare = "[0][1.0][2][3.0][4][5.0][6][7.0][8][9.0][10][11.0][12][13.0][14][15.0][16][17.0][18][19.0][20][21.0][22][23.0][24][25.0][26][27.0][28][29.0][30][31.0][32][33.0][34][35.0][36][37.0][38][39.0][40][41.0][42][43.0][44][45.0][46][47.0][48][49.0][50][51.0][52][53.0][54][55.0][56][57.0][58][59.0][60][61.0][62][63.0][64][65.0][66][67.0][68][69.0][70][71.0][72][73.0][74][75.0][76][77.0][78][79.0][80][81.0][82][83.0][84][85.0][86][87.0][88][89.0][90][91.0][92][93.0][94][95.0][96][97.0][98][99.0]";

        for(int i = 99; i >= 0; i--) {
            if (i % 2 == 0) {
                d.insertLeft(new Integer(i));
            } else {
                d.insertLeft(new Double(i));
            }
        }
           
        try {
            displaySuccessIfTrue(d.toString().equals(compare));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_insertRight() {

        LinkedDeque d = new LinkedDeque();
        String compare = "[0][1.0][2][3.0][4][5.0][6][7.0][8][9.0][10][11.0][12][13.0][14][15.0][16][17.0][18][19.0][20][21.0][22][23.0][24][25.0][26][27.0][28][29.0][30][31.0][32][33.0][34][35.0][36][37.0][38][39.0][40][41.0][42][43.0][44][45.0][46][47.0][48][49.0][50][51.0][52][53.0][54][55.0][56][57.0][58][59.0][60][61.0][62][63.0][64][65.0][66][67.0][68][69.0][70][71.0][72][73.0][74][75.0][76][77.0][78][79.0][80][81.0][82][83.0][84][85.0][86][87.0][88][89.0][90][91.0][92][93.0][94][95.0][96][97.0][98][99.0]";

        for(int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                d.insertRight(new Integer(i));
            } else {
                d.insertRight(new Double(i));
            }
        }
           
        try {
            displaySuccessIfTrue(d.toString().equals(compare));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_insertBoth() {

        LinkedDeque d = new LinkedDeque();
        String compare = "[98][96][94][92][90][88][86][84][82][80][78][76][74][72][70][68][66][64][62][60][58][56][54][52][50][48][46][44][42][40][38][36][34][32][30][28][26][24][22][20][18][16][14][12][10][8][6][4][2][0][1.0][3.0][5.0][7.0][9.0][11.0][13.0][15.0][17.0][19.0][21.0][23.0][25.0][27.0][29.0][31.0][33.0][35.0][37.0][39.0][41.0][43.0][45.0][47.0][49.0][51.0][53.0][55.0][57.0][59.0][61.0][63.0][65.0][67.0][69.0][71.0][73.0][75.0][77.0][79.0][81.0][83.0][85.0][87.0][89.0][91.0][93.0][95.0][97.0][99.0]";

        for(int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                d.insertLeft(new Integer(i));
            } else {
                d.insertRight(new Double(i));
            }
        }
           
        try {
            displaySuccessIfTrue(d.toString().equals(compare));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_deleteLeft() {

        LinkedDeque d = new LinkedDeque();
        String compare = "[48][46][44][42][40][38][36][34][32][30][28][26][24][22][20][18][16][14][12][10][8][6][4][2][0][1.0][3.0][5.0][7.0][9.0][11.0][13.0][15.0][17.0][19.0][21.0][23.0][25.0][27.0][29.0][31.0][33.0][35.0][37.0][39.0][41.0][43.0][45.0][47.0][49.0][51.0][53.0][55.0][57.0][59.0][61.0][63.0][65.0][67.0][69.0][71.0][73.0][75.0][77.0][79.0][81.0][83.0][85.0][87.0][89.0][91.0][93.0][95.0][97.0][99.0]";

        for(int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                d.insertLeft(new Integer(i));
            } else {
                d.insertRight(new Double(i));
            }
        }

        for (int i = 0; i < 25; i++) {
            d.deleteLeft();
        }
           
        try {
            displaySuccessIfTrue(d.toString().equals(compare));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_deleteRight() {

        LinkedDeque d = new LinkedDeque();
        String compare = "[98][96][94][92][90][88][86][84][82][80][78][76][74][72][70][68][66][64][62][60][58][56][54][52][50][48][46][44][42][40][38][36][34][32][30][28][26][24][22][20][18][16][14][12][10][8][6][4][2][0][1.0][3.0][5.0][7.0][9.0][11.0][13.0][15.0][17.0][19.0][21.0][23.0][25.0][27.0][29.0][31.0][33.0][35.0][37.0][39.0][41.0][43.0][45.0][47.0][49.0]";

        for(int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                d.insertLeft(new Integer(i));
            } else {
                d.insertRight(new Double(i));
            }
        }

        for (int i = 0; i < 25; i++) {
            d.deleteRight();
        }
           
        try {
            displaySuccessIfTrue(d.toString().equals(compare));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_deleteBoth() {

        LinkedDeque d = new LinkedDeque();
        String compare = "[48][46][44][42][40][38][36][34][32][30][28][26][24][22][20][18][16][14][12][10][8][6][4][2][0][1.0][3.0][5.0][7.0][9.0][11.0][13.0][15.0][17.0][19.0][21.0][23.0][25.0][27.0][29.0][31.0][33.0][35.0][37.0][39.0][41.0][43.0][45.0][47.0][49.0]";

        for(int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                d.insertLeft(new Integer(i));
            } else {
                d.insertRight(new Double(i));
            }
        }

        for (int i = 0; i < 25; i++) {
            d.deleteLeft();
            d.deleteRight();
        }
           
        try {
            displaySuccessIfTrue(d.toString().equals(compare));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_size() {

        LinkedDeque d = new LinkedDeque();
        
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                d.insertLeft(new Integer(i));
            } else {
                d.insertRight(new Double(i));
            }
        }
    }
}