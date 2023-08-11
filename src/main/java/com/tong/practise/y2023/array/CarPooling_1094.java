package com.tong.practise.y2023.array;

public class CarPooling_1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] diffs = new int[1001];
        int[] nums = new int[1001];

        for (int[] trip : trips) {
            int from = trip[1];
            int to = trip[2];
            int val = trip[0];

            diffs[from] = diffs[from] + val;
            if (to < 1001) {
                diffs[to] = diffs[to] - val;
            }
        }

        int num = 0;
        for (int i : diffs) {
            num += i;
            if (num > capacity) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CarPooling_1094 carPooling = new CarPooling_1094();
        int[][] trips = {{9, 0, 1}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(carPooling.carPooling(trips, capacity));
    }
}
