package Algorithm;

/**
 * Created by zhangwen on 4/12/16.
 */
public class Fibonacci {
    /**
     * 递归方法 解决斐波那契数列,容易爆栈
     *
     * @param n 要求解的n值
     * @return
     */
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            System.out.println(Fibonacci(n - 1) + Fibonacci(n - 2));
            return Fibonacci(n - 1) + Fibonacci(n - 2);

        }
    }

    /**
     * 用动态规划的思路.注意将数组多加一个位置用于当测试用例为0的时候的情况.
     * @param n
     * @return
     */
    public static int Fibonacci2(int n) {
        int[] record = new int[n + 2];
        record[1] = 1;
        for (int i = 2; i <= n; i++) {
            record[i] = record[i - 1] + record[i - 2];
            System.out.println(record[i]);
        }
        return record[n];
    }


    public static void main(String[] args) {
        System.out.println(Fibonacci2(6));
    }
}
