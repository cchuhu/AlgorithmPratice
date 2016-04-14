package DataStructer;

/**
 * Created by zhangwen on 4/14/16.
 * 关于字符串的一些函数的用法,复习一下
 */
public class StringFunction {
    /**
     * trim() 去掉起始和结尾的空格
     * valueOf() 转换为字符串
     * toLowerCase() 转换为小写
     * toUpperCase() 转换为大写
     * length() 取得字符串的长度
     */
    static void fun_split() {
        System.out.println("-----split函数以指定字符区分字符串-----");
        String str_test = "I am Huhu,a rokkie";
        String[] array = str_test.split(" ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "——");
        }
    }

    static void fun_substring() {
        System.out.println("-----substring函数切割字符串-----");
        String str_test = "I am Huhu,a rokkie";
        String sub = str_test.substring(3);
        String sub2 = str_test.substring(3, 9);
        System.out.print(sub + " " + sub2);
    }

    static void fun_replace() {
        System.out.println("-----replace函数替换字符串中的字符-----");
        String str_test = "I am Huhu,a rokkie";
        String sub = str_test.replace("Huhu", "zhangwen");
        System.out.print(sub);
    }

    static void fun_indexof() {
        System.out.println("-----indexof函数返回字符第一次出现的索引-----");
        String str_test = "I am Huhu,a rokkie";
        int index = str_test.indexOf("h");
        System.out.print(index);
    }

    static void fun_concat() {
        System.out.println("-----concat函数连接两个字符串-----");
        String str1 = "I am Huhu,a rokkie";
        String str2 = " Glad to meet you";
        System.out.print(str1.concat(str2));
    }

    public static void main(String[] args) {
        fun_split();
        System.out.println(" ");
        fun_substring();
        System.out.println(" ");
        fun_replace();
        System.out.println(" ");
        fun_indexof();
        System.out.println(" ");
        fun_concat();


    }
}
