package Sort;

/**
 * @author Huhu
 * @version 创建时间：Mar 30, 2016 1:21:47 PM 类说明 较复杂的排序算法
 */
public class ComplexSort {
	/**
	 * 快速排序的算法
	 * 
	 * @params
	 */
	public static void quickSort(int[] list, int left, int right) {
		// 两个哨兵
		int i = left;
		int j = right;
		if (i > j) {
			return;
		}
		// 基准点
		int pos = list[left];

		while (i != j) {
			while (list[j] >= pos && (j > i)) {
				j--;
			}
			while (list[i] <= pos && (j > i)) {
				i++;
			}
			if (i < j) {
				// 交换过程
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;

			}

		}

		// 将基准点归位
		int temp = list[i];
		list[i] = pos;
		list[left] = temp;
		// 递归排序
		quickSort(list, left, i - 1);
		quickSort(list, i + 1, right);
	}

	public static void main(String[] args) {
		int[] list = { 6, 1, 2, 5, 4, 3, 9, 7, 10, 8 };
		quickSort(list, 0, list.length - 1);

	}

}
