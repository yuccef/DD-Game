package DrawTheMap;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.String;

import TheDragon.Dragon;
import TheFighter.FighterCaracter;
//import DrawTheMap.RightSidePanel; 

public class labyrinth {
    

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
    public JLabel FireLabel;
    public JLabel FireFighterLabel;
    public JLabel FighterShiled;
    public JLabel DragonShiled;

    public int currentImageIndexFighterRun = 0;
    public int currentImageIndexFighterAttack=0;
    public int currentImageIndexDragonRun = 0;
    public int currentImageIndexDragonAttack = 0;



    public char SideDragon, SideFighter;

    PicturesPath Paths = new PicturesPath();
    public GameTimers gameTimers;
 

    //Objects
    public FighterCaracter Bnadem = new FighterCaracter( "Youssef ",   400, 30, 10, xFighter, yFighter);
    public Dragon Dragon = new Dragon("Dragon", 400, 20, 20, xDragon, yDragon);
   
   public FighterCaracter getBnadem() {
    return this.Bnadem;
    }
    public Dragon getDragon() {
    return this.Dragon;
    }


   



    //Methods
    public labyrinth() {
        RightSidePanel RightSidePanel = new RightSidePanel(labyrinth.this);
        gameTimers = new GameTimers(this, RightSidePanel);


        Window = new JFrame("Affichage de photos");
        Window.setSize(800, 785);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.add(RightSidePanel);
        Window.setLayout(null);
        



        
        //Map Panel
        JPanel DrawLabyrinthPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image RoadMap = new ImageIcon("../Project/Ressource/MapPixels/labyrinth1.jpg").getImage();
                Image WallMap = new ImageIcon("../Project/Ressource/MapPixels/labyrinth2.jpg").getImage();
               
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



        //Show the fighter and the dragon and Fire
        characterLabel = new JLabel();
        DragonLabel = new JLabel();
        FireLabel = new JLabel();
        FireFighterLabel = new JLabel();
        FighterShiled = new JLabel();
        DragonShiled = new JLabel();


        //Initial Position
        characterLabel.setBounds(xFighter, yFighter, 40, 40);
        DragonLabel.setBounds(xDragon, yDragon, 40, 40);
        FireLabel.setBounds(gameTimers.xFire, gameTimers.yFire, 40, 40);
        FireFighterLabel.setBounds(gameTimers.xFireFighter, gameTimers.yFireFighter, 40, 40);
        FighterShiled.setBounds(xFighter, yFighter, 40, 40);
        DragonShiled.setBounds(xDragon, yDragon, 40, 40);

        //Add to Panel
        DrawLabyrinthPanel.setBounds(0, 0, 800, 635);
        DrawLabyrinthPanel.setLayout(null); 
        DrawLabyrinthPanel.add(DragonLabel);
        DrawLabyrinthPanel.add(characterLabel);
        DrawLabyrinthPanel.add(FireLabel);
        DrawLabyrinthPanel.add(FireFighterLabel);
        DrawLabyrinthPanel.add(FighterShiled);
        DrawLabyrinthPanel.add(DragonShiled);


        //Show the Window
        Window.setSize(new Dimension(1100, 635));
        Window.setResizable(false);
        Window.add(DrawLabyrinthPanel);

     

    
        //Key Listener
        Window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //key listener for knight
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Right knight
                    SideFighter = 'R';
                    if (yFighter!=yDragon){
                        gameTimers.timerShiledFighter.stop();
                        gameTimers.ShieldDragonCheker=0;
                        moveFighter(1,1, 0);
                    }else{
                        if(xFighter+40<=xDragon){
                            gameTimers.timerShiledFighter.stop();
                            gameTimers.ShieldDragonCheker=0;
                            moveFighter(1,1, 0);
                }
            }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // Left knight
                    SideFighter = 'L';
                    moveFighter(1,-1, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) { // Up knight
                    moveFighter(1,0, -1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Down knight
                    moveFighter(1,0, 1);
                }
                 else if (e.getKeyCode()== KeyEvent.VK_ENTER){
                    moveAttack(1);
                    }
                else if(e.getKeyChar()=='x'|| e.getKeyChar()=='X'){
                    gameTimers.ShieldFighterCheker=1;
                    gameTimers.timerShiledFighter.start();
                }

                //key listener for dragon
                if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                    SideDragon = 'R';
                    moveFighter(2,1, 0);
                }else if(e.getKeyChar() == 'q' || e.getKeyChar() == 'Q'){
                    SideDragon = 'L';
                    moveFighter(2,-1, 0);
                }else if(e.getKeyChar() == 'z' || e.getKeyChar() == 'Z'){
                    moveFighter(2,0, -1);
                }else if(e.getKeyChar() == 's' || e.getKeyChar() == 'S'){
                    moveFighter(2,0, 1);
                }
                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    moveAttack(2);
                }
                else if(e.getKeyChar()=='c'|| e.getKeyChar()=='C'){ //we have a problem here andin Shield fighter too
                    gameTimers.timerShiledDragon.start();
                }   


               
            }
             
                @Override
            public void keyReleased(KeyEvent e) {
                    // Do nothing here, as we are not using keyReleased
                }
            });
        Window.setVisible(true);
    }

    public void moveFighter(int Choice, int dx, int dy) {
        int newX = xFighter + dx * 5;
        int newY = yFighter + dy * 5;
        int newXX=xDragon+dx*5;
        int newYY=yDragon+dy*5;
    if(dx>=0 ){
          if(Choice == 1){
        gameTimers.timerShiledFighter.stop();
         gameTimers.ShieldFighterCheker=0;
        FighterShiled.setIcon(null);             
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { 
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(Paths.imagePathsFighterRun[currentImageIndexFighterAttack], Paths.imagePathsDragonRun[currentImageIndexDragonRun]);
                      //FighterLabelRightSideName.setText(" Y " + yFighter);
                      //FighterLabelRightSideLife.setText("  X :" + xFighter);

            }
        }
    }
          if(Choice==2){
        gameTimers.timerShiledDragon.stop();
        DragonShiled.setIcon(null);
        if(newXX>=0 && newXX+40<MATRIX_SIZE && newYY>=0 && newYY+40<MATRIX_SIZE){
            boolean canMove=true;
            for(int i=newXX;i<newXX+40;i++){
            for(int j=newYY;j<newYY+40;j++){
                if(Bmatrix[i][j]==1){
                canMove=false;
                break;
                }
            }
            }
            if(canMove){
            xDragon=newXX;
            yDragon=newYY;
            ShowFighter(Paths.imagePathsFighterRun[currentImageIndexFighterRun], Paths.imagePathsDragonRun[currentImageIndexDragonRun]);
     
            }
        }
    }

}

    if(dx<=0 ){
        if(Choice == 1){
        FighterShiled.setIcon(null);             
        gameTimers.timerShiledFighter.stop();
        gameTimers.ShieldFighterCheker=0;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { 
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(Paths.imagePathsFighterRunInverse[currentImageIndexFighterRun], Paths.imagePathsDragonRun[currentImageIndexDragonRun]);
                     // FighterLabelRightSideName.setText(" Y " + yFighter);
                     // FighterLabelRightSideLife.setText("  X :" + xFighter);

            }
        }

    }
        if(Choice==2){
        gameTimers.timerShiledDragon.stop();
        DragonShiled.setIcon(null);
        if(newXX>=0 && newXX+40<MATRIX_SIZE && newYY>=0 && newYY+40<MATRIX_SIZE){
            boolean canMove=true;
            for(int i=newXX;i<newXX+40;i++){
            for(int j=newYY;j<newYY+40;j++){
                if(Bmatrix[i][j]==1){
                canMove=false;
                break;
                }
            }
            }
            if(canMove){
            xDragon=newXX;
            yDragon=newYY;
            ShowFighter(Paths.imagePathsFighterRun[currentImageIndexFighterRun], Paths.imagePathsDragonRunInverse[currentImageIndexDragonRun]);
            
            }
        }
    }

}
    
    }

    public void ShowFighter(String nomImage, String nomImage2) {

        ImageIcon imageIcon = new ImageIcon(nomImage);
        ImageIcon imageIcon2 = new ImageIcon(nomImage2);

        characterLabel.setIcon(imageIcon);
        DragonLabel.setIcon(imageIcon2);

        characterLabel.setBounds(xFighter, yFighter, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        DragonLabel.setBounds(xDragon, yDragon, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        // characterLabel.repaint();
    }
    
    public void ShowFire( String nomImage, int x, int y) {

    ImageIcon imageIcon = new ImageIcon(nomImage);
    FireLabel.setIcon(imageIcon);
    FireLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());

}

public void ShowFireFighter( String nomImage, int x, int y) {
    ImageIcon imageIcon = new ImageIcon(nomImage);  
    FireFighterLabel.setIcon(imageIcon);
    FireFighterLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
}

public void ShowShiledFighter( int x, int y) {
    int xShield=0;
    String nomImage="";
    if(SideFighter=='R'){
        xShield=x+40;
        nomImage="../Project/Ressource/CharactersMvmnt/KnightMvmnt1/FighterShield.png";
    }
    if(SideFighter=='L'){
        xShield=x-40;
        nomImage="../Project/Ressource/CharactersMvmnt/KnightMvmnt1/FighterShieldInversed.png";
    }
    ImageIcon imageIcon = new ImageIcon(nomImage);
    FighterShiled.setIcon(imageIcon);
    FighterShiled.setBounds(xShield, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
}

public void ShowShiledDragon(int x, int y) {
        int xShield=0;
        String nomImage="";

    if(SideDragon=='R'){
        xShield=x+70;
       nomImage="../Project/Ressource/CharactersMvmnt/FirstDragon/DragonShieldInversed.png";
    }
    if(SideDragon=='L'){
        xShield=x-40;
        nomImage="../Project/Ressource/CharactersMvmnt/FirstDragon/DragonShield.png";
    }
    ImageIcon imageIcon = new ImageIcon(nomImage);
    DragonShiled.setIcon(imageIcon);
    DragonShiled.setBounds(xShield, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
}

  
    public void moveAttack( int Choice)  {
    
    if(Choice==1){
        gameTimers.timerShiledFighter.stop();
        FighterShiled.setIcon(null); 
         gameTimers.ShieldFighterCheker=0;   

        if(SideFighter=='R'){
                    if(SideDragon=='R'){
        int newX = xFighter +  7;
        int newY = yFighter ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                gameTimers.timerFireFighter.start();
                gameTimers.FirstTimeFighter=0;
                ShowFighter(Paths.imagePathsFighterAttack[currentImageIndexFighterAttack],Paths.imagePathsDragonRun[currentImageIndexDragonRun]);

            }
        }
    }
                    if(SideDragon=='L'){
         int newX = xFighter +  7;
        int newY = yFighter ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                 gameTimers.timerFireFighter.start();
                gameTimers.FirstTimeFighter=0;
                ShowFighter(Paths.imagePathsFighterAttack[currentImageIndexFighterAttack],Paths.imagePathsDragonRunInverse[currentImageIndexDragonRun]);

            }
        }

    }
}
        if(SideFighter=='L'){
                         if(SideDragon=='R'){
        int newX = xFighter -  7;
        int newY = yFighter ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(Paths.imagePathsFighterAttackInverse[currentImageIndexFighterAttack],Paths.imagePathsDragonRun[currentImageIndexDragonRun]);
                gameTimers.timerFireFighter.start();
                gameTimers.FirstTimeFighter=0;
            }
        }
    }
                         if(SideDragon=='L'){
        int newX = xFighter -  7;
        int newY = yFighter;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(Paths.imagePathsFighterAttackInverse[currentImageIndexFighterAttack],Paths.imagePathsDragonRunInverse[currentImageIndexDragonRun]);
                gameTimers.timerFireFighter.start();
                gameTimers.FirstTimeFighter=0;
            }
        }
    }
}
}
    if(Choice==2){

        gameTimers.timerShiledDragon.stop();
        DragonShiled.setIcon(null);
     if(SideDragon=='R'){
                          if(SideFighter=='R'){
        int newX = xDragon;
        int newY = yDragon ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xDragon = newX;
                yDragon = newY;
                ShowFighter(Paths.imagePathsFighterRun[currentImageIndexFighterRun],Paths.imagePathsDragonAttack[currentImageIndexDragonAttack]);
                gameTimers.timerFire.start();
                gameTimers.FirstTime=0;

            }
        }
    }
                          if(SideFighter=='L'){
         int newX = xDragon ;
        int newY = yDragon ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xDragon = newX;
                yDragon = newY;
                ShowFighter(Paths.imagePathsFighterRunInverse[currentImageIndexFighterRun],Paths.imagePathsDragonAttack[currentImageIndexDragonAttack]);
                gameTimers.timerFire.start();
                gameTimers.FirstTime=0;
            }
        }

    }
}
     if(SideDragon=='L'){
                       if(SideFighter=='R'){
        int newX = xDragon;
        int newY = yDragon;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xDragon = newX;
                yDragon = newY;
                        gameTimers.timerFire.start();
                        gameTimers.FirstTime=0;

                ShowFighter(Paths.imagePathsFighterRun[currentImageIndexFighterRun],Paths.imagPathsDragonAttackInverse[currentImageIndexDragonAttack]);
            }
        }
    }
                       if(SideFighter=='L'){
      int newX = xDragon ;
        int newY = yDragon;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xDragon = newX;
                yDragon = newY;
                        gameTimers.timerFire.start();
                        gameTimers.FirstTime=0;

                ShowFighter(Paths.imagePathsFighterRunInverse[currentImageIndexFighterRun],Paths.imagPathsDragonAttackInverse[currentImageIndexDragonAttack]);
            }
        }                              
}
}
}

}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new labyrinth();
            }
        });
    }
}
class RightSidePanel extends JPanel {

