/**
 * 题目Id: 剑指 Offer 54
 * 题目：二叉搜索树的第k大节点
 * 日期: 2021-06-19 18:45:24
 **/
//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 170 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        node.left = node1;
        node1.right = node2;
        node.right = node3;
        solution.kthLargest(node, 1);
        System.out.println(solution.kthLargest(node, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */


    class Solution {
        int res, k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }
        void dfs(TreeNode root) {
            if(root == null && k == 0) return;
            dfs(root.right);
            if(--k == 0){
                res = root.val;
                return;
            }
            dfs(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}