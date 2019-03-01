package Piece;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends ChessPiece {
    public boolean white;

    public Pawn(boolean white){
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
            if (toCell.piece != null && toCell.piece.getColor()){
                return false;
            } else{
                if (currentCell.y == 1 && currentCell.y + 2 == toCell.y && currentCell.x == toCell.x){
                    if (cells[currentCell.x][currentCell.y + 1].piece != null)
                        return false;
                    return true;
                }
                if (currentCell.y + 1 == toCell.y){
                    if (currentCell.x + 1 == toCell.x || currentCell.x - 1 == toCell.x){
                        if (toCell.piece != null){
                            return true;
                        }
                        return false;
                    }
                    if (currentCell.x != toCell.x)
                        return false;
                    if (toCell.piece != null) {
                        return false;
                    }
                    return true;
                }
            }
        } else {
            if (toCell.piece != null && !toCell.piece.getColor()){
                return false;
            } else{
                if (currentCell.y == 6 && currentCell.y - 2 == toCell.y && currentCell.x == toCell.x){
                    if (cells[currentCell.x][currentCell.y - 1].piece != null)
                        return false;
                    return true;
                }
                if (currentCell.y - 1 == toCell.y){
                    if (currentCell.x + 1 == toCell.x || currentCell.x - 1 == toCell.x){
                        if (toCell.piece != null){
                            return true;
                        }
                        return false;
                    }
                    if (currentCell.x != toCell.x)
                        return false;
                    if (toCell.piece != null) {
                        return false;
                    }
                    return true;
                }
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
            g.drawImage((Image)Pieces.wP.image, coord.x * cellsize, coord.y * cellsize, null);
        else
            g.drawImage((Image)Pieces.bP.image, coord.x * cellsize, coord.y * cellsize, null);
    }
}
