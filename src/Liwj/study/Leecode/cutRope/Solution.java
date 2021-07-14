package Liwj.study.Leecode.cutRope;

/**
 * Created by Administrator on 2021/5/4.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(5));
    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) (Math.pow(3, a - 1) * 4);
        return (int) (Math.pow(3, a) * 2);
    }
}
