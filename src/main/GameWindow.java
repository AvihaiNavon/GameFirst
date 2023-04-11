package main;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow(GamePanel gamePanel,MainScene mainScene,Scoreboard scoreboard){
        this.setTitle("Game Test");
        this.setSize(800,500);// לא כדאי להגדיר בחלון מכיוון שמתחשב גם בשורת סיום משימה
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mainScene);
        mainScene.setBounds(0,0,200,500);
        this.add(gamePanel);
        gamePanel.setBounds(200,0,400,500);
        this.add(scoreboard);
        scoreboard.setBounds(600,0,200,500);
        this.setLocationRelativeTo(null);//חלון באמצע
        this.setResizable(false);//הגדלת חלון
        //this.pack();//לפי הגודל של הפאנל (מכיוון שיש אחד)
        this.setVisible(true);

    }
}
