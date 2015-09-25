import java.util.Arrays;

public class BaseConverter {
	
	public static void main(String[] args) {
		try {
			int convertToBase = 10;
			if (args.length > 3 || args.length < 2) {
				throw new IllegalArgumentException("args");
			} else if (args.length == 3) {
				convertToBase = Integer.parseInt(args[2]);
			}
			Number num = new Number(args[0], Integer.parseInt(args[1]));
			Number converted = num.convert(convertToBase);
			System.out.println(converted.toString());
		} catch (IllegalArgumentException e) {
			System.out.println("ILLEGAL ARGUMENT EXCEPTION BITCH!!!");
		}
	}
}