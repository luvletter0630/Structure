//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics 树 数学 二叉树 
// 👍 138 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();
        List<Integer> res = solution.pathInZigZagTree(14);
        System.out.println(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            int num = 1;
            int cnt = 1;
            while (cnt * 2 <= label) {
                num++;
                cnt *= 2;
            }
            if (num % 2 == 0) {
                label = getReverse(num,label);
            }
            List<Integer> res = new ArrayList<>();
            while (num > 0) {
                if (num % 2 == 0) {
                    res.add(getReverse(num, label));
                } else {
                    res.add(label);
                }
                label >>= 1;
                num--;
            }
            Collections.reverse(res);
            return res;
        }

        public int getReverse(int row, int lable) {
            return (int) (Math.pow(2, row - 1) + Math.pow(2, row) - 1 - lable);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}