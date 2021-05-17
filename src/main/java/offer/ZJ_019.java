package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/3/14 16:22
 */
public class ZJ_019 {


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2}, {3, 4}};

        ArrayList<Integer> arrayList = printMatrix(arr);
        System.out.println(arrayList);
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> ans = new ArrayList<>();
        int rowLen = matrix.length;//行
        if (rowLen == 0) {
            return ans;
        }
        int colLen = matrix[0].length;//列

        int c1 = 0;
        int c2 = colLen - 1;
        int r1 = 0;
        int r2 = rowLen - 1;
        int times = Math.min(rowLen, colLen) % 2 == 0 ? Math.min(rowLen, colLen) / 2 : Math.min(rowLen, colLen) / 2 + 1;

        for (int i = 0; i < times; i++) {
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2 ; r++) {
                ans.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2){
                for (int c = c2 - 1; c > c1 ; c--) {
                    ans.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1 ; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}
