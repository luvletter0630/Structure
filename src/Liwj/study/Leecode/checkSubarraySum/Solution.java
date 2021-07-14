package Liwj.study.Leecode.checkSubarraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2021/6/2.
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int num = 0;
        for (int i = 0; i < m; i++) {
            num += (nums[i] + num) % k;
            if (map.containsKey(num)){
                int preval = map.get(num);
                if (i - preval > 1){
                    return true;
                }
            }else {
                map.put(num,i);
            }
        }
        return false;
    }
}
