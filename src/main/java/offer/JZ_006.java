package offer;


/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/3/5 22:50
 */
public class JZ_006 {

    public static void main(String[] args) {

        int[] array = new int[]{6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};

        int min = minNumberInRotateArray(array);
        System.out.println(min);

    }

    private static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int l = 0;
        int r = array.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (l == r){
                return array[r];
            }
            int midVal = array[mid];
            if (midVal < array[r]){
                r = mid;
            }else if (midVal > array[r]){
                l = mid + 1;
            }else {
                r--;
            }

        }
        return array[r];
    }
}
