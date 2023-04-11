package main;

import java.awt.*;
import java.util.Random;

public class Bricks  {
    private int x;
    private int y;
    private int width;
    private int height;
    private float a,b,c;

    public Bricks(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 20;
        floatColor();

    }
    private void floatColor(){
        Random random=new Random();
        this.a=random.nextFloat();
        this.b=random.nextFloat();
        this.c=random.nextFloat();
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.getHSBColor(a,b,c));
        graphics.fillRect(this.x,this.y,this.width,this.height);
    }


}
