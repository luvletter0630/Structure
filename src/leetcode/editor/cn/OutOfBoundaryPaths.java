//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以
//穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。 
//
// 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 
//109 + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
// Related Topics 动态规划 
// 👍 187 👎 0


package leetcode.editor.cn;

/**
 * 1  2  3  4  5
 * 1 4  6  8  10 12
 * 2 6  8  10 12 14
 * 3
 * 4
 * 5
 * 1*1  1*2 2*2 1*3  1*4  1*5
 * 1  4    3   2   3
 * 2  4    6   6   5
 * 3  4    9   14  11
 * 4  4    12  30  15
 * 5  4    15  62  27
 */
public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        Solution solution = new OutOfBoundaryPaths().new Solution();
        solution.findPaths(1,3,5,0,1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            int res = 0;
            int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int dp[][] = new int[m][n];
            dp[startRow][startColumn] = 1;
            int mod = 1000000007;
            for (int i = 0; i < maxMove; i++) {
                int[][] dpNew = new int[m][n];
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int count = dp[j][k];
                        if (count >  0) {
                            for (int[] mv : move) {
                                int row = j + mv[0], col = k + mv[1];
                                if (row >= 0 && col >= 0 && row < m && col < n) {
                                    dpNew[row][col] = (dpNew[row][col] + count) % mod;
                                } else {
                                    res = (res + count) % mod;
                                }
                            }
                        }
                    }
                }
                dp = dpNew;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}