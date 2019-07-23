package com.tong;

/**
 * @Description:
 * @Author: 1972376180@qq.com
 * @Date: 2019/7/23 10:04
 */
public class SentinelTest {

    /**
     * 在数组a中，查找key, 返回key所在的位置
     *
     * @param a
     * @param n
     * @param key
     * @return
     */
    public int find(char[] a, int n, char key) {
        if (a == null || n <= 0) {
            return -1;
        }

        int i = 0;
        while (i < n) {
            if (a[i] == key) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 在数组 a 中，查找 key, 返回 key 所在的位置
     *
     * @param a
     * @param n
     * @param key
     * @return
     */
    public int findOptimize(char[] a, int n, char key) {
        if (a == null || n <= 0) {
            return -1;
        }

        if (a[n - 1] == key) {
            return n - 1;
        }

        char temp = a[n - 1];
        a[n - 1] = key;
        int i = 0;
        while (a[i] != key) {
            ++i;
        }

        a[n - 1] = temp;
        if (i == n - 1) {
            return -1;
        } else {
            return i;
        }
    }

}
