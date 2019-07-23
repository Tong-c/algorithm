package com.tong.lafore.chapterEleven;

import com.tong.lafore.chapterEleven.DataItem;

public class HashTable {

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.println(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }


    public int hasFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hasFunc(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hasVal = hasFunc(key);
        while (hashArray[hasVal] != null) {
            if (hashArray[hasVal].getKey() == key) {
                DataItem temp = hashArray[hasVal];
                hashArray[hasVal] = nonItem;
                return temp;
            }
            ++hasVal;
            hasVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hasFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}
