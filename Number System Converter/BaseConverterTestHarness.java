import java.util.Arrays;

public class BaseConverterTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_NumberCreation();
        test_Conversion();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_NumberCreation() {
        System.out.println("Testing Number constructors...");

        String num1 = "[1][2][3][4][5][6][7][8][9]";

        Number num = new Number(num1, 10);
        
        try {
            displaySuccessIfTrue(num.getBase() == 10);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(Arrays.equals(num.getDigits(), new int[]{9,8,7,6,5,4,3,2,1}));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(num.getDigitsValue(6) == 3);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        /*try {
            Number n = new Number("[12]");
            displaySuccessIfTrue(true);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }*/

        try {
            Runtime.getRuntime().exec("java BaseConverter [12]");
            displaySuccessIfTrue(true);
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

    }


    private static void test_Conversion() {
        System.out.println("Testing Number conversions...");

        String num1 = "[1][2][3][4][5][6][7][8][9]";

        Number num = new Number(num1, 10);

        try {
            displaySuccessIfTrue(num.convert(1000).equals(new Number("[123][456][789]", 1000)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(num.convert(2).equals(new Number("[1][1][1][0][1][0][1][1][0][1][1][1][1][0][0][1][1][0][1][0][0][0][1][0][1][0][1]", 2)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(num.convert(2).convert(10).equals(new Number("[1][2][3][4][5][6][7][8][9]", 10)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }
}

/*
(A) Some tests for invalid inputs:

java BaseConverter [12]
java BaseConverter 123 4 5
java BaseConverter [0] 1 2
java BaseConverter [0] 2 1
java BaseConverter [3][1][0][4][2] 4
java BaseConverter [3][1][0][4][2] 4 5 6
java BaseConverter [3][1][0][][2] 4
java BaseConverter [3][1][0]]3[[2] 4
java BaseConverter [3][1][0][x][2] 4
java BaseConverter [3][1][0][-1][2] 4


(B) Some edge cases, i.e., valid, but somewhat degenerate, inputs:

java BaseConverter [0] 10       should output [0]
java BaseConverter [0] 10 5     should output [0]
java BaseConverter [0] 5        should output [0]
java BaseConverter [1] 5        should output [1]
java BaseConverter [1] 10 5     should output [1]
java BaseConverter [1] 10       should output [1]
java BaseConverter [9] 10       should output [9]
java BaseConverter [9] 10 9     should output [1][0]
java BaseConverter [9] 10 8     should output [1][1]
java BaseConverter [9] 10 5     should output [1][4]


(C) Some tests for valid, "sensible" inputs:

java BaseConverter [3][1][0][4][2] 5 3              should print [2][2][0][2][2][2][0]
java BaseConverter [2][2][0][2][2][2][0] 3 5        should print [3][1][0][4][2]
java BaseConverter [1][14][2][15] 16 2              should print [1][1][1][1][0][0][0][1][0][1][1][1][1]
java BaseConverter [5][4][3][2][1][0] 23 7          should print [5][5][3][2][4][2][1][5][6]
java BaseConverter [5][4][3][2][1][0] 23 6          should print [3][1][5][0][3][2][1][3][5][3]
java BaseConverter [15][14][3][22][21][6] 23 6      should print [1][3][5][5][0][1][5][1][1][2][3]
java BaseConverter [1][0][2][3] 10 2                should print [1][1][1][1][1][1][1][1][1][1]
java BaseConverter [1][0][2][4] 10 2                should print [1][0][0][0][0][0][0][0][0][0][0]
java BaseConverter [5][5][3][2][4][2][1][5][6] 7 23     should print [5][4][3][2][1][0]
java BaseConverter [12][20][92][0][1][99] 100 10    should print [1][2][2][0][9][2][0][0][0][1][9][9]
java BaseConverter [12][20][92][0][1][99] 100 10000     should print [1220][9200][199]
*/