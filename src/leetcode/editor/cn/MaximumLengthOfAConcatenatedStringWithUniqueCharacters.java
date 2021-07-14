/**
 * 题目Id: 1239
 * 题目：串联字符串的最大长度
 * 日期: 2021-06-19 14:05:17
 **/
//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。 
//
// 请返回所有可行解 s 中最长长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
// 
//
// 示例 2： 
//
// 输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
// 
//
// 示例 3： 
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] 中只含有小写英文字母 
// 
// Related Topics 位运算 回溯算法 
// 👍 131 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        public int maxLength(List<String> arr) {
            List<Integer> legalStr = new ArrayList();
            for (String s : arr) {
                int n = 0;
                for (int i = 0; i < s.length(); i++) {
                    int ch = s.charAt(i) - 'a';
                    if (((n >> ch)&1)!=0){
                        n = 0;
                        break;
                    }
                    n |= 1 << ch;
                }
                if (n > 0){
                    legalStr.add(n);
                }
            }
            dfs(legalStr,0,0);
            return ans;
        }

        public void dfs(List<Integer> legalStr,int x, int num) {
            if (x == legalStr.size()) {
                ans = Math.max(ans,Integer.bitCount(num));
                return;
            }

            if ((legalStr.get(x) & num) == 0){
                dfs(legalStr,x + 1,num | legalStr.get(x));
            }
            dfs(legalStr,x + 1,num);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}