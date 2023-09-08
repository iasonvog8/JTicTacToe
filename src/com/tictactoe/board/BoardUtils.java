package com.tictactoe.board;

import com.tictactoe.piece.Alliance;
import static com.tictactoe.board.Tile.*;

public class BoardUtils {
    public static final int BOARD_SIZE = 9;
    public static Alliance[] getColumn(Tile[] board, int columnNum) {
        Alliance[] column = new Alliance[3];
        int index = 0;

        for (int tile = columnNum; tile < BOARD_SIZE; tile += 3) {
            if (board[tile] instanceof OccupiedTile) {
                column[index] = board[tile].getPiece().getAlliance();
                index++;
            }
        }

        return column;
    }

    public static Alliance[] getRow(Tile[] board, int rowNum) {
        Alliance[] row = new Alliance[3];
        int index = 0;

        for (int tile = rowNum * 3; tile < BOARD_SIZE; tile ++) {

            if (board[tile] instanceof OccupiedTile) {
                row[index] = board[tile].getPiece().getAlliance();
                index++;
            }

            if (tile % 3 == 2) break;

        }

        return row;
    }

    public static Alliance[] getDiagonal(Tile[] board, int diagonalNum) {
        Alliance[] diagonal = new Alliance[3];
        int index = 0;

        if (diagonalNum == 0) {
            for (int tile = diagonalNum; tile < BOARD_SIZE; tile += 4) {
                if (board[tile] instanceof OccupiedTile) {
                    diagonal[index] = board[tile].getPiece().getAlliance();
                    index++;
                }
            }
        }else {
            for (int tile = diagonalNum; tile < BOARD_SIZE; tile += 2) {
                if (tile == 8) break;

                if (board[tile] instanceof OccupiedTile) {
                    diagonal[index] = board[tile].getPiece().getAlliance();
                    index++;
                }
            }
        }

        return diagonal;
    }
    public static boolean isValidTile(int currentTileCoordinate) {
        return currentTileCoordinate < 9 && currentTileCoordinate >= 0;
    }
}
