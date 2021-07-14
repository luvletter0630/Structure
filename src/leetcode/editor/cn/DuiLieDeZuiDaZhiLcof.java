/**
 * 题目Id: 剑指 Offer 59 - II
 * 题目：队列的最大值
 * 日期: 2021-07-09 22:04:59
 **/
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 设计 队列 单调队列 
// 👍 259 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        DuiLieDeZuiDaZhiLcof solution = new DuiLieDeZuiDaZhiLcof();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {
        private Deque<Integer> numque;
        private Deque<Integer> maxque;

        public MaxQueue() {
            numque =new LinkedList<Integer>();
            maxque =new LinkedList<Integer>();
        }

        public int max_value() {
            if (maxque.isEmpty()){
                return -1;
            }
            return maxque.peekFirst();
        }

        public void push_back(int value) {
            numque.offerLast(value);
            while (!maxque.isEmpty()&&value>maxque.peekLast()){
                maxque.pollLast();
            }
            maxque.offerLast(value);
        }

        public int pop_front() {
            if(numque.isEmpty()){
                return -1;
            }
            if (maxque.peekFirst().equals(numque.peekFirst())){
                maxque.pollFirst();
            }
            return numque.poll();
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}