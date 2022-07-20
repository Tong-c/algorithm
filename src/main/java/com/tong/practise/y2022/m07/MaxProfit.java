package com.tong.practise.y2022.m07;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (null == prices) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int currProfit = prices[j] - prices[i];
                    if (currProfit > maxProfit) {
                        maxProfit = currProfit;
                    }
                }
            }
        }

        return maxProfit;
    }
}
