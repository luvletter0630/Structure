package leetcode.editor.cn.week.eliminateMaximum;



/**
 * @author liwj
 * @addrees
 * @cnName
 * @date 2021/7/4
 */
public class Solution {
    public static void main(String[] args) {
        int [] dist = {46,33,44,42,46,36,7,36,31,47,38,42,43,48,48,25,28,44,49,47,29,32,30,6,42,9,39,48,22,26,50,34,40,22,10,45,7,43,24,18,40,44,17,39,36};
        int [] speed = {1,2,1,3,1,1,1,1,1,1,1,1,1,1,7,1,1,3,2,2,2,1,2,1,1,1,1,1,1,1,1,6,1,1,1,8,1,1,1,3,6,1,3,1,1};
        new Solution().eliminateMaximum(dist,speed);
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int len = dist.length;
        int cnt = 0;
        int x = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dist[i] /= speed[i];
        }
        return cnt;
    }
}
