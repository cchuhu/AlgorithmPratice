package Algorithm;

import java.util.Stack;

/**
 * Created by zhangwen on 4/19/16.
 * 牛客网笔试题,翻转字符串但不改变单词内部顺序,颠倒大小写.
 */
public class TransformString {
    public static String trans(String s, int n) {
        String str[] = s.split(" ");
        String result = "";
        Stack<String> mStack = new Stack<>();
        //利用栈翻转字符串
        for (int i = 0; i < str.length; i++) {
            mStack.push(str[i]);
        }
        //逐个单词转换
        for (int j = 0; j < str.length; j++) {
            //先声明一个buffer
            StringBuffer sb = new StringBuffer();
            //弹出顶端string
            String temp = mStack.pop();
            //处理string的每一个字母
            for (int k = 0; k < temp.length(); k++) {
                //如果是大写字母
                if (Character.isUpperCase(temp.charAt(k))) {
                    sb.append(Character.toLowerCase(temp.charAt(k)));
                } else {
                    sb.append(Character.toUpperCase(temp.charAt(k)));
                }
            }
            result += sb + " ";
        }
        result=result.trim();
        return result;
    }



    public static void main(String[] args) {
        System.out.print(trans("", 16));
    }
}
