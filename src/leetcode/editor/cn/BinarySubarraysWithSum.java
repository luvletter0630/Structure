/**
 * 题目Id: 930
 * 题目：和相同的二元子数组
 * 日期: 2021-07-08 21:25:18
 **/
//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 183 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        Solution solution = new BinarySubarraysWithSum().new Solution();
        System.out.println(solution.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int sum = 0;
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            int res = 0;
            for (int num : nums) {
                cnt.put(sum,cnt.getOrDefault(sum,0) + 1);
                sum += num;
                res += cnt.getOrDefault(sum - goal,0);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}