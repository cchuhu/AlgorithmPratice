package Algorithm;

import java.math.BigInteger;

/**
 * @author Huhu
 * @version 创建时间：Mar 26, 2016 8:54:26 PM 类说明 大数相乘
 */
public class BigNumber {
	public static void main(String[] args) {
		String number_one = "3333333332323232323234234234234234234";
		String number_two = "546426523232323234234234234234234";
		BigInteger num_one = new BigInteger(number_one);
		BigInteger num_two = new BigInteger(number_two);
		BigInteger result = num_one.multiply(num_two);
		System.out.println(result);

	}
}
