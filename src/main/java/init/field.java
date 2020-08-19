package init;

import pieces.piece;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class field {

    private JButton btn;
    private boolean isBlack;
    private int row;
    private int column;
    private boolean isFocus = false;
    private piece p;


    public field(JButton bt, boolean black, int x, int y){
        this.btn = bt;
        this.isBlack = black;
        this.row = x;
        this.column = y;
    }

    public JButton getButton(){
        return this.btn;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void onClick(){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hasFocussed() != null){
                    if(hasFocussed().hasPiece()){
                        if(hasFocussed().getPiece().moveTo(row, column)){
                            // Piece can move to location
                            // Update Piece position
                            // if enemy killed, take piece out

                            hasFocussed().setFocus(false);
                        }else{
                            // Piece cant move to location
                            System.out.println("Cant move to location!");
                            System.out.println("("+hasFocussed().getRow()+", "+hasFocussed().getColumn()+") unfocussed!");
                            hasFocussed().setFocus(false);
                        }
                    }else{

                    }


                }else{
                    if(hasPiece()){
                        isFocus = true;
                        System.out.println("("+row + "," +column+") is now focus");
                    }
                }
            }
        });
    }

    public field hasFocussed(){
        for(int i = 0; i < GUI.board.length; i++){
            for(int j = 0; j < GUI.board.length; j++){
                if(GUI.board[i][j].getFocus()){
                    return GUI.board[i][j];
                }
            }
        }
        return null;
    }


    public boolean getFocus(){
        return isFocus;
    }
    public void setFocus(boolean foc){
        this.isFocus = foc;
    }
    public void setPiece(piece p){
        this.p = p;
    }
    public piece getPiece(){
        return this.p;
    }
    public boolean hasPiece(){
        if(this.p == null){
            return false;
        }
        return true;
    }
}
