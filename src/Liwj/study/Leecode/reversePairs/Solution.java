package Liwj.study.Leecode.reversePairs;

/**
 * Created by Administrator on 2021/6/5.
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class Solution {
    private int cnt = 0;
    public int reversePairs(int[] nums) {
        merge_sort(nums, 0, nums.length - 1);
        return cnt;
    }

    public void merge_sort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + ((r - l) >> 1);
            merge_sort(nums, l, mid);
            merge_sort(nums, mid + 1, r);
            merge_sort(nums, l, r, mid);
        }
    }

    public void merge_sort(int[] nums, int l, int r, int mid) {
        int[] temp = new int[r - l + 1];
        int left = l;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right < temp.length) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                cnt += (mid - left + 1);
                temp[index++] = nums[right++];

            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right < temp.length) {
            temp[index++] = nums[right++];
        }
        index = 0;
        while (l <= r){
            nums[l++] = temp[index ++];
        }
    }
}
