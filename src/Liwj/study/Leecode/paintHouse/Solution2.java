package Liwj.study.Leecode.paintHouse;

/**
 * Created by Administrator on 2021/5/4.
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int [][] testarr = {{17,2,17,1},{16,16,5,6},{14,3,19,2}};
        System.out.println(solution2.minCostII(testarr));
    }

    public int minCostII(int[][] costs) {
        for (int i = 1; i < costs.length; i++) {
            for (int k = 0; k < costs[0].length; k++) {
                costs[i][k] += getMinnum(costs[i - 1],k);
            }
        }
        return getMinnum(costs[costs.length - 1],-1);
    }

    public int getMinnum(int[] arr, int exp) {
        int temp = 0;
        if (exp != 0) {
            temp = arr[0];
        } else {
            temp = arr[1];
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < temp && i != exp) {
                temp = arr[i];
            }
        }
        return temp;
    }
}
