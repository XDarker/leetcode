package Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.zip.ZipEntry;

/**
 * @Created by XDarker
 * @Description 窗口最大值
 * @Date 2020/12/9 14:47
 */
public class T0006_getMaxWindow {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int size = 3;

        int[] result = maxSlidingWindow(arr, size);
        System.out.println(Arrays.toString(result));

    }

    private static int[] maxSlidingWindow(int[] arr, int w) {

        int len = arr.length;
        int[] result = new int[len - w + 1];
        int index = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < len; i++) {

            while (!qmax.isEmpty() && arr[i] >= arr[qmax.getLast()]) {
                qmax.removeLast();
            }
            qmax.add(i);
            if (qmax.getFirst() == i - w) {
                //队列头已经过期
                qmax.removeFirst();
            }
            if (i >= w - 1) {
                result[index++] = arr[qmax.getFirst()];
            }
        }


        return result;
    }
}
