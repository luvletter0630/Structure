/**
 * 题目Id: 1711
 * 题目：大餐计数
 * 日期: 2021-07-07 20:58:57
 **/
//大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。 
//
// 你可以搭配 任意 两道餐品做一顿大餐。 
//
// 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
//餐 的数量。结果需要对 109 + 7 取余。 
//
// 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：deliciousness = [1,3,5,7,9]
//输出：4
//解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
//它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
// 
//
// 示例 2： 
//
// 
//输入：deliciousness = [1,1,1,3,3,3,7]
//输出：15
//解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。 
//
// 
//
// 提示： 
//
// 
// 1 <= deliciousness.length <= 105 
// 0 <= deliciousness[i] <= 220 
// 
// Related Topics 数组 哈希表 
// 👍 97 👎 0

package leetcode.editor.cn;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    public static void main(String[] args) {
        Solution solution = new CountGoodMeals().new Solution();
        int[] x = {1, 1, 1, 1, 1, 1, 1};
        solution.countPairs(x);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(int[] deliciousness) {
            int res = 0;
            int mod = 1000000007;
            int len = deliciousness.length;
            Map<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
            int maxNum = 0;
            for (int i = 0; i < len; i++) {
                maxNum = Math.max(maxNum, deliciousness[i]);
            }
            int maxSum = maxNum * 2;

            for (int i = 0; i < len; i++) {
                int x = deliciousness[i];
                for (int sum = 1; sum <= maxSum; sum <<= 1) {
                    int cnt = cntMap.getOrDefault(sum - x,0);
                    res = (res + cnt) % mod;
                }
                cntMap.put(x,cntMap.getOrDefault(x,0) + 1);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}