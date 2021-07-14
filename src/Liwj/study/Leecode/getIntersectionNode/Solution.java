package Liwj.study.Leecode.getIntersectionNode;

/**
 * Created by Administrator on 2021/6/4.
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int alen = 0;
        int blen = 0;
        ListNode pA=headA,pB=headB;
        while (pA != null){
            pA = pA.next;
            alen ++;
        }
        while (pB != null){
            pB = pB.next;
            blen ++;
        }
        int n =Math.abs(alen - blen);
        while (n-- > 0){
            if (alen > blen){
                headA = headA.next;
            }else {
                headB = headB.next;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
            if (headA == headB){
                return headA;
            }
        }
        return headA;
    }
}
