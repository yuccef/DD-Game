package src.mygame.Views;



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.String;


import src.mygame.Utils.*;
import src.mygame.WelcomingPage;
import src.mygame.Controllers.*;
import src.mygame.Models.TheDragon.Dragon;
import src.mygame.Models.TheFighter.FighterCaracter;



public class labyrinth {


      Sound sound = new Sound();

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


    public int xBonus1 = 300;
    public int yBonus1 = 120;
    public int xBonus2 = 530;
    public int yBonus2 = 280;


    public int Walk =15;
 
    public JLabel characterLabel;
    public JLabel DragonLabel;
    public JLabel FireDragonLabel;
    public JLabel FireFighterLabel;
    public JLabel FighterShield;
    public JLabel DragonShield;

    public JLabel BonusLabel;
    public JLabel BonusLabel2;


    //Should to update this
    public int currentImageIndexFighterRun = 0;
    public int currentImageIndexFighterAttack=0;
    public int currentImageIndexDragonRun = 0;
    public int currentImageIndexDragonAttack = 0;

    int [] indices = new int[4];


    public char SideDragon='L', SideFighter='R';
    
    public String Fightermove;

    public FighterCaracter Bnadem;
    public Dragon Dragon;

    public String Thelevel;
    public String TheCharacter;


    
    //Objects
    PicturesPath Paths = new PicturesPath();
    public GameTimers gameTimers;
    public FighterCaracter HumanFighter = new FighterCaracter( "Human ",   400, 30, 10, xFighter, yFighter);
    public FighterCaracter Witch = new FighterCaracter( "Witch ",   400, 30, 10, xFighter, yFighter);
    public FighterCaracter Knight = new FighterCaracter( "Knight ",   400, 30, 10, xFighter, yFighter);

    public Dragon Dragon1 = new Dragon("Dragon 1", 400, 20, 20, xDragon, yDragon);
    public Dragon Dragon2 = new Dragon("Dragon 2", 500, 40, 20, xDragon, yDragon);
    public Dragon Dragon3 = new Dragon("Dragon 3", 600, 60, 20, xDragon, yDragon);
    public CharactersMovesManage CharactersMovesManage;
    public RightSidePanel RightSidePanel ;
    public WelcomingPage welcomingPageLabyrinth  ;


//Methods
public labyrinth(WelcomingPage welcomingPage) {
    this.welcomingPageLabyrinth = welcomingPage;
   
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
                //juste un exemple
       


                // g.drawImage(Bonus,300 ,120 , this);
                //     g.drawImage(Bonus, 530 ,280 , this);

                for(int i=0; i<20;i++){
                    for(int j=0; j<20; j++){
                        if(Lmatrix[i][j] == 1){
                            g.drawImage(WallMap, i*40 , j*40, this);
                        }
                    }   
                }

        }             
    };

            BonusLabel = new JLabel();
            BonusLabel2 = new JLabel();

                 Image Bonus = new ImageIcon("../Project/src/mygame/resource/Bonus.png").getImage();
                ImageIcon BonusIcon = new ImageIcon(Bonus);
                BonusLabel.setIcon(BonusIcon);
                BonusLabel2.setIcon(BonusIcon);
      

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

                   BonusLabel.setBounds(xBonus1, yBonus1, BonusIcon.getIconWidth(), BonusIcon.getIconHeight());
                   BonusLabel2.setBounds(xBonus2, yBonus2, BonusIcon.getIconWidth(), BonusIcon.getIconHeight());


        //Add to Panel
        DrawLabyrinthPanel.setBounds(0, 0, 800, 635);
        DrawLabyrinthPanel.setLayout(null);

        DrawLabyrinthPanel.add(DragonLabel);
        DrawLabyrinthPanel.add(characterLabel);

        DrawLabyrinthPanel.add(FireDragonLabel);
        DrawLabyrinthPanel.add(FireFighterLabel);

        DrawLabyrinthPanel.add(FighterShield);
        DrawLabyrinthPanel.add(DragonShield);

        DrawLabyrinthPanel.add(BonusLabel);
        DrawLabyrinthPanel.add(BonusLabel2);


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
                    if(Walk %15==0){
                    sound.playSound(2);
                    }
                     Walk++;
                    Fightermove="run";
                    DragonActionAI.DragonActionAI(labyrinth.this);

                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // Left Fighter
                    SideFighter = 'L';
                       CharactersMovesManage.moveFighter(1,-1, 0, labyrinth.this);
                    if(Walk %15==0){
                    sound.playSound(2);
                    }
                    Walk++;                       Fightermove="run";
                    DragonActionAI.DragonActionAI(labyrinth.this);
                // IN UP AND DOWN I SHOULD TO UPDATE SIDES
                } else if (e.getKeyCode() == KeyEvent.VK_UP) { // Up Fighter
                       CharactersMovesManage.moveFighter(1,0, -1, labyrinth.this);
                    if(Walk %15==0){
                    sound.playSound(2);
                    }
                    Walk++;
                    Fightermove="run";
                    DragonActionAI.DragonActionAI(labyrinth.this );

                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Down Fighter
                       CharactersMovesManage.moveFighter(1,0, 1, labyrinth.this);
                    if(Walk %15==0){
                    sound.playSound(2);

                    }
                    Walk++;
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




    //Getters
    public FighterCaracter getBnadem() {
        return this.Bnadem;
    }
    public Dragon getDragon() {
    return this.Dragon;
}

 public int getLifeFighter(){
    return this.Bnadem.score;
}

public int getLifeDragon(){
    return this.Dragon.score;
}

     public labyrinth  getLabyrinth(){
    return this;
     }


// main of our file 
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            WelcomingPage welcomingPage = new WelcomingPage();
            labyrinth labyrinthObj = new labyrinth(welcomingPage); // Create an instance of labyrinth
            Bonus Bonus = new Bonus();
            Bonus.Bonus(labyrinthObj);
            labyrinthObj.RightSidePanel = new RightSidePanel(labyrinthObj); // Initialize RightSidePanel
            labyrinthObj.RightSidePanel.RightSidePanelDraw(); // Draw RightSidePanel
            labyrinthObj.Window.setVisible(true);
        }
    });
}
}




 