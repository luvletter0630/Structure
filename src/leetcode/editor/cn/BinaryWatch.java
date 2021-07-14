/**
 * 题目Id: 401
 * 题目：二进制手表
 * 日期: 2021-06-21 22:08:01
 **/
//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "3:25" 。 
// 
//
// 
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
//Unported (CC BY-SA 3.0) ） 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
// Related Topics 位运算 回溯算法 
// 👍 300 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
        System.out.println(solution.readBinaryWatch(1).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] num = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        private List<String> res = new ArrayList<>();

        public List<String> readBinaryWatch(int turnedOn) {
/*            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                        builder.append(i).append(":").append(j > 10 ? j : "0" + j);
                        res.add(builder.toString());
                        builder.setLength(0);
                    }
                }
            }*/
            dfs(turnedOn, 0, 0, 0);
            return res;
        }

        public void dfs(int turned, int high, int low, int cur) {
            if (turned == 0) {
                String time = high + ":";
                if (low > 9) {
                    time += low;
                } else {
                    time += "0" + low;
                }
                res.add(time);
                return;
            }
            for (int i = cur; i < 10 && turned > 0; i++) {
                if (i < 4 && high + num[i] < 12) {
                    dfs(turned - 1, high + num[i], low, i + 1);
                } else if (i > 3 && low + num[i] < 60) {
                    dfs(turned - 1, high, low + num[i], i + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}