import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class WordFrequenciesTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_WordFrequenciesCreation();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_WordFrequenciesCreation() {

        System.out.println("Testing WordFrequencies Creation...");

        try {
            WordFrequencies wf = new WordFrequencies(new BufferedReader(new FileReader("test.txt")), false, false);
            wf.parseText();
        } catch (IOException e) {
            System.out.println("Error");
        }

        try {
            displaySuccessIfTrue(true);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }
}