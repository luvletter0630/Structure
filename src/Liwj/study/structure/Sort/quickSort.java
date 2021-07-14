package Liwj.study.structure.Sort;

/**
 * Created by Administrator on 2021/4/17.
 */
public class quickSort {

    public static void qiuckSort(int[] arr) {
        qiuckSort(arr, 0, arr.length - 1);
    }

    public static void qiuckSort(int[] arr, int l, int r) {
        if (l < r) {
            int temp = arr[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && arr[j] >= temp) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                if (i < j && arr[i] < temp) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = temp;

            qiuckSort(arr, l, j - 1);
            qiuckSort(arr, j + 1, r);
        }
    }
}
