package main;

import javax.swing.*;
import java.awt.*;

public class MainScene extends JPanel {
    private JButton jButton1;
    public MainScene(Scoreboard scoreboard,GamePanel gamePanel){
        this.setBackground(Color.black);
      //  int buttons=4;
     // GridLayout gridLayout=new GridLayout(buttons,1);//מייצר פורמט לכפתורים 4 בעמודה
     //this.setLayout(gridLayout);
//        for(int i=1;i<=buttons;i++){
//            this.add(new JButton(String.valueOf(i)));// מייצר את הכפתורים
//        }
        jButton1=new JButton("Starting a game");
        jButton1.setBounds(0,60,20,20);// לא עובד צריך לבדוק!
        this.add(jButton1);
        jButton1.addActionListener((event)->{
            gamePanel.StarOrEndGame();

        });
        JButton jButton2=new JButton("Information game");
        jButton2.setBounds(0,20,20,20);
        this.add(jButton2);
        jButton2.addActionListener((event)->{
            String information="Information game:....coming soon";
            JOptionPane.showConfirmDialog(this,information,"Information",JOptionPane.PLAIN_MESSAGE);
        });
        JButton jButton3=new JButton("Scoreboard");
        jButton3.setBounds(0,40,20,20);
        this.add(jButton3);
        JButton jButton4=new JButton("Exit game");
        jButton4.setBounds(0,60,20,20);
        this.add(jButton4);
        jButton4.addActionListener((event)->{

        });
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

    }
}
