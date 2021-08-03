package leetcode.editor.cn;

import java.util.Arrays;

public class minAbsoluteSumDiff {
    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int len = nums1.length;
            int sort[] = nums2.clone();
            Arrays.sort(sort);
            int[] sum = new int[len];
            int maxValue = 0;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                sum[i] = Math.abs(nums1[i] - nums2[i]);
                cnt += sum[i];
                maxValue = Math.max(sum[i] - Math.abs(binaryFind(sort,nums1[i]) - nums1[i]),maxValue);
            }
            return cnt - maxValue;
        }

        public int binaryFind(int[] numArayy,int num) {
            // 1 2 4 7 8 9   6  l=0 r=5 mid = 2
            //
            int l = 0;
            int r = numArayy.length - 1;
            while (l < r){
                int mid = (r - l >> 1) + l;
                if (numArayy[mid] < num){
                    l = mid + 1;
                }else {
                    r = mid;
                }
            }
            return l;
        }
    }
}
