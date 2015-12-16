import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class WordFrequencies {

	
	BufferedReader buffRead;
	HashMap<String, Integer> table;
	boolean sensitive;
	boolean clean;
	
	public WordFrequencies(BufferedReader bf, boolean sense, boolean cl) {
		this.buffRead = bf;
		this.table = new HashMap<String, Integer>();
		this.sensitive = sense;
		this.clean = cl;
	}

	public HashMap<String, Integer> getTable() {
		return this.table;
	}

	public void parseText() throws IOException {
		try {
			String s = this.buffRead.readLine();
			String curr = "";
			Integer val;
			Scanner scan;
			while (s != null) {
				scan = new Scanner(s);
				scan.useDelimiter("[^\\w\\-\\']");
				while(scan.hasNext()) {
					curr = scan.next();
					curr = curr.equals("") && scan.hasNext() ? scan.next() : curr;
					curr = curr.replaceAll("[\\W]", "");
					curr = !this.sensitive ? curr.toUpperCase() : curr;
					if (this.table.containsKey(curr)) {
						val = this.table.get(curr);
						this.table.put(curr, new Integer(val.intValue() + 1));
					} else {
						this.table.put(curr, new Integer(1));
					}
				}
				s = this.buffRead.readLine();
				scan.close();
			}
		} catch (IOException e) {
			System.out.println("Error");
		}
	}

	public void sortAndPrint() {
		ArrayList<String> keys = new ArrayList<String>(this.table.keySet());
		ArrayList<Integer> vals = new ArrayList<Integer>();
		Collections.sort(keys);
		Integer val;
		String curr;
		for (int i = 0; i < keys.size(); i++) {
			curr = keys.get(i);
			System.out.print(curr);
			for (int j = 0; j < 5 + (10 - curr.length()); j++) {
				System.out.print(" ");
			}
			if (this.clean) {
				System.out.println();
			} else {
				System.out.println(table.get(curr).toString());
			}
		}
	}

	public static boolean[] parseArgs(String[] arr) {
		if (arr.length > 1) {
			throw new IllegalArgumentException();
		}
		if (arr.length > 0 && !arr[0].substring(0,1).equals("-")) {
			System.out.println("Arrs suck");
			throw new IllegalArgumentException();
		}
		boolean[] conditions = new boolean[]{false, false};
		if (arr.length > 0) {
			if (arr[0].contains("s")) {
				conditions[0] = true;
			}
			if (arr[0].contains("c")) {
				conditions[1] = true;
			}
		}
			return conditions;
		}


		public static void main(String[] args) {
			try {
			boolean[] cond = parseArgs(args);
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				WordFrequencies wf = new WordFrequencies(reader, cond[0], cond[1]);
				wf.parseText();
				wf.sortAndPrint();
			} catch (Exception e) {
				System.out.println("Error");
			}
		}
	}