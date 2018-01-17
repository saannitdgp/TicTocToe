package tictactoe;

import jdk.nashorn.internal.scripts.JO;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// player = 1 - X
// player = 2 - O
public class Main extends JFrame implements ActionListener{
    private JPanel T;
    private JButton [][] btn ;
    private Board ob ;
    int player ;

    public Main(){
        setTitle("TicTacToe");
        setVisible(true);
        setResizable(false);
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        inti_component();
    }
    private void setPlayer(int x){
        player = x;
    }
    private void inti_component() {
            T = new JPanel();
            btn = new JButton[3][3];
            T.setLayout(new GridLayout(3,3));
            for(int i=0; i<  3; i++) {
                for(int j=0 ; j < 3 ; j++) {
                    MyButton b1 = (MyButton) new MyButton(i,j);
                    b1.setBounds(90,90,100,50);
                    b1.setVisible(true);
                    b1.setFont(new Font("Arial",Font.PLAIN,80));
                    b1.setBackground(Color.BLACK);
                    b1.setForeground(Color.WHITE);
                    b1.addActionListener(this);
                    btn[i][j] = b1;
                }
            }
            for(int i=0; i< 3; i++) {
                for (int j =0; j < 3; j++)
                    T.add(btn[i][j]);
            }
            add(T);

    }
    public void actionPerformed(ActionEvent e) {
        int[] index = ((MyButton) e.getSource()).getIndex();
        int x = index[0];
        int y = index[1];
        ob.setValue(x, y, 3);
        refereshBoard();
        if (ob.checkWin(player)) {
            JOptionPane.showMessageDialog(this, "You Win!");
            ob.intiBoard();
            refereshBoard();
        } else if (ob.isBoardFull()) {
            JOptionPane.showMessageDialog(this, "Game Draw");
            ob.intiBoard();
            refereshBoard();
        } else {
            setPlayer(3 - player);
            playComputer();
        }
    }

    private void playComputer() {
        int buttonNumber;
        //1 : buttonNumber = possibleWin(player)
        //2 : buttonNumber = possibleWin(3-player)
        //3 : buttonNumber = randomBlankButton();
        // play_move()
        buttonNumber = ob.possibleWin(player);
        if( buttonNumber == 0 )
            buttonNumber = ob.possibleWin(3 - player);
       if( buttonNumber == 0)
            buttonNumber = ob.randomBlankButton();
        if(buttonNumber != 0) {
            buttonNumber--;
            int x = buttonNumber/3;
            int y = buttonNumber - x*3;
            ob.setValue(x,y,5);
            refereshBoard();
            if(ob.checkWin(player)){
                JOptionPane.showMessageDialog(this,"You Lost!");
                ob.intiBoard();
                refereshBoard();
                setPlayer(1);
            }
            else if(ob.isBoardFull()){
                JOptionPane.showMessageDialog(this,"Game Draw!");
                ob.intiBoard();
                refereshBoard();
                setPlayer(1);
            }
            else {
                setPlayer(1);
            }
        }
    }

    public void refereshBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (ob.getValue(i, j)) {
                    case 2:
                        btn[i][j].setEnabled(true);
                        btn[i][j].setText("");
                        break;
                    case 3:
                        btn[i][j].setEnabled(false);
                        btn[i][j].setForeground(Color.WHITE);
                        btn[i][j].setText("X");
                        break;
                    case 5:
                        btn[i][j].setEnabled(false);
                        btn[i][j].setForeground(Color.RED);
                        btn[i][j].setText("O");
                        break;
                }
            }
        }
    }

    public void play(){
           this.ob = new Board();
           refereshBoard();
           setPlayer(1);

    }
    public static void main(String... agrs){
        Main ob = new Main();
        ob.inti_component();
        ob.play();
    }
}
