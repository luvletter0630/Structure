//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 197 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels(" "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            int left = 0;
            int right = s.length() - 1;
            if (right < 0){
                return s;
            }
            Set<Character> ch = new HashSet<>();
            ch.add('a');
            ch.add('e');
            ch.add('i');
            ch.add('o');
            ch.add('u');
            StringBuilder builderl = new StringBuilder();
            StringBuilder builderr = new StringBuilder();
            while (left < right) {
                if (ch.contains(s.charAt(left)) && ch.contains(s.charAt(right))) {
                    builderl.append(s.charAt(right));
                    builderr.append(s.charAt(left));
                    left++;
                    right--;
                    if(left == right){
                        builderl.append(s.charAt(left));
                    }
                } else if (ch.contains(s.charAt(left)) && !ch.contains(s.charAt(right))) {
                    builderr.append(s.charAt(right));
                    right--;
                    if(left == right){
                        builderl.append(s.charAt(left));
                    }
                } else if (!ch.contains(s.charAt(left)) && ch.contains(s.charAt(right))) {
                    builderl.append(s.charAt(left));
                    left++;
                    if(left == right){
                        builderl.append(s.charAt(left));
                    }
                } else {
                    builderl.append(s.charAt(left));
                    builderr.append(s.charAt(right));
                    left++;
                    right--;
                    if(left == right){
                        builderl.append(s.charAt(left));
                    }
                }
            }
            return builderl.append(builderr.reverse()).toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}