package Algorithm;

/**
 * Created by zhangwen on 4/13/16.
 * 题目说明:在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindinTwodimenArray {
    /**
     * @错误思路: 一开始的思路是错的, 我的思路是先从第一行开始搜索, 搜索到一个比target值大的index, 然后搜索index-1列,
     * 潜意识里认为index-1列里面的数字一定比index列的数小,这是不正确的.所以以后举例找思路的时候一定不能找太规则的.
     * @正确思路: 从二维数组的左下角开始找, 向上递减, 向右递增.
     */
    public static boolean Find(int[][] array, int target) {

        int col = array[0].length;//列数
        //初始化两个游标
        int i = array.length - 1;
        int j = 0;
        while ((i >= 0) && (j < col)) {

            if (array[i][j] > target) {
                i--;
                //注意if和else if的区别!!
            } else if (array[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int target = 5;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.print(Find(array, target));
    }

}
