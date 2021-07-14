/**
 * 题目Id: 剑指 Offer 55 - II
 * 题目：平衡二叉树
 * 日期: 2021-06-26 16:11:12
 **/
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 166 👎 0

package leetcode.editor.cn;

public class PingHengErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return root == null ? true : Math.abs((dfs(root.left, 0) - dfs(root.right, 0))) < 2 && isBalanced(root.right) && isBalanced(root.left);
        }

        public int dfs(TreeNode root, int deep) {
            if (root == null) {
                return deep;
            }
            deep++;
            return Math.max(dfs(root.left, deep), dfs(root.right, deep));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}