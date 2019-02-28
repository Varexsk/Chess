package Piece;

import java.awt.*;

public class Pawn extends ChessPiece {
    public boolean white;

    public Pawn(boolean white){
        this.white = white;
    }

    public boolean move(Cell currentCell, Cell toCell) {
        if (white){
            if (toCell.piece != null && toCell.piece.getColor()){
                return false;
            } else{
                if (currentCell.y == 1 && currentCell.y + 2 == toCell.y){
                    return true;
                }
                if (currentCell.y + 1 == toCell.y){
                    if (currentCell.x + 1 == toCell.x || currentCell.x - 1 == toCell.x){
                        if (toCell.piece != null){
                            return true;
                        }
                        return false;
                    }
                    if (toCell.piece != null){
                        return false;
                    }
                    return true;
                }
            }
        } else {
            if (toCell.piece != null && !toCell.piece.getColor()){
                return false;
            } else{
                if (currentCell.y == 6 && currentCell.y - 2 == toCell.y){
                    return true;
                }
                if (currentCell.y - 1 == toCell.y){
                    if (currentCell.x + 1 == toCell.x || currentCell.x - 1 == toCell.x){
                        if (toCell.piece != null){
                            return true;
                        }
                        return false;
                    }
                    if (toCell.piece != null){
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
