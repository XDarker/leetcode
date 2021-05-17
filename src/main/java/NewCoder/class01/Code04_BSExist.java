package NewCoder.class01;

/**
 * @Created by XDarker
 * @Description 在一个有序数组中寻找一个数是否存在
 * @Date 2021/2/24 22:32
 */
public class Code04_BSExist {

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,4,5};
        int num = 5;
        boolean exist = exist(arr, num);
        System.out.println(exist);
    }

    private static boolean exist(int[] arr, int num) {

        if (arr == null || arr.length == 0){
            return false;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l < r){
            mid = l + ((r - l)/2);
            if (arr[mid] == num){
                return true;
            }else if(arr[mid] > num){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        return arr[l] == num;
    }
}
