package com.tictactoe;

import com.tictactoe.board.Board;
import com.tictactoe.board.Tile;
import com.tictactoe.board.TableBase;
import com.tictactoe.piece.Alliance;
import com.tictactoe.piece.Piece;
import com.tictactoe.player.AI.Evaluation;
import com.tictactoe.player.AI.Minimax;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board tictactoe = new Board();


        tictactoe.initBoard();
        int pos = 0;

        while (!TableBase.isEndGameTableBase(tictactoe.getBoard())) {
            System.out.println("pos: ");
            if (sc.hasNextInt())
                pos = sc.nextInt();
            tictactoe.setPiece(pos, new Piece(Alliance.O));
            tictactoe.setPiece(Minimax.findBestMove(tictactoe.getBoard()), new Piece(Alliance.X));
            display(tictactoe.getBoard());
        }
    }
    public static void display(Tile[] board) {
        for (int sq = 0; sq < 9; sq++) {
            if (board[sq] instanceof Tile.EmptyTile)
                System.out.print(" |");
            else
                System.out.print(board[sq].getPiece().getAlliance() + "|");

            if (sq % 3 == 2)
                System.out.println("\n" + "-".repeat(6));
        }
    }
}
