package Liwj.study.Leecode.findMaxLength.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2021/6/3.
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map  = new HashMap<>();
        int max = 0;
        int cnt = 0;
        map.put(0,-1);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1){
                cnt ++;
            }else {
                cnt --;
            }
            if (map.containsKey(cnt)){
                int preval=map.get(cnt);
                max = Math.max(max,i - preval);
            }else {
                map.put(cnt,i);
            }
        }
        return max;
    }
}
