package com.tong.lafore.chapterEleven.hashTableInChain;

public class HashTable {

    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int size){
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for(int j = 0;j < arraySize;j++){
            hashArray[j] = new SortedList();
        }
    }

    public void displayTable(){
        for(int j = 0;j < arraySize;j++){
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hasFunc(int key){
        return key % arraySize;
    }

    public void insert(Link theLink){
        int key = theLink.getKey();
        int hashVal = hasFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key){
        int hashVal = hasFunc(key);
        hashArray[hashVal].delete(key);

    }

    public Link find(int key){
        int hashVal = hasFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }




}
