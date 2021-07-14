package Liwj.study.Leecode.numSquares;

/**
 * @author liwj
 * @addrees https://leetcode-cn.com/problems/coin-change-2/
 * @cnName 零钱兑换 II
 * @date 2021/6/12
 */
public class Solution {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        new Solution().change(amount, coins);
    }

    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        int cnt = 1;
        for (int coin : coins) {
            cnt = 1;
            while (cnt <= amount ) {
                if (coin <= amount && cnt >= coin) dp[cnt] = dp[cnt] + dp[cnt - coin];
                cnt++;
            }
        }
        return dp[amount];
    }
}
