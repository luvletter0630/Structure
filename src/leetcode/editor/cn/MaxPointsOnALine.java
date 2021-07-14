/**
 * 题目Id: 149
 * 题目：直线上最多的点数
 * 日期: 2021-06-24 22:39:20
 **/
//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// points 中的所有点 互不相同 
// 
// Related Topics 几何 哈希表 数学 
// 👍 312 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            if (n <= 2){
                return n;
            }
            int rt = 0;
            for (int i = 0; i < n; i++) {
                if (rt >= n -1 || rt > n /2){
                    break;
                }
                Map<Integer,Integer> map = new HashMap<Integer,Integer>();
                for (int j = i + 1; j < n; j++) {
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    if (x == 0){
                        y = 1;
                    }
                    if (y == 0 ){
                        x = 1;
                    }else {
                        //if ()
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}