package Liwj.study.structure.Sort;

import Liwj.study.structure.Query.BinarySearch;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2021/4/12.
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] testarr = {1, 6, 7, 8, 5, 4, 3, 2, 9, 0, 10, 13, 45, 12};
        int[] testarr2 = {1, 2, 0, 5, 4, 9, 6};

        //sort.shellSortMove(testarr);
        //quickSort.qiuckSort(testarr);
        MergeSort.MergeSort(testarr);
        System.out.println(BinarySearch.binarySerch(testarr,13));

        //sort.quickSort(testarr,0,testarr.length - 1);
        System.out.println(Arrays.toString(testarr));
        int[] intarr = new int[80000];
        for (int i = 0; i < intarr.length; i++) {
            intarr[i] = new Random().nextInt(80000);
        }
        long starttime = System.currentTimeMillis();
        System.out.println(starttime);
        //sort.selectSort(intarr);
        //sort.BubbleSort(intarr);
        //sort.insertSort(intarr);
        //sort.shellSortExchange(intarr);
        long endtime = System.currentTimeMillis();
        System.out.println(endtime);
        System.out.println((endtime - starttime) / 1000);

    }

    public void BubbleSort(int[] inarr) {
        int temp = 0;
        boolean flag = true;
        for (int i = 0; i < inarr.length - 1; i++) {
            for (int j = 0; j < inarr.length - i - 1; j++) {
                if (inarr[j] > inarr[j + 1]) {
                    flag = false;
                    temp = inarr[j];
                    inarr[j] = inarr[j + 1];
                    inarr[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public void ChooseSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    temp = arr[i];
                    min = j;
                }
            }
            if (i != min) {
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertindex = i - 1;
            int indexVal = arr[i];
            while (insertindex >= 0 && indexVal < arr[insertindex]) {
                arr[insertindex + 1] = arr[insertindex];
                insertindex--;
            }
            arr[insertindex + 1] = indexVal;
        }
    }

    public void myinsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertindex = i;
            int indexVal = arr[i];
            while (insertindex > 0 && arr[insertindex - 1] > indexVal) {
                arr[insertindex] = arr[insertindex - 1];
                insertindex--;
            }
            arr[insertindex] = indexVal;
        }
    }

    public void shellSortExchange(int[] arr) {
        int temp = 0;
        for (int single = arr.length / 2; single > 0; single /= 2) {
            for (int i = single; i < arr.length; i++) {
                for (int j = i - single; j >= 0; j -= single) {
                    if (arr[j] > arr[j + single]) {
                        temp = arr[j];
                        arr[j] = arr[j + single];
                        arr[j + single] = temp;
                    }
                }
            }
        }
    }

    public void shellSortMove(int[] arr) {
        int temp = 0;
        for (int half = arr.length / 2; half > 0; half /= 2) {
            for (int i = half; i < arr.length; i++) {
                int j = i;
                temp = arr[i];
                while (j - half >= 0 && temp < arr[j - half]) {
                    arr[j] = arr[j - half];
                    j = j - half;
                }
                arr[j] = temp;
            }
        }
    }
}
