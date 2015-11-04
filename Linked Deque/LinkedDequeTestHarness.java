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
        test_size();

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

        for(int i = -1; i > -50; i--) {
            if (i % 2 == 0) {
                d.insertLeft(new Double(i));
            } else {
                d.insertLeft(new Integer(i));
            }
        }

        compare = "[-49][-48.0][-47][-46.0][-45][-44.0][-43][-42.0][-41][-40.0][-39][-38.0][-37][-36.0][-35][-34.0][-33][-32.0][-31][-30.0][-29][-28.0][-27][-26.0][-25][-24.0][-23][-22.0][-21][-20.0][-19][-18.0][-17][-16.0][-15][-14.0][-13][-12.0][-11][-10.0][-9][-8.0][-7][-6.0][-5][-4.0][-3][-2.0][-1][0][1.0][2][3.0][4][5.0][6][7.0][8][9.0][10][11.0][12][13.0][14][15.0][16][17.0][18][19.0][20][21.0][22][23.0][24][25.0][26][27.0][28][29.0][30][31.0][32][33.0][34][35.0][36][37.0][38][39.0][40][41.0][42][43.0][44][45.0][46][47.0][48][49.0][50][51.0][52][53.0][54][55.0][56][57.0][58][59.0][60][61.0][62][63.0][64][65.0][66][67.0][68][69.0][70][71.0][72][73.0][74][75.0][76][77.0][78][79.0][80][81.0][82][83.0][84][85.0][86][87.0][88][89.0][90][91.0][92][93.0][94][95.0][96][97.0][98][99.0]";
           
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

        for(int i = 100; i < 150; i++) {
            if (i % 2 == 0) {
                d.insertRight(new Double(i));
            } else {
                d.insertRight(new Integer(i));
            }
        }

        compare = "[0][1.0][2][3.0][4][5.0][6][7.0][8][9.0][10][11.0][12][13.0][14][15.0][16][17.0][18][19.0][20][21.0][22][23.0][24][25.0][26][27.0][28][29.0][30][31.0][32][33.0][34][35.0][36][37.0][38][39.0][40][41.0][42][43.0][44][45.0][46][47.0][48][49.0][50][51.0][52][53.0][54][55.0][56][57.0][58][59.0][60][61.0][62][63.0][64][65.0][66][67.0][68][69.0][70][71.0][72][73.0][74][75.0][76][77.0][78][79.0][80][81.0][82][83.0][84][85.0][86][87.0][88][89.0][90][91.0][92][93.0][94][95.0][96][97.0][98][99.0][100.0][101][102.0][103][104.0][105][106.0][107][108.0][109][110.0][111][112.0][113][114.0][115][116.0][117][118.0][119][120.0][121][122.0][123][124.0][125][126.0][127][128.0][129][130.0][131][132.0][133][134.0][135][136.0][137][138.0][139][140.0][141][142.0][143][144.0][145][146.0][147][148.0][149]";
           
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

        compare = "[198.0][196.0][194.0][192.0][190.0][188.0][186.0][184.0][182.0][180.0][178.0][176.0][174.0][172.0][170.0][168.0][166.0][164.0][162.0][160.0][158.0][156.0][154.0][152.0][150.0][148.0][146.0][144.0][142.0][140.0][138.0][136.0][134.0][132.0][130.0][128.0][126.0][124.0][122.0][120.0][118.0][116.0][114.0][112.0][110.0][108.0][106.0][104.0][102.0][100.0][98][96][94][92][90][88][86][84][82][80][78][76][74][72][70][68][66][64][62][60][58][56][54][52][50][48][46][44][42][40][38][36][34][32][30][28][26][24][22][20][18][16][14][12][10][8][6][4][2][0][1.0][3.0][5.0][7.0][9.0][11.0][13.0][15.0][17.0][19.0][21.0][23.0][25.0][27.0][29.0][31.0][33.0][35.0][37.0][39.0][41.0][43.0][45.0][47.0][49.0][51.0][53.0][55.0][57.0][59.0][61.0][63.0][65.0][67.0][69.0][71.0][73.0][75.0][77.0][79.0][81.0][83.0][85.0][87.0][89.0][91.0][93.0][95.0][97.0][99.0][101][103][105][107][109][111][113][115][117][119][121][123][125][127][129][131][133][135][137][139][141][143][145][147][149][151][153][155][157][159][161][163][165][167][169][171][173][175][177][179][181][183][185][187][189][191][193][195][197][199]";

        for(int i = 100; i < 200; i++) {
            if (i % 2 == 0) {
                d.insertLeft(new Double(i));
            } else {
                d.insertRight(new Integer(i));
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

        for (int i = 0; i < 74; i++) {
            d.deleteLeft();
        }

        compare = "[99.0]";
           
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

        for (int i = 0; i < 74; i++) {
            d.deleteRight();
        }

        compare = "[98]";
           
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

        for (int i = 0; i < 24; i++) {
            d.deleteLeft();
            d.deleteRight();
        }

        compare = "[0][1.0]";

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

        try {
            displaySuccessIfTrue(d.size() == 100);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        for (int i = 0; i < 25; i++) {
            d.deleteLeft();
            d.deleteRight();
        }

        try {
            displaySuccessIfTrue(d.size() == 50);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }
}