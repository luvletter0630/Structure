//给定一个正整数数组 nums和整数 k 。 
//
// 请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 104 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 106 
// 
// Related Topics 数组 滑动窗口 
// 👍 274 👎 0


package leetcode.editor.cn;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        solution.numSubarrayProductLessThanK(new int[]{10,5,2,6},100);
    }

    /**
     *     leetcode submit region begin(Prohibit modification and deletion)
     */
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int len = nums.length;
            int cnt = 0;
            int left = 0;
            long produce = 1;
            for (int i = 0; i < len; i++) {
                produce = nums[i] * produce;
                while (produce > k){
                    produce /= nums[left++];
                }
                cnt += i - left + 1;
            }
            return cnt;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}