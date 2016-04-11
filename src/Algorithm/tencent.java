package Algorithm;

/**
 * @author Huhu
 * @version 创建时间：Apr 8, 2016 4:20:16 PM 类说明 腾讯笔试编程题
 *          有一个M行N列的矩阵，其中一部分格子里面有一些有价值的物品。现在从左上角出发，你能获取的物品的总价值量最大有多少？
 *          思路：f(x,y)=Max(f(x-1,y),f(x,y-1))
 */
public class tencent {
    /**
     * 在原二维数组的基础上计数,关键代码table[x][y]=table[x][y]+Max(table[x-1][y],table[x][y-1]);
     */
    public static int Count(int[][] table) {
        //获取列表的长
        int l = table.length;
        //获取列表的宽
        int w = table[0].length;
        //开两层循环遍历累加数组
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                //原点不变
                if (i == 0 && j == 0) {
                    table[i][j] = table[i][j];
                } else {
                    //如果是第一行,则最大值只有可能来自左边
                    if (i == 0) {
                        table[i][j] = table[i][j] + table[i][j - 1];
                    } else {
                        //除去每一行的第一个数字,因为第一个数字的值只有一个来源
                        if (j == 0) {
                            table[i][j] = table[i][j] + table[i - 1][j];
                        } else {
                            table[i][j] = table[i][j] + Max(table[i - 1][j], table[i][j - 1]);
                        }
                    }
                }

            }
        }

        return table[l - 1][w - 1];
    }

    /**
     * 比较大小的函数
     */
    public static int Max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;

    }

    public static void main(String[] args) {
        int[][] table = {
                {0, 2, 11, 13}, {1, 0, 1, 1}, {5, 0, 3, 1}, {5, 1, 0, 0}
        };
        int maxValue = Count(table);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + "  ");
            }
            System.out.println(" ");
        }
        System.out.print(maxValue);
    }


}