package com.dawidg90.sudoku.load;

import com.dawidg90.sudoku.SudokuSolver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TextFileLoader implements SudokuLoader {

    private final String filePath;

    public TextFileLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int[][] load() {
        final var loadedBoard = new int[SudokuSolver.GRID_SIZE][SudokuSolver.GRID_SIZE];

        try (InputStream inputStream = getInputStreamForAFile()) {
            loadBoard(loadedBoard, inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return loadedBoard;
    }

    private InputStream getInputStreamForAFile() {
        final var classLoader = this.getClass().getClassLoader();
        return classLoader.getResourceAsStream(getFilenameWithPackage());
    }

    private String getFilenameWithPackage() {
        return getPackageNameWithSlashes() + this.filePath;
    }

    private String getPackageNameWithSlashes() {
        return this.getClass().getPackageName().replace('.', '/') + "/";
    }

    private void loadBoard(int[][] loadedBoard, InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream);
        int i = 0;
        while (scanner.hasNext()) {
            int[] oneRow = getOneRow(scanner);
            loadedBoard[i++] = oneRow;
        }
    }

    private int[] getOneRow(Scanner scanner) {
        final var nextLine = scanner.nextLine();
        final var split = nextLine.split(",[ ]?");

        if (split.length < SudokuSolver.GRID_SIZE) {
            throw new RuntimeException("Elements in array do not match. Should be 9 elements in row.");
        }

        final int[] oneRow = new int[SudokuSolver.GRID_SIZE];

        for (int i = 0; i < SudokuSolver.GRID_SIZE; i++) {
            oneRow[i] = Integer.parseInt(split[i]);
        }
        return oneRow;
    }
}
