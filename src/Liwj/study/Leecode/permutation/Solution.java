package Liwj.study.Leecode.permutation;

import java.util.*;

/**
 * Created by Administrator on 2021/5/17.
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/
 */
class Solution {
    char[] arry;
    List<String> result = new LinkedList<String>();

    public String[] permutation(String s) {
        arry = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }

    public void dfs(int x) {
        if (x == arry.length - 1) {
            result.add(String.valueOf(arry));
            return;
        }
        Set<Character> characters = new HashSet<Character>();
        for (int i = x; i < arry.length; i++) {
            if (characters.contains(arry[i])) continue;
            swap(x, i);
            dfs(x + 1);
            swap(x, i);
        }
    }

    public void swap(int i, int x) {
        char temp = arry[i];
        arry[i] = arry[x];
        arry[x] = temp;
    }
}