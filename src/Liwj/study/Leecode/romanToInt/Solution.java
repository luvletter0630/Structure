package Liwj.study.Leecode.romanToInt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2021/5/15.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("IV"));
    }

    public int romanToInt(String s) {
        String[] romainnum = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] alnum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < romainnum.length; i++) {
            map.put(romainnum[i],alnum[i]);
        }
        int res = 0;
        int num = map.get(s.charAt(0) + "");
        String cur = "";
        for (int i = 1; i < s.length(); i++) {
            cur = s.charAt(i) + "";
            if (num >= map.get(cur)){
                res +=  num;
            }else {
                res -= num;
            }
            num = map.get(cur);
        }
        res += num;
        return res;
    }
}
