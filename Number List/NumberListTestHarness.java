import java.util.Arrays;

public class NumberListTestHarness {

	private static int attempts = 0;
	private static int successes = 0;

	public static void main(String[] args) {
		attempts = 0;
		successes = 0;

		/*
		try {
			displaySuccessIfTrue(true);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
		*/

		test_Constructor();
		test_add();
		test_addAll();
		test_clear();
		test_contains();
		test_containsAll();
		test_equals();
		test_isEmpty();
		test_remove();
		test_removeAll();
		test_retainAll();
		test_sizeIncludingDuplicates();
		test_toArray();
		test_size();
		test_count();
		test_toString();
		test_finalizeArray();
		test_fromArray();



		System.out.println(successes + "/" + attempts + " tests passed.");
	}

	private static void displaySuccessIfTrue(boolean value) {
		attempts++;
		successes += value ? 1 : 0;

		System.out.println(value ? "success" : "failure");
	}

	private static void test_Constructor() {
		System.out.println("Testing constructors...");

		NumberList nL = new NumberList();

		try {
			displaySuccessIfTrue(true);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_add() {
		System.out.println("Testing add()...");

		Long[] l1 = new Long[20];
		Long[] l2 = new Long[13];

		for (int i = 0; i < 20; i++) {
			l1[i] = new Long(i);
		}

		NumberList nL = new NumberList(l1);

		for (int i = 0; i < 13; i++) {
			l2[i] = new Long(i);
		}

		NumberList nL2 = new NumberList(l2);

		for (int i = 13; i < 20; i++) {
			nL2.add(new Long(i));
		}

		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		l1 = new Long[500000];
		l2 = new Long[100000];

		for (int i = 0; i < 500000; i++) {
			l1[i] = new Long(i);
		}
		
		nL = new NumberList(l1);

		for (int i = 0; i < 100000; i++) {
			l2[i] = new Long(i);
		}

		nL2 = new NumberList(l2);

		for (int i = 100000; i < 500000; i++) {
			nL2.add(new Long(i));
		}

		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_addAll() {
		System.out.println("Testing addAll()...");

		Long[] l1 = new Long[20];
		Long[] l2 = new Long[13];
		Long[] l3 = new Long[7];

		for (int i = 0; i < 20; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 13; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 0; i < 7; i++) {
			l3[i] = new Long(i + 13);
		}

		NumberList nL = new NumberList(l1);
		NumberList nL2 = new NumberList(l2);
		NumberList nL3 = new NumberList(l3);

		nL2.addAll(nL3);

		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		l1 = new Long[500000];
		l2 = new Long[100000];
		l3 = new Long[400000];

		for (int i = 0; i < 500000; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 100000; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 0; i < 400000; i++) {
			l3[i] = new Long(i + 100000);
		}

		nL = new NumberList(l1);
		nL2 = new NumberList(l2);
		nL3 = new NumberList(l3);

		nL2.addAll(nL3);

		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

	}

	private static void test_clear() {
		System.out.println("Testing clear()...");

		NumberList nL = new NumberList();
		NumberList nL2 = new NumberList(new Long[100000]);
		NumberList nL3 = new NumberList(new Long[100000000]);
		NumberList nL4 = new NumberList();

		nL2.clear();
		nL3.clear();
		nL4.clear();

		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL.equals(nL3));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL.equals(nL4));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_contains() {
		System.out.println("Testing contains()...");

		Long[] l1 = new Long[20];
		Long seven = new Long(7);
		Long eighteen = new Long(18);

		for (int i = 0; i < 20; i++) {
			l1[i] = new Long(i);
		}

		NumberList nL = new NumberList(l1);
		
		try {
			displaySuccessIfTrue(nL.contains(seven));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL.contains(eighteen));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		l1 = new Long[100000];

		for (int i = 0; i < 100000; i++) {
			l1[i] = new Long(i);
		}

		nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.contains(new Long(53345)));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}		
	}

