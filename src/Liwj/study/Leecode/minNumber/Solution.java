package Liwj.study.Leecode.minNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2021/5/28.
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class Solution {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + "");
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);

    }
}
