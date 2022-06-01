package com.dawidg90.sudoku.display;

import com.dawidg90.sudoku.SudokuSolver;

public class ConsoleDisplay implements SudokuDisplay {

    @Override
    public void display(int[][] board) {
        System.out.println();
        for (int row = 0; row < SudokuSolver.GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < SudokuSolver.GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                if (board[row][column] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(board[row][column]);
                }
            }
            System.out.println();
        }
    }
}
