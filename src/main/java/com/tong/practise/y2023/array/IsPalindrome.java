package com.tong.practise.y2023.array;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }

        s = s.toLowerCase();

        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return false;
        }

        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(chars[l])) {
                l++;
                continue;
            }

            if (!Character.isLetterOrDigit(chars[r])) {
                r--;
                continue;
            }

            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        String s = " ";
        System.out.println(isPalindrome.isPalindrome(s));
    }
}
