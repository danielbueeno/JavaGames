package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTac implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    public TicTac(){
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        

        textField.setBackground(new Color(255,250,250));
        textField.setForeground(new Color(255,127,80));
        textField.setFont(new Font("Ink Free",Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i = 0;i<9; i++){
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setBackground(new Color(255,160,122));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            button_panel.add(buttons[i]);
            
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i= 0; i<9; i++){
            if(e.getSource()== buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,250,250));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        boolean dc = check();
                        if(!dc){drawCheck();}
                        
                    }
                }
                else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,250,250));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        boolean dc = check();
                        if(!dc){drawCheck();}
                    }
                }
            }
        }

    }

    public void firstTurn(){
        try{
            Thread.sleep(1000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        

       if(random.nextInt(2) == 0){
           player1_turn = true;
           textField.setText("X turn!");
       }else{
        player1_turn = false;
        textField.setText("0 turn!");
       }

    }

    public boolean check(){
        boolean winner = false;
        //check X win conditions
        if((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")){
            xWins(0, 1, 2);
            winner = true;
        }

        else if((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")){
            xWins(3, 4, 5);
            winner = true;
        }

        else if((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")){
            xWins(6, 7, 8);
            winner = true;
        }

        else if((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")){
            xWins(0, 3, 6);
            winner = true;
        }

        else if((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")){
            xWins(1, 4, 7);
            winner = true;
        }

        else if((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")){
            xWins(2, 5, 8);
            winner = true;
        }

        else if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")){
            xWins(0, 4, 8);
            winner = true;
        }

        else if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")){
            xWins(2, 4, 6);
            winner = true;
        }

        //check X win conditions
        else if((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")){
            oWins(0, 1, 2);
            winner = true;
        }

        else if((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")){
            oWins(3, 4, 5);
            winner = true;
        }

        else if((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")){
            oWins(6, 7, 8);
            winner = true;
        }

        else if((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")){
            oWins(0, 3, 6);
            winner = true;
        }

        else if((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")){
            oWins(1, 4, 7);
            winner = true;
        }

        else if((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")){
            oWins(2, 5, 8);
            winner = true;
        }

       else if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")){
            oWins(0, 4, 8);
            winner = true;
        }

        else if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")){
            oWins(2, 4, 6);
            winner = true;
        }
        return winner;
    }

    public void drawCheck(){
        int y = 0;
        for(int i= 0; i<9; i++){
            if(buttons[i].getText()!=""){
                y++;
            }
        }
        if(y==9){
            draw();
        }
    }

    public void xWins(int a, int b, int c){

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
            if(i != a && i!= b && i != c){
                buttons[i].setBackground(Color.GRAY);
            }
        }
       
        textField.setText("X wins!");
       
    }

    public void oWins(int a, int b, int c){
       
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
            if(i != a && i!= b && i != c){
                buttons[i].setBackground(Color.GRAY);
            }
        }

        textField.setText("O wins!");
        
    }

    public void draw(){
        textField.setText("Draw!");
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
    }

}
