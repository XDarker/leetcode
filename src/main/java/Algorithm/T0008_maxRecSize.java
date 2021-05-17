package Algorithm;

import javafx.scene.chart.StackedAreaChart;

import java.util.Stack;

/**
 * @Created by XDarker
 * @Description 最大子矩阵
 * @Date 2020/12/10 10:39
 */
public class T0008_maxRecSize {

    public static void main(String[] args) {

        int[][] map = new int[][]{
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,0}
        };
        int result = maxRecSize(map);
        System.out.println(result);

    }

    private static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    private static int maxRecFromBottom(int[] height) {

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int popIndex = stack.pop();
                int leftIndexLess = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - leftIndexLess - 1) * height[popIndex];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftIndexLess = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - leftIndexLess - 1) * height[popIndex];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;

    }


}
