package leetcode.editor.cn.week.wonderfulSubstrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liwj
 * @addrees
 * @cnName
 * @date 2021/6/27
 */
public class Solution {
    public long wonderfulSubstrings(String word) {
        Set<String> set = new HashSet<String>();
        long res = 0;
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.charAt(i) + "")) {
                set.remove(word.charAt(i) + "");
                res -= 1;
            } else {
                set.add(word.charAt(i) + "");
                res += 1;
            }
            String s = word.charAt(i) + "";
            for (int j = i + 1; j < word.length(); j++) {
                s += word.charAt(j);
                if (set.contains(s)) {
                    set.remove(s);
                    res -= 1;
                } else{
                    set.add(s);
                    res += 1;
                }
            }
        }
        return res;
    }
}
