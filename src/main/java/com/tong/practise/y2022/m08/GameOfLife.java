package com.tong.practise.y2022.m08;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int rowLength = board.length;
        int columnLength = board[0].length;
        int[][] newBoard = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                int currNum = board[i][j];

                int topRowIndex = i - 1;
                int belowRowIndex = i + 1;
                int leftColumnIndex = j - 1;
                int rightColumnIndex = j + 1;

                int liveNum = 0;

                int topLeft = 0;
                int topCenter = 0;
                int topRight = 0;
                if (topRowIndex >= 0) {

                    if (leftColumnIndex >= 0) {
                        topLeft = board[topRowIndex][leftColumnIndex];
                        if (topLeft > 0) {
                            liveNum++;
                        }
                    }

                    topCenter = board[topRowIndex][j];
                    if (topCenter > 0) {
                        liveNum++;
                    }

                    if (rightColumnIndex < columnLength) {
                        topRight = board[topRowIndex][rightColumnIndex];
                        if (topRight > 0) {
                            liveNum++;
                        }
                    }
                }

                int centerLeft = 0;
                int centerRight = 0;
                if (leftColumnIndex >= 0) {
                    centerLeft = board[i][leftColumnIndex];
                    if (centerLeft > 0) {
                        liveNum++;
                    }
                }

                if (rightColumnIndex < columnLength) {
                    centerRight = board[i][rightColumnIndex];
                    if (centerRight > 0) {
                        liveNum++;
                    }
                }

                int belowLeft = 0;
                int belowCenter = 0;
                int belowRight = 0;
                if (belowRowIndex < rowLength) {
                    if (leftColumnIndex >= 0) {
                        belowLeft = board[belowRowIndex][leftColumnIndex];
                        if (belowLeft > 0) {
                            liveNum++;
                        }
                    }
                    belowCenter = board[belowRowIndex][j];
                    if (belowCenter > 0) {
                        liveNum++;
                    }

                    if (rightColumnIndex < columnLength) {
                        belowRight = board[belowRowIndex][rightColumnIndex];
                        if (belowRight > 0) {
                            liveNum++;
                        }
                    }
                }

                if (liveNum < 2 && currNum == 1) {
                    newBoard[i][j] = 0;
                }
                if ((liveNum == 2 || liveNum == 3) && currNum == 1) {
                    newBoard[i][j] = 1;
                }
                if (liveNum > 3) {
                    newBoard[i][j] = 0;
                }
                if (liveNum == 3 && currNum == 0) {
                    newBoard[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife tester = new GameOfLife();
        int[][] nums = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        tester.gameOfLife(nums);
        System.out.println();
    }
}
