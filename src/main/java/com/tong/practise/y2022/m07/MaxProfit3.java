package com.tong.practise.y2022.m07;

public class MaxProfit3 {

    public int maxProfit(int[] prices) {
        if (null == prices) {
            return 0;
        }
        boolean buyFlag = false;
        int maxProfit = 0;
        int buyPrice = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                if (buyFlag) {
                    int currProfit = prices[i] - buyPrice;
                    maxProfit = maxProfit + currProfit;
                }
                buyPrice = prices[i];
                buyFlag = true;
            } else if (prices[i] >= prices[i + 1] && buyPrice != -1) {
                int currProfit = prices[i] - buyPrice;
                maxProfit = maxProfit + currProfit;
                buyFlag = false;
                buyPrice = -1;
            }
        }

        if (prices.length > 1) {
            if (prices[prices.length - 2] < prices[prices.length - 1]) {
                maxProfit = maxProfit + (prices[prices.length - 1] - prices[prices.length - 2]);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9};
        MaxProfit3 maxProfit3 = new MaxProfit3();
        System.out.println(maxProfit3.maxProfit(prices));
    }
}
