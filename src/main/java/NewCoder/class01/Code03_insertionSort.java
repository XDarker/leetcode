package NewCoder.class01;

import java.util.Arrays;

/**
 * @Created by XDarker
 * @Description 插入排序
 * @Date 2021/2/24 21:54
 */
public class Code03_insertionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 4, 3, 2};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    /**
     * 插入排序
     * @param arr
     */
    private static void insertionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }


    }

    /**
     * 交换位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
