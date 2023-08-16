package com.tong.practise.y2023.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }

            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }

            for (int i = endCol; i >= startCol; i--) {
                result.add(matrix[endRow][i]);
            }

            for (int i = endRow; i > startRow; i--) {
                result.add(matrix[i][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralOrder_54 spiralOrder = new SpiralOrder_54();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = spiralOrder.spiralOrder(matrix);
        System.out.println(result);
    }
}
