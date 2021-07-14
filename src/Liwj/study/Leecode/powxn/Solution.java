package Liwj.study.Leecode.powxn;

/**
 * Created by Administrator on 2021/5/5.
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        int res = 1;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }

        return res;
    }
}
