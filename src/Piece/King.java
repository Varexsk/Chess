package Piece;

import java.awt.*;
import java.util.ArrayList;

public class King extends ChessPiece{
    public boolean white;

    public King(boolean white){
        this.white = white;
    }

    public ArrayList<Point> getMoves (Cell currentCell, Cell[][] cells){
        ArrayList<Point> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (move(currentCell, cells[i][j], cells)){
                    moves.add(new Point(i, j));
                }
            }
        }
        return moves;
    }

    public boolean move(Cell currentCell, Cell toCell, Cell[][] cells) {
        if (white) {
            if (toCell.piece != null && toCell.piece.getColor())
                return false;
            else
                if (Math.abs(currentCell.x - toCell.x) == 1 && Math.abs(currentCell.y - toCell.y) == 1)
                    return true;
                return  (Math.abs(currentCell.x - toCell.x) == 1 && Math.abs(currentCell.y - toCell.y) == 0 || Math.abs(currentCell.x - toCell.x) == 0 && Math.abs(currentCell.y - toCell.y) == 1);

        } else {
            if (toCell.piece != null && !toCell.piece.getColor())
                return false;
            else
                if (Math.abs(currentCell.x - toCell.x) == 1 && Math.abs(currentCell.y - toCell.y) == 1)
                    return true;
                return  (Math.abs(currentCell.x - toCell.x) == 1 && Math.abs(currentCell.y - toCell.y) == 0 || Math.abs(currentCell.x - toCell.x) == 0 && Math.abs(currentCell.y - toCell.y) == 1);

        }
    }

    public boolean getColor(){
        return white;
    }

    @Override
    public void paint(Graphics g, int cellsize, Point coord) {
        if (white)
            g.drawImage((Image)Pieces.wK.image, coord.x * cellsize, coord.y * cellsize, null);
        else
            g.drawImage((Image)Pieces.bK.image, coord.x * cellsize, coord.y * cellsize, null);
    }
}