package offer;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/3/6 23:03
 */
public class JZ_007 {


    public static int Fibonacci(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}
