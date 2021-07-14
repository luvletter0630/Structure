package Liwj.study.Leecode.verifyPostorder;

/**
 * Created by Administrator on 2021/5/10.
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length - 1);
    }

    public boolean check(int[] postorder, int i, int j) {
        if (i > j) return true;
        int m;
        int p;
        p = i;
        while (postorder[p] < postorder[j]) p++;
        m = p;
        while (postorder[p] > postorder[j]) p++;
        return i == j & check(postorder, i, m - 1) && check(postorder, m, j - 1);
    }
}
