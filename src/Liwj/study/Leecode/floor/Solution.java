package Liwj.study.Leecode.floor;

/**
 * Created by Administrator on 2021/5/2.
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(numWays(0));
    }

    public static int numWays(int n) {
        int a = 0,b = 1;
        int sum = 0;
        for(int i = 0;i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
