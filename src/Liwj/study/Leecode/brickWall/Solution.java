package Liwj.study.Leecode.brickWall;

import java.util.*;

/**
 * Created by Administrator on 2021/5/2.
 * https://leetcode-cn.com/problems/brick-wall/
 */
public class Solution {
    public  int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int key = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                key += list.get(j);
                if (map.containsKey(key)){
                    int value = map.get(key) + 1;
                    map.put(key, value);
                }else {
                    map.put(key, 1);
                }
            }
        }
        int result = 0;
        for (Integer i : map.values()) {
            result = Math.max(result,i);
        }
        return wall.size() - result;
    }
}
