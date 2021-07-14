package Liwj.study.structure.Query;

/**
 * Created by Administrator on 2021/4/17.
 */
public class BinarySearch {

    public static int binarySerch(int arr[], int num) {
        return binarySearch(arr, 0, arr.length - 1, num);
    }

    public static int binarySearch(int arr[], int l, int r, int num) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        int midval = arr[mid];

        if (num < midval) {
            return binarySearch(arr, l, mid - 1, num);
        } else if (num > midval) {
            return binarySearch(arr, mid + 1, r, num);
        } else {
            return mid;
        }


    }
}
