//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 383 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
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
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer,TreeNode> parents = new HashMap<Integer,TreeNode>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            getParents(root);
            getNode(target,null,0,k);

            return res;
        }

        public void getParents(TreeNode root){
            if (root.left != null){
                parents.put(root.left.val,root);
                getParents(root.left);
            }
            if (root.right != null){
                parents.put(root.right.val,root);
                getParents(root.right);
            }
        }

        public void getNode(TreeNode node,TreeNode found,int deep,int k){
            if (node == null){
                return;
            }
            if (k == deep){
                res.add(node.val);
                return;
            }
            if (node.left != found){
                getNode(node.left,node,deep + 1,k);
            }
            if (node.right != found){
                getNode(node.right,node,deep + 1,k);
            }
            if (parents.get(node.val) != found){
                getNode(parents.get(node.val),node,deep + 1,k);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}