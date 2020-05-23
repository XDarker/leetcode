package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2020/5/13 23:09
 */
public class T0001_twoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));

    }

    /**
     * 暴力循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+ 1; j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        if (nums == null || nums.length < 2) {
            return res;
        }
        for(int i = 0; i < nums.length; i++){
            map.put(target - nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            Integer k = map.get(nums[i]);
           if (k != null && k != i){
               res[0] = i;
               res[1] = k;
               return res;
           }
        }
        return res;
    }

    /**利用map
     * 遍历数组 用两数之和 减去 元素 得到的 差值 查询是否在map中，
     * 不在就将其加入，key是 差值 value是 元素下标，依次循环找出
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        if (nums == null || nums.length < 2) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            // 存储差值为key,下标为value(题目要求从1开始故＋1)
            map.put(target - nums[i], i);
        }

        return res;
    }
}
