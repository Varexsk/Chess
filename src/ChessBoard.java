import Piece.Cell;
import Piece.Pawn;
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

        cells[0][6].piece = new Pawn(false);
        cells[1][6].piece = new Pawn(false);
        cells[2][6].piece = new Pawn(false);
        cells[3][6].piece = new Pawn(false);
        cells[4][6].piece = new Pawn(false);
        cells[5][6].piece = new Pawn(false);
        cells[6][6].piece = new Pawn(false);
        cells[7][6].piece = new Pawn(false);

    }

}


