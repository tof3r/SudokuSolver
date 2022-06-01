package com.dawidg90.sudoku.resolve;

import com.dawidg90.sudoku.SudokuSolver;

public class SudokuResolver {

    public boolean resolve(int[][] board) {
        for (int row = 0; row < SudokuSolver.GRID_SIZE; row++) {
            for (int column = 0; column < SudokuSolver.GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToPut = 1; numberToPut <= SudokuSolver.GRID_SIZE; numberToPut++) {
                        if (isValidPlaceToPutNumber(board, row, column, numberToPut)) {
                            board[row][column] = numberToPut;

                            if (resolve(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean existsInRow(int[][] board, int row, int numberToCheck) {
        for (int i = 0; i < SudokuSolver.GRID_SIZE; i++) {
            if (board[row][i] == numberToCheck) {
                return true;
            }
        }
        return false;
    }

    private boolean existsInColumn(int[][] board, int column, int numberToCheck) {
        for (int i = 0; i < SudokuSolver.GRID_SIZE; i++) {
            if (board[i][column] == numberToCheck) {
                return true;
            }
        }
        return false;
    }

    private boolean existsInMiniBox(int[][] board, int row, int column, int numberToCheck) {
        int localRow = row - row % 3;
        int localColumn = column - column % 3;

        for (int rowInBox = localRow; rowInBox < localRow + 3; rowInBox++) {
            for (int columnInBox = localColumn; columnInBox < localColumn + 3; columnInBox++) {
                if (board[rowInBox][columnInBox] == numberToCheck) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPlaceToPutNumber(int[][] board, int row, int column, int numberToCheck) {
        return !existsInRow(board, row, numberToCheck) && !existsInColumn(board, column, numberToCheck)
                && !existsInMiniBox(board, row, column, numberToCheck);
    }
}
