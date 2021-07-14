package Liwj.study.Leecode.maxUncrossedLines;

/**
 * Created by Administrator on 2021/5/21.
 */
public class Solution {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 7, 1, 7, 5};
        int[] num2 = {1, 3, 9, 2, 1, 7};
        new Solution().maxUncrossedLines(num1, num2);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length + 1;
        int n = nums2.length + 1;
        int[][] result = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
