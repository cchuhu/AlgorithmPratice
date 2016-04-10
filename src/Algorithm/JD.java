package Algorithm; /**
 * @author Huhu
 * @version 创建时间：Apr 9, 2016 12:42:01 PM 
 * 类说明 每手委托包括一个委托单号i,价格pi,买入或卖出标记di,交易数量qi.
 * 
 *  
 *  测试数据：
 * 6 2
 * B 10 3
 * S 50 2
 * S 40 1
 * B 50 6
 * B 20 4
 * S 25 10
 */
import java.util.Arrays;
import java.util.Scanner;

public class JD {
	/**
	 * 输入的n个数据，前s为
	 * 热门
	 */
	static int n, s;
	/**
	 * 存放“买”的数组，要足够大，采用hash思想
	 */
	static int[] blist = new int[10000];
	/**
	 * 存放“卖”的数组，要足够大，采用hash思想
	 */
	static int[] slist = new int[10000];
	/**
	 * 存放卖的价格最低的S个业务的数组
	 */
	static int[] smin;
	/**
	 * 存放买的价格最低的S个业务的数组
	 */
	static int[] bmax;
	/**
	 * 为了判断当前业务数量是否大于S的bnum和snum 
	 * 标记smin中的最大值MAX用于替换使用，maxindex为smin中MAX的数组下标
	 * 标记bmax中的最大值MIN用于替换使用，minindex为bmax中MAX的数组下标
	 */
	static int bnum, snum, MAX, MIN, maxindex, minindex;
	/**
	 * 当前输入是否与smin中的某个元素相同，避免重复替换掉MAX
	 */
	static boolean hasmin = false;
	/**
	 * 当前输入是否与bmax中的某个元素相同，避免重复替换掉MIN
	 */
	static boolean hasmax = false;

	public static void main(String[] args) {

		
		int a =5;
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		s = scan.nextInt();
		smin = new int[s];
		bmax = new int[s];
		MAX = 0;
		MIN = 0;
		maxindex = 0;
		minindex = 0;

		int index = 0;
		String str = "";

		for (int i = 0; i < n; i++) {
			str = scan.next();
			// 卖，需要求出最便宜的S个
			if (str.equals("S")) {
				index = scan.nextInt();
				slist[index] += scan.nextInt();
				// 如果smin未被填充满，则直接填充
				for (int j = 0; j < s; j++) {
					if (smin[j] == 0) {
						smin[j] = index;
						snum++;
						break;
					}
				}

				// 寻找smin中的MAX用于替换
				MAX = smin[0];
				for (int x = 0; x < s; x++) {
					if (index == smin[x]) {
						hasmin = true;
					}
					if (MAX < smin[x]) {
						MAX = smin[x];
						maxindex = x;
					}
				}
				// 如果当前输入比smin中的最大值还小而且与smin中的其他元素不相同，那么可以替换
				if (index < MAX && (!hasmin)) {
					smin[maxindex] = index;
					snum++;
				}
				hasmin = false;
			}

			// 买，需要求出最贵的S个
			if (str.equals("B")) {
				index = scan.nextInt();
				blist[index] += scan.nextInt();
				// 如果bmax违被填满，则直接填入
				for (int j = 0; j < s; j++) {
					if (bmax[j] == 0) {
						bmax[j] = index;
						break;
					}
				}
				// 求bmax中的最小值用于替换
				MIN = bmax[0];
				for (int y = 0; y < s; y++) {
					if (index == bmax[y]) {
						hasmax = true;
					}

					if (MIN > bmax[y]) {
						MIN = bmax[y];
						minindex = y;
					}
				}
				// 如果输入的值比bmax中的最小值还大且与别的元素不相同的话那么可以替换
				if (index > MIN && (!hasmax)) {
					bmax[minindex] = index;
					bnum++;
				}
				hasmax = false;
			}

		}

		// 升序排序
		Arrays.sort(smin);
		// 题目要求降序排序，这里进行降序排序处理
		// 业务的数量是否小于S
		if (snum < s) {
			for (int i = s - 1; i >= s - snum; i--) {
				System.out.print("S " + smin[i] + " " + slist[smin[i]] + "\n");
			}
		} else {
			for (int i = s - 1; i >= 0; i--) {
				System.out.print("S " + smin[i] + " " + slist[smin[i]] + "\n");
			}
		}

		// 升序排序
		Arrays.sort(bmax);
		// 题目要求降序排序，这里进行降序排序处理
		// 业务的数量是否小于S
		if (bnum < s) {
			for (int i = s - 1; i >= s - bnum; i--) {
				System.out.print("B " + bmax[i] + " " + blist[bmax[i]] + "\n");
			}
		} else {
			for (int i = s - 1; i >= 0; i--) {
				System.out.print("B " + bmax[i] + " " + blist[bmax[i]] + "\n");
			}
		}

	}
}
