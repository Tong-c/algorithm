package com.tong.practise.y2023.array;

import java.util.Arrays;

public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        int[] diffs = new int[n];

        for (int[] booking : bookings) {
            int i = booking[0];
            int j = booking[1];
            int val = booking[2];

            diffs[i - 1] = diffs[i - 1] + val;
            if (j < n) {
                diffs[j] = diffs[j] - val;
            }
        }

        int[] res = new int[n];
        res[0] = diffs[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diffs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        CorpFlightBookings corpFlightBookings = new CorpFlightBookings();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] result = corpFlightBookings.corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(result));
    }

}
