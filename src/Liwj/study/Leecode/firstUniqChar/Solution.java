package Liwj.study.Leecode.firstUniqChar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2021/6/5.
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(s.replaceAll("a", ""));
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
