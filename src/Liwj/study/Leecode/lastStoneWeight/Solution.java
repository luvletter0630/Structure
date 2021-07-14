package Liwj.study.Leecode.lastStoneWeight;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Administrator on 2021/6/8.
 * https://leetcode-cn.com/problems/last-stone-weight/
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 8, 5};
        System.out.println(lastStoneWeight(arr));
    }

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        for (int num : stones) {
            heap.add(num);
        }
        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();
            if (a > b) heap.add(a - b);
        }
        return heap.poll();
    }
}
