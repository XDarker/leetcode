package Algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Created by XDarker
 * @Description 单调栈结构
 * @Date 2020/12/9 16:41
 */
public class T0007_rightWay {

    public static void main(String[] args) {

        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[][] result = rightWay(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        System.out.println("=====================================");
        result = getNearLessNoRepeat(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    private static int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;

        }
        return res;
    }

    public static int[][] getNearLessNoRepeat(int[] arr) {

        int len = arr.length;
        int[][] result = new int[len][2];
        Stack<Integer> singleStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!singleStack.isEmpty() && arr[singleStack.peek()] > arr[i]) {
                int popIndex = singleStack.pop();
                int leftIndexLess = singleStack.isEmpty() ? -1 : singleStack.peek();
                result[popIndex][0] = leftIndexLess;
                result[popIndex][1] = i;
            }
            singleStack.push(i);
        }

        while (!singleStack.isEmpty()){
            int popIndex = singleStack.pop();
            int leftIndexLess = singleStack.isEmpty() ? -1 : singleStack.peek();
            result[popIndex][0] = leftIndexLess;
            result[popIndex][1] = -1;
        }

        return result;

    }
}
