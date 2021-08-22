//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 2 * 109 
// 
// Related Topics 递归 数学 动态规划 
// 👍 304 👎 0


package leetcode.editor.cn;

/**
 * 1 11 21 31 41 51 61 71 81 91 101 111
 * 10 11 12 13 14 15 16 17 18 19 110 111
 * 100 101 102 103 104 105 106 107 108 109 110 111
 *1 1 1
 * 11 + 1 12
 * 10 + 1 12
 * 11 + 1 12
 */
public class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int high = 0;
            int dight = 1;
            int cur = 0;
            int low = 0;
            int res = 0;
            while (n > 0){
                high = n / 10;
                cur = n % 10;
                if (cur == 0){
                    res += high * dight;
                }else if (cur == 1){
                    res += high * dight + low + 1;
                }else {
                    res += (high + 1) * dight;
                }
                low += cur * dight;
                dight *=10;
                n /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}