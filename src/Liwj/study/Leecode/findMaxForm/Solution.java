package Liwj.study.Leecode.findMaxForm;

/**
 * Created by Administrator on 2021/6/6.
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[len][2];
        for (int i = 0; i < len; i++) {
            int zero = 0, one = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') zero++;
                else one++;
            }
            cnt[i] = new int[]{zero, one};
        }
        int[][] f = new int[m + 1][n + 1];
        for (int k = 0; k < len; k++) {
            int zero = cnt[k][0], one = cnt[k][1];
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    f[i][j] = Math.max(f[i][j], f[i - zero][j - one] + 1);
                }
            }
        }
        return f[m][n];
    }
}
