//package Algorithm;
//
//import java.util.LinkedList;
//
///**
// * @Created by XDarker
// * @Description TODO
// * @Date 2020/12/10 16:34
// */
//public class T0009_getNumArr {
//
//    public static void main(String[] args) {
//
//        int[] arr = {2, 4, 5, 6};
//        int num = 1;
//        int result = rfeddgetNum(arr, num);
//        System.out.println(result);
//
//
//    }
//
//    private static int getNum(int[] arr, int num) {
//        if (arr == null || arr.length == 0 || num < 0) {
//            return 0;
//        }
//        LinkedList<Integer> qmax = new LinkedList<>();
//        LinkedList<Integer> qmin = new LinkedList<>();
//        int i = 0;
//        int j = 0;
//        int res = 0;
//        while (i < arr.length) {
//            while (j < arr.length) {
//                if (qmin.isEmpty() || qmin.peekLast() != j) {
//                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
//                        qmin.pollLast();
//                    }
//                    qmin.addLast(j);
//
//                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
//                        qmax.pollLast();
//                    }
//                    qmax.addLast(j);
//                }
//                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
//                    break;
//                }
//                j++;
//            }
//            res += j - i;
//            if (qmin.peekFirst() == i) {
//                qmin.pollFirst();
//            }
//            if (qmax.peekFirst() == i) {
//                qmax.pollFirst();
//            }
//            i++;
//        }
//
//        return res;
//
//    }
//}
