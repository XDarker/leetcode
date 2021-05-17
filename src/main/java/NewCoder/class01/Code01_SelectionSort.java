package NewCoder.class01;

import java.util.Arrays;

/**
 * @Created by XDarker
 * @Description 选择排序
 * @Date 2021/2/24 20:34
 */
public class Code01_SelectionSort {

    public static void main(String[] args) {


        int[] arr = new int[]{2, 4, 3, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序
     * 时间复杂度 n2
     * 不稳定
     * 每次遍历找出最小的 从左往右排序
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
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
