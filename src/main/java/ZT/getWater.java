package ZT;

/**
 * @Created by XDarker
 * @Description 数组蓄水池直方图 最大能装多少水
 * @Date 2020/9/7 22:07
 */
public class getWater {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int water = water(arr);
        System.out.println(water);

    }

    private static int water(int[] arr) {

        int len = arr.length;
        int leftMax = arr[0];
        int rightMax = arr[len - 1];

        int L = 1;
        int R = len - 2;
        int water = 0;
        while (L <= R) {
            if (leftMax <= rightMax) {
                water += Math.max(leftMax - arr[L], 0);
                leftMax = Math.max(leftMax, arr[L]);
                L++;
            } else {
                water += Math.max(rightMax - arr[R], 0);
                rightMax = Math.max(rightMax, arr[R]);
                R--;

            }
        }
        return water;


    }
}
