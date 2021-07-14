package Liwj.study.Leecode.printLink;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Administrator on 2021/4/30.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.reversePrint(head)));
    }
}

class Solution {
    int i = 0;
    int j = 0;
    int [] res;
    public int[] reversePrint(ListNode head) {
        solve(head);
        return res;
    }
    public int [] solve(ListNode head){
        if (head == null){
            res = new int[i];
            return res;
        }
        i++;
        solve(head.next);
        res[j] = head.val;
        j ++;
        return res;
    }
}
