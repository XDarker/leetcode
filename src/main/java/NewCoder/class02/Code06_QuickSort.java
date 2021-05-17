package NewCoder.class02;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/4/5 21:09
 */
public class Code06_QuickSort {

    public static void qucikSott(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {

        if (l < r) {
            swap(arr, l + (int) Math.random() * (r - l + 1), r);
            int[] p = partition(arr, l, r);
            qucikSort(arr, l, p[0] - 1);
            qucikSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {

        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            }else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less+1, more};

    }

    private static void qucikSort(int[] arr, int l, int i) {
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
