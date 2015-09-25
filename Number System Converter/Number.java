import java.util.Arrays;

public class Number {
	
	private long[] digits;
	private String initialNumber;
	private long base;

	public Number(String originalNumber, long numBase) {
		if (numBase < 2) {
			throw new IllegalArgumentException();
		}
		this.base = numBase;
		this.initializeString(originalNumber);
	}

	public long[] getDigits() {
		return digits;
	}

	public long getDigitsValue(int index) {
		return digits[index];
	}

	public long getBase() {
		return this.base;
	}

	private void initializeString(String s) {
		try {
			if (!(s.substring(0, 1).equals("[") && s.substring(s.length() - 1).equals("]"))) {
				System.out.println("Bracket");
				throw new IllegalArgumentException();
			}
			s = s.substring(1, s.length() - 1).replace("][", ",");
			int arrayLength = s.length() - s.replace(",", "").length() + 1;
			this.digits = new long[arrayLength];
			long currDig = 0;
			int newIndex = 0;
			int lastIndex = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.substring(i, i + 1).equals(",") && s.substring(i + 1, i + 2).equals(",") && i <= s.length() - 2) {
					throw new IllegalArgumentException();
				}
			}
			for (int i = arrayLength - 1; i >= 0; i--) {
				for (int j = newIndex; j < s.length() && !s.substring(j, j + 1).equals(","); j++) {
					lastIndex = j + 1;
				}
				this.digits[i] = Long.parseLong(s.substring(newIndex, lastIndex));
				if (this.digits[i] >= this.base || this.digits[i] < 0) {
					throw new IllegalArgumentException();
				}
				newIndex = lastIndex + 1;
			}
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	public long logBase(long base, long number) {
		double n = (double) number;
		double log = (Math.log((double) n) / Math.log((double) base));
		return (int) log;
	}

	public Number convert(long newBase) {
		String converted = "";
		String zeros = "";
		long thisNum = 0;
		long newPow = 0;
		long currPow = 0;
		long maxPow = 0;
		long currNum = 0;
		long currIntAmount = 0;
		long answer = 0;	
		for (int i = 0; i < this.digits.length; i++) {
			thisNum += this.digits[i] * Math.pow(this.base, i);
		}

		if (thisNum == 0) {
			converted = "[0]";
		} else {
			for (int i = 0; thisNum > 0; i++) {
				newPow = this.logBase(newBase, thisNum);
				if (i == 0) {
					maxPow = newPow;
				}
				if (newPow != (currPow - 1)) {
					for (int j = 0; j < (currPow - newPow - 1); j++) {
						zeros += "[0]";
					}
				}
				currPow = newPow;
				while (currNum <= thisNum) {
					currNum += Math.pow(newBase, currPow);
					currIntAmount += 1;
				}
				currNum -= Math.pow(newBase, currPow);
				thisNum -= currNum;
				answer += currNum;
				if (currIntAmount > 0) {
					currIntAmount -= 1;
				}
				currNum = 0;
				converted += zeros + "[" + currIntAmount + "]";
				currIntAmount = 0;
				zeros = "";
			}

			
			while ((converted.length() / 3) < (maxPow + 1)) {
				converted += "[0]";
			}
		}

		return new Number(converted, newBase);
	}

	public boolean equals(Number n) {
		return (Arrays.equals(this.digits, n.getDigits()) && this.base == n.getBase());
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = this.digits.length - 1; i >= 0; i--) {
			s += "[" + this.digits[i] + "]";
		}
		return s;
	}
}