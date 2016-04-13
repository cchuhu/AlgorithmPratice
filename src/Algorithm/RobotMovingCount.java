package Algorithm;

/**
 * Created by zhangwen on 4/13/16.
 * 题目描述:地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMovingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        //标志每个点走过还是没走过
        int flags[][] = new int[rows][cols];
        return move(0, 0, rows, cols, flags, threshold);

    }

    public static int move(int i, int j, int rows, int cols, int flags[][], int threshold) {
        //递归终止条件 注意j>=cols 为什么要=呢,因为当j=cols时已经是最后一列了.
        if (i < 0 || j < 0 || j >= cols || i >= rows || count(i) + count(j) > threshold || flags[i][j] == 1) {
            return 0;
        } else {
            //将已经走过的格子标记为1
            flags[i][j] = 1;
            //千万不要忘记最后的+1!!
            int result = move(i - 1, j, rows, cols, flags, threshold) +
                    move(i, j - 1, rows, cols, flags, threshold) +
                    move(i + 1, j, rows, cols, flags, threshold) +
                    move(i, j + 1, rows, cols, flags, threshold) + 1;

            return result;
        }


    }

    /**
     * 计算每个数的个位和十位数相加的和
     *
     * @param i
     * @return
     */
    public static int count(int i) {
        int sum = 0;
        do {
            sum = sum + i % 10;
            i = i / 10;
        } while (i % 10 > 0);
        return sum;
    }


    public static void main(String[] args) {
        System.out.print(movingCount(19, 100, 100));
    }
}
