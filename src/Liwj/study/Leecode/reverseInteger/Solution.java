package Liwj.study.Leecode.reverseInteger;

/**
 * Created by Administrator on 2021/5/3.
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        //2147483647
        return (int) result == result ? (int) result : 0;
    }
}
