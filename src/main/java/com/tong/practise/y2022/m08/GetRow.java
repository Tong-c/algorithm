package com.tong.practise.y2022.m08;

import java.util.ArrayList;
import java.util.List;

public class GetRow {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }

        List<Integer> lastRow = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> currRow = new ArrayList<>();
            if (i == 0) {
                currRow.add(1);
            } else {
                for (int j = 0; j <= i; j++) {
                    int num1 = 0;
                    if (j > 0) {
                        num1 = lastRow.get(j - 1);
                    }
                    int num2 = 0;
                    if (j <= lastRow.size() - 1) {
                        num2 = lastRow.get(j);
                    }
                    currRow.add(num1 + num2);
                }
            }
            if (i == rowIndex) {
                return currRow;
            }
            lastRow = currRow;
        }

        return result;
    }

    public static void main(String[] args) {
        GetRow tester = new GetRow();
        int numRows = 3;
        System.out.println(tester.getRow(numRows));

        // 1
        // 1 1
        // 1 2 1
        // 1 3 3 1
        // 1 4 6 4 1
    }
}
