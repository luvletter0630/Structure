package Liwj.study.Leecode.removeElements;

/**
 * Created by Administrator on 2021/6/5.
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmpnode = new ListNode();
        tmpnode.next = head;
        ListNode cur = head;
        ListNode pre = tmpnode;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return tmpnode.next;
    }
}
