import javax.swing.*;

public class field {

    private JButton btn;
    private boolean isBlack;

    public field(JButton bt, boolean black){
        this.btn = bt;
        this.isBlack = black;
    }

    public JButton getButton(){
        return this.btn;
    }

}
