package Piece;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends ChessPiece{
    public boolean white;

    public Knight(boolean white){
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
        if (white){
            if (toCell.piece != null && toCell.piece.getColor())
                return false;
            if (Math.abs(currentCell.x - toCell.x) == 2 && Math.abs(currentCell.y - toCell.y) == 1 ||
                    Math.abs(currentCell.x - toCell.x) == 1 && Math.abs(currentCell.y - toCell.y) == 2){
                return true;
            }
        } else {
            if (toCell.piece != null && !toCell.piece.getColor())
                return false;
            if (Math.abs(currentCell.x - toCell.x) == 2 && Math.abs(currentCell.y - toCell.y) == 1 ||
                    Math.abs(currentCell.x - toCell.x) == 1 && Math.abs(currentCell.y - toCell.y) == 2){
                return true;
            }
        }
        return false;
    }

    public boolean getColor(){
        return white;
    }

    @Override
    public void paint(Graphics g, int cellsize, Point coord) {
        if (white)
            g.drawImage((Image)Pieces.wN.image, coord.x * cellsize, coord.y * cellsize, null);
        else
            g.drawImage((Image)Pieces.bN.image, coord.x * cellsize, coord.y * cellsize, null);
    }
}
