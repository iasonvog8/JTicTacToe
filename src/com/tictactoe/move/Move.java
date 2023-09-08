package com.tictactoe.move;

import com.tictactoe.piece.Piece;

public class Move {
    private final int coordinate;
    private final Piece piece;

    public Move(final int coordinate, final Piece piece) {
        this.coordinate = coordinate;
        this.piece = piece;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }
}
