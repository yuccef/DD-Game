package src.mygame.Views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.String;



import src.mygame.Utils.*;
import src.mygame.Controllers.*;



import src.mygame.Models.TheDragon.Dragon;
import src.mygame.Models.TheFighter.FighterCaracter;



public class labyrinth {

       public void showLabyrinthWindow() {
            Window.setVisible(true);
        }
    

    public  int MATRIX_SIZE = 810;

    public JFrame Window;
    public int[][] Lmatrix;
    public int[][] Bmatrix;
    
    public int xFighter = 0;
    public int yFighter = 40;
    public int xDragon = 720;
    public int yDragon = 520;
 
    public JLabel characterLabel;
    public JLabel DragonLabel;
    public JLabel FireDragonLabel;
    public JLabel FireFighterLabel;
    public JLabel FighterShield;
    public JLabel DragonShield;


    //Should to update this
    public int currentImageIndexFighterRun = 0;
    public int currentImageIndexFighterAttack=0;
    public int currentImageIndexDragonRun = 0;
    public int currentImageIndexDragonAttack = 0;


    public char SideDragon, SideFighter;
    
    public String Fightermove;


    
    //Objects
    PicturesPath Paths = new PicturesPath();
    public GameTimers gameTimers;
    public FighterCaracter Bnadem = new FighterCaracter( "Youssef ",   400, 30, 10, xFighter, yFighter);
    public Dragon Dragon = new Dragon("Dragon", 400, 20, 20, xDragon, yDragon);
    public CharactersMovesManage CharactersMovesManage;
    public RightSidePanel RightSidePanel ;



    //Getters
    public FighterCaracter getBnadem() {
        return this.Bnadem;
    }
    public Dragon getDragon() {
    return this.Dragon;
}

     public labyrinth  getLabyrinth(){
    return this;
     }



//Methods
public labyrinth() {
   
    //Objects 2

    RightSidePanel = new RightSidePanel(labyrinth.this);
    RightSidePanel.RightSidePanelDraw();


   

        
     

    
    gameTimers = new GameTimers(this, RightSidePanel);
    DragonActionAI DragonActionAI = new DragonActionAI();
    CharactersMovesManage = new CharactersMovesManage(this);

    
        Window = new JFrame("D&D Game");
        Window.setSize(800, 785);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.add(RightSidePanel);
        Window.setLayout(null);

        
        //Map Panel
        JPanel DrawLabyrinthPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image RoadMap = new ImageIcon("../Project/src/mygame/resource/MapPixels/labyrinth1.jpg").getImage();
                Image WallMap = new ImageIcon("../Project/src/mygame/resource/MapPixels/labyrinth2.jpg").getImage();
               
                MapMaths MapManage = new MapMaths();

                Lmatrix = MapManage.loadMap();
                Bmatrix = MapManage.CreatTheBigMatrix(Lmatrix);   

                for(int i=0; i<800; i=i+40){
                    for(int j=0; j<800; j=j+40){
                        if(Bmatrix[i][j] == 0){
                            g.drawImage(RoadMap, i , j, this);
                        }
           
                    }
                }

                for(int i=0; i<20;i++){
                    for(int j=0; j<20; j++){
                        if(Lmatrix[i][j] == 1){
                            g.drawImage(WallMap, i*40 , j*40, this);
                        }
                    }   
                }

        }             
    };



        //Labels
        characterLabel = new JLabel();
        DragonLabel = new JLabel();

        FireDragonLabel = new JLabel();
        FireFighterLabel = new JLabel();

        FighterShield = new JLabel();
        DragonShield = new JLabel();



        //Initialize Labels
        characterLabel.setBounds(xFighter, yFighter, 40, 40);
        DragonLabel.setBounds(xDragon, yDragon, 40, 40);
       
        FireDragonLabel.setBounds(gameTimers.xFire, gameTimers.yFire, 40, 40);
        FireFighterLabel.setBounds(gameTimers.xFireFighter, gameTimers.yFireFighter, 40, 40);
       
        FighterShield.setBounds(xFighter, yFighter, 40, 40);
        DragonShield.setBounds(xDragon, yDragon, 40, 40);



        //Add to Panel
        DrawLabyrinthPanel.setBounds(0, 0, 800, 635);
        DrawLabyrinthPanel.setLayout(null);

        DrawLabyrinthPanel.add(DragonLabel);
        DrawLabyrinthPanel.add(characterLabel);

        DrawLabyrinthPanel.add(FireDragonLabel);
        DrawLabyrinthPanel.add(FireFighterLabel);

        DrawLabyrinthPanel.add(FighterShield);
        DrawLabyrinthPanel.add(DragonShield);


        //Show the Window
        Window.setSize(new Dimension(1100, 635));
        Window.setResizable(false);
        Window.add(DrawLabyrinthPanel);
        Window.setLocationRelativeTo(null);


    
