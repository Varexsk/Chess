package Piece;

import java.awt.*;
import java.util.ArrayList;

abstract public class ChessPiece {
    protected boolean white;
    public abstract boolean move(Cell currentCell, Cell toCell, Cell[][]cells);
    public abstract void paint(Graphics g, int cellsize, Point coord);
    public abstract boolean getColor();
    public abstract ArrayList<Point> getMoves(Cell toCell, Cell[][]cells);
}
