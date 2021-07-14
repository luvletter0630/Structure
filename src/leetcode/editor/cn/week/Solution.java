package leetcode.editor.cn.week;

import java.util.Arrays;

/**
 * @author liwj
 * @addrees https://leetcode-cn.com/contest/weekly-contest-247/problems/maximum-product-difference-between-two-pairs/
 * @cnName 两个数对之间的最大乘积差
 * @date 2021/6/27
 */
class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }
}
