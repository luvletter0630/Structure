package Liwj.study.Leecode.LCOF;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2021/5/3.
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Solution {
    public static void main(String[] args) {
        char[][] borad = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(borad, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean result = false;
        char[] c = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findChar(board, c, i, j, 0)) {
                    return true;
                }
            }
        }
        return result;
    }

    public static boolean findChar(char[][] board, char[] c, int i, int j, int n) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || c[n] != board[i][j]) {
            return false;
        }
        if (n == c.length - 1) {
            return true;
        }
        board[i][j] = ' ';
        boolean result = false;
        result = findChar(board, c, i + 1, j, n + 1) || findChar(board, c, i, j + 1, n + 1) || findChar(board, c, i - 1, j, n + 1) || findChar(board, c, i, j - 1, n + 1);
        board[i][j] = c[n];
        return result;
    }
}
