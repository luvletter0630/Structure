package Liwj.study.Leecode.rotateArray;

/**
 * Created by Administrator on 2021/5/1.
 */
public class Solution {
    public static void main(String[] args) {
        int [] arr = {0,1,4,4,5,6,7};
        System.out.println(Solution.minArray(arr));
    }


    public static int minArray(int[] numbers) {
        int l = 0,r = numbers.length - 1;
        if (r == 0){
            return -1;
        }
        if (numbers[l] < numbers[r]){
            return numbers[l];
        }
        int mid = 0;
        while (l < r){
            mid = (r - l) / 2 + l;
            if (numbers[mid] < numbers[r]){
                r = mid;
            }else if (numbers[mid] > numbers[r]){
                l = mid + 1;
            }else {
                r --;
            }
        }
        return numbers[mid];
    }
}
