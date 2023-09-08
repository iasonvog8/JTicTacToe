package com.tictactoe.board;

import com.tictactoe.piece.Alliance;

import java.util.Arrays;
import java.util.Objects;

import static com.tictactoe.board.Tile.*;

public class TableBase {
    public static boolean isEndGameTableBase(Tile[] board) {
        return isDrawGameTableBase(board) || isThereWinner(board, Alliance.X) || isThereWinner(board, Alliance.O);
    }

    public static boolean isDrawGameTableBase(Tile[] board) {
        return !isMovesLeft(board) && !isThereWinner(board, Alliance.X) && !isThereWinner(board, Alliance.O);
    }

    public static boolean isMovesLeft(Tile[] board) {
        for (int tile = 0; tile < 9; tile++) {

            if (board[tile] instanceof EmptyTile)
                return true;
        }

        return false;
    }

    public static boolean isThereWinner(Tile[] board, Alliance alliance) {
        // first column
        if (Arrays.stream(BoardUtils.getColumn(board, 0)).allMatch(t -> Objects.equals(t, alliance)))
            return true;

        // second column
        if (Arrays.stream(BoardUtils.getColumn(board, 1)).allMatch(t -> Objects.equals(t, alliance)))
            return true;

        // third column
        if (Arrays.stream(BoardUtils.getColumn(board, 2)).allMatch(t -> Objects.equals(t, alliance)))
            return true;

        // first row
        if (Arrays.stream(BoardUtils.getRow(board, 0)).allMatch(t -> Objects.equals(t, alliance)))
            return true;

        // second row
        if (Arrays.stream(BoardUtils.getRow(board, 1)).allMatch(t -> Objects.equals(t, alliance)))
            return true;

        // third row
        if (Arrays.stream(BoardUtils.getRow(board, 2)).allMatch(t -> Objects.equals(t, alliance)))
            return true;

        // diagonal right
        if (Arrays.stream(BoardUtils.getDiagonal(board, 0)).allMatch(t -> Objects.equals(t, alliance)))
            return true;

        // diagonal left
        return Arrays.stream(BoardUtils.getDiagonal(board, 2)).allMatch(t -> Objects.equals(t, alliance));
    }
}
