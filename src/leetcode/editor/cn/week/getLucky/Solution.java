package leetcode.editor.cn.week.getLucky;

public class Solution {
    public static void main(String[] args) {
        new Solution().getLucky("leetcode",2);
    }

    public int getLucky(String s, int k) {
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            builder.append(s.charAt(i) - 'a' + 1);
        }
        int n = 0;
        while (k - 1 > 0) {
            String str = builder.toString();
            builder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                n += Integer.parseInt(str.charAt(i) + "");
            }
            builder.append(n);
        }
        return Integer.parseInt(builder.toString());
    }
}
