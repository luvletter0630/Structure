package Liwj.study.Leecode.validateStackSequences;

import java.util.Stack;

/**
 * Created by Administrator on 2021/5/9.
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = popped.length - 1; i >= 0; i--) {
            stack2.push(popped[i]);
        }
        for (int j = 0; j < pushed.length; j++) {
            stack1.push(pushed[j]);
            while (!stack1.isEmpty() && stack1.peek().equals(stack2.peek())){
                stack1.pop();
                stack2.pop();
            }
        }
        System.out.println(1);
        return stack1.isEmpty();
    }
}
