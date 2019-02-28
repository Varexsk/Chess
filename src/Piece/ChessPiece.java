package Piece;

import java.awt.*;

abstract public class ChessPiece {
    protected boolean white;
    protected Point coord;
    public abstract boolean move(Cell currentCell, Cell toCell);
    public abstract void paint(Graphics g, int cellsize, Point coord);
    public abstract boolean getColor();
}
