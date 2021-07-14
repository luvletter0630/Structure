package Liwj.study.Leecode.replaceSpace;

/**
 * Created by Administrator on 2021/4/30.
 */
public class Solution {

    public  String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c:s.toCharArray()){
            if (c == ' '){
                builder.append("%20");
            }else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
