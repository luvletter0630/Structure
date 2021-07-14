/**
 * 题目Id: 773
 * 题目：滑动谜题
 * 日期: 2021-06-26 14:50:55
 **/
//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 
//
// 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 示例： 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//输入：board = [[3,2,4],[1,5,0]]
//输出：14
// 
//
// 提示： 
//
// 
// board 是一个如上所述的 2 x 3 的数组. 
// board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列. 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 179 👎 0

package leetcode.editor.cn;

import java.util.*;

public class SlidingPuzzle {
    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] neib = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        public int slidingPuzzle(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(board[i][j]);
                }
            }
            String statu = sb.toString();
            if (statu.equals("123450")) {
                return 0;
            }
            int step = 0;
            Queue<String> status = new LinkedList<String>();
            status.offer(statu);
            Set<String> seen = new HashSet<String>();
            seen.add(statu);
            while (!status.isEmpty()) {
                ++step;
                int size = status.size();
                for (int i = 0; i < size; i++) {
                    String s = status.poll();
                    for (String sn: getStatus(s)) {
                        if (!seen.contains(sn)){
                            if (sn.equals("123450")){
                                return step;
                            }
                            seen.add(sn);
                            status.offer(sn);
                        }
                    }
                }
            }
            return -1;
        }

        public List<String> getStatus(String statu) {
            List<String> ret = new ArrayList<>();
            char[] chArr = statu.toCharArray();
            int x = statu.indexOf('0');
            for (int y : neib[x]) {
                swap(chArr, x, y);
                ret.add(new String(chArr));
                swap(chArr, x, y);
            }
            return ret;
        }

        public void swap(char[] array, int x, int y) {
            char temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}