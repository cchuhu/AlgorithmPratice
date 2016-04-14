package Algorithm;

/**
 * Created by zhangwen on 4/14/16.
 *
 * @类说明 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class RotateArray {
    /**
     * 思路:既然是非递减序列,那么第i个元素比第i-1个元素小的时候就是最小值.
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        //数组为空时
        if (array.length == 0)
            return 0;
        //前部分数据旋转
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return array[i + 1];
        }

        //全部数据旋转，相当于没有旋转，最小数即为第一个数
        return array[0];
    }
}
