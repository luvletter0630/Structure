package Liwj.study.Leecode.minDays;


/**
 * Created by Administrator on 2021/5/9.
 */
public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return  -1;
        int low = Integer.MAX_VALUE; int high = 0;
        int mid = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(bloomDay[i],low);
            high = Math.max(bloomDay[i], high);
        }
        while (low < high){
            mid = (high - low)/2 + low;
            if (check(bloomDay,m,k,mid)){
                high = low;
            }else {
                low += 1;
            }
        }

        return low;
    }

    public boolean check(int [] bloomDay,int m,int k,int days){
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
