package Liwj.study.Leecode.mirrorTree;

/**
 * Created by Administrator on 2021/5/8.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode tempnode = root.left;
            root.left = root.right;
            root.right = tempnode;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
}
