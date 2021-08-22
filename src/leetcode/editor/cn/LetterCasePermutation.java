//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 290 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();
        List<String> rs = solution.letterCasePermutation("a1b2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        char[] chars;
        int len;

        public List<String> letterCasePermutation(String s) {
            len = s.length();
            chars = s.toCharArray();
            dfs("");
            return res;
        }

        public void dfs(String s) {
            for (int i = s.length(); i < len; i++) {
                if (!Character.isDigit(chars[i])) {
                    char ch = Character.isUpperCase(chars[i])?Character.toLowerCase(chars[i]):Character.toUpperCase(chars[i]);
                    dfs(s + ch);
                }
                s = s + chars[i];
            }
            res.add(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}