/**
 * 题目Id: 剑指 Offer 57 - II
 * 题目：和为s的连续正数序列
 * 日期: 2021-06-30 21:37:40
 **/
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 
// 👍 282 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        System.out.println(solution.findContinuousSequence(15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 1; i <= target / 2; i++) {
                int n = i;
                ArrayList<Integer> save = new ArrayList<>();
                save.add(i);
                for (int j = i + 1; j <= target / 2 + 1 && n <= target; j++) {
                    save.add(j);
                    n += j;
                    if (n == target){
                        result.add(save);
                        break;
                    }
                }
            }
            int res [][] = new int[result.size()][0];
            if (result.size() > 0){
                for (int i = 0; i < result.size(); i++) {
                    res[i] = new int[result.get(i).size()];
                    for (int j = 0; j < result.get(i).size(); j++) {
                        res[i][j] = result.get(i).get(j);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}