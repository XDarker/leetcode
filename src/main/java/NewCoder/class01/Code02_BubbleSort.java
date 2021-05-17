package NewCoder.class01;

import java.util.Arrays;

/**
 * @Created by XDarker
 * @Description 冒泡排序
 * @Date 2021/2/24 20:46
 */
public class Code02_BubbleSort {


    public static void main(String[] args) {

        int[] arr = new int[]{2, 1, 4, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 遍历 大的数依次往后移动
     * 时间复杂度 n2
     * 稳定
     * @param arr
     */
    private static void bubbleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
