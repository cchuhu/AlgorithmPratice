package Algorithm;

/**
 * Created by zhangwen on 5/14/16.
 * 完全背包问题
 */
public class package_total {
    public static void main(String[] args) {
        //物品的重量
        int w[] = {5, 2, 6, 4};
        //背包的价值
        int v[] = {10, 20, 30, 50};
        //背包总容量
        int weight = 10;
        //表示背包价值的一维数组,value[i]表示当背包容量为i时对应的价值量
        int value[] = new int[11];
        //第一层循环表示放第j个物品
        for (int j = 0; j < w.length; j++) {
            //注意i的起始条件,不能从0开始,若从0开始会数组越界.
            for (int i = w[j]; i < weight + 1; i++) {
                value[i] = ((value[i - w[j]] + v[j]) > value[i]) ? (value[i - w[j]] + v[j]) : (value[i]);
            }
            System.out.println("存放第" + j + "个物品时数组的状态:");
            for (int i = 0; i < value.length; i++) {
                System.out.print(value[i] + " ");
            }
            System.out.println("");

        }
        System.out.println("最大价值量为" + value[weight]);


    }
}
