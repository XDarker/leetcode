package leetcode;

/**
 * @Created by XDarker
 * @Description 最长回文子串
 * @Date 2020/5/25 21:56
 */
public class T0005_longestPalindrome {

    public static void main(String[] args) {

        String s = "babad";
        String res = longestPalindrome(s);
        System.out.println(res);

    }

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validatePalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private static boolean validatePalindrome(char[] charArray, int left, int right) {

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
