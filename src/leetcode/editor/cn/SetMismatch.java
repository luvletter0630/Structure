/**
 * 题目Id: 645
 * 题目：错误的集合
 * 日期: 2021-07-04 10:08:03
 **/
//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。 
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,4]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 位运算 数组 哈希表 排序 
// 👍 189 👎 0

package leetcode.editor.cn;


public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //ans1
        /*
        public int[] findErrorNums(int[] nums) {
            int sum = 0;
            int len = nums.length;
            int [] cnt = new int[len + 1];
            int sums = len * (len + 1) / 2;
            int set = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                if (cnt[nums[i]] == 0){
                    set += nums[i];
                }
                cnt[nums[i]] ++;
            }
            int[] res = new int[2];
            res[0] = sum - set;
            res[1] = sums - set;
            return res;
        }
        */
        public int[] findErrorNums(int[] nums) {
            int len = nums.length;
            int cnt[] = new int[len + 1];
            for (int num : nums){
                cnt[num] ++;
            }
            int res[] = new int[2];
            for (int i = 0; i <= len; i++) {
                if (cnt[i] == 0){
                    res[1] = cnt[i];
                }
                if (cnt[i] == 2){
                    res[0] = cnt[i];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}