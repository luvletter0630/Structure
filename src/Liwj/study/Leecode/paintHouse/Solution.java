package Liwj.study.Leecode.paintHouse;

/**
 * Created by Administrator on 2021/5/4.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] testarr = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(solution.minCost(testarr));
    }
    public int minCost(int[][] costs) {
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1],costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0],costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0],costs[i - 1][1]);
        }
        return Math.min(costs[costs.length - 1][2],Math.min(costs[costs.length - 1][0],costs[costs.length - 1][1]));
    }
}
