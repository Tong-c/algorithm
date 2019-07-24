package com.tong.wangzheng.array;

/**
 * 实现两个有序数组合并为一个有序数组
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 3, 4, 6, 8};

        int[] c = new int[a.length + b.length];
        int size = 0;

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
            size++;
        }

        int k;

        i:
        for (int j = 0; j < b.length; j++) {
            ii:
            for (k = 0; k < size; k++) {
                if (b[j] <= c[k]) {
                    iii:
                    for (int m = size - 1; m >= k; m--) {
                        c[m + 1] = c[m];
                    }
                    c[k] = b[j];
                    size++;
                    break ii;
                }
            }

            if (k == size) {
                c[size] = b[j];
                size++;
            }
        }

        System.out.println(c);//用了时间复杂度最高的方法，可歌可泣

    }


}
