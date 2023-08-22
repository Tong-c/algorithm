package com.tong.practise.y2023.matrix;

public class GenerateMatrix_59 {

    public int[][] generateMatrix(int n) {
        int num = 1;

        int startCol = 0;
        int endCol = n - 1;
        int startRow = 0;
        int endRow = n - 1;

        int[][] result = new int[n][n];

        while (num <= n * n) {
            for (int i = startCol; i <= endCol; i++) {
                result[startRow][i] = num;
                num++;
            }

            for (int i = startRow + 1; i <= endRow; i++) {
                result[i][endCol] = num;
                num++;
            }

            if (startCol == endCol || startRow == endRow) {
                break;
            }

            for (int i = endCol - 1; i >= startCol; i--) {
                result[endRow][i] = num;
                num++;
            }

            for (int i = endRow - 1; i > startRow; i--) {
                result[i][startCol] = num;
                num++;
            }

            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateMatrix_59 generateMatrix_59 = new GenerateMatrix_59();
        int[][] result = generateMatrix_59.generateMatrix(9);
        System.out.println(result);
        // 1, 2, 3
        // 8, 9, 4
        // 7, 6, 5
    }
}
