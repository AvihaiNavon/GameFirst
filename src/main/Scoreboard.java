package main;

import javax.swing.*;
import java.awt.*;


public class Scoreboard extends JPanel {
    private boolean information;
    public Scoreboard(){
        this.setBackground(Color.blue);
        this.information=false;
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if(information) {
            graphics.setColor(Color.gray);
            graphics.fillOval(0, 0, 100, 100);
        }


    }
    public void showInformation(){
        information= !information;
    }

}
