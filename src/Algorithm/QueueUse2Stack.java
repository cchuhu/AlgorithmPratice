package Algorithm;


import java.util.Stack;

/**
 * Created by zhangwen on 4/10/16.
 * 类说明:使用两个栈实现队列
 */
public class QueueUse2Stack {
    //初始化两个栈
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 入队列操作
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(new Integer(node));
    }

    /**
     * 出队列操作
     *
     * @return
     */
    public int pop() {
        int a;
        //stack2是空的情况,代表第一次pop
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                a = stack1.pop();
                stack2.push(a);
            }

        }
        //如果不为空,证明不是第一次pop,此时stack1已经为空,直接从stack2里pop就可以了
        a = stack2.pop();
        return a;
    }
}
