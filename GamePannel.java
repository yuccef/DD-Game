import javax.swing.JPanel;
import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
import java.awt.Color;



public class GamePannel extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L; 
    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 is the original size of the player character or any other character in the game
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48x48 tile is new  size of the player character or any other character in the game
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 13;
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHight = tileSize * maxScreenRow; //576 pixels

    
    Thread  gameThread;
    public CollisionChecker collisionChecker = new CollisionChecker(this);

    public int FPS = 60;


    public GamePannel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.startGameThread();
        
    }

    public void startGameThread(){
        
            gameThread = new Thread(this);
            gameThread.start();
        
    }

    public void run(){

        double drawInterval = 1000000000/FPS; //0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            this.repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;  

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        
        }
    }    
}
