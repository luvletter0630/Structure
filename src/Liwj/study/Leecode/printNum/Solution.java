package Liwj.study.Leecode.printNum;

import java.util.Arrays;

/**
 * Created by Administrator on 2021/5/5.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.printNumbers(2)));
    }

    public int[] printNumbers(int n) {
        int num = (int) (Math.pow(10,n) - 1);
        int [] res = new int[num];
        for (int i = 1; i <= num; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
