import Piece.Cell;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game {
    private JFrame frame;
    private ChessBoard chessBoard;
    private Paint panel;
    private int count;
    private Point coord;

    public static ArrayList<Point> getListMoves() {
        return listMoves;
    }

    private static ArrayList<Point> listMoves;

    public Game(){
        chessBoard = new ChessBoard();
        frame = new JFrame();
        panel = new Paint();
        count = 0;
    }

    public void step(Cell currentCell, Cell toCell) {
        if (currentCell.piece != null && currentCell.piece.move(currentCell, toCell, ChessBoard.getCells())){
            toCell.piece = currentCell.piece;
            currentCell.piece = null;
        }
    }

    public void setGUI(){
        frame.setTitle("Chess in Java");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setPreferredSize(new Dimension(ChessBoard.WIDTH*ChessBoard.CELL, ChessBoard.HEIGHT*ChessBoard.CELL));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / ChessBoard.CELL;
                int y = e.getY() / ChessBoard.CELL;
                if (count == 0) {
                    coord = new Point(x, y);
                    if(chessBoard.getCell(coord).piece != null){
                        listMoves = chessBoard.getCell(coord).piece.getMoves(chessBoard.getCell(coord), ChessBoard.getCells());
                        count++;
                        panel.repaint();
                    }
                } else {
                    Point coord2 = new Point(x, y);
                    if (!coord2.equals(coord)) {
                        step(chessBoard.getCell(coord), chessBoard.getCell(coord2));
                        panel.repaint();
                    }
                    listMoves = null;
                    count = 0;
                }
            }

        });
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void startGame(){
        chessBoard.setDefaultPositionPieces();
        setGUI();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
