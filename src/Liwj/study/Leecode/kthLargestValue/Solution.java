package Liwj.study.Leecode.kthLargestValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2021/5/19.
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 3, 7, 6};
        Solution solution = new Solution();
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            integers.add(arr[i]);
        }
        solution.nthElement(integers,0,2,integers.size() - 1);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }

        nthElement(results, 0, k - 1, results.size() - 1);
        return results.get(k - 1);
    }

    public void nthElement(List<Integer> results, int left, int kth, int right) {
        if (left == right) {
            return;
        }
        int pivot = 1;
        swap(results, pivot, right);
        // 三路划分（three-way partition）
        int sepl = left - 1, sepr = left - 1;
        for (int i = left; i <= right; i++) {
            if (results.get(i) > results.get(right)) {
                swap(results, ++sepr, i);
                swap(results, ++sepl, sepr);
            } else if (results.get(i) == results.get(right)) {
                swap(results, ++sepr, i);
            }
        }
        if (sepl < left + kth && left + kth <= sepr) {
            return;
        } else if (left + kth <= sepl) {
            nthElement(results, left, kth, sepl);
        } else {
            nthElement(results, sepr + 1, kth - (sepr - left + 1), right);
        }
    }

    public void swap(List<Integer> results, int index1, int index2) {
        int temp = results.get(index1);
        results.set(index1, results.get(index2));
        results.set(index2, temp);
    }

}