// I want to stop this file juste here

        //Key Listener
        Window.addKeyListener(new KeyListener() {
     
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //key listener for the Fighter
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Right Fighter
                    SideFighter = 'R';
                    CharactersMovesManage.moveFighter(1,1, 0, labyrinth.this);
                    Fightermove="run";
                    DragonActionAI.DragonActionAI(labyrinth.this);

                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // Left Fighter
                    SideFighter = 'L';
                       CharactersMovesManage.moveFighter(1,-1, 0, labyrinth.this);
                    Fightermove="run";
                    DragonActionAI.DragonActionAI(labyrinth.this);
                // IN UP AND DOWN I SHOULD TO UPDATE SIDES
                } else if (e.getKeyCode() == KeyEvent.VK_UP) { // Up Fighter
                       CharactersMovesManage.moveFighter(1,0, -1, labyrinth.this);
                    Fightermove="run";
                    DragonActionAI.DragonActionAI(labyrinth.this );

                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Down Fighter
                       CharactersMovesManage.moveFighter(1,0, 1, labyrinth.this);
                    Fightermove="run";
                    DragonActionAI.DragonActionAI(labyrinth.this );
                }
                else if (e.getKeyCode()== KeyEvent.VK_ENTER){  //Attack
                       CharactersMovesManage.moveAttack(1, labyrinth.this);
                    Fightermove="Attack";
                    DragonActionAI.DragonActionAI(labyrinth.this);
                    }
                else if(e.getKeyChar()=='x'|| e.getKeyChar()=='X'){  //Defend
                    gameTimers.ShieldFighterCheker=1;
                    gameTimers.timerShieldFighter.start();
                    Fightermove="Defend";            
                    DragonActionAI.DragonActionAI(labyrinth.this );
                }
             


                //key listener for dragon
                if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                    SideDragon = 'R';
                       CharactersMovesManage.moveFighter(2,1, 0,  labyrinth.this);
                }else if(e.getKeyChar() == 'q' || e.getKeyChar() == 'Q'){
                    SideDragon = 'L';
                       CharactersMovesManage.moveFighter(2,-1, 0, labyrinth.this);
                }else if(e.getKeyChar() == 'z' || e.getKeyChar() == 'Z'){
                                              CharactersMovesManage.moveFighter(2,0, -1, labyrinth.this);
                }else if(e.getKeyChar() == 's' || e.getKeyChar() == 'S'){
                     CharactersMovesManage.moveFighter(2,0, 1, labyrinth.this);
                }
                // else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                //     moveAttack(2);
                // }
                // else if(e.getKeyChar()=='c'|| e.getKeyChar()=='C'){ //we have a problem here andin Shield fighter too
                //     gameTimers.timerShieldDragon.start();
                // }   
               
            }
             
                @Override
            public void keyReleased(KeyEvent e) {
                }
            });
        
        Window.setVisible(true);
        DragonActionAI.DragonActionAI(labyrinth.this);


    }
//this is the end of labyrinth method


// main of our file 
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            labyrinth labyrinthObj = new labyrinth(); // Create an instance of labyrinth
            labyrinthObj.RightSidePanel = new RightSidePanel(labyrinthObj); // Initialize RightSidePanel
            labyrinthObj.RightSidePanel.RightSidePanelDraw(); // Draw RightSidePanel
            labyrinthObj.Window.setVisible(true);
        }
    });
}
}




 