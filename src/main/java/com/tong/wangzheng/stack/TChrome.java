package com.tong.wangzheng.stack;

/**
 * 使用栈结构模拟浏览器前进后退
 */
public class TChrome {

    private ArrayStack s1;
    private ArrayStack s2;

    public TChrome() {
        s1 = new ArrayStack();
        s2 = new ArrayStack();
    }

    /**
     * 前进
     */
    public void forward(int item) {
        while (s2.pop() != -1) {
            s2.pop();
        }
        s1.push(item);
    }

    /**
     * 后退
     */
    public int backward() {
        int item = s1.pop();
        s2.push(item);
        return item;
    }


    public static void main(String[] args) {
        TChrome chrome = new TChrome();
        chrome.forward(1);
        chrome.forward(2);
        System.out.println(chrome.backward());
        chrome.forward(3);
        System.out.println(chrome.backward());
        System.out.println(chrome.backward());
    }

}
