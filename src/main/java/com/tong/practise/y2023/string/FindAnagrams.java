package com.tong.practise.y2023.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

    public List<String> findAnagrams(String s, String p) {
        List<String> result = new ArrayList<>();

        Map<Character, Integer> ori = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            ori.put(p.charAt(i), ori.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int r = 0;
        int valid = 0;

        while (r < s.length()) {
            char sChar = s.charAt(r);
            r++;
            if (ori.containsKey(sChar)) {
                window.put(sChar, window.getOrDefault(sChar, 0) + 1);
                if (ori.get(sChar).equals(window.get(sChar))) {
                    valid++;
                }
            }

            while (valid == ori.size()) {
                if (r - l == p.length()) {
                    result.add(l + "");
                }

                char c = s.charAt(l);
                l++;

                if (ori.containsKey(c)) {
                    if (window.get(c).equals(ori.get(c))) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        // 0, 6
        List<String> result = findAnagrams.findAnagrams(s, p);
        System.out.println(result);
    }
}
