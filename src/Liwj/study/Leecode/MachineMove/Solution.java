package Liwj.study.Leecode.MachineMove;

/**
 * Created by Administrator on 2021/5/3.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(3,3,3));
    }

    private int m, n, k;
    private boolean visit[][];
    int count = 0;

    public int movingCount(int m, int n, int k) {
        int result = 0;
        this.m = m;
        this.n = n;
        this.k = k;
        visit = new boolean[m][n];
        int res = movingResult(0, 0);
        System.out.println(count);
        return res;
    }

    public int getNum(int x, int y) {
        int num = 0;
        while (x > 0 || y > 0) {
            num += x % 10 + y % 10;
            x /= 10;
            y /= 10;
        }
        return num;
    }

    public int movingResult(int x, int y) {
        if (x >= m || y >= n || getNum(x, y) > k || visit[x][y] == true) {
            return 0;
        }
        count ++;
        visit[x][y] = true;
        int result = 1 + movingResult(x + 1, y) + movingResult(x, y + 1);
        return result;
    }
}
