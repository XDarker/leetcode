package offer;

/**
 * @Created by XDarker
 * @Description 矩形覆盖
 * @Date 2021/3/7 16:21
 */
public class JZ_010 {


    public int rectCover(int target) {

        if(target <= 2){
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];

    }
}
