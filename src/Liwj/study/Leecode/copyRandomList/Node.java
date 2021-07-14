package Liwj.study.Leecode.copyRandomList;

/**
 * Created by Administrator on 2021/5/12.
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public static void main(String[] args) {
        Node node = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node.next = node1;
        node.random = null;
        node1.next = node2;
        node1.random = node;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.next = null;
        node4.random = node;

        new Solution().copyRandomList(node);
    }

    public Node copyRandomList(Node head) {
        Node temp;
        Node curnode = head;
        while (curnode != null) {
            temp = new Node(curnode.val);
            temp.next = curnode.next;
            curnode.next = temp;
            curnode = temp.next;
        }
        curnode = head;
        Node res;
        while (curnode != null) {
            res = curnode.next;
            if (curnode.random != null)
                res.random = curnode.random.next;
            curnode = res.next;
        }
        temp = head.next;
        curnode = head;
        res = head.next;
        while (temp.next != null){
            curnode.next = temp.next;
            curnode = curnode.next;
            temp.next = curnode.next;
            temp = temp.next;
        }
        curnode.next = null;
        return res;
    }
}