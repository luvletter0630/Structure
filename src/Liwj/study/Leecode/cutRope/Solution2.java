package Liwj.study.Leecode.cutRope;

/**
 * Created by Administrator on 2021/5/4.
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.cuttingRope(500));
    }

    public int cuttingRope(int n) {
        long res = 1L;
        int p = (int) 1e9 + 7;
        if (n < 4) {
            return n - 1;
        }

        while (n > 4) {
            res = res * 3 % p;
            n -= 3;
        }

        return (int) (res * n % p);
    }
}
