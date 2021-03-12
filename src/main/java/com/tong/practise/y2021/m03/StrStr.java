package com.tong.practise.y2021.m03;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从 0 开始)。如果不存在，则返回  -1
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("", "aa"));
    }

    public static int strStr(String haystack, String needle) {

        boolean isHaystackEmpty = null == haystack || "".equals(haystack);
        boolean isNeedleEmpty = null == needle || "".equals(needle);

        if (isHaystackEmpty && isNeedleEmpty) {
            return 0;
        }

        if (isHaystackEmpty) {
            return -1;
        }

        if (isNeedleEmpty) {
            return 0;
        }

        char[] chars = haystack.toCharArray();
        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if (needleLength > haystackLength) {
            return -1;
        }

        for (int i = 0; i < chars.length; i++) {
            if (haystackLength - i < needleLength) {
                return -1;
            }

            String toMatchChar = "";
            for (int j = 0; j < needleLength; j++) {
                toMatchChar = toMatchChar + chars[i + j];
            }
            if (toMatchChar.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
