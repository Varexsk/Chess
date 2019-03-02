import Piece.*;

import java.awt.*;

public class ChessBoard {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    public static final int CELL = 80;

    public static Cell[][] getCells() {
        return cells;
    }

    private static Cell cells[][];

    public ChessBoard(){
        cells = new Cell[8][8];
    }

    public Cell getCell(Point coord){
        return cells[coord.x][coord.y];
    }

    public void setDefaultPositionPieces(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }

        cells[0][1].piece = new Pawn(true);
        cells[1][1].piece = new Pawn(true);
        cells[2][1].piece = new Pawn(true);
        cells[3][1].piece = new Pawn(true);
        cells[4][1].piece = new Pawn(true);
        cells[5][1].piece = new Pawn(true);
        cells[6][1].piece = new Pawn(true);
        cells[7][1].piece = new Pawn(true);
        cells[0][0].piece = new Rook(true);
        cells[7][0].piece = new Rook(true);
        cells[1][0].piece = new Knight(true);
        cells[6][0].piece = new Knight(true);
        cells[2][0].piece = new Bishop(true);
        cells[5][0].piece = new Bishop(true);
        cells[3][0].piece = new Queen(true);
        cells[4][0].piece = new King(true);

        cells[0][6].piece = new Pawn(false);
        cells[1][6].piece = new Pawn(false);
        cells[2][6].piece = new Pawn(false);
        cells[3][6].piece = new Pawn(false);
        cells[4][6].piece = new Pawn(false);
        cells[5][6].piece = new Pawn(false);
        cells[6][6].piece = new Pawn(false);
        cells[7][6].piece = new Pawn(false);
        cells[0][7].piece = new Rook(false);
        cells[7][7].piece = new Rook(false);
        cells[1][7].piece = new Knight(false);
        cells[6][7].piece = new Knight(false);
        cells[2][7].piece = new Bishop(false);
        cells[5][7].piece = new Bishop(false);
        cells[3][7].piece = new Queen(false);
        cells[4][7].piece = new King(false);

    }

}


