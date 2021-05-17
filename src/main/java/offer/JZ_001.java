package offer;

import java.util.logging.Level;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/2/21 19:55
 */
public class JZ_001 {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int num = 10;

        boolean res = find(num, arr);
        System.out.println(res);


    }

    private static boolean find(int target, int[][] array) {

        if (array == null || array.length == 0) {
            return false;
        }
        int row = array.length - 1;
        if (row == -1) {
            return false;
        }
        int col = array[0].length - 1;
        if (row == 0 && array[0].length == -1) {
            return false;
        }

        int rowLen = 0;
        while (row >= rowLen && col >= 0) {
            for (int i = rowLen; i <= row && col >= 0; ) {
                if (array[i][col] < target) {
                    rowLen++;
                    i++;
                } else if (array[i][col] > target) {
                    col--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
