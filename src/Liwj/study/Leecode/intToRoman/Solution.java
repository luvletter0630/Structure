package Liwj.study.Leecode.intToRoman;

/**
 * Created by Administrator on 2021/5/14.
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Solution {
    public String intToRoman(int num) {
        String[] romainnum = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] alnum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String res = "";
        for (int i = 0; i < romainnum.length; i++) {
            while (num - alnum[i] >= 0){
                num -= alnum[i];
                res += romainnum[i];
            }
        }
        return res;
    }
}