    public labyrinth labyrinthInstance;

    public GameTimers gameTimers;
    public JLabel FighterLabelRightSideLife;
    public JLabel FighterLabelRightSideName;
    public JLabel DragonLabelRightSideName;
    public JLabel DragonLabelRightSideLife;

    public JPanel FighterLifePanel;
    public JPanel DragonLifePanel;


    public RightSidePanel(labyrinth labyrinthInstance) {
        this.labyrinthInstance = labyrinthInstance;
        Dragon Dragon = labyrinthInstance.getDragon();
        FighterCaracter Bnadem = labyrinthInstance.getBnadem();

        setLayout(null);
        setBounds(800, 0, 285, 597);
        setBackground(Color.decode("#e8dfdb"));
        LineBorder border = new LineBorder(Color.decode("#365979"), 10, true);
        LineBorder border1 = new LineBorder(Color.decode("#8bb1c4"), 5, true);
        LineBorder border2 = new LineBorder(Color.decode("#b96343"), 5, true);
        setBorder(border);
        //Fonts     
        Font FontForTitle = new Font("Comic Sans MS", Font.BOLD, 20);
        Font FontForTimer = new Font("Courier New", Font.BOLD, 14);
        Font FontForNames = new Font("Georgia", Font.BOLD, 16);
        Font FontForLife = new Font("lucida Handwriting", Font.BOLD, 10);

        // Life Panels
           FighterLifePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (Bnadem.score > 200) {
                    g.setColor(Color.GREEN);
                } else if (Bnadem.score > 100) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.RED);
                }

                int width = (int) ((Bnadem.score / (double) 400) * getWidth());
                g.fillRect(0, 0, width, getHeight());
            }
        };
        FighterLifePanel.setBounds(20, 345, 110, 40);
        FighterLifePanel.setBorder(border1);

         DragonLifePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (Dragon.score > 200) {
                    g.setColor(Color.GREEN);
                } else if (Dragon.score > 100) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.RED);
                }

                int width = (int) ((Dragon.score / (double) 400) * getWidth());
                g.fillRect(0, 0, width, getHeight());
            }
        };
        DragonLifePanel.setBounds(160, 345, 110, 40);
        DragonLifePanel.setBorder(border1);

        JLabel TitleLabel = new JLabel("  Jeu de combat");
        TitleLabel.setBorder(border);
        TitleLabel.setFont(FontForTitle);
        TitleLabel.setForeground(Color.decode("#7e5835"));
        TitleLabel.setOpaque(true);
        TitleLabel.setBackground(Color.decode("#d1c0b9"));
        TitleLabel.setBounds(40, 60, 220, 50);

         // RightSide (Timer Label)
        JLabel RightSideLabelTimer = new JLabel("0");
        Timer RightSidetimer = new Timer(1000, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                RightSideLabelTimer.setText("Timer : " + count + "s");
            }
        });

        RightSidetimer.start();
        RightSideLabelTimer.setBounds(170, 6,    110, 30);
        RightSideLabelTimer.setBorder(border2);
        RightSideLabelTimer.setFont(FontForTimer);
        RightSideLabelTimer.setForeground(Color.decode("#425b8a"));
        RightSideLabelTimer.setOpaque(true);
        RightSideLabelTimer.setBackground(Color.decode("#d1c0b9"));



        //Fighter Label

        //picture
        JLabel FighterLabelRightSidePicture = new JLabel();
        FighterLabelRightSidePicture.setBounds(20, 210, 110,    124);
        ImageIcon imageIconFighterLabelRightSidePicture = new ImageIcon("../Project/Ressource/CharactersMvmnt/KnightMvmnt1/IconeFighter.png");
        Image imageFighterLabelRightSidePicture = imageIconFighterLabelRightSidePicture.getImage();
        Image newImageFighterLabelRightSidePicture = imageFighterLabelRightSidePicture.getScaledInstance(124, 124, Image.SCALE_SMOOTH); 
        imageIconFighterLabelRightSidePicture = new ImageIcon(newImageFighterLabelRightSidePicture); 
        FighterLabelRightSidePicture.setIcon(imageIconFighterLabelRightSidePicture);
        FighterLabelRightSidePicture.setBorder(border1);

        //name
        FighterLabelRightSideName = new JLabel("    "+Bnadem.name);
        FighterLabelRightSideName.setBorder(border1);
        FighterLabelRightSideName.setFont(FontForNames);
        FighterLabelRightSideName.setForeground(Color.decode("#425b8a"));
        FighterLabelRightSideName.setOpaque(true);
        FighterLabelRightSideName.setBackground(Color.decode("#d1c0b9"));
        FighterLabelRightSideName.setBounds(20, 150, 110, 50);

        //life
        FighterLabelRightSideLife = new JLabel("Vie:"+ Bnadem.score +"  ") ;
        FighterLabelRightSideLife.setFont(FontForLife);
        FighterLabelRightSideLife.setForeground(Color.decode("#425b8a"));    
        FighterLabelRightSideLife.setBounds(20, 300, 120, 50);


        // Dragon Label

        //picture
        JLabel DragonLabelRightSidePicture = new JLabel();
        DragonLabelRightSidePicture.setBounds(160, 210, 110,    124);
        ImageIcon imageIconDragonLabelRightSidePicture = new ImageIcon("../Project/Ressource/CharactersMvmnt/FirstDragon/DragonIcone.png");
        Image imageDragonLabelRightSidePicture = imageIconDragonLabelRightSidePicture.getImage();
        Image newImageDragonLabelRightSidePicture = imageDragonLabelRightSidePicture.getScaledInstance(124, 124, Image.SCALE_SMOOTH); 
        imageIconDragonLabelRightSidePicture = new ImageIcon(newImageDragonLabelRightSidePicture); 
        DragonLabelRightSidePicture.setIcon(imageIconDragonLabelRightSidePicture);
        DragonLabelRightSidePicture.setHorizontalAlignment(SwingConstants.CENTER);
        DragonLabelRightSidePicture.setVerticalAlignment(SwingConstants.CENTER);
        DragonLabelRightSidePicture.setBorder(border1);

        //name
        DragonLabelRightSideName = new JLabel("    "+ Dragon.name);
        DragonLabelRightSideName.setBorder(border1);
        DragonLabelRightSideName.setFont(FontForNames);
        DragonLabelRightSideName.setForeground(Color.decode("#425b8a"));
        DragonLabelRightSideName.setOpaque(true);
        DragonLabelRightSideName.setBackground(Color.decode("#d1c0b9"));
        DragonLabelRightSideName.setBounds(160, 150, 110, 50);

        //life
        DragonLabelRightSideLife = new JLabel("  Score :"+ Bnadem.score+"  ") ;
        DragonLabelRightSideLife.setFont(FontForLife);
        DragonLabelRightSideLife.setForeground(Color.decode("#425b8a"));
        DragonLabelRightSideLife.setBounds(160, 350, 110, 50);
        
        // Add components to the panel
        add(FighterLabelRightSidePicture);
        add(DragonLabelRightSidePicture);

        add(FighterLabelRightSideName);
        add(DragonLabelRightSideName);

        add(TitleLabel);
        add(RightSideLabelTimer);

        add(DragonLifePanel);
        add(FighterLifePanel);

        add(FighterLabelRightSideLife);
        add(DragonLabelRightSideLife);
        FighterLifePanel.add(FighterLabelRightSideLife);
        DragonLifePanel.add(DragonLabelRightSideLife);

  
  
    }   
     
}
       
