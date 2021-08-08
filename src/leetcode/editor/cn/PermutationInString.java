//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 396 👎 0


package leetcode.editor.cn;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("hello","ooolleoooleh"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] cntArr = new int[26];
            int lenOfs1 = s1.length();
            int lenOfs2 = s2.length();
            if (lenOfs1 > lenOfs2) {
                return false;
            }
            for (int i = 0; i < lenOfs1; i++) {
                cntArr[s1.charAt(i) - 'a']++;
            }
            int[] tmp = cntArr.clone();
            int cnt = lenOfs1;
            for (int i = 0; i <= lenOfs2 - lenOfs1; i++) {
                if (tmp[s2.charAt(i) - 'a'] < 1){
                    continue;
                }
                tmp[s2.charAt(i) - 'a']--;
                cnt--;
                if(cnt == 0){
                    return true;
                }
                for (int j = i + 1; j < lenOfs2; j++) {
                    int index = s2.charAt(j) - 'a';
                    if (tmp[index] > 0) {
                        tmp[index] --;
                        cnt --;
                        if (cnt == 0){
                            return true;
                        }
                    }else {
                        tmp = cntArr.clone();
                        cnt = lenOfs1;
                    }
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}