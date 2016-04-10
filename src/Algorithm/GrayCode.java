package Algorithm;

/**
 * @author Huhu
 * @version 创建时间：Mar 30, 2016 10:09:28 PM 类说明
 */
public class GrayCode {
	public static String[] GrayCode(int n) {

		// produce 2^n grade codes
		String[] graycode = new String[(int) Math.pow(2, n)];
		if (n == 1) {
			graycode[0] = "0";
			graycode[1] = "1";
			return graycode;
		}

		String[] last = GrayCode(n - 1);

		for (int i = 0; i < last.length; i++) {
			graycode[i] = "0" + last[i];
			graycode[graycode.length - 1 - i] = "1" + last[i];
		}

		return graycode;
	}

	public static void main(String[] args) {
		String[] result = GrayCode(5);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

}
