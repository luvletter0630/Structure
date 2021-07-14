package Liwj.study.Leecode.deleteAndEarn;


/**
 * Created by Administrator on 2021/5/5.
 * https://leetcode-cn.com/problems/delete-and-earn/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {8, 7, 3, 8, 1, 4, 10, 10, 10, 2};
        System.out.println(solution.deleteAndEarn(arr));
    }

    int count[] = new int[10009];

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int x : nums) {
            count[x]++;
            max = Math.max(max, x);
        }

        int[][] f = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            f[i][1] = f[i - 1][0] + i * count[i];
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
        }
        return Math.max(f[max][0], f[max][1]);
    }
}
