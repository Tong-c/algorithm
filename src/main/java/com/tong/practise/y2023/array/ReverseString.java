package com.tong.practise.y2023.array;

public class ReverseString {

    public void reverseString(char[] s) {
        if (null == s || s.length == 0) {
            return;
        }
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;

            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] s = {'h', 'e'};
        reverseString.reverseString(s);
        System.out.println(s);
    }
}
