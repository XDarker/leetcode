package leetcode;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2020/5/28 22:59
 */
public class T0322_coinChange {

    public static void main(String[] args) {

        int res = coinChange(27);
        System.out.println(res);
    }

    public static int coinChange(int amount) {

        //0元钱 只要0个硬币
        if (amount == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;

        if (amount >= 2){
            res =coinChange(amount - 2) + 1;
        }
        if (amount >= 5){
            res =Math.min(coinChange(amount - 5) + 1, res);
        }
        if (amount >= 7){
            res =Math.min(coinChange(amount - 7) + 1, res);
        }
        return res;

    }

}
