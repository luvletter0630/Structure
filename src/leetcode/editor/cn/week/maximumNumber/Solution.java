package leetcode.editor.cn.week.maximumNumber;

public class Solution {
    public String maximumNumber(String num, int[] change) {
        int len = num.length();
        StringBuilder builder = new StringBuilder();
        boolean rep = true;
        boolean visit = false;
        for (int i = 0; i < len; i++) {
            if ((num.charAt(i) - '0') < change[num.charAt(i) - '0'] && rep == true ) {
                builder.append(change[num.charAt(i) - '0']);
                visit = true;
            }else if((num.charAt(i) - '0') == change[num.charAt(i) - '0']) {
                if (visit){
                    rep = false;
                }
            }else{
                builder.append(num.charAt(i) - '0');
            }
        }
        return builder.toString();
    }
}
