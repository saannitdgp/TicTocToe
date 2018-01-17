package tictactoe;

import javax.swing.*;

class MyButton extends JButton {
    private  int i , j;
    MyButton(int i, int j) {
        super();
        this.i = i;
        this.j = j;
    }
    public int[] getIndex() {
        return new int[]{i,j};
    }
}
