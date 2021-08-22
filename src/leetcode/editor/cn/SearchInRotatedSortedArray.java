//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1508 👎 0


package leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 1, 2, 3}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int index = binaryFindIdx(nums);
            int num = 0;
            int len = nums.length;
            if (target < nums[0]) {
                num = binaryFind(nums, target, index + 1, len - 1);
            } else {
                num = binaryFind(nums, target, 0, index);
            }
            return num;
        }

        public int binaryFind(int[] nums, int target, int l, int r) {
            while (l < r) {
                int mid = (r - l >> 1) + l;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return nums[l] == target ? l : -1;
        }

        public int binaryFindIdx(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            if (nums[0] < nums[r]) {
                return r;
            }
            while (l < r) {
                int mid = (r - l >> 1) + l;
                if (mid - 1 < 0) {
                    break;
                }
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] > nums[l] && nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}