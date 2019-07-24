package com.tong.wangzheng.array;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 */
public class TFixedArray {
    private int[] data;
    /**
     * 数组实际元素的个数
     */
    private int size;

    public TFixedArray(int length) {
        data = new int[length];
    }

    public TFixedArray() {
        data = new int[10];
    }

    /**
     * 数组添加元素，保证有序
     */
    public void put(int data) {
        if (this.data.length == size) {
            throw new RuntimeException("数组无空间");
        }

        for (int i = 0; i < size; i++) {
            if (data <= this.data[i]) {
                for (int j = size; j > i; j--) {
                    this.data[j] = this.data[j - 1];
                }
                this.data[i] = data;
                size++;
                return;
            }
        }

        this.data[size] = data;
        size++;
    }

    /**
     * 删除元素
     *
     * @return
     */
    public int remove(int data) {
        for (int i = 0; i < size; i++) {
            if (data == this.data[i]) {
                for (int j = i; j < size; j++) {
                    this.data[j] = this.data[j + 1];
                    size--;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        TFixedArray array = new TFixedArray();
        array.put(3);
        array.put(2);
        array.put(1);
        array.put(8);
        System.out.println(array);
    }
}
