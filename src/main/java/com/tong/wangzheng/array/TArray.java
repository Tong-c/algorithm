package com.tong.wangzheng.array;

/**
 * 支持自动扩容的数组
 */
public class TArray {

    private int[] data;
    /**
     * 数组实际元素个数
     */
    private int size;

    public TArray(int length) {
        this.data = new int[length];
    }

    public TArray() {
        this.data = new int[10];
    }

    /**
     * 添加元素
     *
     * @param data
     */
    public void put(int data) {
        if (this.data.length == size) {
            resize();
        }

        this.data[size] = data;
        size++;
    }

    /**
     * 扩容方法
     */
    private void resize() {
        int[] tempData = new int[data.length + data.length / 2];
        for (int i = 0; i < data.length; i++) {
            tempData[i] = data[i];
        }
        this.data = tempData;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 获取数组当前元素个数
     *
     * @return
     */
    public int count() {
        return this.size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.length == 0;
    }

    /**
     * 修改指定index位置的元素
     */
    public void set(int index, int data) {
        checkIndex(index);
        this.data[index] = data;
    }


    /**
     * 获取index位置的元素
     *
     * @param index
     */
    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    /**
     * 查看数组是否包含元素
     *
     * @param data
     * @return
     */
    public boolean contains(int data) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == data) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素的位置
     *
     * @return
     */
    public int find(int data) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == data) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在指定位置插入元素
     */
    public void add(int index, int data) {
        checkIndex(index);

        if (this.data.length == size) {
            resize();
        }

        for (int i = index; i < size; i++) {
            this.data[i + 1] = this.data[i];
        }

        this.data[index] = data;
        size++;
    }

    /**
     * 在数组头部插入元素
     */
    public void addFirst(int data) {
        add(0, data);
    }

    /**
     * 在数组尾部插入元素
     */
    public void addLast(int data) {
        add(size, data);
    }

    /**
     * 删除指定位置的元素
     *
     * @return
     */
    public int remove(int index) {
        checkIndex(index);
        int removeData = this.data[index];
        for (int i = index + 1; i < size; i++) {
            this.data[i] = this.data[i + 1];
        }

        size--;
        return removeData;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除末尾元素
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }


    /**
     * 检验索引合法性
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index > this.data.length) {
            throw new RuntimeException("索引非法");
        }
    }

}
