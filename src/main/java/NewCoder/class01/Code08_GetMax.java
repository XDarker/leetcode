package NewCoder.class01;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/4/5 14:01
 */
public class Code08_GetMax {
    /**
     * 找出数组的最大值
     *
     * @param arr
     * @return
     */
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
