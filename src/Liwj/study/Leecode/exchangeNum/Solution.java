package Liwj.study.Leecode.exchangeNum;

/**
 * Created by Administrator on 2021/5/6.
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int l =0;
        int r=nums.length;
        int temp = 0;
        while (l < r){
            while (l < r && nums[l] %2 != 0){
                l++;
            }
            while (l < r && nums[r] % 2 == 0){
                r--;
            }
            if (l < r){
                temp = nums[l];
                nums[l] =nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }

}
