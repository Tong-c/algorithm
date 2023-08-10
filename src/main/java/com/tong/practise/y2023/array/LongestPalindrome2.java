package com.tong.practise.y2023.array;

public class LongestPalindrome2 {

    public String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        String res = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String res1 = palindrome1(s, i);
            String res2 = palindrome2(s, i);

            if (res.length() < res1.length()) {
                res = res1;
            }

            if (res.length() < res2.length()) {
                res = res2;
            }
        }
        return res;
    }

    private String palindrome2(String s, int i) {
        int l = i;
        int r = i + 1;
        if (i == s.length() - 1 || s.charAt(l) != s.charAt(r)) {
            return "";
        }
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return s.substring(l + 1, r);
    }

    private String palindrome1(String s, int i) {
        int l = i;
        int r = i;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        LongestPalindrome2 longestPalindrome = new LongestPalindrome2();
        String s = "babad";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }
}
