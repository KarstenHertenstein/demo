import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;

public class GUI{

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private field[][] board = new field[8][8];
    private JPanel chessBoard;

    GUI() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));

        chessBoard = new JPanel(new GridLayout(8, 8));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        // create the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((j % 2 == 1 && i % 2 == 1)
                        //) {
                        || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                    field f = new field(b, false);
                    board[i][j] = f;
                } else {
                    b.setBackground(Color.BLACK);
                    field f = new field(b, true);
                    board[i][j] = f;
                }

            }
        }

        // fill the black non-pawn piece row
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard.add(board[i][j].getButton());
            }
        }

    }

    public void putPawn(){
        // Get Icon
        ImageIcon white = new ImageIcon("src/main/resources/white_pawn_white_background.png");
        ImageIcon black = new ImageIcon("src/main/resources/white_pawn_black_background.png");

        // Scale Icons to 64x64 px
        Image img = white.getImage();
        Image newImg = img.getScaledInstance(64,64, Image.SCALE_SMOOTH);
        white = new ImageIcon(newImg);
        img = black.getImage();
        newImg = img.getScaledInstance(64,64, Image.SCALE_SMOOTH);
        black = new ImageIcon(newImg);

        for(int i = 0; i < 8; i++){
            if(i % 2 == 0){
                board[6][i].getButton().setIcon(white);
            }else{
                board[6][i].getButton().setIcon(black);
            }
        }


    }


    public final JComponent getChessBoard() {
        return chessBoard;
    }

    public field[][] getBoard() {
        return board;
    }

    public final JComponent getGui() {
        return gui;
    }
}
