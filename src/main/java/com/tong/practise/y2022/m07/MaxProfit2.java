package com.tong.practise.y2022.m07;

public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        if (null == prices) {
            return 0;
        }
        int maxProfit = 0;
        int lowestPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];

            if (currPrice > prices[i - 1]) {
               int currMaxProfit = currPrice - lowestPrice;
                if (currMaxProfit > maxProfit) {
                    maxProfit = currMaxProfit;
                }
            }

            if (currPrice < lowestPrice) {
                lowestPrice = currPrice;
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        MaxProfit2 maxProfit2 = new MaxProfit2();
        System.out.println(maxProfit2.maxProfit(prices));
    }
}
