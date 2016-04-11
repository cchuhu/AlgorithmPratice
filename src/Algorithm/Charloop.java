package Algorithm;

/**
 * Created by zhangwen on 4/11/16.
 *
 * @类说明 假设一组字符为abcdefghi, 现在将前i个字符放到后面去, 例如:i=4,变成efghiabcd
 */
public class Charloop {
    /**
     * 通常想法是将前i个字符拷贝出来放到另外的空间,然后将n-i个字符前移i位.但如果空间有限的话不能这样做怎么办呢?
     * 可以将前i位和后n-i位看成两个数组,利用翻转交换的思想
     * 例如:  a b c d e f  g h i
     * reverse(0,i-1)  d c b a e f g h i
     * reverse(i,n-1)  d c b a i h g f e
     * reverse(0,n-1) e f g h i a b c d
     * 而reverse函数就只是一个交换函数而已
     */


    /**
     * @param i 要交换的前面的索引
     * @param j 要交换的后面的索引
     */
    public static void reverse(int i, int j, int[] list) {
        while (i < j) {
            //如果i<j,证明游标还没有相遇,则继续交换元素
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i++;
            j--;
        }

    }

    public static void main(String[] args) {

        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        //将前4个位置交换到后面.
        int pos = 4;
        int length = list.length;

        reverse(0, pos - 1, list);
        reverse(pos, length-1, list);
        reverse(0, length-1, list);

        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }

    }

}
