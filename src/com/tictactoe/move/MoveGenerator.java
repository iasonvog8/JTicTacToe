package com.tictactoe.move;

import com.tictactoe.board.Tile;
import com.tictactoe.board.TableBase;
import com.tictactoe.piece.Alliance;
import com.tictactoe.piece.Piece;

import java.util.LinkedList;

public class MoveGenerator {
    public static LinkedList<Move> generateAllPossibleMoves(Tile[] board, boolean XTurn) {
        LinkedList<Move> allPossibleLegalMoves = new LinkedList<>();

        if (!TableBase.isEndGameTableBase(board)) {
            for (Tile t : board) {
                if (t instanceof Tile.EmptyTile)
                    allPossibleLegalMoves.add(new Move(t.tileCoordinate, new Piece(XTurn ? Alliance.X : Alliance.O)));
            }
        }
        return allPossibleLegalMoves;
    }
}
