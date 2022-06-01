package com.dawidg90.sudoku;

import com.dawidg90.sudoku.display.ConsoleDisplay;
import com.dawidg90.sudoku.display.SudokuDisplay;
import com.dawidg90.sudoku.load.SudokuLoader;
import com.dawidg90.sudoku.load.TextFileLoader;
import com.dawidg90.sudoku.resolve.SudokuResolver;

public class SudokuSolver {

    public static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        final SudokuLoader sudokuLoader = new TextFileLoader("board1.txt");
        int[][] board = sudokuLoader.load();

        System.out.println("Sudoku to solve: ");
        final SudokuDisplay sudokuDisplay = new ConsoleDisplay();
        sudokuDisplay.display(board);

        final SudokuResolver resolver = new SudokuResolver();
        resolver.resolve(board);

        System.out.println("Resolved sudoku:");
        sudokuDisplay.display(board);
    }
}
