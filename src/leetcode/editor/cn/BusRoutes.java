/**
 * 题目Id: 815
 * 题目：公交路线
 * 日期: 2021-06-29 22:23:22
 **/
//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。 
//
// 
// 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 
//-> ... 这样的车站路线行驶。 
// 
//
// 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。 
//
// 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
// 
//
// 示例 2： 
//
// 
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 105 
// routes[i] 中的所有值 互不相同 
// sum(routes[i].length) <= 105 
// 0 <= routes[i][j] < 106 
// 0 <= source, target < 106 
// 
// Related Topics 广度优先搜索 数组 哈希表 
// 👍 216 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {
        Solution solution = new BusRoutes().new Solution();
        int[][] test = {{1, 12}, {4, 5, 15}, {6}, {15, 9}, {9, 12, 13}};
        System.out.println(solution.numBusesToDestination(test, 1, 15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            int m = routes.length;
            Map<Integer, HashSet<Integer>> stations = new HashMap<Integer, HashSet<Integer>>();
            Map<Integer, Integer> route = new HashMap<Integer, Integer>();
            Queue<Integer> Statq = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                for (int j : routes[i]) {
                    if (j == source) {
                        Statq.offer(i);
                        route.put(i, 1);
                    }
                    HashSet<Integer> stat = stations.getOrDefault(j, new HashSet<Integer>());
                    stat.add(i);
                    stations.put(j, stat);
                }
            }
            if (!stations.containsKey(source)) {
                return -1;
            }

            Set<Integer> arristate = new HashSet<Integer>();
            arristate.add(source);

            while (!Statq.isEmpty()) {

                int st = Statq.poll();
                int step = route.get(st);

                for (int curstat : routes[st]) {
                    if (curstat == target) {
                        return step;
                    }
                    Set<Integer> lines = stations.get(curstat);
                    if (lines == null) {
                        continue;
                    }
                    for (int nts :
                            lines) {
                        if (!route.containsKey(nts)){
                            route.put(nts,step + 1);
                            Statq.offer(nts);
                        }
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}