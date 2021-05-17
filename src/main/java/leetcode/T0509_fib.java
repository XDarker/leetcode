package leetcode;

/**
 * @Created by XDarker
 * @Description 斐波那契数
 * @Date 2020/5/26 22:47
 */
public class T0509_fib {


    static int[] nums = new int[46];

    public static void main(String[] args) {

        int res = fib(10);
        System.out.println(res);
    }


    public static int fib(int N) {
        if (N == 0){
            return 0;
        }

        if (N == 1){
            return 1;
        }
        if (nums[N] ==  0){
            nums[N] = fib(N - 1) + fib(N - 2);
        }
        return nums[N];
    }
}
