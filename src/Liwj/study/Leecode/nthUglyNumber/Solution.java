package Liwj.study.Leecode.nthUglyNumber;

/**
 * Created by Administrator on 2021/6/5.
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i = 0, j = 0, k = 0;
        dp[0] = 1;
        for (int l = 1; l < n; l++) {
            int tmp = Math.min(Math.min(dp[i] * 2, dp[j] * 3), dp[k] * 5);
            if (tmp == dp[i] * 2) i++;
            if (tmp == dp[j] * 3) j++;
            if (tmp == dp[k] * 5) k++;
            dp[l] = tmp;
        }
        return dp[n - 1];
    }
}
