package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private int xDelta=150,yDelta=420;
    private float xDeltaBall=190,yDeltaBall=400;
    private float xDir=0.08f,yDir=0.08f;
    private ArrayList<Bricks> arrayBricks;
    private BufferedImage img,sumImg;// מחלקה שמאפשר משחק עם התמונה כמו להקטין
    private boolean startGame;

    public GamePanel() {
        this.startGame = false;
            mouseInputs = new MouseInputs(this);
            addKeyListener(new KeyboardInputs(this));
            addMouseListener(mouseInputs);
            addMouseMotionListener(mouseInputs);
            this.arrayBricks = new ArrayList<>();
            int indexX = 10;
            int indexY = 10;
            for (int i = 1; i < 7; i++) {
                for (int t = 0; t < 6; t++) {
                    Bricks bricks = new Bricks(indexX, indexY);
                    this.arrayBricks.add(bricks);
                    indexX += 60;

                }
                indexY += 20;
                indexX = 10;
            }
        }


    private void importImg() { //מתודה להכנסת תמונה
        InputStream is=getClass().getResourceAsStream("/player_sprites.png");// חייב סלאש למציאה בתקיות
        try{
            img= ImageIO.read(is);
        } catch (IOException e) {
           e.printStackTrace();
        }finally {
            try {
                is.close(); //לסגור את התמונה שלא יגרום לבעיות
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void changeXDelta(int value){
        if (this.xDelta+value>0&&this.xDelta+value<300) {// צריך לשנות לגודל קבוע
            this.xDelta += value;
        }
        repaint();
    }
    public void changeYDelta(int value){
        this.yDelta+=value;
        repaint();//צביעה מחדש
    }
    public void setRectPos(int x,int y){ //לקבוע מיקום אובייקט עם העכבר
        this.xDelta=x;
        this.yDelta=y;
        repaint();
    }
    public void StarOrEndGame(){
        this.startGame=!startGame;

    }
    public void updateBall(){
        xDeltaBall+=xDir;
        if(xDeltaBall>=400||xDeltaBall<=0){
            xDir*=-1;
        }

        yDeltaBall-=yDir;
        if(0>yDeltaBall||yDeltaBall>500){
            yDir*=-1;
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);// קוראת למחלקה שמאפשרת לנו את הציור, מנקה ומכין את השטח בשבלינו
        //if(this.startGame) {
        g.fillRect(xDelta, yDelta, 100, 25);//צובע את המלבן
        g.fillOval((int) xDeltaBall,(int) yDeltaBall , 13, 17);
        updateBall();
        repaint();


           for (Bricks bricks : this.arrayBricks) {
               bricks.paint(g);
           }
        //   } else {
       // g.drawString("Welcome to the brick breaking game",100,200);
    //}


    }
//    private void updateRectangle(){
//        xDelta+=xDir;
//        if(xDelta>400||xDelta<0){
//            xDir*=-1;
//            color=getRndColor();
//        }
//        yDelta+=yDir;
//        if(yDelta>400||yDelta<0){
//            yDir*=-1;
//            color=getRndColor();
//        }
//    }
//    private Color getRndColor(){
//        int r=random.nextInt(255);
//        int g=random.nextInt(255);
//        int b=random.nextInt(255);
//        return new Color(r,g,b);
//    }
}
