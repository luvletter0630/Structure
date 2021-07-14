package Liwj.study.Leecode.xorGame;

/**
 * Created by Administrator on 2021/5/22.
 */
public class Solution {
    public boolean xorGame(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n == 0|| nums.length % 2 == 0;
    }
}
