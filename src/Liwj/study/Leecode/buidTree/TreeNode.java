package Liwj.study.Leecode.buidTree;

import java.util.Arrays;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return null;
        } else {
            TreeNode firstNode = new TreeNode(preorder[0]);
            int indexofnode = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (preorder[0] == inorder[i]) {
                    indexofnode = i;
                    break;
                }
            }
            firstNode.left = buildTree(Arrays.copyOfRange(preorder, 1, indexofnode + 1), Arrays.copyOfRange(inorder, 0, indexofnode));
            firstNode.right = buildTree(Arrays.copyOfRange(preorder, indexofnode + 1, preorder.length), Arrays.copyOfRange(inorder, indexofnode + 1, inorder.length));
            return firstNode;
        }
    }
}