	private static void test_containsAll() {
		System.out.println("Testing containsAll()...");

		Long[] l1 = new Long[20];
		Long[] l2 = new Long[13];
		Long[] l3 = new Long[7];

		for (int i = 0; i < 20; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 13; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 0; i < 7; i++) {
			l3[i] = new Long(i + 13);
		}

		NumberList nL = new NumberList(l1);
		NumberList nL2 = new NumberList(l2);
		NumberList nL3 = new NumberList(l3);

		try {
			displaySuccessIfTrue(nL.containsAll(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL.containsAll(nL3));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL2.addAll(nL3);

		try {
			displaySuccessIfTrue(nL.containsAll(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		l1 = new Long[1000];
		l2 = new Long[123];
		l3 = new Long[877];

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 123; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 0; i < 877; i++) {
			l3[i] = new Long(i + 123);
		}

		nL = new NumberList(l1);
		nL2 = new NumberList(l2);
		nL3 = new NumberList(l3);

		try {
			displaySuccessIfTrue(nL.containsAll(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL.containsAll(nL3));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL2.addAll(nL3);

		try {
			displaySuccessIfTrue(nL.containsAll(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

	}

	private static void test_equals() {
		System.out.println("Testing equals()...");

		Long[] l1 = new Long[20];
		Long[] l2 = new Long[13];
		Long[] l3 = new Long[7];

		for (int i = 0; i < 20; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 13; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 0; i < 7; i++) {
			l3[i] = new Long(i + 13);
		}

		NumberList nL = new NumberList(l1);
		NumberList nL2 = new NumberList(l2);
		NumberList nL3 = new NumberList(l3);
		NumberList nL4 = new NumberList(l1);

		try {
			displaySuccessIfTrue(!nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL.equals(nL4));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL2.addAll(nL3);

		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		l1 = new Long[1000];
		l2 = new Long[123];
		l3 = new Long[877];

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 123; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 0; i < 877; i++) {
			l3[i] = new Long(i + 123);
		}

		nL = new NumberList(l1);
		nL2 = new NumberList(l2);
		nL3 = new NumberList(l3);
		nL4 = new NumberList(l1);

		try {
			displaySuccessIfTrue(!nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL.equals(nL4));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL2.addAll(nL3);

		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_isEmpty() {
		System.out.println("Testing isEmpty()...");

		NumberList nL = new NumberList();
		NumberList nL2 = new NumberList(new Long[10]);
		NumberList nL3 = new NumberList(new Long[10000]);
		NumberList nL4 = new NumberList(new Long[12345]);
		NumberList nL5 = new NumberList(new Long[1]);

		try {
			displaySuccessIfTrue(nL.isEmpty());
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL2.isEmpty());
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL3.isEmpty());
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL4.isEmpty());
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL5.isEmpty());
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL.add(new Long(1));

		try {
			displaySuccessIfTrue(!nL.isEmpty());
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_remove() {
		System.out.println("Testing remove()...");

		Long[] l1 = new Long[1000];
		Long[] l2 = new Long[999];
		Long[] l3 = new Long[501];

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 123; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 124; i < 1000; i++) {
			l2[i - 1] = new Long(i);
		}

		for (int i = 0; i < 500; i++) {
			l3[i] = new Long(i * 2);
		}

		NumberList nL = new NumberList(l1);
		NumberList nL2 = new NumberList(l2);
		NumberList nL3 = new NumberList(l3);
		NumberList nL4 = new NumberList(l1);

		try {
			displaySuccessIfTrue(!nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL.remove(new Long(123));


		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		for (int i = 1; i < 1000; i += 2) {
			nL4.remove(new Long(i));
		}

		try {
			displaySuccessIfTrue(nL4.equals(nL3));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_removeAll() {
		System.out.println("Testing removeAll()...");

		Long[] l1 = new Long[1000];
		Long[] l2 = new Long[123];
		Long[] l3 = new Long[877];

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 123; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 0; i < 877; i++) {
			l3[i] = new Long(i + 123);
		}

		NumberList nL = new NumberList(l1);
		NumberList nL2 = new NumberList(l2);
		NumberList nL3 = new NumberList(l3);
		NumberList nL4 = new NumberList(l1);

		nL.removeAll(nL2);

		try {
			displaySuccessIfTrue(nL.equals(nL3));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL4.addAll(nL3);

		nL4.removeAll(nL3);

		try {
			displaySuccessIfTrue(nL4.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}		
	}

	private static void test_retainAll() {
		System.out.println("Testing retainAll()...");

		Long[] l1 = new Long[1000];
		Long[] l2 = new Long[123];
		Long[] l3 = new Long[877];

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i);
		}

		for (int i = 0; i < 123; i++) {
			l2[i] = new Long(i);
		}

		for (int i = 0; i < 877; i++) {
			l3[i] = new Long(i + 123);
		}

		NumberList nL = new NumberList(l1);
		NumberList nL2 = new NumberList(l2);
		NumberList nL3 = new NumberList(l3);
		NumberList nL4 = new NumberList(l1);

		nL.retainAll(nL2);

		try {
			displaySuccessIfTrue(nL.equals(nL2));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL4.addAll(nL2);
		NumberList nL5 = new NumberList(nL4.toArray());
		nL2.addAll(nL3);
		nL4.retainAll(nL2);

		try {
			displaySuccessIfTrue(nL4.equals(nL5));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_sizeIncludingDuplicates() {
		System.out.println("Testing sizeIncludingDuplicates()...");

		Long[] l1 = new Long[1000];

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(5);
		}

		NumberList nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.sizeIncludingDuplicates() == 1000);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i % 2);
		}

		nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.sizeIncludingDuplicates() == 1000);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i % 5);
		}

		nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.sizeIncludingDuplicates() == 1000);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_toArray() {
		System.out.println("Testing toArray()...");

		Long[] l1 = new Long[1000];

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i);
		}

		NumberList nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(Arrays.equals(nL.toArray(), l1));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i % 2);
		}

		nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(Arrays.equals(nL.toArray(), l1));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_size() {
		System.out.println("Testing size()...");

		Long[] l1 = new Long[1000];

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(5);
		}

		NumberList nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.size() == 1);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		for (int i = 0; i < 1000; i++) {
			l1[i] = new Long(i % 2);
		}

		nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.size() == 2);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		for (int i = 0; i < 1000; i++) {
			l1[i] = (i % 5 == 0) ? new Long(i) : new Long(0);
		}

		nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.size() == 200);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_count() {
		System.out.println("Testing count()...");

		Long[] l1 = new Long[1000];

		for (int i = 0; i < 1000; i++) {
			l1[i] = (i % 5 == 0) ? new Long(i) : new Long(0);
		}

		NumberList nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.count(new Long(0)) == 801);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.count(new Long(0)) == 801);
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_toString() {
		System.out.println("Testing toString()...");

		Long[] l1 = new Long[1000];

		for (int i = 0; i < 1000; i++) {
			l1[i] = (i % 5 == 0) ? new Long(i) : new Long(0);
		}

		NumberList nL = new NumberList(l1);

		try {
			displaySuccessIfTrue(nL.toString().equals(Arrays.toString(l1)));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		nL = new NumberList();

		try {
			displaySuccessIfTrue(nL.toString().equals(Arrays.toString(new Long[]{null, null, null, null, null, null, null, null, null, null})));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_finalizeArray() {
		System.out.println("Testing finalizeArray()...");

		Long[] l1 = new Long[1000];
		Long[] l2 = new Long[500];

		for (int i = 0; i < 1000; i++) {
			l1[i] = (i > 499) ? null : new Long(i);
		}

		for (int i = 0; i < 500; i++) {
			l2[i] = new Long(i);
		}

		NumberList nL = new NumberList();
		NumberList nL2 = new NumberList(l1);
		NumberList nL3 = new NumberList(l2);
		nL.finalizeArray();
		nL2.finalizeArray();
		nL3.finalizeArray();

		try {
			displaySuccessIfTrue(nL.toString().equals(Arrays.toString(new Long[0])));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL2.equals(nL3));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}
	}

	private static void test_fromArray() {
		System.out.println("Testing fromArray()...");

		Long[] l1a = new Long[1000];
		Long[] l1b = new Long[500];

		long[] l2a = new long[1000];
		long[] l2b = new long[500];

		for (int i = 0; i < 1000; i++) {
			l1a[i] = new Long(i);
		}

		for (int i = 0; i < 500; i++) {
			l1b[i] = new Long(i);
		}

		for (int i = 0; i < 1000; i++) {
			l2a[i] = (long) (i);
		}

		for (int i = 0; i < 500; i++) {
			l2b[i] = (long) (i);
		}

		NumberList nL1a = new NumberList(l1a);
		NumberList nL1b = new NumberList(l1b);
		NumberList nL2a = NumberList.fromArray(l2a);
		NumberList nL2b = NumberList.fromArray(l2b);

		try {
			displaySuccessIfTrue(nL1a.equals(nL2a));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

		try {
			displaySuccessIfTrue(nL1b.equals(nL2b));
		} catch(Exception e) {
			displaySuccessIfTrue(false);
		}

	}
}