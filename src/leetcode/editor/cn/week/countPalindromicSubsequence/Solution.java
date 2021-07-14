package leetcode.editor.cn.week.countPalindromicSubsequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liwj
 * @addrees
 * @cnName
 * @date 2021/7/11
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().countPalindromicSubsequence("bbcbaba");
    }

    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<Character>();
        int res = 0;
        int arr[] = new int[2];
        for (int i = 0; i < len; i++) {
            if (!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                for (int j = len - 1; j > i; j--) {
                    if (s.charAt(i) != s.charAt(j)){
                        continue;
                    }else {
                        Set<Character> cntset = new HashSet<Character>();
                        for (int k = i + 1; k < j; k++) {
                            cntset.add(s.charAt(k));
                        }
                        res += cntset.size();
                        break;
                    }
                }

            }
        }
        return res;
    }
}
