package Liwj.study.Leecode.MedianFinder;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Administrator on 2021/5/18.
 */
public class MedianFinder {
    Queue<Integer> bigHeap;
    Queue<Integer> smallHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        smallHeap = new PriorityQueue<Integer>();
        bigHeap = new PriorityQueue<Integer>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (bigHeap.size() != smallHeap.size()) {
            bigHeap.add(num);
            smallHeap.add(bigHeap.poll());
        } else {
            smallHeap.add(num);
            bigHeap.add(smallHeap.poll());
        }
    }

    public double findMedian() {
        if (bigHeap.size() == smallHeap.size()) {
            return (double) (bigHeap.peek() + smallHeap.peek()) / 2;
        } else {
            return bigHeap.peek();
        }
    }
}
