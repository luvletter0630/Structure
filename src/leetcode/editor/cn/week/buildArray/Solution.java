package leetcode.editor.cn.week.buildArray;

/**
 * @author liwj
 * @addrees
 * @cnName
 * @date 2021/7/4
 */
public class Solution {
    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int [] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
