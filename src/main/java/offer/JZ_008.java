package offer;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/3/6 23:15
 */
public class JZ_008 {

    public int jumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1 || target == 2){
            return target;
        }
        int[] a = new int[target + 1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= target; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[target];
    }
}
