package com.dawidg90.sudoku.load;

/**
 * Specify the way of loading sudoku board.
 */
public interface SudokuLoader {
    /**
     * Loads the sudoku board.
     */
    int[][] load();
}
