
import Piece.Cell;
import Piece.Pieces;

import javax.swing.*;
import java.awt.*;

public class Paint extends JComponent {
    Color lightBrown = new Color(240,217,181);
    Color brown = new Color(181,136,99);
    public void paintComponent(Graphics g){
        setChessBoard(g);
        setImages();
        drawPieces(g);
        drawMoves(g);
    }

    public void setChessBoard(Graphics g){
        for (int i = 0; i < 8; i++)
            if(i % 2 == 0)
                for (int j = 0; j < 8; j++)
                    if (j % 2 == 0) {
                        g.setColor(lightBrown);
                        fillRect(g, i, j);
                    } else {
                        g.setColor(brown);
                        fillRect(g, i, j);
                    }
            else
                for (int j = 0; j < 8; j++)
                    if (j % 2 == 0) {
                        g.setColor(brown);
                        fillRect(g, i, j);
                    } else {
                        g.setColor(lightBrown);
                        fillRect(g, i, j);
                    }
    }

    public void drawMoves(Graphics g){
        g.setColor(new Color(109,159,88));
        if (Game.getListMoves() != null)
            for (Point p : Game.getListMoves())
                g.fillOval(p.x * ChessBoard.CELL + (ChessBoard.CELL - ChessBoard.CELL /4)/2 , p.y * ChessBoard.CELL + (ChessBoard.CELL -ChessBoard.CELL /4)/2 , ChessBoard.CELL /4, ChessBoard.CELL/4);
    }

    public void drawPieces(Graphics g){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
               if (ChessBoard.getCells()[i][j].piece != null)
                   ChessBoard.getCells()[i][j].piece.paint(g, ChessBoard.CELL, new Point(i, j));
    }

    public void setImages(){
        for (Pieces pieces: Pieces.values())
            pieces.image = getImage(pieces.name());
    }

    public Image getImage(String name){
        String filename = "img/"+ name +".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

    public void fillRect(Graphics g, int i, int j){
        g.fillRect(j * ChessBoard.CELL, i * ChessBoard.CELL, ChessBoard.CELL, ChessBoard.CELL);
    }

}
