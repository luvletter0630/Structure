package Liwj.study.Leecode.isSymmetric;

/**
 * Created by Administrator on 2021/5/8.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compareNode(root.left, root.right);
    }

    public boolean compareNode(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return compareNode(left.left, right.right) && compareNode(left.right, right.left);
    }
}