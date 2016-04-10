package Algorithm;

/**
 * @author Huhu
 * @version 创建时间：Mar 26, 2016 9:44:00 PM 类说明 输出全排列
 */
public class pailie {

	static void perm(char[] list, int k, int m) {
		int i;
		if (k == m) {
			for (i = 0; i <= m; i++) {
				System.out.print(list[i]);
			}
			System.out.println("");
		} else {
			for (i = k; i <= m; i++) {
				Swap(list, k, i );
				perm(list, k + 1, m);
				list = Swap(list, k, i);
			}
		}
	}

	static char[] Swap(char[] list, int a, int b) {
		char temp = list[a];
		list[a] = list[b];
		list[b] = temp;
		return list;
	}

	public static void main(String[] args) {
		char[] test = new char[] { 'a', 'b', 'c', 'd', 'e' };
		perm(test, 0,4 );
	}
}
