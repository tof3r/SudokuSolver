package com.dawidg90.sudoku.display;

/**
 * Specify the way of displaying sudoku board.
 */
public interface SudokuDisplay {
    /**
     * Displays the board.
     *
     * @param board the board to display
     */
    void display(int[][] board);
}
