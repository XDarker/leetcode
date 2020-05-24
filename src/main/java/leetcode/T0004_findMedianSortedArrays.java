package leetcode;

import java.util.Arrays;

/**
 * @Created by XDarker
 * @Description 寻找两个正序数组的中位数
 * @Date 2020/5/24 14:08
 */
public class T0004_findMedianSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2,3,4,5,6};

        double res = findMedianSortedArrays2(nums1, nums2);
        System.out.println(res);

    }

    /**
     * 新建一个数组，len1 + len2) / 2 + 1， 我们只用到中位数之前的数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length < 1) {
            int len2 = nums2.length;
            if (len2 % 2 == 0) {
                return (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2.0;
            }
            return nums2[(len2) / 2];
        }
        if (nums2 == null || nums2.length < 1) {
            int len1 = nums1.length;
            if (len1 % 2 == 0) {
                return (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2.0;
            }
            return nums1[(len1) / 2];
        }
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[(len1 + len2) / 2 + 1];
        int l1 = 0;
        int l2 = 0;
        int max1 = nums1[0];
        int max2 = nums2[0];

        int i = 0;
        while (i < (len1 + len2) / 2 + 1 && (l1 < len1 || l2 < len2)) {
            if (l1 < len1) {
                max1 = nums1[l1];
            }
            if (l2 < len2) {
                max2 = nums2[l2];
            }
            if (max1 < max2) {
                res[i] = max1;
                l1++;
            } else {
                res[i] = max2;
                l2++;
            }
            i++;
            max1 = max2 = Integer.MAX_VALUE;
        }
        System.out.println(Arrays.toString(res));

        int index = i - 1;
        System.out.println("index:" + index);
        if ((len1 + len2) % 2 == 0) {
            return (res[index] + res[index - 1]) / 2.0;
        }
        return res[index];

    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int sum = len1 + len2;
        //确定长度之和是奇数还是偶数
        if (sum % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, sum / 2) + findKth(nums1, 0, nums2, 0, sum / 2 + 1)) / 2.0;
        }
        return findKth(nums1, 0, nums2, 0, (sum + 1) / 2);


    }

    private static int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {

        if (left1 >= nums1.length) {
            return nums2[left2 + k - 1];
        }
        if (left2 >= nums2.length) {
            return nums1[left1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        //判断index 能不能用
        int mid1 = left1 + k / 2 - 1;
        int midPart1 = Integer.MAX_VALUE;
        if (mid1 < nums1.length) {
            midPart1 = nums1[mid1];
        }
        int mid2 = left2 + k / 2 - 1;
        int midPart2 = Integer.MAX_VALUE;
        if (mid2 < nums2.length) {
            midPart2 = nums2[mid2];
        }
        if (midPart1 <= midPart2) {
            return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
        }
        return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);


    }


}
