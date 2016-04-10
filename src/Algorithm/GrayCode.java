package Algorithm;

/**
 * @author Huhu
 * @version 创建时间：Mar 30, 2016 10:09:28 PM
 *          类说明
 *          格雷码(Gray Code)是一个数列集合，每个数使用二进位来表示，假设使用n位元来表示每个数字，任两个数之间只有一个位元值不同。
 *          例如以下为3位元的格雷码： 000 001 011 010 110 111 101 100 。
 */
public class GrayCode {
    /**
     * 思路:
     * 第一步：产生 0, 1 两个字符串。
     * 第二步：在第一步的基础上，每一个字符串都加上0和1，但是每次只能加一个，所以得做两次。这样就变成了 00,01,11,10 （注意对称）。
     * 第三步：在第二步的基础上，再给每个字符串都加上0和1，同样，每次只能加一个，这样就变成了 000,001,011,010,110,111,101,100。
     * 好了，这样就把3位元格雷码生成好了。
     * 如果要生成4位元格雷码，我们只需要在3位元格雷码上再加一层0,1就可以了： 0000,0001,0011,0010,0110,0111,0101,0100,1100,1101,1110,1010,0111,1001,1000.
     * 也就是说，n位元格雷码是基于n-1位元格雷码产生的。
     */
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
