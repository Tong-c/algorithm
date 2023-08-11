package com.tong.practise.y2023.matrix;

public class Rotate {

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < row; i++) {
            int l = 0;
            int r = row - 1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;

                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate.rotate(matrix);
        System.out.println(matrix);
    }
}
