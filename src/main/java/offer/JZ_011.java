package offer;

/**
 * @Created by XDarker
 * @Description 二进制中1的个数
 * @Date 2021/3/7 16:31
 */
public class JZ_011 {

    public int NumberOf1(int n) {
        int ans = 0;
        for (int i = 1; i <= 32; i++) {
            if ((n & 1) == 1) {
                ans++;
            }
            n = n >> 1;
        }
        return ans;

    }
}
