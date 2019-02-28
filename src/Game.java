import Piece.Cell;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game {
    private JFrame frame;
    private ChessBoard chessBoard;
    private Paint panel;
    private int count;
    private Point coord;

    public Game(){
        chessBoard = new ChessBoard();
        frame = new JFrame();
        panel = new Paint();
        count = 0;
    }

    public void step(Cell currentCell, Cell toCell) {
        if (currentCell.piece != null && currentCell.piece.move(currentCell, toCell)){
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
                        count++;
                    }
                } else {
                    count = 0;
                    Point coord2 = new Point(x, y);

                    if (!coord2.equals(coord)) {
                        System.out.println(coord.x + ", " + coord.y + "------>" + coord2.x + ", " + coord2.y);
                        step(chessBoard.getCell(coord), chessBoard.getCell(coord2));
                        panel.repaint();
                    }
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
