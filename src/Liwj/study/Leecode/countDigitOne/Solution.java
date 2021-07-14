package Liwj.study.Leecode.countDigitOne;


/**
 * Created by Administrator on 2021/5/27.
 */
public class Solution {
    public int countDigitOne(int n) {
        int i = n % 100;
        int res = 0;
        res = getNum(i);
        int cnt = n / 100;


        return (n / 100 - 1) * 100 + (n%100);

    }

    public int getNum(int i) {
        if (i == 1) {
            i = 1;
        } else if (i == 10) {
            i = 2;
        } else if (i > 10 && i < 20) {
            i = 2 + (i - 11);
        } else {
            if (i / 10 == 0) {
                i = 0;
            } else if (i / 10 > 0 && i % 10 > 0) {
                i = 11 + i / 10;
            } else {
                i = 10 + i / 10;
            }
        }
        return i;
    }
}
