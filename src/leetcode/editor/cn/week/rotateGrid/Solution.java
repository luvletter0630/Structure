package leetcode.editor.cn.week.rotateGrid;

/**
 * @author liwj
 * @addrees https://leetcode-cn.com/contest/weekly-contest-247/problems/cyclically-rotating-a-grid/
 * @cnName 循环轮转矩阵
 * @date 2021/6/27
 */
public class Solution {
    public static void main(String[] args) {
        int [][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k = 2;
        new Solution().rotateGrid(grid,k);
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[] arrtemp = new int[grid.length * grid[0].length];
        int t = 1, b = grid.length - 1, r = grid[0].length - 1;
        int[] resArrl = getArray(grid, 0, 0, 0, r, t, b, arrtemp, 0);
        if (m / 2 >= n / 2) {
            int start = (m - 2) * n;
            while (n - 2 >= 0) {
                int mvbit = k % ((m - 2) * n);
                if (mvbit != 0) {
                    int temp[] = new int[mvbit];
                    System.arraycopy(resArrl, start - (m - 2) * n, temp, 0, mvbit);
                    System.arraycopy(resArrl, mvbit, resArrl, start - (m - 2) * n, start - mvbit);
                    System.arraycopy(temp, 0, resArrl, start - mvbit, mvbit);
                }
                start += (m - 2) * (n - 2);
                m -= 2;
                n -= 2;
            }
        } else {
            int start = m * (n - 2);
            while (m - 2 >= 0) {
                int mvbit = k % (m - 2) * n;
                if (mvbit != 0) {
                    int temp[] = new int[mvbit];
                    System.arraycopy(resArrl, (m - 2) * n - mvbit, temp, 0, mvbit);
                    System.arraycopy(resArrl, 0, resArrl, start - mvbit, mvbit);
                    System.arraycopy(temp, 0, resArrl, 0, mvbit);
                }
                start += (m - 2) * (n - 2);
                m -= 2;
                n -= 2;
            }
        }
        return null;
    }

    public int[] getArray(int[][] array, int i, int j, int l, int r, int t, int b, int[] res, int cnt) {
        if (cnt == array.length * array[0].length) {
            return res;
        }
        res[cnt] = array[i][j];
        cnt++;
        while (j < r) {
            j++;
            res[cnt] = array[i][j];
            cnt++;
            if (cnt == array.length * array[0].length) {
                return res;
            }
        }
        while (i < b) {
            i++;
            res[cnt] = array[i][j];
            cnt++;
            if (cnt == array.length * array[0].length) {
                return res;
            }
        }
        while (j > l) {
            j--;
            res[cnt] = array[i][j];
            cnt++;
            if (cnt == array.length * array[0].length) {
                return res;
            }
        }
        while (i > t) {
            i--;
            res[cnt] = array[i][j];
            cnt++;
            if (cnt == array.length * array[0].length) {
                return res;
            }
        }
        return getArray(array, i, j + 1, l + 1, r - 1, t + 1, b - 1, res, cnt);
    }
}
