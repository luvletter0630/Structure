package Liwj.study.Leecode.spiralOrder;

import java.util.Arrays;

/**
 * Created by Administrator on 2021/5/8.
 */
public class Solution {
    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.spiralOrder(test)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            int [] res = new int[0];
            return res;
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int t = 1, b = matrix.length - 1, l = 0, r = matrix[0].length - 1, cnt = 0;
        return getArray(matrix, 0, 0, l, r, t, b, res, 0);
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
