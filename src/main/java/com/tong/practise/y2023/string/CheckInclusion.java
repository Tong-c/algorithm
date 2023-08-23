package com.tong.practise.y2023.string;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> ori = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            ori.put(s1.charAt(i), ori.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int r = 0;
        int valid = 0;

        while (r < s2.length()) {
            char sChar = s2.charAt(r);
            r++;
            if (ori.containsKey(sChar)) {
                window.put(sChar, window.getOrDefault(sChar, 0) + 1);
                if (window.get(sChar).equals(ori.get(sChar))) {
                    valid++;
                }
            }

            while (valid == ori.size()) {
                if (r - l == s1.length()) {
                    return true;
                } else {
                    char c = s2.charAt(l);
                    l++;

                    if (ori.containsKey(c)) {
                        if (window.get(c).equals(ori.get(c))) {
                            valid--;
                        }
                        window.put(c, window.get(c) - 1);
                    }
                }
            }
        }

        if (r - l == s1.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        String s1 = "ea";
        String s2 = "eldbeaooo";
        boolean result = checkInclusion.checkInclusion(s1, s2);
        System.out.println(result);
    }
}
