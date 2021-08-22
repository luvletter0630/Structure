//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 
// 👍 464 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        solution.updateMatrix(mat);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] mx = {0, 0, 1, -1};
        int[] my = {1, -1, 0, 0};

        public int[][] updateMatrix(int[][] mat) {
            int col = mat[0].length;
            int row = mat.length;
            int[][] res = new int[row][col];
            boolean[][] visit = new boolean[row][col];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 0) {
                        visit[i][j] = true;
                        queue.offer(new int[]{i, j});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] solution = queue.poll();
                int x = solution[0];
                int y = solution[1];
                for (int i = 0; i < 4; i++) {
                    int dx = mx[i] + x;
                    int dy = my[i] + y;
                    if (dx >= 0 && dx< col && dy >= 0 && dy < row && !visit[dx][dy]){
                        res[dx][dy] = res[x][y] + 1;
                        visit[dx][dy] = true;
                        queue.offer(new int[]{dx,dy});
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}