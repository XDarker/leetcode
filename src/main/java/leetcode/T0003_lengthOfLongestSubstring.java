package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Created by XDarker
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Date 2020/5/23 23:28
 */
public class T0003_lengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbbdefghh";

        int res = lengthOfLongestSubstring2(s);

        System.out.println(res);
    }


    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.length();
        }

        List<String> list = new ArrayList<>();
        String[] str = s.split("");
        int max = 1;
        for (int i = 0; i < str.length; i++) {

            String val = str[i];
            int index = list.indexOf(val);
            if (index > -1) {
                list = list.subList(index + 1, list.size());
            }
            list.add(val);
            if (max < list.size()) {
                max = list.size();
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.length();
        }

        int[] hash = new int[256];
        int begin = 0;
        int end = 0;
        int repeat = 0;
        int res = 0;

        while (end < s.length()) {
            if (hash[s.charAt(end)] > 0) {
                //遇到一个重复的字符
                repeat++;
            } else {
                //如果没有重复的将其加入
                hash[s.charAt(end)]++;
                end++;
            }

            while (repeat > 0) {
                if (hash[s.charAt(begin)] > 0) {
                    repeat--;
                    hash[s.charAt(begin)]--;
                    begin++;
                }
            }
            res = Math.max(res, end - begin);

        }
        return res;

    }

    /**
     * hashmap
     * 每次找到一个重复的， 替换起始位置begin
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {

        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring4(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.length();
        }
        int res = 0;
        int begin = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(begin));
                begin++;
            } else {
                set.add(s.charAt(i));
                i++;
                res = Math.max(res, set.size());
            }
        }

        return res;
    }
}
