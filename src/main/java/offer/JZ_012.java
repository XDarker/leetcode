package offer;

/**
 * @Created by XDarker
 * @Description 数值的整数次方
 * @Date 2021/3/7 16:36
 */
public class JZ_012 {

    public double Power(double base, int exponent) {
        if(base == 0){
            return 0;
        }
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }

        int m = Math.abs(exponent);
        double result = base;
        for (int i = 2; i <= m; i++) {
            result = result * base;
        }

        return exponent > 0 ? result : 1/result ;

    }
}
