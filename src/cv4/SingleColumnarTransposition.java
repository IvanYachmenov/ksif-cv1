package cv4;

import cv3.PermutationFromPhrase;
import java.util.ArrayList;
import java.util.List;


public class SingleColumnarTransposition {
    public Integer[] key;

    public SingleColumnarTransposition(Integer[] key){
        this.key = key;
    }

    public SingleColumnarTransposition(String key){
        this.key = PermutationFromPhrase.permutationFromPhrase(key);
    }

    public String encrypt(String plainText) {
        int columns = key.length;
        int rows = plainText.length() / columns;
        if (plainText.length() % columns > 0) rows++;

        char[][] matrix = new char[rows][columns];

        int i = 0, j = 0;
        for (char c : plainText.toCharArray()) {
            matrix[i][j++] = c;
            if (j == columns) { j = 0; i++; }
        }

        StringBuilder out = new StringBuilder();
        for (int rank = 0; rank < columns; rank++) {
            int colIdx = key[rank];
            for (int r = 0; r < rows; r++) {
                if (matrix[r][colIdx] != '\u0000') {
                    out.append(matrix[r][colIdx]);
                }
            }
        }
        return out.toString();
    }

    public String decrypt(String cipherText) {
        int columns = key.length;
        int rows = cipherText.length() / columns;
        int nonCompleteCols = cipherText.length() % columns;
        if (nonCompleteCols > 0) rows++;

        char[][] matrix = new char[rows][columns];
        int idx = 0;

        for (int rank = 0; rank < columns; rank++) {
            int colIdx = key[rank]; // rank -> columnIndex
            int height = rows - ((nonCompleteCols > 0 && colIdx >= nonCompleteCols) ? 1 : 0);
            for (int r = 0; r < height; r++) {
                matrix[r][colIdx] = cipherText.charAt(idx++);
            }
        }

        StringBuilder out = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (matrix[r][c] != '\u0000') out.append(matrix[r][c]);
            }
        }
        return out.toString();
    }


}
