package NewCoder.class01;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/2/24 21:12
 */
public class Code07_EvenTimeOddTimes {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 5, 3, 1};
        printOddTimesNums2(arr);


    }

    /**
     * 找出一个数组中出现奇数次的数
     * @param arr
     */
    private static void printOddTimesNums1(int[] arr) {

        int eor = 0;
        for (int cur : arr) {
            eor = eor ^ cur;
        }
        System.out.println("奇数次的那个数:" + eor);

    }

    /**
     * 找出一个数组中两个数出现了奇数次，找出出现奇数次的这两个数
     * @param arr
     */
    private static void printOddTimesNums2(int[] arr) {

        int eor = 0;
        for (int curNum : arr) {
            eor = eor ^ curNum;
        }
        // eor = a ^ b;
        // eor != 0;
        // eor 拆成二进制 必然有一个位置上是1
        int rightOne = eor & (~eor + 1);  //提取出最右的1


        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & rightOne) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println("奇数次的那两个数:" + onlyOne + " " + (eor ^ onlyOne));

    }

}
