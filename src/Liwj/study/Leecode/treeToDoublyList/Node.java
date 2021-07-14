package Liwj.study.Leecode.treeToDoublyList;

/**
 * Created by Administrator on 2021/5/12.
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {
    Node pre;
    Node head;

    public Node treeToDoublyList(Node root) {
        buildList(root);
        head.right = pre;
        pre.left = head;
        return root;
    }

    public void buildList(Node node) {
        if (node == null) {
            return;
        }
        buildList(node.left);
        if (pre == null) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        buildList(node.right);
    }
}
