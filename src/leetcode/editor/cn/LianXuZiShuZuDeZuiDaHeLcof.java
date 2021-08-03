//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 
// 👍 330 👎 0


package leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int dp = nums[0];
            int len = nums.length;
            int max = dp;
            for (int i = 1; i < len; i++) {
                if (nums[i] <= 0 && dp <= 0) {
                    dp = nums[i];
                    max = Math.max(dp,max);
                }else {
                    dp = Math.max(nums[i],dp + nums[i]);
                    max = Math.max(dp,max);
                }

            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}