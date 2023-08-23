package com.tong.practise.y2023.string;

import java.util.HashMap;
import java.util.Map;

public class MinWindow2_76 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> ori = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int l = 0;
        int r = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char sChar = s.charAt(r);
            r++;

            if (ori.containsKey(sChar)) {
                window.put(sChar, window.getOrDefault(sChar, 0) + 1);
                if (window.get(sChar).equals(ori.get(sChar))) {
                    valid++;
                }
            }

            while (valid == ori.size()) {
                if (r - l < len) {
                    len = r - l;
                    start = l;
                }

                char d = s.charAt(l);
                l++;
                if (ori.containsKey(d)) {
                    if (ori.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len < Integer.MAX_VALUE ? s.substring(start, start + len) : "";
    }

    public static void main(String[] args) {
        MinWindow2_76 minWindow_76 = new MinWindow2_76();
        String s = "ACBDOBECODEBANC";
        String t = "AABC";
        // BANC
        String result = minWindow_76.minWindow(s, t);
        System.out.println(result);
    }
}
