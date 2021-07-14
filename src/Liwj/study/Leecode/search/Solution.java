package Liwj.study.Leecode.search;

/**
 * Created by Administrator on 2021/6/7.
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        new Solution().search(array, 10);
    }

    private int cnt = 0;

    public int search(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;
        int mid = l + (r - l) >> 1;
        return binarySearch(nums, target, l, r);
    }

    public int binarySearch(int[] nums, int target, int l, int r) {
        if (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (nums[mid] == target) {
                while (nums[mid - 1] == target) {
                    mid--;
                }
                while (mid < nums.length && nums[mid] == target) {
                    mid++;
                    cnt++;
                }
                return cnt;
            } else if (nums[mid] < target) {
                return binarySearch(nums, target, mid + 1, r);
            } else {
                return binarySearch(nums, target, l, mid - 1);
            }
        }
        return 0;
    }
}
