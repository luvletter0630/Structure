//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 389 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
        solution.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        public int orangesRotting(int[][] grid) {
            Queue<int[]> queue = new LinkedList<>();
            int col = grid[0].length;
            int row = grid.length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            if (queue.isEmpty()) {
                return -1;
            }
            int cnt = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] sol = queue.poll();
                    int x = sol[0];
                    int y = sol[1];
                    for (int j = 0; j < 4; j++) {
                        int mx = x + dx[j];
                        int my = y + dy[j];
                        if (mx >= 0 && mx < col && my >= 0 && my < row && grid[mx][my] == 1) {
                            grid[mx][my] = 2;
                            queue.offer(new int[]{mx, my});
                        }
                    }
                }
                if (queue.size() > 0) {
                    cnt++;
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }

            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}