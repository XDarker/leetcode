package NewCoder.class01;

/**
 * @Created by XDarker
 * @Description 一个有序arr，找满足>=value的最左位置
 * @Date 2021/2/24 22:40
 */
public class Code05_BSNearLeft {

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,3,5};
        int value = 1;
        int res = nearestIndex(arr, value);
        System.out.println(res);
    }

    // 在arr上，找满足>=value的最左位置
    private static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
}
