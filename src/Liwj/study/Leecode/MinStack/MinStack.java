package Liwj.study.Leecode.MinStack;

import java.util.Stack;

/**
 * Created by Administrator on 2021/5/9.
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
     }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() && stack1.peek() <= stack2.peek()){
            stack2.push(x);
        }
    }

    public void pop() {
        stack1.pop();
        if (stack2.peek().equals(stack1.pop())){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
