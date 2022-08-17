package com.tong.practise.y2022.m08;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            if (i == 0) {
                currRow.add(1);
            } else {
                List<Integer> lastRow = result.get(i - 1);
                for (int j = 0; j <= i; j++) {
                    int num1 = 0;
                    if (j - 1 >= 0) {
                        num1 = lastRow.get(j - 1);
                    }
                    int num2 = 0;
                    if (j <= lastRow.size() - 1) {
                        num2 = lastRow.get(j);
                    }
                    currRow.add(num1 + num2);
                }
            }
            result.add(currRow);
        }
        return result;
    }

    public static void main(String[] args) {
        Generate tester = new Generate();
        int numRows = 10;
        System.out.println(tester.generate(numRows));

        // 1
        // 1 1
        // 1 2 1
        // 1 3 3 1
        // 1 4 6 4 1
    }
}
