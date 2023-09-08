package com.tictactoe.player.AI;

import com.tictactoe.board.BoardUtils;
import com.tictactoe.board.TableBase;
import com.tictactoe.board.Tile;
import com.tictactoe.move.Move;
import com.tictactoe.piece.Alliance;

import java.util.Arrays;

import static com.tictactoe.player.AI.Evaluation.*;
import static com.tictactoe.move.MoveGenerator.*;
import static com.tictactoe.board.Tile.*;

public class Minimax {

    // max has X pieces
    public static int findBestMove(Tile[] board) {
        int bestVal = Integer.MIN_VALUE;
        int bestMove = 0;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        for (int i = 0; i < BoardUtils.BOARD_SIZE; i++)
        {
            // Check if cell is empty
            if (board[i] instanceof EmptyTile && BoardUtils.isValidTile(i)) {
                int moveVal = minimax(board, 9, true);

                if (moveVal > bestVal) {
                    bestMove = i;
                    bestVal = moveVal;
                }
                System.out.println(i + " " + bestMove + " "  + bestVal);
            }
        }
        return bestMove;
    }

    private static int minimax(Tile[] state, int depth, boolean isMaximizingPlayer) {

        if (isMaximizingPlayer)
            return max(state, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
        else
            return min(state, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static int max(Tile[] state, int depth, int alpha, int beta) {

        if (depth == 0 || TableBase.isEndGameTableBase(state)) {
            System.out.println(evaluate(state, Alliance.X));
            return evaluate(state, Alliance.X);
        }

        int maxEval = Integer.MIN_VALUE;

        for (Move childMove : generateAllPossibleMoves(state, true)) {

            Tile[] childState = Arrays.copyOf(state, state.length);
            childState[childMove.getCoordinate()] = new OccupiedTile(childMove.getCoordinate(), childMove.getPiece());

            int eval = min(childState, depth - 1, alpha, beta);

            maxEval = Math.max(maxEval, eval);
            alpha = Math.max(alpha, eval);

            childState[childMove.getCoordinate()] = new EmptyTile(childMove.getCoordinate());

            if (beta <= alpha)
                break; // Beta pruning
        }
        return maxEval;
    }

    private static int min(Tile[] state, int depth, int alpha, int beta) {
        if (depth == 0 || TableBase.isEndGameTableBase(state)) {
            System.out.println(evaluate(state, Alliance.X));
            return evaluate(state, Alliance.X);
        }

        int minEval = Integer.MAX_VALUE;

        for (Move childMove : generateAllPossibleMoves(state, false)) {

            Tile[] childState = Arrays.copyOf(state, state.length);
            childState[childMove.getCoordinate()] = new OccupiedTile(childMove.getCoordinate(), childMove.getPiece());

            int eval = max(childState, depth - 1, alpha, beta);

            minEval = Math.min(minEval, eval);
            beta = Math.min(beta, eval);

            childState[childMove.getCoordinate()] = new EmptyTile(childMove.getCoordinate());

            if (beta <= alpha)
                break; // Alpha pruning
        }
        return minEval;
    }

}
