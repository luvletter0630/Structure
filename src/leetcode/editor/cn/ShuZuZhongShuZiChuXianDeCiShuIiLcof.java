/**
 * 题目Id: 剑指 Offer 56 - II
 * 题目：数组中数字出现的次数 II
 * 日期: 2021-06-26 17:06:42
 **/
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 193 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ones = 0, two = 0;
            for (int num : nums) {
                ones = ones ^ num & ~two;
                two = two ^ num & ~ones;
            }
            return ones;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}