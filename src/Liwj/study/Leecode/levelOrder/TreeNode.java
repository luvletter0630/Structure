package Liwj.study.Leecode.levelOrder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2021/5/9.
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
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
    public int[]  levelOrder(TreeNode root) {
        int[] res = new int[counNode(root)];
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res[i] = node.val;
            i++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }

    public int counNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + counNode(root.left) + counNode(root.right);
    }
}