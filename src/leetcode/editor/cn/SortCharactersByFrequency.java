/**
 * 题目Id: 451
 * 题目：根据字符出现频率排序
 * 日期: 2021-07-03 21:27:20
 **/
//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
// 👍 307 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            int len = s.length();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            Queue<Character> queue = new PriorityQueue<Character>((x, y) -> map.get(y) - map.get(x));
            for (int i = 0; i < len; i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (char ch : map.keySet()) {
                queue.offer(ch);
            }
            StringBuilder builder = new StringBuilder();
            while (!queue.isEmpty()){
                for (int i = 0; i < map.get(queue.peek()); i++) {
                    builder.append(queue.peek());
                }
                queue.poll();
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}