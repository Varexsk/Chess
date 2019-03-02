package Piece;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends ChessPiece{
    public boolean white;

    public Rook(boolean white){
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
        boolean result = false;
        if (white){
            if (toCell.piece != null && toCell.piece.getColor())
                return false;
            if (currentCell.x == toCell.x){
                if (Math.abs(currentCell.y - toCell.y) == 1) {
                    if (toCell.piece != null && toCell.piece.getColor())
                        return false;
                    return true;
                }
                for (int i = 1; i <= Math.abs(currentCell.y - toCell.y) - 1 ; i++) {
                    if (currentCell.y < toCell.y)
                        if (cells[currentCell.x][currentCell.y + i].piece != null)
                            return false;

                    if (currentCell.y > toCell.y)
                        if (cells[currentCell.x][currentCell.y - i].piece != null)
                            return false;

                    result = true;
                }
            }
            if (currentCell.y == toCell.y){
                if (Math.abs(currentCell.x - toCell.x) == 1) {
                    if (toCell.piece != null && toCell.piece.getColor())
                        return false;
                    return true;
                }
                for (int i = 1; i <= Math.abs(currentCell.x - toCell.x) - 1 ; i++) {
                    if (currentCell.x < toCell.x)
                        if (cells[currentCell.x + i][currentCell.y].piece != null)
                            return false;

                    if (currentCell.x > toCell.x)
                        if (cells[currentCell.x - i][currentCell.y].piece != null)
                            return false;

                    result = true;
                }
            }
        } else {
            if (toCell.piece != null && !toCell.piece.getColor())
                return false;
            if (currentCell.x == toCell.x){
                if (Math.abs(currentCell.y - toCell.y) == 1) {
                    if (toCell.piece != null && !toCell.piece.getColor())
                        return false;
                    return true;
                }
                for (int i = 1; i <= Math.abs(currentCell.y - toCell.y) - 1 ; i++) {
                    if (currentCell.y < toCell.y)
                        if (cells[currentCell.x][currentCell.y + i].piece != null)
                            return false;

                    if (currentCell.y > toCell.y)
                        if (cells[currentCell.x][currentCell.y - i].piece != null)
                            return false;

                    result = true;
                }
            }
            if (currentCell.y == toCell.y){
                if (Math.abs(currentCell.x - toCell.x) == 1) {
                    if (toCell.piece != null && !toCell.piece.getColor())
                        return false;
                    return true;
                }
                for (int i = 1; i <= Math.abs(currentCell.x - toCell.x) - 1 ; i++) {
                    if (currentCell.x < toCell.x)
                        if (cells[currentCell.x + i][currentCell.y].piece != null)
                            return false;

                    if (currentCell.x > toCell.x)
                        if (cells[currentCell.x - i][currentCell.y].piece != null)
                            return false;

                    result = true;
                }
            }
        }
        return result;
    }

    public boolean getColor(){
        return white;
    }

    @Override
    public void paint(Graphics g, int cellsize, Point coord) {
        if (white)
            g.drawImage((Image)Pieces.wR.image, coord.x * cellsize, coord.y * cellsize, null);
        else
            g.drawImage((Image)Pieces.bR.image, coord.x * cellsize, coord.y * cellsize, null);
    }
}
