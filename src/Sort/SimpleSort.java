package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huhu
 * @version 创建时间：Mar 30, 2016 10:36:40 AM 类说明 冒泡排序
 */
public class SimpleSort {
	/**
	 * 插入排序的算法
	 * 
	 * @params list 待排序的数组
	 */
	public static void InsertSort(int[] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = i; j > 0; j--) {
				if (list[j] < list[j - 1]) {
					int temp = list[j - 1];
					list[j - 1] = list[j];
					list[j] = temp;
				}
			}
			for (int count = 0; count < list.length; count++) {
				System.out.print(list[count] + " ");
			}
			System.out.println(" ");
		}
		// 输出数组
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

	/**
	 * 冒泡排序
	 * 
	 * @params list 待排序数组
	 */
	public static void BubbleSort(int[] list) {
		for (int j = list.length; j > 0; j--) {
			for (int i = 0; i < j - 1; i++) {
				if (list[i] > list[i + 1]) {
					int temp = list[i + 1];
					list[i + 1] = list[i];
					list[i] = temp;
				}
			}
			for (int count = 0; count < list.length; count++) {
				System.out.print(list[count] + " ");
			}
			System.out.println(" ");

		}
		// 输出数组
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

	/**
	 * 选择排序 选择最大元素，放在list[max]位置，然后次大的元素放在list[max-1]
	 * 
	 * @params
	 */
	public static void SelectSort(int[] list) {
		for (int i = list.length - 1; i > 0; i--) {
			// 从0到list.length-1选择最大元素
			// 最大元素的游标
			int pos = 0;
			for (int j = 0; j <= i; j++) {
				if (list[pos] < list[j]) {
					pos = j;
				}
			}
			int temp = list[i];
			list[i] = list[pos];
			list[pos] = temp;

		}
		// 输出数组
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

	public static void main(String[] args) {
		// 待排序数组
		int[] list = { 1, 2, 6, 32, 0, 87, 59, 3, 31, 2, 11 };
		// InsertSort(list);
		// BubbleSort(list);
		SelectSort(list);
	}

}
