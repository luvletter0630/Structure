//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3639 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        solution.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,-5,-6,-7,3,4,5,6,9,7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len - 2 && nums[i] <= 0; i++) {
                int x = nums[i];
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = len - 1;
                while (left < right) {
                    int y = nums[left], z = nums[right];
                    if (x + y + z == 0) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(x);
                        ans.add(y);
                        ans.add(z);
                        res.add(ans);
                        while (nums[left] == y && left < right){
                            left ++;
                        }
                        while (nums[right] == z && left < right){
                            right --;
                        }
                    }else if (x + y + z > 0){
                        right --;
                    }else {
                        left ++;
                    }
                }
            }
            return res;
        }
    }//leetcode submit region end(Prohibit modification and deletion)

}