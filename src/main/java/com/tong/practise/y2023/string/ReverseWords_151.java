package com.tong.practise.y2023.string;

public class ReverseWords_151 {

    public String reverseWords(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }

        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            l++;
            r--;
        }

        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sBuilder.append(chars[i]);
        }

        String[] words = sBuilder.toString().split(" ");
        sBuilder = new StringBuilder();
        for (String word : words) {
            if (word.length() < 1) {
                continue;
            }
            char[] wordChars = word.toCharArray();
            int wordL = 0;
            int wordR = wordChars.length - 1;
            while (wordL < wordR) {
                char temp = wordChars[wordL];
                wordChars[wordL] = wordChars[wordR];
                wordChars[wordR] = temp;

                wordL++;
                wordR--;
            }

            StringBuilder wordBuilder = new StringBuilder();
            for (int i = 0; i < wordChars.length; i++) {
                wordBuilder.append(wordChars[i]);
            }
            sBuilder.append(wordBuilder);
            sBuilder.append(" ");
        }

        return sBuilder.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords_151 reverseWords = new ReverseWords_151();
        String s = "a good   example";
        System.out.println(reverseWords.reverseWords(s));
    }
}
