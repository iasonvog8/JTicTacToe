package com.tictactoe.player.AI;

import com.tictactoe.Test;
import com.tictactoe.board.TableBase;
import com.tictactoe.board.Tile;
import com.tictactoe.piece.Alliance;

import static com.tictactoe.piece.Alliance.*;

public class Evaluation {
    public static int evaluate(Tile[] board, Alliance maximizerAlliance) {
        Test.display(board);
        System.out.println();
        if (TableBase.isThereWinner(board, maximizerAlliance == X ? X : O))
            return 10;
        else if (TableBase.isThereWinner(board, maximizerAlliance == X ? O : X))
            return  -10;
        else return  0;

    }
}