class GameTimers {

    public Timer timerFireFighter;
    public int xFireFighter=0;
    public int yFireFighter=0;
    public int FirstTimeFighter=0;
    public int SetFireFighter=0;
    public int ShieldFighterCheker=0;
      
    public Timer timerFire; 
    public int xFire=0; 
    public int yFire=0; 
    public int FirstTime=0;
    public int SetFire=0;
    public int ShieldDragonCheker=0;
    
    public Timer timerFighterRun;
    public   Timer timerDragonRun;
    public    Timer timerFighterAttack;
    public    Timer timerDragonAttack;

    public Timer timerShiledFighter;
    public Timer timerShiledDragon;


    public FighterCaracter Bnadem;
    public Dragon Dragon;

    public  FighterCaracter  getBnademTimer() {
    return this.Bnadem;
    }
    public Dragon getDragonTimer() {
    return this.Dragon;
    }


   
    public GameTimers(labyrinth labyrinthInstance ,RightSidePanel RightSidePanelTest) {
        Bnadem = labyrinthInstance.getBnadem();
        Dragon = labyrinthInstance.getDragon();
        labyrinth labyrinth = labyrinthInstance;
        RightSidePanel RightSidePanel =RightSidePanelTest;

   
        //Timer for the fighter and the dragon
         timerFighterRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labyrinth.currentImageIndexFighterRun = ( labyrinth.currentImageIndexFighterRun + 1) % 7; // Loop through the images
            }
        });
        timerFighterRun.start();

          timerDragonRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labyrinth.currentImageIndexDragonRun = (labyrinth.currentImageIndexDragonRun + 1) % 6; // Loop through the images
            }
        });
        timerDragonRun.start();

         timerFighterAttack = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labyrinth.currentImageIndexFighterAttack = (labyrinth.currentImageIndexFighterAttack + 1) % 4; // Loop through the images
            }
        });
        timerFighterAttack.start();

         timerDragonAttack = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labyrinth.currentImageIndexDragonAttack = (labyrinth.currentImageIndexDragonAttack + 1) %4; // Loop through the images
            }
        });
        timerDragonAttack.start();

         timerFire = new Timer(30, new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {

                if(FirstTime==0){
                 xFire = labyrinth.xDragon;
                 yFire = labyrinth.yDragon;
                 FirstTime=1;
                }
            if(labyrinth.SideDragon=='L'){

                 
    
           
            
       if (xFire <= labyrinth.xFighter   || xFire==40 || xFire==760) {
                 
           labyrinth.FireLabel.setIcon(null);
                  timerFire.stop();
                    if(xFire<=labyrinth.xFighter && labyrinth.yDragon==labyrinth.yFighter){
                    timerFire.stop();
                    labyrinth.FireLabel.setIcon(null);
                    Dragon.DamageDragonFighterCaracter(Bnadem, Dragon);
                    Bnadem.FighterCaracterUpdateDealth(Bnadem);
                    Bnadem.lose(Bnadem);
                    RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    RightSidePanel.FighterLifePanel.repaint();
                    
                }
                
           
                    
                }
               
                
         if(ShieldFighterCheker==1  && xFire <= labyrinth.xFighter +40 ){
            if(labyrinth.yDragon==labyrinth.yFighter){
                    timerFire.stop();
                    labyrinth.FireLabel.setIcon(null);
                    Bnadem.FighterDefense(Bnadem, Dragon);
                    Bnadem.lose(Bnadem);
                    RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    RightSidePanel.FighterLifePanel.repaint();  
                    ShieldFighterCheker=0;
                    timerShiledFighter.stop();
                    labyrinth.FighterShiled.setIcon(null);
                 }
                 timerFire.stop();  
                labyrinth.FireLabel.setIcon(null);
                }
               else{
                    labyrinth.ShowFire("../Project/Ressource/CharactersMvmnt/FirstDragon/FireInversed.png", xFire, yFire);
                    xFire -= 5;

                }

            }
            if(labyrinth.SideDragon=='R'){
             
             if (xFire == labyrinth.xFighter   ||xFire==760) {
                   timerFire.stop();
                    labyrinth.FireLabel.setIcon(null);
                    FirstTime=0;    

                }else{
                    labyrinth.ShowFire("../Project/Ressource/CharactersMvmnt/FirstDragon/Fire.png", xFire, yFire);
                   xFire += 5;


                }   
            }
  
        }
        });
        timerFire.setInitialDelay(0);

        timerFireFighter = new Timer(30, new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {

                if(FirstTimeFighter==0){
                xFireFighter = labyrinth.xFighter;
                yFireFighter = labyrinth.yFighter;
                FirstTimeFighter=1;
                }

            if(labyrinth.SideFighter=='R'){
                if (xFireFighter >= labyrinth.xDragon   || xFireFighter>=760) {
                    if(xFireFighter>=labyrinth.xDragon && labyrinth.yFighter==labyrinth.yDragon){
                    timerFireFighter.stop();
                    labyrinth.FireFighterLabel.setIcon(null);
                    Bnadem.DamageFighterCaracterTheDragon(Bnadem, Dragon);
                    Dragon.DragonUpdateDealth(Dragon);
                    Dragon.lose(Dragon);
                    RightSidePanel.DragonLabelRightSideLife.setText(" Score : " + Dragon.score);
                    RightSidePanel.DragonLifePanel.repaint();
                }     
                    timerFireFighter.stop();
                    labyrinth.FireFighterLabel.setIcon(null);
                }

            //         if(labyrinth.Bmatrix[xFireFighter+40][yFireFighter]==1){
            //         timerFireFighter.stop();
            //         labyrinth.FireLabel.setIcon(null);
            //     }
             
                else{
                    labyrinth.ShowFireFighter("../Project/Ressource/CharactersMvmnt/KnightMvmnt1/FireFighter.png", xFireFighter, yFireFighter);
                    xFireFighter += 5;

                }
         

            }
            if(labyrinth.SideFighter=='L'){
             
             if (xFireFighter == labyrinth.xDragon   ||xFireFighter==40) {
                   timerFireFighter.stop();
                    labyrinth.FireFighterLabel.setIcon(null);
                    FirstTimeFighter=0;    

                }else{
                    labyrinth.ShowFireFighter("../Project/Ressource/CharactersMvmnt/KnightMvmnt1/FireFighterInversed.png", xFireFighter, yFireFighter);
                   xFireFighter -= 5;

                }   
            }
            }
        });
        timerFireFighter.setInitialDelay(0);

        timerShiledFighter = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(labyrinth.yDragon==labyrinth.yFighter){
                if(labyrinth.xDragon<= labyrinth.xFighter+40 ){
                    labyrinth.FighterShiled.setIcon(null);
                    timerShiledFighter.stop();
                    ShieldFighterCheker=0;
                    RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    RightSidePanel.FighterLifePanel.repaint();
                    }
                else{
                    labyrinth.ShowShiledFighter(labyrinth.xFighter, labyrinth.yFighter);
                    RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    RightSidePanel.FighterLifePanel.repaint();
                    ShieldFighterCheker=1;

                }

            }else{
                   labyrinth.ShowShiledFighter(labyrinth.xFighter, labyrinth.yFighter);
                    RightSidePanel.FighterLifePanel.repaint();
            } 
            }
        });
        timerShiledFighter.setInitialDelay(0);        

        



        timerShiledDragon = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(labyrinth.yDragon==labyrinth.yFighter){
                if(labyrinth.xDragon<= labyrinth.xFighter-40 ){
                    labyrinth.FighterShiled.setIcon(null);
                    timerShiledDragon.stop();
                    RightSidePanel.DragonLabelRightSideLife.setText(" Score : " + Dragon.score);
                    RightSidePanel.DragonLifePanel.repaint();
                    }
                else{
                    labyrinth.ShowShiledDragon(labyrinth.xDragon, labyrinth.yDragon);
                    RightSidePanel.DragonLabelRightSideLife.setText(" Score : " + Dragon.score);
                    RightSidePanel.DragonLifePanel.repaint();

                }

            }else{
                   labyrinth.ShowShiledDragon(labyrinth.xDragon, labyrinth.yDragon);
                    RightSidePanel.DragonLifePanel.repaint();
        }
           
  
            }
        }); 

        
    }
}


 