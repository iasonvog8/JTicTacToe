package com.tictactoe.piece;

public class Piece {
    private final Alliance alliance;

    public Piece(final Alliance alliance) {
        this.alliance = alliance;
    }

    public Alliance getAlliance() {
        return alliance;
    }

}
