package Liwj.study.Leecode.bitCount;

/**
 * Created by Administrator on 2021/5/5.
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0){
            res +=1;
            n &= n - 1;
        }
        return res;
    }
}
