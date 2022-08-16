package com.tong.practise.y2022.m08;

public class MinPathSum2 {

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j > 0) {
                    grid[0][j] = grid[0][j - 1] + grid[0][j];
                } else if (i > 0 && j == 0) {
                    grid[i][0] = grid[i - 1][0] + grid[i][0];
                } else if (i > 0 && j > 0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MinPathSum2 tester = new MinPathSum2();
        // 1, 2, 3
        // 3, 2, 1
        // 3, 4, 5
        int[][] grid = {{1, 2, 3}, {3, 2, 1}, {3, 4, 5}};
        System.out.println(tester.minPathSum(grid));
    }
}
