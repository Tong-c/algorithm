package com.tong.sedgewick.chapterOne.s03.p88;

import java.util.Iterator;

/**
 * 下压栈-能够动态调整数组大小的实现
 */
public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] a = (T[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 调整数组大小，新建临时数组，复制数据
     * @param max
     */
    public void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
