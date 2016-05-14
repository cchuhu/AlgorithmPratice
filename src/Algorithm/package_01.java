package Algorithm;

/**
 * Created by zhangwen on 5/14/16.
 * 01背包问题,用一维数组解决
 */
public class package_01 {

    public static void main(String[] args) {
        //物品的重量
        int w[] = {5, 4, 6, 3};
        //背包的价值
        int v[] = {10, 40, 30, 50};
        //背包总容量
        int weight = 10;
        //表示背包价值的一维数组,value[i]表示当背包容量为i时对应的价值量
        int value[] = new int[11];
        //第一层循环表示放第j个物品
        for (int j = 0; j < w.length; j++) {
            /*第二层循环表示放不放第j个物品的比较,注意要倒序,因为这是一维数组,在比较第j个物品放与不放的时候需要value[0...i-1]的数据,
            正序放的时候就会将这个区间内的数据改变.如果正序的话,不能保证物品只放一次,如果是二维数组的话可以正序放,因为每行数据都是独立的,不会覆盖之前的数据*/
            for (int i = weight; i >= w[j]; i--) {
                /*加入物品j时,背包容量为i时的价值量应该表示为value[i-w[j]]+v[j];
                不加入物品j时,背包容量为i时的价值量应该表示为value[i];
                因此只需要比较这两个值即可*/
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
