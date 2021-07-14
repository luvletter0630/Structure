package Liwj.study.structure.Sort;

/**
 * Created by Administrator on 2021/4/17.
 */
public class MergeSort {
    public static void MergeSort(int arr[]) {
        int[] temp = new int[arr.length];
        MergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void MergeSort(int arr[], int l, int r, int temp[]) {
        if (l < r){
            int mid = (l + r) / 2;
            MergeSort(arr,0,mid,temp);
            MergeSort(arr,mid + 1,r,temp);
            MergeSort(arr,l,mid,r,temp);
        }
    }

    public static void MergeSort(int arr[],int l,int mid,int r,int temp[]){
        int i = l;
        int j = mid + 1;
        int t = 0;

        while (i <=mid && j<=r){
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid){
            temp[t++] = arr[i++];
        }

        while (j<=r){
            temp[t++] = arr[j++];
        }
        t = 0;
        while (l <= r){
            arr[l++] = temp[t++];
        }
    }
}
