package main;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private MainScene mainScene;
    private Scoreboard scoreboard;
    private Thread gameThread;
    private final int FPS_SET=120;

    public Game(){
        gamePanel=new GamePanel();
        scoreboard=new Scoreboard();
        mainScene=new MainScene(scoreboard,gamePanel);
        gameWindow=new GameWindow(gamePanel,mainScene,scoreboard);
        gamePanel.requestFocus();
        startGameLoop();
    }
    private void startGameLoop(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    public void run(){
        double timePerFrame=1000000000.0;// בדיקה של לופ בנוו שניות
        long lastFrame=System.nanoTime();
        long now=System.nanoTime();
        int frames=0;
        long lastCheck=System.currentTimeMillis();

        while (true){
            now=System.nanoTime();
            if(now-lastFrame>=timePerFrame){
                gamePanel.repaint();
                lastFrame=now;
                frames++;
            }
            if(System.currentTimeMillis()-lastCheck>=1000){
                lastCheck=System.currentTimeMillis();
                System.out.println("FPS: "+ frames);
                frames=0;
            }

        }
    }
}
