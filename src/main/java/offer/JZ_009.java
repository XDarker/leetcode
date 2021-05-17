package offer;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/3/7 16:13
 */
public class JZ_009 {

    public int jumpFloorII(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1 || target == 2){
            return target;
        }
        int[] a = new int[target + 1];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= target; i++) {
            for(int j = 1; j <= i; j++){
                a[i] += a[i - j];
            }
        }
        return a[target];
    }
}

