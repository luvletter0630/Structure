/**
 * 题目Id: 34
 * 题目：在排序数组中查找元素的第一个和最后一个位置
 * 日期: 2021-07-16 20:38:01
 **/
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1109 👎 0

package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        //5 7 7 8 8 10
        // 2 5
        int [] arrr = solution.searchRange(new int[]{5, 7, 7, 8, 8,8,8,8,8,10}, 8);
        System.out.println(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = (r - l >> 1) + l;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int [] res = new int[2];
            res[0] = l;
            l = 0;
            r = nums.length - 1;
            while (l < r) {
                int mid = (r - l + 1 >> 1) + l;
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            res[1] = r;
            return r == target?res:new int[]{-1,-1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}