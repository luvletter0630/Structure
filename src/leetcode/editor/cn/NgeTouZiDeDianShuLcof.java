/**
 * 题目Id: 剑指 Offer 60
 * 题目：n个骰子的点数
 * 日期: 2021-07-12 20:51:43
 **/
//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 
// 👍 260 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13
 * 0 1 0 0 0 0 0 0 0 0 0 0
 * 1 0 1 1 1 1 1 1 0 0 0 0  0  0  0
 * 2 0 0 1 2 3 4 5 6 5 4 3  2  1  0
 * 3 0 0 0 1 3 6
 */

public class NgeTouZiDeDianShuLcof {
    public static void main(String[] args) {
        Solution solution = new NgeTouZiDeDianShuLcof().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] dicesProbability(int n) {
            double res[] = new double[6];
            Arrays.fill(res, 1.0 / 6.0);
            for (int i = 2; i <= n; i++) {
                double [] tmp = new double[5 * i + 1];
                for (int j = 0; j < res.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        tmp[j + k] += res[j] / 6;
                    }
                }
                res = tmp;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}