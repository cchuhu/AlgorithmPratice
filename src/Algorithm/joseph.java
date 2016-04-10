package Algorithm;

/**
 * @author Huhu
 * @version 创建时间：Mar 26, 2016 8:12:08 PM 类说明 约瑟夫环
 */
public class joseph {
	/**
	 * 递归函数
	 * 
	 * @params size:总人数 K代表去掉第几个人 i代表第几轮
	 */
	 static int function(int size, int k, int i) {
		if (i == 1) {
			return (size + k - 1) % size;
		} else {
			return (function(size - 1, k, i - 1) + k) % size;
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++)
			System.out.println("第" + i + "次" + function(10, 3, i));

	}
}
