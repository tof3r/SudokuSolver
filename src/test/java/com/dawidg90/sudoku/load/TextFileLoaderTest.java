package com.dawidg90.sudoku.load;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Loads board from file.")
class TextFileLoaderTest {

    @DisplayName("Loads from file, ok expected.")
    @Test
    void loadBoard() {
        int[] firstRow = {8, 0, 0, 0, 0, 7, 3, 0, 0};
        int[] secondRow = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] thirdRow = {4, 0, 0, 5, 0, 0, 0, 0, 1};
        int[] fourthRow = {0, 0, 0, 0, 0, 2, 0, 0, 6};
        int[] fifthRow = {1, 0, 0, 0, 0, 3, 0, 0, 8};
        int[] sixthRow = {6, 8, 0, 0, 7, 0, 0, 0, 5};
        int[] seventhRow = {7, 0, 0, 0, 0, 4, 9, 0, 0};
        int[] eighthRow = {0, 2, 6, 0, 0, 0, 0, 0, 0};
        int[] ninthRow = {0, 0, 4, 0, 2, 0, 1, 0, 0};

        SudokuLoader loader = new TextFileLoader("board1.txt");
        int[][] loadedArray = loader.load();

        assertArrayEquals(firstRow, loadedArray[0]);
        assertArrayEquals(secondRow, loadedArray[1]);
        assertArrayEquals(thirdRow, loadedArray[2]);
        assertArrayEquals(fourthRow, loadedArray[3]);
        assertArrayEquals(fifthRow, loadedArray[4]);
        assertArrayEquals(sixthRow, loadedArray[5]);
        assertArrayEquals(seventhRow, loadedArray[6]);
        assertArrayEquals(eighthRow, loadedArray[7]);
        assertArrayEquals(ninthRow, loadedArray[8]);
    }

    @DisplayName("Loads from file, error expected due to wrong board format.")
    @Test()
    void loadBoardWrongFormat() {
        SudokuLoader loader = new TextFileLoader("board_wrong_format.txt");

        Assertions.assertThrows(RuntimeException.class, loader::load);
    }

    @DisplayName("Loads from file, error expected due to file does not exists.")
    @Test
    void loadBoardFileNotExists() {
        SudokuLoader loader = new TextFileLoader("abc.txt");

        Assertions.assertThrows(NullPointerException.class, loader::load);
    }
}