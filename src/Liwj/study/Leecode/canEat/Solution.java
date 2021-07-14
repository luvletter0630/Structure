package Liwj.study.Leecode.canEat;

/**
 * Created by Administrator on 2021/6/1.
 */
public class Solution {
    public static void main(String[] args) {
        int[][] queries = {{3,1,2}, {4,10,3}, {2, 13, 1000000000}};
        int[] candiesCount = {5,2,6,4,1};
        new Solution().canEat(candiesCount,queries);
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long dp[] = new long[n];
        dp[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        int q = queries.length;
        for (int i = 0; i < q; i++) {
            if (queries[i][0] == 0){
                res[i] =queries[i][1] < dp[queries[i][0]];
            }else {
                res[i] = queries[i][1] >= (dp[queries[i][0]] / queries[i][2]) && queries[i][1] < dp[queries[i][0]];
            }
        }
        return res;
    }
}
