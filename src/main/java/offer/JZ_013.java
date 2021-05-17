package offer;

/**
 * @Created by XDarker
 * @Description 调整数组顺序使奇数位于偶数前面
 * @Date 2021/3/7 16:53
 */
public class JZ_013 {

    public int[] reOrderArray(int[] array) {

        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j + 1 <= i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
