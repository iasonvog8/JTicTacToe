package com.tictactoe.board;

import com.tictactoe.piece.Piece;

import static com.tictactoe.board.Tile.*;

public class Board {
    private final Tile[] board;

    public Board() {
        this.board = new Tile[BoardUtils.BOARD_SIZE];
    }

    public Tile[] getBoard() {
        return board;
    }

    public void setPiece(int tileCoordinate, Piece piece) {
        this.board[tileCoordinate] = new OccupiedTile(tileCoordinate, piece);
    }

    public void initBoard() {
        for (int tile = 0; tile < BoardUtils.BOARD_SIZE; tile++) {
            this.board[tile] = new EmptyTile(tile);
        }
    }
}
